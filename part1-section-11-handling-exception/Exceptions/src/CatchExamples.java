/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 11: Handling Exception
Topic:  Describe Exception Handling and types of exceptions
Sub-Topic:  Catch Examples
*/

import java.io.IOException;

class CustomThrowable extends Throwable {
    CustomThrowable(String message) {
        super(message);
    }
}

class CustomException extends Exception {
    CustomException(String message) {
        super(message);
    }
}

class SuperClass {
    public void methodSuperClass() throws CustomException {

    }
}

class SubClass extends SuperClass {
    public void methodSubClass() {
        try {
            methodSuperClass();
        } catch (Exception CustomException) {
            // ignore it
        }
    }
}

public class CatchExamples {
    public static void main(String[] args) {
        CatchExamples ce = new CatchExamples();

        // Reminder, Throwable or custom subclasses of Throwable and any
        // Exception descendants are checked.

        try {
            extracted();
        } catch (CustomThrowable e) {
            // throw new RuntimeException(e);
        }

        try {
            extracted1();
        } catch (CustomException e) {
            // throw new RuntimeException(e);
        }

        try {
            SubClass c = new SubClass();
            c.methodSuperClass();
            ce.testError();
            // int i = 1 / 0;

        } catch (ArithmeticException e) {
            e = new ArithmeticException("This works"); // this is permitted, in a single exception catch clause
            throw e;
        } catch (CustomException | RuntimeException | IOException e) {
            // e = new CustomException(""); // e is implicit final
            System.out.println("Inside catch " + e.getClass());
            throw new RuntimeException("So many exceptions, so little time");
        }
    }

    private static void extracted1() throws CustomException {
        CustomException CustomException = new CustomException("");
        throw CustomException;
    }

    private static void extracted() throws CustomThrowable {
        CustomThrowable customThrowable = new CustomThrowable("");
        throw customThrowable;
    }

    private void testError() throws IOException {
        // We'll complete this later
    }
}