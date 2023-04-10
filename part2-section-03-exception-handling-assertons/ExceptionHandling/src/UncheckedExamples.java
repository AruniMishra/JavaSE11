/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Exception Handling and Assertions
Topic:  Custom Exceptions
Sub-Topic:  Custom UnChecked Examples
*/

// This class extends a subclass of Error
class CustomError extends UnknownError {
    CustomError(String message) {
        super(message);
    }
}

// This class extends a subclass of RuntimeException
class CustomArithmeticException extends ArithmeticException {
    CustomArithmeticException(String message) {
        super(message);
    }
}

public class UncheckedExamples {
    public static void main(String[] args) {

        UncheckedExamples uex = new UncheckedExamples();
        // try/catch not required by compiler, here to allow
        // execution to proceed to second invocation
        try {
            System.out.println("---- Executing method that throws" +
                    " CustomError");
            uex.testCustomError(0);
        } catch (CustomError e) {
            System.out.println(e);
        }
        System.out.println("---- Executing method that throws Custom" +
                " RuntimeException");
        uex.testCustomRuntimeException(0);

    }

    private void testCustomError(int i) {
        try {
            throw new UnknownError();
        } catch (Throwable e) {
            // Calls constructor on CustomError that takes message
            if (i == 0) throw new CustomError(
                    "Head scratching unknown Error");
        }

    }

    private void testCustomRuntimeException(int i) {
        try {
            int temp = 10 / i;
        } catch (RuntimeException e) {
            // Calls constructor on CustomArithmeticException
            if (i == 0) throw new CustomArithmeticException(
                    "Custom Arithmetic: Divide by zero error");
        }

    }
}
