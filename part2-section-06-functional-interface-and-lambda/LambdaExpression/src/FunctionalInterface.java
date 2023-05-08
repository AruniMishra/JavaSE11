/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 5: Functional Interface and Lambda Expressions
Topic:  Functional Interface Examples
*/

// package-private functional interface with Single-Abstract-Method
interface Doable {
    void doIt();
}

// Extending interfaces
@java.lang.FunctionalInterface
interface ExtendedDoable extends Doable {

    // void extendedDoIt(); // adding it makes it non-functional interface

    // void doIt(); // valid, overriding the method


    // overriding it with default interface (if only method here), makes it non-functional interface
    default void doIt() {
        System.out.println("Default method implementing doIt()");
    }

    void extendedDoIt(); // makes it functional interface again
}


public class FunctionalInterface {

    public static void main(String[] args) {

        // Anonymous class implements Doable interface
        Doable d = new Doable() {
            public void doIt() {
                System.out.println("Anonymous class invoking doIt()");
            }
        };

        // Lambda Expression assigned to a Doable local variable
        Doable d2 = () ->
                System.out.println("Lambda Expression invoking doIt()");


        // Lambda Expression assigned to a ExtendedDoable local variable
        ExtendedDoable exd2 = () ->
                System.out.println("ExtendedDoable Lambda Expression invoking doIt()");

        // Anonymous class implements Shapeable interface
        Shapeable s = new Shapeable() {
            public void shapeIt() {
                System.out.println("Anonymous class invoking shapeIt()");
            }
        };

        // Lambda Expression assigned to a Shapeable local variable
        Shapeable s2 = () ->
                System.out.println("Lambda Expression invoking shapeIt()");

        System.out.print("main executes anonymous class d.doIt(): ");
        d.doIt();
        System.out.print("main executes anonymous class s.shapeIt(): ");
        s.shapeIt();

        // Execute method passing anonymous class
        doItWithDoable(d);
        // Execute method passing anonymous class
        doItWithShapeable(s);

        // Execute method passing local variable with lambda expression
        doItWithDoable(d2);
        doItWithDoable(exd2); // executed the default method doIt(), and not the code in the lambda expression.
        // Execute method passing local variable with lambda expression
        doItWithShapeable(s2);


        System.out.println("----------------");
        // Execute method passing anonymous class
        doItWithDoable2(d);

        // Execute method passing local variable with lambda expression
        doItWithDoable2(d2);
        doItWithDoable2(exd2); // executed the default method do it, and not the code in the lambda expression.

    }

    // Pass through method to execute Interface method
    private static void doItWithDoable(Doable d) {
        System.out.print("doItWithDoable executes d.doIt(): ");
        d.doIt();
    }

    private static void doItWithDoable2(Doable d) {
        if (d instanceof ExtendedDoable) {
            System.out.print("doItWithDoable executes d.extendedDoIt(): ");
            ((ExtendedDoable) d).extendedDoIt();
        } else {
            System.out.print("doItWithDoable executes d.doIt(): ");
            d.doIt();
        }
    }


    // Pass through method to execute Interface method
    private static void doItWithShapeable(Shapeable s) {
        System.out.print("doItWithShapeable executes s.shapeIt(): ");
        s.shapeIt();
    }

    // private nested functional interface
    private interface Shapeable {
        void shapeIt();
    }


}

