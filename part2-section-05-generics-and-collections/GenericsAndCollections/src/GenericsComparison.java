/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generic Methods
*/

import java.util.ArrayList;
import java.util.List;

// A generic class with no generic methods
class GenericsClass<T> {

    // instance field set to type of type parameter of the class
    T aGenericField;

    // constructor takes argument (typed to type parameter of the class)
    GenericsClass(T aGenericField) {
        this.aGenericField = aGenericField;
        System.out.println("GenericsClass constructor: " +
                aGenericField.getClass().getName());
    }

    // method returns result typed to type parameter of the class
    public T aGenericClassMethod() {
        return this.aGenericField;
    }

    public <E> T genericStaticMethod(E aGenericParameter) {
        System.out.println("NonGenericClass: static generic method: " +
                aGenericParameter.getClass().getName());
        return this.aGenericField;
    }
}

// a non-generic class with generic methods
class NonGenericClass {

    // constructor declared with type parameter T.
    // Method's single argument restricted to method type parameter
    <T> NonGenericClass(T aGenericParameter) {
        System.out.println("NonGenericClass: generic constructor: " +
                aGenericParameter.getClass().getName());
    }

    // static method with type parameter
    // Method's single argument restricted to method type parameter
    public static <T> void genericStaticMethod(T aGenericParameter) {
        System.out.println("NonGenericClass: static generic method: " +
                aGenericParameter.getClass().getName());
    }

    // instance method with type parameter
    // Method's single argument restricted to method type parameter
    public <T> void genericInstanceMethod(T aGenericParameter) {
        System.out.println("NonGenericClass: instance generic method: " +
                aGenericParameter.getClass().getName());
    }
}

public class GenericsComparison {
    public static void main(String[] args) {

        // Create instances of generic class using type arguments
        GenericsClass<Number> a1 =
                new GenericsClass<>(Double.valueOf("10"));
        GenericsClass<ArrayList<String>> a2 =
                new GenericsClass(List.of("A", "B", "C"));

        GenericsClass<ArrayList<String>> a3 =
                new GenericsClass<>(new ArrayList<>(List.of("A", "B", "C")));

        // Create instances of non-generic class with a generic
        // constructor same as any other non-generic - compiler uses type
        // inference
        NonGenericClass b1 = new NonGenericClass(Double.valueOf("10"));

        //  Alternately, you can specify the type for clarity if desired
        NonGenericClass b2 = new <ArrayList<String>>NonGenericClass(
                new ArrayList<>(List.of("A", "B", "C")));

        // Invoking static generic method specifying type (optional)
        NonGenericClass.<Exception>genericStaticMethod(
                new RuntimeException("Just Testing"));

        // Invoking instance generic method
        b1.genericInstanceMethod("Hello");
    }
}

