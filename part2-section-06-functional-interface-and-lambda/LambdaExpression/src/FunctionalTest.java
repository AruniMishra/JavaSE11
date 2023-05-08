
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 5: Functional Interface and Lambda Expressions
Topic:  Lambda Expression Extras
*/

// Interface with 3 abstract methods
interface Functionable {

    int function(int i1, int i2);

    String toString();

    boolean equals(Object o);
}

public class FunctionalTest {
    public static void main(String[] args) {
        // Lambda Expression using Functionable interface, which implies
        // Functionable interface is a function interface.
        Functionable f = (s, t) -> s + t;
        System.out.println(f.function(5, 5));
        System.out.println(f.toString());
    }
}
