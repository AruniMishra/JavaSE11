/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals
Topic: Inner Classes, Extras
*/
public class OuterMost {

    private String OuterString = "Attribute of OuterMost class";

    // public inner class member
    public class PublicInner {

        static final String myStatic = "";
        private String InnerString = "Attribute of Public inner class";

        // Constructor
        public PublicInner() {
            // reference enclosing object's fields with simple name
            System.out.println("PublicInner instantiated, OuterString = " +
                    OuterString);
            // reference enclosing object's fields with class name & this
            System.out.println("PublicInner instantiated, OuterString = " +
                    OuterMost.this.OuterString);
        }

        // This inner class is now two levels deep
        public class NestedInnerSecondLevel {
            public NestedInnerSecondLevel() {

                // reference enclosing object's fields with simple name
                System.out.println("NestedInnerSecondLevel instantiated,"
                        + " OuterString = " + OuterString);

                // reference enclosing object's fields with class name & this
                System.out.println("NestedInnerSecondLevel instantiated," +
                        " OuterString = " + OuterMost.this.OuterString);

                // reference enclosing object's fields with simple name
                System.out.println("NestedInnerSecondLevel instantiated," +
                        " InnerString = " + InnerString);

                // reference enclosing object's fields with class name & this
                System.out.println("NestedInnerSecondLevel instantiated," +
                        " InnerString = " + OuterMost.PublicInner.this.InnerString);

            }
        }
    }

    // package/private inner class member
    class PackageInner {
        // Constructor
        public PackageInner() {
            System.out.println("PackageInner instantiated");
        }
    }

    // protected inner class member
    protected class ProtectedInner {
        // Constructor
        public ProtectedInner() {
            System.out.println("ProtectedInner instantiated");
        }
    }

    // private inner class member
    private class PrivateInner {
        // Constructor
        public PrivateInner() {
            System.out.println("PrivateInner instantiated");
        }
    }


}

class InnerClassExtras {
    public static void main(String[] args) {

        OuterMost outer = new OuterMost();

        // To access inner classes (from an unrelated class), an object
        // reference of the enclosing class is required, using .new construct.

        // Create a local variable using the public inner class
        OuterMost.PublicInner publicInner = outer.new PublicInner();

        // Create a local variable using the package-private inner class
        OuterMost.PackageInner packageInner = outer.new PackageInner();

        // Create a local variable using the protected inner class
        OuterMost.ProtectedInner protectedInner = outer.new ProtectedInner();


        System.out.println("\n--- Accessing a class two levels deep");
        // Create a local variable for the more nested inner class using
        // previous local variable publicInner
        OuterMost.PublicInner.NestedInnerSecondLevel nested =
                publicInner.new NestedInnerSecondLevel();

        // Or alternately chain instantiations outer to inner...
        OuterMost.PublicInner.NestedInnerSecondLevel alternate =
                new OuterMost()
                        .new PublicInner()
                        .new NestedInnerSecondLevel();

    }
}
