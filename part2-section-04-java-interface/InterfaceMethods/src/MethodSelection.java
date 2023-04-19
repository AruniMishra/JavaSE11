/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Nested Class, Extras
*/

interface LessSpecificInterface {
    default void doSomething() {
        System.out.println("LessSpecific: doSomething");
    }
}

interface MoreSpecificInterface {
    default void doSomething() {
        System.out.println("MoreSpecific: doSomething");
    }
}

class SuperClass {
    int a;

    public void doSomething() {
        System.out.println("SuperClass: doSomething");
    }
}

public class MethodSelection extends SuperClass implements MoreSpecificInterface {
    public static void main(String[] args) {
        MethodSelection methodSelection = new MethodSelection();
        methodSelection.callDoSomething();
    }

    public void callDoSomething() {
        System.out.println(a);
        doSomething();

        // LessSpecificInterface.super.doSomething();
    }

    public void doSomething() {

    }
}