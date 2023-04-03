abstract class AbstractExample {

    // A constant can be defined on an abstract class
    public static final String ABSTRACT_CONSTANT = "Abstract";

    // a final static method can be declared on an abstract class
    public static final void doThisAndOnlyThis() {
        System.out.println("static final method is ok abstract class");
        System.out.println("My constant is " + ABSTRACT_CONSTANT);
    }

    // This is a final method, but is not static.  This means any
    // subclass can call it, but they cannot override it.
    public final void doThisAndThat() {
        System.out.println("My method may be final, " +
                "but it can still support polymorphism");
        System.out.println(doThis() + " and " + doThat());
    }

    // Implementing classes need to implement abstract methods.
    abstract String doThis();

    abstract String doThat();
}

// ConcreteExample implements the two abstract methods it inherits.
class ConcreteExample extends AbstractExample {

    String doThis() {
        return "I do this";
    }

    String doThat() {
        return "I do that";
    }

//    public static final void doThisAndOnlyThis() {
//        System.out.println("ConcreteExample: static final method is ok abstract class");
//        System.out.println("My constant is " + ABSTRACT_CONSTANT);
//    }
}

// Now we test our final methods...
public class AbstractClassExample {

    public static void main(String[] args) {
        // Call to the final static method...
        ConcreteExample.doThisAndOnlyThis();

        ConcreteExample c = new ConcreteExample();
        // Call to the final method defined on the abstract parent.
        c.doThisAndThat();
    }
}