public class LocalClassExample {
    private String defaultName = "Jane";

    // local field for last name
    private String lastName = "Doe";

    public static void main(String[] args) {
        new LocalClassExample().methodWithLocalClass();
    }

    // Creating a non-static method that declares a local class
    private void methodWithLocalClass() {

        // shadow enclosing class variable
        String defaultName = "Ralph";

        // by adding below code, defaultName is no longer effectively final
        // if (this.defaultName !=null ) defaultName = this.defaultName;


        // LocalClass Only has scope within this method
        class LocalClass {
            // local class can have all the same members as an outer class
            // (with the exception of static members).
            String name;

            // Constructor on local class
            private LocalClass(String name) {
                if (name == null) {
                    this.name = defaultName;
                } else {
                    this.name = name;
                }
                this.name += " " + LocalClassExample.this.lastName;
            }


            void performSomeAction() {
                System.out.println("LocalClass.name = " + name);

            }
            // Static declarations in inner classes are not supported at language level '11'
            // static String s;
        }

        // Create multiple instances of local class within
        // the enclosing code's scope..
        LocalClass jeff = new LocalClass("Jeff");
        LocalClass martha = new LocalClass("Martha");
        LocalClass bob = new LocalClass("Bob");

        // Execute methods on instances of the local class
        jeff.performSomeAction();
        martha.performSomeAction();
        bob.performSomeAction();

        // Access fields directly from instance of local class
        System.out.println("Bob's name is: " + bob.name);


        new LocalClass(null).performSomeAction();
    }
}
