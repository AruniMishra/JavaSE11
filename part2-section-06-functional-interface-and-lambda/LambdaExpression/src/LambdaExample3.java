/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 5: Functional Interface and Lambda Expressions
Topic:  Lambda Expressions
*/

interface Runnable {
    public int run(int a);
}

public class LambdaExample3 {

    // static field
    private static int staticInt = 50;

    // instance field
    private int instanceInt;

    // Constructor
    LambdaExample3(int instanceInt) {
        this.instanceInt = instanceInt;
    }

    public static void main(String[] args) {

        LambdaExample3 lambdaExample =
                new LambdaExample3(100);

        // Lambda Expression uses no outside variables
        Runnable r1 = (a) -> a + 1;
        lambdaExample.doSomething("Example 1", r1, 5);

        // Lambda expression uses static field in expression
        Runnable r2 = (a) -> a + LambdaExample3.staticInt++;
        lambdaExample.doSomething("Example 2", r2, 5);
        lambdaExample.doSomething("Example 3", r2, 5);
        System.out.println(LambdaExample3.staticInt);

        // Lambda expression uses instance field in expression
        Runnable r3 = (a) -> a + lambdaExample.instanceInt++;
        lambdaExample.doSomething("Example 4", r3, 5);
        lambdaExample.doSomething("Example 5", r3, 5);

        int i = 10;
        // Lambda expression uses local variable in expression
        Runnable r4 = (a) -> a + i;
        lambdaExample.doSomething("Example 6", r4, 5);

        int j = 20;
        lambdaExample.doSomething("Example 7", j++);
        lambdaExample.doSomething("Example 8", j++);

        int k = 0;
        // you cannot use variable names in the parameter declarations of the Lambda Expression that conflict
        // with enclosing codes variables.
        // Runnable r5 = (k) -> k + 1;

        Runnable r5 = (instanceInt) -> k + 1;
        lambdaExample.doSomething("Example 9", r5, j++);
    }

    // Executes and prints Runnable.
    private void doSomething(String s, Runnable r, int a) {
        System.out.println(s + " : r.run(a) = " + r.run(a));
    }

    // Runnable created in the method uses parameter value
    // in its lambda expression
    private void doSomething(String s, int b) {
        // Lambda expression uses method parameter of enclosing method
        // in its expression
        Runnable r = (a) -> b + 1;
        doSomething(s, r, 5);
    }
}

