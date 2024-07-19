/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, wildcards
*/

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

    /*
    Wildcards support both upper and lower bounds, type parameters only support upper bounds(extends).
    So, if you want to define a method that takes a List of type Integer or it's superclass, you can do:

    public void print(List<? super Integer> list)  // OK

    but you can't use a type parameter:
    public <T super Integer> void print(List<T> list)  // Won't compile

    i.e. super is used with wildcard (?) only.
    */

    // Method prints elements in a list, restricted to Exception
    // elements and any of its subclasses
    public static void printUpperList(List<? extends Exception> list) {

        // when using an upper bound, able to use specific methods and
        // attributes on the specified type
        System.out.println("\n----- Using upper bound ------");
        list.forEach((s) -> System.out.println(s.getLocalizedMessage()));

    }

    // Method prints elements in a list, restricted to Exception
    // elements and any of its superclasses
    public static void printLowerList(List<? super Exception> list) {
        // Because superclasses are acceptable for lower bound,
        // the methods of the declared type exception are not available,
        // because the type of object actually passed could be something as broad as an object.
        System.out.println("\n----- Using lower bound ------");
        list.forEach((s) -> System.out.println(s));
    }


    // you can't overload methods using type parameters.
    // 'printList(List<? extends Exception>)' clashes with 'printList(List<? super Exception>)'; both methods have same erasure
    // public static void printList(List<? extends Exception> list) {}
    // public static void printList(List<? super Exception> list) {}


    // Method prints elements in a list, with no restrictions on
    // type of element
    public static void printOpenDoor(List<?> list) {
        System.out.println("\n----- Using no bounds ------");
        list.forEach((s) -> System.out.println(s));
    }

    // Method prints elements in a list, the list is made up of
    // Objects
    public static void printObjectList(List<Object> list) {
        System.out.println("----- List made up of objects ------");
        list.forEach((s) -> System.out.println(s));
    }


    public static void printLowerListRuntimeException(List<? super RuntimeException> list) {
        System.out.println("\n----- Using upper bound ------");
        list.forEach((s) -> System.out.println(s.getClass()));
    }

    public static void main(String[] args) {

        // Create two lists typed slightly differently
        ArrayList<RuntimeException> runtimeExceptionList =
                new ArrayList<>();
        ArrayList<Exception> exceptionList = new ArrayList<>();

        // Populate with some forced exceptions
        for (int i = 0; i < 3; i++) {
            try {
                int j = i / 0;
            } catch (RuntimeException e) {
                runtimeExceptionList.add(e);
                exceptionList.add(e);
            }
        }

        // RuntimeException allowed by upper bounded <? extends Exception>
        printUpperList(runtimeExceptionList);
        // RuntimeException allowed by unbounded <?>
        printOpenDoor(runtimeExceptionList);

        // RuntimeException NOT allowed by lower bounded <? super Exception>
        // printLowerList(runtimeExceptionList);

        // RuntimeException NOT allowed by type arg <Object>
        // printObjectList(runtimeExceptionList);

        // Exception allowed by upper bounded <? extends Exception>
        printUpperList(exceptionList);
        // Exception allowed by lower bounded <? super Exception>
        printLowerList(exceptionList);
        // Exception allowed by unbounded <?>
        printOpenDoor(exceptionList);

        // <? super RuntimeException>
        printLowerListRuntimeException(exceptionList);  // S is a sub type of T; A<T> <<< A<? super T> <<< A<? super S>

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // Exception NOT allowed by type arg <Object>
        // printObjectList(exceptionList);

        List<Integer> integerList = List.<Integer>of(5, 10, 15);
        // Integer type allowed by unbounded wildcard <?>
        printOpenDoor(integerList);

        // Integer NOT allowed by upper bounded <? extends Exception>
        // printUpperList(integerList);
        // Integer NOT allowed by lower bounded <? super Exception>
        // printLowerList(integerList);
        // Integer NOT allowed by type arg <Object>
        // printObjectList(integerList);

        // Object meets requirement for all the methods, with the
        // exception of the upper bound method.
        List<Object> objectList = List.of("a", "B", "c");

        // Object allowed by <? super Exception>
        printLowerList(objectList);
        // Object allowed by <?>
        printOpenDoor(objectList);
        // Object allowed by <Object>
        printObjectList(objectList);

        // Object NOT allowed by upper bounded <? extends Exception>
        // printUpperList(objectList);


        // Note: you can always cast a generic type to a raw type.
        List objectList2 = List.<Integer>of(5, 10, 15);
        printObjectList(objectList2);


        // Now looking at that code we could have replaced that with the following,
        // which will do the same thing,
        List objectList3 = integerList;

        // So, you can parse a raw type to any method that has a method argument,
        // with a type argument even a method that specifies an upper bound,
        // but you do so at your own peril.
        printObjectList(objectList3);
        printObjectList((List) integerList); // raw type


        printOpenDoor(objectList3);
        printLowerList(objectList3);
        try {
            // So, you can parse a raw type to any method that has a method argument,
            // with a type argument even a method that specifies an upper bound,
            // but you do so at your own peril.
            printUpperList(objectList3);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e); // ClassCastException
        }


        System.out.println("-------------------------");
        List<? super Number> ls = new ArrayList<>();

        Integer a = 9;
        ls.add(a);
        // for (int a1 : ls) { }// type of read objects is 'Object' and type of write objects are Number and its subclasses


        // as upper-bounded wildcard is used, hence add operation is not supported.
        List<? extends Number> list0 = new ArrayList<>();
        // list0.add(10L);//does not compile

        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        List<? extends Number> list = new ArrayList<>(listOfIntegers);
        // list.add(10L); //does not compile

        List<Number> listNumber = new ArrayList<>();
        // List<Number> listNumber2 = listOfIntegers; // not allowed

        //  A<S> <<< A<? extends S> <<< A<? extends T>
        // Since Integer is a subtype of Number,
        // List<Integer> is a subtype of List<? extends Integer> and List<? extends Integer> is a subtype of List<? extends Number>.
        List<? extends Number> listExtendNumber = listOfIntegers; // allowed

        listNumber.add(10L);
        listNumber.add(12F);

        List<? extends Number> listSingle = new ArrayList<>(listNumber);
        // listSingle.add(10L);//does not compile

        /*
        The popular description "list can take a Number or a subclass of Number", is more fitting for:
        List<Number> listNumber = new ArrayList<>();


        Whereas:
        List<? extends Number> list = new ArrayList<>();
        can be thought of as "list can take a single type which is a subclass of Number".
        e.g. integerList1 = new ArrayList<Short>();
        */


        // The lower bound version (lbv):
        List<? super Number> list2 = new ArrayList<>();
        list2.add(10L); // compiles fine
        // has the opposite effect. We can add (write) to it, but we can't read from it
        // (unless we use Object as the type), eg.

        // Long a2 = list2.get(0); // compiler error
        Object o = list2.get(0); // compiles fine
        // because once again, Java doesn't know what type will be returned.


        List<?> list3 = new ArrayList<>();
        // list3.add(10); // error,  You cannot add any thing to it and you can only retrieve Objects from it.


        //-----------------------

        List<? super Object> wildSuperObject = new ArrayList<>();
        wildSuperObject.add(new Object());
        wildSuperObject.add("aaa");

        List<?> wildList = new ArrayList<>();
        // wildList.add(new Object());
        // wildList.add("aaa");
        wildList.add(null); // Note that you can add null to it though i.e. list2.add(null); is valid.
    }
}