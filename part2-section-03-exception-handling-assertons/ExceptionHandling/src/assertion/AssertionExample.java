/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Exception Handling and Assertions
Topic:  Using assertions
*/
package assertion;

import assertion.invariant.InvariantExamples;

public class AssertionExample {

    static {
        boolean startupAllowed = false;

        // startupAllowed will be true ONLY if assertions are enabled
        // otherwise statement is simply ignored.
        assert startupAllowed = true;

        // The following statement prevents the class from loading...
        if (!startupAllowed)
            throw new RuntimeException("Assertions must be enabled!!!");
    }


    // Method to be used by assert statement to populate detailed message
    public static String getAssertMessage(assertFlags aflag) {
        return "Method returns " + aflag.message;
    }

    public static void printAssertMessage(assertFlags aflag) {
        System.out.println("Method returns " + aflag.message);
    }

    public static void main(String[] args) {

        /*
        setting below vm option will disable assertion for InvariantExample class:
        -ea -da:assertion.invariant.InvariantExamples
         */
        InvariantExamples.main(args);

        byte s2;

        // Value below exceeds Byte Max Value
        // Byte.MAX_VALUE is 127 and maxValue is 128
        short maxValue = Byte.MAX_VALUE + 1;

        //  assert that value is within the proper range for byte, which is false
        // assert maxValue >= Byte.MIN_VALUE && maxValue <= Byte.MAX_VALUE;

        // can be re-written as below
        // assert maxValue >= Byte.MIN_VALUE && maxValue <= Byte.MAX_VALUE :
        //         "Value out of range for a byte";

        // can be re-written as below
        // assert maxValue >= Byte.MIN_VALUE && maxValue <= Byte.MAX_VALUE :
        //         getAssertMessage(assertFlags.BYTE_OUT_OF_RANGE);


        // invalid: void type not allowed in second part.
        // assert maxValue >= Byte.MIN_VALUE && maxValue <= Byte.MAX_VALUE :
        //         printAssertMessage(assertFlags.BYTE_OUT_OF_RANGE);

        //  can be re-written as below
        assert maxValue >= Byte.MIN_VALUE && maxValue <= Byte.MAX_VALUE :
                assertFlags.BYTE_OUT_OF_RANGE;

        // Casting short to a byte could lead to undetected overflow..
        s2 = (byte) maxValue;

        // Printing short value prints the 'actual expected value'
        System.out.println("Short value = " + maxValue);

        // Printing byte value shows maximum value overflowed.
        System.out.println("Byte value = " + s2);

    }


    // enum maintains detailed messages Assertion Errors.
    enum assertFlags {
        BYTE_OUT_OF_RANGE("Value is out of range for a byte");

        private String message;

        assertFlags(String message) {
            this.message = message;
        }
    }
}
