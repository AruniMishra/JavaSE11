/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Using annotations in java.lang package.
*/

// Create a class with a method marked as deprecated
public class HasDeprecatedMethod {
    /**
     * Using javadoc tag @deprecated
     *
     * @deprecated As of release 1.2, replaced by {@link #doThat()}
     */
    // Using annotation @Deprecated
    @Deprecated(
            since = "1.3",
            forRemoval = true)
    public void doThis() {
        System.out.println("Doing this");
    }


    /**
     * Using javadoc tag @deprecated
     *
     * @deprecated As of release 1.5
     */
    @Deprecated(
            since = "1.5")
    public void doThisAlso() {
        System.out.println("Doing this also");
    }


    public void doThat() {
        System.out.println("Doing that");
    }
}

class JavaLangAnnotations {

    @SuppressWarnings({"deprecation", "removal"})
    // @SuppressWarnings({"removal"})
    // @SuppressWarnings({"deprecation"})
    public static void main(String[] args) {
        HasDeprecatedMethod hasDeprecatedMethod = new HasDeprecatedMethod();
        // Deprecated method usage...
        hasDeprecatedMethod.doThis();


        // Deprecated method usage...
        // hasDeprecatedMethod.doThisAlso();

    }
}