/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Use wrapper classes, Autoboxing, Unboxing during assignments
*/

public class WrapperClassAssignments {

    // No assignment required for static and instance fields
    static Boolean myStaticBoolean = true;  // default is null
    static boolean myStaticboolean;  // default is false

    // Autoboxing permitted during assignment to a field
    Boolean myInstanceBoolean = false;

    // Unboxing permitted during assignment to a field
    boolean myInstanceboolean = myStaticBoolean;

    public static void main(String[] args) {
        WrapperClassAssignments w = new WrapperClassAssignments();

        // Set a wrapper variable to a boolean variable (AutoBoxing)
        Boolean bWrapperVariable = w.myInstanceboolean;
        System.out.println("bWrapperVariable = " + bWrapperVariable);

        // Set a wrapper variable to a boolean literal (AutoBoxing)
        Boolean bWrapperVariable2 = true;
        System.out.println("bWrapperVariable2 = " + bWrapperVariable2);

        // Set a primitive variable directly to a wrapper (Unboxing)
        boolean bPrimitiveVariable = w.myInstanceBoolean;
        System.out.println("bPrimitiveVariable = " + bPrimitiveVariable);

        // Passing boolean primitive to Boolean wrapper parameter
        // (Autoboxing)
        testBoolean(true);

        // Passing Boolean local variable to boolean primitive
        // parameter (Unboxing)
        testboolean(bWrapperVariable);
    }

    // Method declared with Boolean wrapper but can be invoked
    // with a primitive
    private static void testBoolean(Boolean b) {
        System.out.println("Boolean Wrapper Value = " + b);
    }

    // Note case of method name below, avoiding overloading the method
    // Do not want JVM to decide which method is invoked.
    private static void testboolean(boolean b) {
        System.out.println("boolean Value = " + b);
    }
}
