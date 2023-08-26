/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Using @SafeArgs
*/

import java.util.Arrays;

// Create a simple generic class
class MyClass<T> {
    T name;

    MyClass(T name) {
        this.name = name;
    }
}

public class SafeArgsExample {
    // @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // Generic Array creation is not allowed
        // MyClass<String>[] myArray = { // invalid
        MyClass[] myArray = { // this is valid
                new MyClass<>("jane"),
                new MyClass<>("joe")
        };

        // Yet you can do this...
        doSomething(new MyClass<>("jane"), new MyClass<>("joe"));
    }

    // @SuppressWarnings("unchecked")
    // @SuppressWarnings("varargs") // this alone doesn't fix "heap pollution" error
    @SafeVarargs // equivalent to @SuppressWarnings({"unchecked", "varargs"})
    // Method with parameterized typed MyClass varargs
    public static void doSomething(MyClass<String>... myStuff) {
        Arrays.stream(myStuff)
                .forEach(System.out::println);
    }
}

    /*
    @SafeVarargs annotation can be applied to methods and constructors only it causes error if:
    - If it is applied to a fixed arity method/constructor
    - If it is applied to a variable arity method that is neither static nor final nor private
     */