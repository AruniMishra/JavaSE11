// This class demonstrates static fields, a static initializer, and
// a static method
class StaticStuff {
    static final String appName = "A Good App";
    static int counter;

    // static initializer
    static {
        System.out.println("Initializing StaticStuff class");
        StaticStuff.counter++;
    }

    static void printAppName() {
        System.out.println("Application Name:  " + appName +
                " : counter  = " + counter);
    }
}


public class StaticElementTests {
    public static void main(String[] args) {

        // Add some 'work' first to prove StaticStuff not initialized
        // on start-up
        for (int i = 0; i < 3; i++) {
            System.out.println("Printing " + (i));
        }

        System.out.println(StaticStuff.appName);

        //** Create an object of type StaticStuff.
        StaticStuff st = null;

//        // We access static member of the StaticStuff class
        System.out.println("Application Name: " + st.appName + "  " + st.counter);
//
//        int myCounter = StaticStuff.counter;
//        System.out.println("myCounter = " + myCounter);
//
//        // Execute static method on StaticStuff
//        // s.printAppName();
//
//        StaticStuff s = new StaticStuff();
//        System.out.println("Created first instance of StaticStuff");
//        s.printAppName();
//
//        System.out.println("Created second instance of StaticStuff");
//        StaticStuff s0 = new StaticStuff();
//        s0.printAppName();
//
//        System.out.println("Created third instance of StaticStuff");
//        StaticStuff s1 = new StaticStuff();
//        s1.printAppName();
//

    }
}