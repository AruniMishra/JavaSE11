// Option1

// import nest.EnclosingClass;

// Option2, static here is optional
import static nest.EnclosingClass.NestedStaticClass;

public class StaticClassExample {
    public static void main(String[] args) {
        /*
        Option1
         */

        // // Reference static field on static nested class directly:
        // System.out.println(EnclosingClass.NestedStaticClass.staticName);
        //
        // // Reference static method on static nested class directly:
        // System.out.println(EnclosingClass.NestedStaticClass.getStaticName());
        //
        // // Reference enum on static nested class directly:
        // System.out.println(EnclosingClass.NestedStaticClass.Colors.BLUE);
        //
        // // Local variable declaration using a nested class's interface
        // EnclosingClass.NestedStaticClass.NestedInterface n;
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
        NestedStaticClass.NestedInterface n;

        //____________________________________________________________


        // Create an instance of the static class
        NestedStaticClass nInstance = new NestedStaticClass();
        System.out.println(nInstance.getInstanceName());

    }
}
