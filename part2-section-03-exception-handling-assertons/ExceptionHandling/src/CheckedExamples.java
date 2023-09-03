/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Exception Handling and Assertions
Topic:  Custom Exceptions
Sub-Topic:  Custom Checked Examples - Catch/Specify Requirements
*/

// A custom exception which extends Exception (checked).
class CustomException extends Exception {
    //  Add an error_code for our own purposes, perhaps logging
    private static final int ERROR_CODE = 9876;

    CustomException(String message, Throwable cause, boolean writableStackTrace) {
        // call super - making the third argument, enableSuppression = false
        super(message + " (" + ERROR_CODE + ")", cause, false, writableStackTrace);
    }
}

// A custom exception which extends Throwable (checked).
class CustomThrowable extends Throwable {
    // Custom exceptions are like any other class and can have
    // members of many flavors.  Here a constant is defined.
    private static final int ERROR_CODE = 1234;

    // Default constructor (super() is implied), an exception
    // created with this constructor has a null message
    CustomThrowable() {

    }

    // You can leverage Throwable's constructors and customize
    CustomThrowable(String message) {
        super(message + " (" + ERROR_CODE + ")");

    }

    // You can leverage Throwable's constructors and customize
    CustomThrowable(String message, Throwable e) {
        super(message + " (" + ERROR_CODE + ")", e);
        // Want custom exception of this type to do additional something
        doSomethingSpecial();
    }

    void doSomethingSpecial() {
        System.out.println("[First] Send alert, log or persist information");
    }
}

public class CheckedExamples {

    // main method to exercise both methods
    public static void main(String[] args) throws CustomException {
        CheckedExamples cex = new CheckedExamples();

        System.out.println("------- Custom Throwable Handled -------");
        // try/catch not required since method handles exception
        cex.handleThrowable();

        System.out.println("-----------------------------------------------------");

        try {
            System.out.println("\n---- Custom Throwable Thrown/Caught -------");
            cex.throwThrowable(0);
        } catch (CustomThrowable c) {
            c.printStackTrace(System.out);
        }
        System.out.println("\n-----------------------------------------------------");
        System.out.println("---- Custom Throwable Thrown/Not Caught -----");
        // cex.throwThrowable(1);

        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");


        CheckedExamples cex1 = new CheckedExamples();
        System.out.println("\n------- Custom Throwable Handled -------");
        // try/catch not required since method handles exception
        cex1.handleThrowable();

        try {
            System.out.println("\n---- Custom Exception Thrown/Caught -------");
            cex1.testExceptionNotHandled(0);
        } catch (CustomException c) {
            c.printStackTrace(System.out);
        }

        System.out.println("---- Custom Exception Thrown/Not Caught -----");
        cex1.testExceptionNotHandled(1);

    }

    // This method does NOT handle the custom exception thrown
    // Note that the exception is declared in the throws clause
    private void throwThrowable(int i) throws CustomThrowable {
        try {
            // Customizing existing platform exception with message
            throw new IllegalStateException("Whoops, This is bad");
        } catch (Exception e) {
            // Calls constructor on CustomThrowable that takes message
            // and originating Exception
            if (i == 0) throw new CustomThrowable("Caught and Re-Thrown", e);

            // Note that exception is ignored if i <> 0
        }
        // Calls constructor on CustomThrowable that takes message
        if (i == 1) throw new CustomThrowable("Created and Thrown");

    }

    // This method handles the checked exception it throws
    // Note that this method declares no exceptions in a throws clause
    private void handleThrowable() {
        try {
            // Creating with no args constructor & throwing
            throw new CustomThrowable();
        } catch (CustomThrowable c) {
            // Method handles all CustomThrowable thrown within it
            c.printStackTrace(System.out);
        }
    }

    // This method does NOT handle the custom exception thrown
    // Note that the exception is declared in the throws clause
    private void testExceptionNotHandled(int i) throws CustomException {
        try {
            throw new IllegalStateException("Ouch - Bug");
        } catch (Exception e) {
            // Calls constructor on CustomException that takes message
            // and originating Exception object, and boolean for stack trace
            if (i == 0) throw new CustomException("Custom Exception- false", e, false);
            else throw new CustomException("Custom Exception- true", e, true);
        }
    }
}

