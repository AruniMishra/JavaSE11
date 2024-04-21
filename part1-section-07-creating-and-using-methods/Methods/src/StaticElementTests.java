// This class demonstrates static fields, a static initializer, and
// a static method
class StaticStuff {
    static final String appName = "A Good App";
    static int counter = 0;

    // static initializer block
    /*
     * only invoked in below conditions satisfies:
     * 1. any of the non-final, static member is referred in "main" class; either
     * when referred via:
     * 1.1 class reference, or
     * 1.2 instance reference
     * 2. Class object is initialized.
     *
     * Also, static block only invokes once.
     *
     * Reasoning:
     * The class does not have to be initialized for the application to use that
     * field;
     * cause of course once we set the "final" value, it can no longer be changed.
     *
     */
    static {
        System.out.println("Initializing StaticStuff class");
        StaticStuff.counter++;
    }

    static void printAppName() {
        System.out.println("Application Name:  " + appName + " : counter  = " + counter);
    }

}

public class StaticElementTests {
    public static void main(String[] args) {

        // Add some 'work' first to prove StaticStuff not initialized
        // on start-up
        for (int i = 0; i < 3; i++) {
            System.out.println("Printing " + (i));
        }

        // System.out.println(StaticStuff.counter);
        // System.out.println(StaticStuff.appName);
        // System.out.println(StaticStuff.counter);

        // ** Create an object of type StaticStuff.
        StaticStuff st = new StaticStuff();
        // StaticStuff st = null;
        System.out.println("Has it been initialised? ");

        // We access static member of the StaticStuff class
        System.out.println("Application Name: " + st.appName + "  " + st.counter);

        int myCounter = StaticStuff.counter;
        System.out.println("myCounter = " + myCounter);

        // Execute static method on StaticStuff
        st.printAppName();

        StaticStuff s = new StaticStuff();
        System.out.println("Created first instance of StaticStuff");
        s.printAppName();

        System.out.println("Created second instance of StaticStuff");
        StaticStuff s0 = new StaticStuff();
        s0.printAppName();

        System.out.println("Created third instance of StaticStuff");
        StaticStuff s1 = new StaticStuff();
        s1.printAppName();

    }
}