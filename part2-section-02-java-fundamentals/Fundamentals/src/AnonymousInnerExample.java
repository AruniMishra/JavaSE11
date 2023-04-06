interface Doable {
    void doSomething();
}

abstract class AnAbstractClass {
    int i;

    public abstract void doSomething();
}

public class AnonymousInnerExample {
    String name = "Default";

    public static void main(String[] args) {
        new AnonymousInnerExample().testAnonymous();
    }

    public void testAnonymous() {

        // Declare a variable of type AnAbstractClass and immediately
        // define the class body
        AnAbstractClass a = new AnAbstractClass() {

            // static fields, initializers, methods not allowed
            // static int a =0;

            // Implementing the abstract method on AnAbstractClass
            public void doSomething() {
                System.out.println("Anonymous AnAbstractClass " +
                        "will doSomething with " + i);
            }
        };  // Declaration occurs in an expression and must end with ';'

        a.doSomething();

    }
}