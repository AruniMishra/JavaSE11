/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 5: Functional Interface and Lambda Expressions
Topic:  Lambda Expression Examples
*/

// Create a very basic functional interface
interface Viewable {
    void view();
}

public class LambdaExamples {

    // Anywhere you declare a variable, you can use a lambda expression
    private static Viewable staticViewable =
            () -> System.out.println("Static Variable Lambda");

    private Viewable instanceViewable =
            () -> System.out.println("Instance Variable Lambda");

    // Method parameter using the interface type
    private static void viewIt(Viewable v) {
        v.view();
    }

    public static void main(String[] args) {

        // local variable assigned a lambda expression
        // (the body enclosed in {})
        Viewable localViewable = () -> {
            System.out.println("Local Variable Lambda");
        };   // Observe the semi-colon.  Do not omit

        // Execution of lambda expressions deferred until
        // these methods are invoked.
        viewIt(localViewable);
        viewIt(staticViewable);
        viewIt(new LambdaExamples().instanceViewable);

        // lambda method is passed as part of the invocation
        viewIt(()-> System.out.println("Lambda Expression on the fly"));


        for (String s : new String[]{"First", "Second", "Third"}) {
            viewIt(() -> System.out.println("Lambda Expression" +
                    " on the fly " + s));
        }


    }

}
