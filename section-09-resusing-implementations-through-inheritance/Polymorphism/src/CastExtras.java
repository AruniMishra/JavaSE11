
import java.util.Arrays;

public class CastExtras {
    // Just want a few classes to play with

    static class BaseClass {
        String name = "Base Case";

        public String toString() {
            return getClass().getName();
        }
    }

    static class NextClass extends BaseClass {
        String name = "Next Best Case";
    }

    // main method, we'll test out some more casting examples
    public static void main(String[] args) {

        // Let's create the most generic of arrays
        Object[] myObjectArray = new Object[10];

        // This fills an Object array with Objects that are NextClass
        // It does not change the type of array to NextClass[]
        Arrays.fill(myObjectArray, new NextClass());

        // You can put any type of Object in there
        myObjectArray[5] = new StringBuilder("test");

        System.out.println(myObjectArray.getClass().getTypeName());
        System.out.println(Arrays.toString(myObjectArray));

        // We are going to loop through our array and cast each
        // object first to a NextClass to print the name attribute on
        // NextClass, and then we cast to BaseClass to print the
        // name attribute on the BaseClass
        try {
            for (Object o : myObjectArray) {
                // We can cast to most specific class
                NextClass n = (NextClass) o;
                System.out.println(n.name);

                // We can cast to less specific class if we prefer more
                // generic name
                BaseClass b = (BaseClass) o;
                System.out.println(b.name);
            }
        } catch (Exception e) {
            // Not to mention any object might be in your array...
            e.printStackTrace(System.out);
        }

        System.out.println("------");
        // Next we'll create an array of mixed types, using the common
        // denominator BaseClass
        BaseClass mixedArray[] = new BaseClass[6];
        // Fill half with NextClass
        Arrays.fill(mixedArray,0, 3, new NextClass());
        // Fill half with BaseClass
        Arrays.fill(mixedArray,3, 6, new BaseClass());

        System.out.println(Arrays.toString(mixedArray));
        for (BaseClass n : mixedArray) {
            // We cast if we want NextClass's more specific name...
            System.out.println(n + ":" +
                    // ternary conditional operator uses instanceof
                    ((n instanceof NextClass) ? ((NextClass) n).name : n.name)
            );
        }
        System.out.println("----------");

        // Compiler let's you get away with it, it's feasible that
        // that mixedArray could be populated with objects of its subtype only
        // but JVM won't allow it
//        NextClass[] nextArray = (NextClass[]) mixedArray;

        // Let's actually fill it with just NextClass objects .
//        Arrays.fill(mixedArray, new NextClass());
//        JVM still doesn't allow it
//        NextClass[] nextArray2 = (NextClass[]) mixedArray;


        /**
         * below code will compile, but will JVM won't allow.
         */
        BaseClass baseClass1 = new BaseClass();
        NextClass nextClass1 = (NextClass) baseClass1;



        BaseClass baseClass2 = new NextClass();
    }
}