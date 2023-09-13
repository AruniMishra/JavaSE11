/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, create a generic class
*/

// Declaring non-generic or 'raw' type.
class SpecificallyTypedClass {

    // instance variable
    Object currentObj;

    // Constructor
    SpecificallyTypedClass(Object o) {
        this.currentObj = o;
        printType();
    }

    // instance method
    public void printType() {
        System.out.println("Instance variable type is Object, but " +
                "runtime type = " + this.currentObj.getClass().getName());
    }
}

class MyClass<T> {
    T aField;

    public MyClass(T aField) {
        this.aField = aField;
    }

    class InnerClass {
        int a;
        T aField;
    }
}


// Declaring a generic class
// also, Generic class can not extend 'java.lang.Throwable' & 'Exception'
class GenericallyTypedClass<T> {

    // Declaring an instance variable using type parameter
    T currentObj;

    // Constructor allows passing an object to the Generic class
    // using the type parameter T
    GenericallyTypedClass(T t) {
        this.currentObj = t;
        printType();
    }

    // instance method
    public void printType() {
        System.out.println("Instance variable type is T but compile" +
                " time type = " + this.currentObj.getClass().getName());
    }
}

public class TestGenerics {

    public static void main(String[] args) {

        MyClass<String> stringType = new MyClass<>("hello");

        // Declare and instantiate different instances of non-generic class
        SpecificallyTypedClass raw1 = new SpecificallyTypedClass("hello");
        SpecificallyTypedClass raw2 =
                new SpecificallyTypedClass(new StringBuilder("hello"));
        SpecificallyTypedClass raw3 = new SpecificallyTypedClass(10);

        // Declare and instantiate different instances of generic class

        // Declare type argument <String> on both sides of
        // assignment operator
        GenericallyTypedClass<String> generic1 =
                new GenericallyTypedClass<String>("hello");

        // Declare type argument <StringBuilder> on left side of assignment,
        // use <> diamond operator on right side
        GenericallyTypedClass<StringBuilder> generic2 =
                new GenericallyTypedClass<>(new StringBuilder("hello"));

        // Declare a LVTI (var), and specify type argument on right side of
        // assignment using  <Integer>
        var generic3 = new GenericallyTypedClass<Integer>(10);


        Object o = raw1.currentObj;

        // Code compiles, but if currentObj is not a String,
        // ClassCastException thrown
        /*
        you cannot guarantee that the object type you expected
        is actually the type of the object that you'll get using a raw type
         */
        // String cannot be cast to class java.lang.StringBuilder
        // StringBuilder s0 = (StringBuilder) o;

        // valid
        String s1 = (String) o;


        // You could write code as follows to try to prevent a
        // ClassCastException
        if (o instanceof String) {
            String s = (String) o;
        } else if (o instanceof StringBuilder) {
            StringBuilder s = (StringBuilder) o;
        } else {
            Integer s = (Integer) o;
        }


        // preferred with Generics instead raw
        /*
         this code is guaranteed to work without casting
         because we made a contract with the code that only objects of type string
         would ever be used in the generic1 instance.
         */
        String s2 = generic1.currentObj;


        // below gives compiler error
        // generic1 = new GenericallyTypedClass<>(new StringBuilder("hello"));
        // generic1 = new GenericallyTypedClass<StringBuilder>(new StringBuilder("hello"));
        // generic1 = new GenericallyTypedClass<String>(new StringBuilder("hello"));


        // below will not generate compiler error
        generic1 = new GenericallyTypedClass(new StringBuilder("hello"));
        // but this will generate ClassCastException
        // String s3 = generic1.currentObj;


        GenericallyTypedClass<Integer> generic4 = new GenericallyTypedClass<Integer>(10);

        // primitive not allowed
        // GenericallyTypedClass<int> generic4 = new GenericallyTypedClass<int>(10);

    }

}

