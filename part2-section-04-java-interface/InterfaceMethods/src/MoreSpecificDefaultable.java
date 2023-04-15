/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Interfaces
Topic:  Default methods
*/

// Interface extends Defaultable, and overrides the default method
public interface MoreSpecificDefaultable extends Defaultable {
    // default void defaultNotAbstractMethod() {
    //     System.out.println("MoreSpecificDefaultable default method ");
    // }

    // override the default method making it abstract in an implementing class or extending interface,
    // forcing implementation to subtypes or implementing types.
    void defaultNotAbstractMethod();
}

// Class implements both interfaces
// class MoreSpecific implements Defaultable, MoreSpecificDefaultable {
class MoreSpecific extends DefaultClass implements Defaultable, MoreSpecificDefaultable {

    // invokes the abstract method
    public static void main(String[] args) {
        new MoreSpecific().abstractMethod();
    }

    // implements the abstractMethod and calls the default method
    public void abstractMethod() {
        defaultNotAbstractMethod();  // Which default method is used?
    }

   /* public void defaultNotAbstractMethod() {
        // Try to specify that you want to  use Defaultable's default method
        // invalid
        // Defaultable.super.defaultNotAbstractMethod();

        new Defaultable() {
            public void abstractMethod() {
            }
        }.defaultNotAbstractMethod();
    }*/
}

