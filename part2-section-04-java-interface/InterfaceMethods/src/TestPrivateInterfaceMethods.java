/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic: Default, Static, Private methods
*/

// This interface has new features for interfaces:
interface PrivateAndDefaultTestable {


    // static method
    public static void doInterfaceSomethingPublicAndStatic() {
        System.out.println("This is an interface's public and" +
                " static method");
        doInterfaceSomethingPrivateAndStatic();

        // doInterfaceSomethingPublicDefaultdoInterfaceSomethingPublicDefault();
        // doInterfaceSomethingPrivate();
    }

    // private static method accessible by static method
    private static void doInterfaceSomethingPrivateAndStatic() {
        System.out.println("\tThis is private and static interface " +
                " method");
    }

    // default method
    default void doInterfaceSomethingPublicDefault() {
        System.out.println("This is interface's public default method");
        // Accesses a private method
        doInterfaceSomethingPrivate();
        doInterfaceSomethingPublicAndStatic();
        doInterfaceSomethingPrivateAndStatic();
    }


    // private method consolidates code
    private void doInterfaceSomethingPrivate() {
        System.out.println("\tThis is private interface instance method");
    }
}

// Example of simple class with a public static method
class TestStatic {
    public static void doClassPublicAndStatic() {
        System.out.println("This is a class's public and static method");
    }
}

// This class tests ways to call interface methods (default, static, etc)
public class TestPrivateInterfaceMethods extends TestStatic implements PrivateAndDefaultTestable {
    public static void main(String[] args) {
        // Accessing static method on a class (when current class is subclass)
        // from a static method
        doClassPublicAndStatic();

        // Access static method on class with class qualifier
        TestStatic.doClassPublicAndStatic();

        new TestStatic().doClassPublicAndStatic(); // valid on class, but invalid on Interface
        new TestPrivateInterfaceMethods().doClassPublicAndStatic(); // valid on class, but invalid on Interface

        // Access static method on interface with interface qualifier
        PrivateAndDefaultTestable.doInterfaceSomethingPublicAndStatic();

        PrivateAndDefaultTestable privateAndDefaultTestable = new TestPrivateInterfaceMethods();
        // privateAndDefaultTestable.doInterfaceSomethingPublicAndStatic(); // invalid on interface


        // Cannot call without qualifier even if current class implements interface
        // doInterfaceSomethingPublicAndStatic();


        // Cannot use interface with super in a static method
        // PrivateAndDefaultTestable.super.doInterfaceSomethingPublicAndStatic();


        // Call non-static method using instance of current class
        new TestPrivateInterfaceMethods().testNonStatic();


        // Non-static method 'doInterfaceSomethingPublicDefault()' cannot be referenced from a static context
        // doInterfaceSomethingPublicDefault();


        // calling default from static with class object.
        new TestPrivateInterfaceMethods().doInterfaceSomethingPublicDefault();

    }

    void testNonStatic() {
        System.out.println("\n---- Executing interface methods in " +
                "instance method ---");

        // Accessing static method on a class (when current class is subclass)
        // from an instance method
        doClassPublicAndStatic();

        // Access static method on class with class qualifier
        TestStatic.doClassPublicAndStatic();

        new TestStatic().doClassPublicAndStatic();// also valid,

        // Access static method on interface with interface qualifier
        PrivateAndDefaultTestable.doInterfaceSomethingPublicAndStatic();

        // Can call default method on interface, but only in a non-static context
        doInterfaceSomethingPublicDefault();

        // Can use "default method" with super in a "non-static method only"
        /*
        If you want to invoke the default method implementation, then the correct syntax is:
         [Interface_name].super.[default_method_name].
         */
        PrivateAndDefaultTestable.super.doInterfaceSomethingPublicDefault();

        // Cannot call without qualifier even if current class implements interface
        // from non-static context
        // Static method may be invoked on containing interface class only
        // doInterfaceSomethingPublicAndStatic();

    }
}
