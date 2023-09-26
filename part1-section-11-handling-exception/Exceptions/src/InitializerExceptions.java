import java.io.FileNotFoundException;
import java.io.IOException;

/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 11: Handling Exception
Topic:  Exceptions, Out of Ordingary
Sub-Topic:  Exceptions in Initializers
*/
class StaticTest {
    public static String currentMessage;

    // Initialized to 0
    public static int currentVal;

    // Static Initializer
    static {
        System.out.println("\nInitializing class StaticTest");
        try {
            // We force an error for demonstration purposes
            if ((10 / currentVal) > 0) {
                System.out.println("Whoops");
            }

        } catch (Exception e) {
            System.out.println("Caught the error");
            // throw new RuntimeException("runtime");
        } finally {
            currentVal = 1;
        }
        currentMessage = "Inside Static Initializer";
    }
}

public class InitializerExceptions {

    // Create an instance initializer block that throws an unchecked exception
    {
        int i = 0;
        if (i == 0) throw new IOException("Whoops");
    }

    // Constructor declares IOException in a throws clause
    // throws is permitted here, even the constructor is empty
    InitializerExceptions() throws IOException {

    }

    /*
    The instance initializer code will be executed before the try catch block we've just created,
    and not be wrapped in the try block as a result.
    The only way to get your code to compile is to have every constructor declare the exception in its throw clause.
     */
    // Second constructor without a throws clause
    // InitializerExceptions(String parameterOne) {
    //     try {
    //
    //     } catch (IOException e) {
    //         System.out.println("I'm ignoring the error");
    //     }
    // }

    // now permitted
    InitializerExceptions(String parameterOne) throws IOException {

    }

    public static void main(String[] args) {
        System.out.println("Executing main()");
        System.out.println("\nStaticTest.currentMessage: " + StaticTest.currentMessage);

        try {
            InitializerExceptions ie = new InitializerExceptions();
        } catch (Exception e) {
            System.out.println("Ignoring the error, " + e.getMessage());
        }

    }

    // Create a subclass of InitializerExceptions
    class SubClass extends InitializerExceptions {

        // Valid, try-catch not permitted
        SubClass() throws IOException {
            super();  // Note that call to super() is redundant statement
        }

        /*
        below is non-valid
        Call to 'super()' must be first statement in constructor body
         */
        // SubClass() {
        //     try {
        //         super();  // Note that call to super() is redundant statement
        //     } catch (IOException e) {
        //         throw new RuntimeException(e);
        //     }
        // }

    }
}

/*
Observe that the rule for overriding a method is opposite to the rule for constructors.
An overriding method cannot throw a superclass exception,
while a constructor of a subclass cannot throw subclass exception
(Assuming that the same exception or its super class is not present in the subclass constructor's throws clause).
 For example:

  class A{
    public A() throws IOException{ }
    void m() throws IOException{ }
  }

  class B extends A{
    //IOException is valid here, but FileNotFoundException is invalid
    public B() throws IOException{ }

    //FileNotFoundException is valid here, but Exception is invalid
    void m() throws FileNotFoundException{ }
}
(Note: FileNotFoundException is a subclass of IOException, which is a subclass of Exception)
 */


