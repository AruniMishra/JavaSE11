/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Using annotations in java.lang package.
*/

// Create a class with a method marked as deprecated
public class HasDeprecatedMethod {
    /*
    @Deprecated annotation has 2 attributes: 'since' and 'forRemoval'.
    Default value of 'since' is empty string "" and  default value of 'forRemoval' is false.
    Javadoc comment for this method uses @deprecated tag to provide documentation about the deprecation.
     */


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

    // @SuppressWarnings must support three values: unchecked, deprecation, and removal
    @SuppressWarnings({"deprecation", "removal"})
    // @SuppressWarnings({"deprecated", "removal"}) // valid, but "deprecated" is not a valid value.
    /*
    @SuppressWarnings("deprecation") => As we are passing just one value, "deprecation" to String [],
    hence {} can be omitted
     */
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