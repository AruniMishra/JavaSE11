// Option1

// import nest.EnclosingClass;

// Option2, static here is optional

import nest.EnclosingClass;

import static nest.EnclosingClass.NestedStaticClass;

public class StaticClassExample {
    public static void main(String[] args) {
        /*
        Option1
         */

        // Reference static field on static nested class directly:
        System.out.println(NestedStaticClass.staticName); // NestedStaticClass is a static class, it is not required to have an associated outer class instance.


        // Reference static method on static nested class directly:
        System.out.println(EnclosingClass.NestedStaticClass.getStaticName());

        // Reference enum on static nested class directly:
        System.out.println(EnclosingClass.NestedStaticClass.Colors.BLUE);

        // Local variable declaration using a nested class's interface
        EnclosingClass.NestedStaticClass.NestedInterface n;
        //____________________________________________________________

        /*
        Option2
         */
        // Reference static field on static nested class directly:
        System.out.println(NestedStaticClass.staticName);

        // Reference static method on static nested class directly:
        System.out.println(NestedStaticClass.getStaticName());

        // Reference enum on static nested class directly:
        System.out.println(NestedStaticClass.Colors.BLUE);

        // Local variable declaration using a nested class's interface
        NestedStaticClass.NestedInterface n1;

        //____________________________________________________________


        // Create an instance of the static class
        NestedStaticClass nInstance = new NestedStaticClass();
        System.out.println(nInstance.getInstanceName());

        // create object of static class
        NestedStaticClass nInstance1 = new EnclosingClass.NestedStaticClass(); // also valid

        // Since static nested class is a static class, it does not have an instance of the outer class associated with it
        // new EnclosingClass().new NestedStaticClass(); // NestedStaticClass is static inner class and cannot be instantiated like this

    }
}
