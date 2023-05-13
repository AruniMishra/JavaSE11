/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Stream API
Topic:  Method References and Lambda Expressions
*/

// Simple Functional Interface
interface MyInterface {

    String doSomething(String s);
}

// Class implements Functional Interface
class MyClass implements MyInterface {

    public String doSomething(String s) {
        return "3.  MyClass " + s;
    }
}

public class FunctionalInterfaceArguments {
    public static void main(String[] args) {

        // Create local variable, assign lambda expression to it
        MyInterface i = (s) -> "1.  variable " + s;

        // Executing operation passing Interface parameter
        executeInterface(i);

        // Executing operation passing lambda expression directly
        executeInterface((s) -> "2.  unnamed " + s);

        // Executing operation passing method reference
        executeInterface(new MyClass()::doSomething);

        // Executing operation passing return value (interface) of
        // another method
        executeInterface(FunctionalInterfaceArguments.returnInterface());


        // This is important to understand: When you pass a method reference
        // as a parameter to a method argument defined by a functional
        // interface, the method must have the same signature and return
        // type as the functional interface's only qualifying abstract method.

        // So in this example the method I reference returns a MyInterface
        // interface and not a method that matches the signature of
        // MyInterface.doSomething, the string doSomething parameter string method.
        // executeInterface(FunctionalInterfaceArguments::returnInterface);

    }

    // to make line 50 valid,
    // private static String returnInterface(String s) {
    //     return s;
    // }

    // Example operation that accepts functional interface as argument
    private static void executeInterface(MyInterface i) {
        System.out.println(i.doSomething("hello"));
    }

    // Returns an interface.
    private static MyInterface returnInterface() {
        MyInterface i = (s) -> "4.  method " + s;
        return i;
    }
}

