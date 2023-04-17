/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Method clashing
*/

interface FirstInterface {
    // private method
    static void methodA() {
        System.out.println("FirstInterface's default method A");
    }

    default void defaultA() {
        System.out.println("FirstInterface's default method A");
        methodA();
    }
}

interface SecondInterface {
    // static (and public) method
    static void methodA() {
        System.out.println("SecondInterface's default method A");
    }

    default void defaultA() {
        System.out.println("SecondInterface's default method A");
    }
}

public class ClashingMethods implements FirstInterface {
    public static void main(String[] args) {
        ClashingMethods first = new ClashingMethods();
        // Calling static method on an interface
        SecondInterface.methodA();
        FirstInterface.methodA();

        // first.methodA(); // not allowed

        first.defaultA();

    }
}