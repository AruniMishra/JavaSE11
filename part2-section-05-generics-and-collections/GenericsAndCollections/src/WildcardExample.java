/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, wildcards
*/

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

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
        System.out.println("\n----- Using lower bound ------");
        list.forEach((s) -> System.out.println(s));

    }

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

        // Exception NOT allowed by type arg <Object>
        //-- printObjectList(exceptionList);

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
        //--printUpperList(objectList);
    }
}