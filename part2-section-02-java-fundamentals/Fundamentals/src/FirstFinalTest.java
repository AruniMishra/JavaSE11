/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals
Topic 1: Final modifier used with classes.
*/

// The following class is a class with no modifiers which means we can
// use it to subclass and we can override methods except final methods
class ExtendMeOptional {

    // private not allowed
    // private ExtendMeOptional() {}

    // This method is valid for overriding
    public void doSomething() {
        System.out.println("Overriding ExtendMeOptional.doSomething " +
                "is optional");
    }

    // A final method in a non-final class cannot be overridden by a
    // subclass
    public final void doSomethingFinally() {
        System.out.println("Overriding ExtendMeOptional.doSomethingFinally " +
                "is NOT optional");
    }
}

// The following class is a class with the final modifier which means we
// can NOT use it to subclass.
final class ExtendMeNotAllowed {
    // creating private prevents creating of the instance
    // private ExtendMeNotAllowed(){}

    public void doSomething() {
        System.out.println("Overriding ExtendMeNotAllowed.doSomething " +
                "is NOT optional");
    }

    // final modifier here is redundant since there will be no subclass
    // to override this method
    public final void doSomethingFinally() {
        System.out.println("Overriding ExtendMeNotAllowed.doSomethingFinally" +
                " is also NOT optional");
    }

}

public class FirstFinalTest {
    public static void main(String[] args) {

        // Create an instance of the non-modified class
        // and execute it's methods
        ExtendMeOptional objectA = new ExtendMeOptional();
        objectA.doSomething();
        objectA.doSomethingFinally();

        // Create an instance of the final modified class
        // and execute it's methods
        ExtendMeNotAllowed objectB = new ExtendMeNotAllowed();
        objectB.doSomething();
        objectB.doSomethingFinally();

        System.out.println("----------------------------------------------------");
        // Create an instance of our extended class
        // and execute it's methods
        MyFirstExtendedClass objectC = new MyFirstExtendedClass();
        objectC.doSomething();
        objectC.doSomethingFinally();

        System.out.println("----------------------------------------------------");
        // Create an instance of our class which extends the abstract class
        // class and execute it's methods
        MySecondExtendedClass objectD = new MySecondExtendedClass();
        objectD.doSomething();
        objectD.doSomethingFinally();
    }
}

class MyFirstExtendedClass extends ExtendMeOptional {
    // This method is valid for overriding
    public void doSomething() {
        System.out.println("This method is better for my subclass than " +
                "the original ExtendMeOptional.doSomething ");
    }
}

// The following class is an abstract class which means we MUST subclass it.
// It is incomplete in its current form and cannot be instantiated.
abstract class ExtendMeRequired {

    public abstract void doSomething();

    // A final method in a non-final class cannot be overridden by a subclass
    public final void doSomethingFinally() {
        System.out.println("Overriding ExtendMeRequired.doSomethingFinally " +
                "is not optional");
    }
}

final class MySecondExtendedClass extends ExtendMeRequired {

    // an overridden method can be modified with the final modifier and
    // still considered a valid override.
    public final void doSomething() {
        System.out.println("Implementation of this method was required");
    }
}

