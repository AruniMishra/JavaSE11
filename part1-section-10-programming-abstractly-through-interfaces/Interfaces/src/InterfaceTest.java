@FunctionalInterface
interface InterfaceExample {

    // Define some variables

    /**
     * All fields on an interface are "public static final"
     */

    // no modifiers at all
    String interfaceName = "InterfaceExample";

    // single modifier
    static String staticInterfaceName = "StaticInterfaceExample";
    public String publicInterfaceName = "PublicInterfaceName";
    final String finalInterfaceName = "FinalInterfaceName";

    // double modifiers
    public final String publicFinalInterfaceName = "PublicFinalInterfaceName";
    static final String staticFinalInterfaceName = "StaticFinalInterfaceName";

    // triple modifiers
    public static final String publicStaticFinalInterfaceName = "PublicStaticFinalInterfaceName";


    /**
     * private methods(java 9); both static and non-static concrete methods can be private
     */
    private static String privateStaticMethod() {
        return "private static";
    }

    static String publicStaticMethod() {
        // You can call private static method from public static method
        return InterfaceExample.privateStaticMethod() + " then static";
    }

    // These methods are private because we declared them private.
    // For concrete - only private
    private String privateMethod() {
        return "private";
    }

    // These methods are public implicitly
    default String defaultMethod() {
        // You can call private method from a default method
        return privateMethod() + " then default";
    }

    /*
    a functional interface has exactly one abstract method.
     */
    // This is the public method that would, in theory, be the method
    // that you want all implementing classes to have in common.
    abstract void theImportantMethod();


    // nested class also permitted
    abstract class abstractNestedclass {
        abstract void abstractNestedClassMethod();
    }


    // nested class also permitted
    class nestedclass {
        void nestedclassMethod() {

        }
    }

}

public class InterfaceTest implements InterfaceExample {
    public static void main(String[] args) {

        // Regardless of how you define it, a variable on an interface is
        // public static final
        System.out.println("All fields on an interface are" +
                " public static final:");
        System.out.println(InterfaceExample.interfaceName);
        System.out.println(InterfaceExample.staticInterfaceName);
        System.out.println(InterfaceExample.publicInterfaceName);
        System.out.println(InterfaceExample.finalInterfaceName);
        System.out.println(InterfaceExample.publicFinalInterfaceName);
        System.out.println(InterfaceExample.staticFinalInterfaceName);
        System.out.println(InterfaceExample.publicStaticFinalInterfaceName);

        System.out.println("\nExecuting concrete methods on interface");
        // public static method can be accessed from type
        System.out.println(InterfaceExample.publicStaticMethod());

        // default method can be accessed from object which implements type
        InterfaceTest it = new InterfaceTest();
        System.out.println(it.defaultMethod());

        System.out.println("\nExecuting methods using the interface type");
        InterfaceTest anotherIt = new InterfaceTest();
        it.testInterface(anotherIt);

        Object o = anotherIt;
        it.testInterface(o);

    }

    public void theImportantMethod() {
        System.out.println("This is the important method that all objects " +
                "implementing InterfaceTest must override and implement ");
    }

    // Method that accepts the interface as a parameter
    public void testInterface(InterfaceExample it) {
        System.out.println("Executing testInterface with InterfaceExample");
        it.theImportantMethod();
    }

    // Method that accepts on object as a parameter
    public void testInterface(Object o) {
        System.out.println("Executing testInterface with Object");
        // Using instanceof with an interface
        if (o instanceof InterfaceExample) {

            // Casting using an interface
            InterfaceExample it = (InterfaceExample) o;
            it.theImportantMethod();
        }

    }

}