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

        // Anonymous class extending Object
        Object b = new Object() {
            public String toString() {
                return "Anonymous object";
            }
        };
        System.out.println(b);

        // Anonymous class implements interface Doable
        new Doable() {
            public void doSomething() {
                System.out.println("Anonymous Doable " +
                        "will doSomething with " + b);
            }
        }.doSomething();


        // If you want to pass parameters to your anonymous
        // class, you can extend abstract class using a local
        // class
        abstract class ConcreteClass extends AnAbstractClass {
            ConcreteClass(int i) {
                this.i = i;
            }
        }

        // This example shows an anonymous class created with an
        // instance initializer and passing a value to the constructor
        AnAbstractClass c = new ConcreteClass(5) {
            {
                i = 2 * this.i;
            }

            public void doSomething() {
                System.out.println("Anonymous AnAbstractClass " +
                        "will doSomething with " + i);
            }
        };
        c.doSomething();


    }
}