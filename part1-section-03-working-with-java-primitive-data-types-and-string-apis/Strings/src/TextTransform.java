/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 3: Working with Java Primitive Data Types and String APIs
Topic: Create and Manipulate Strings
Sub-Topic:  Transform String.
*/

public class TextTransform {
    public static void main(String[] args) {

        // Example of:  repeat(int count) (introduced in Java 11)
        // Returns a String
        String repeatString = "Repeat After Me ";

        // We'll repeat the String 3 x, set count parameter = 3
        repeatString = repeatString.repeat(3);
        System.out.println("repeatString *3= " + repeatString);

        // But what does passing a zero in do?
        repeatString = repeatString.repeat(0);
        System.out.println("repeatString *0= " + repeatString);


        String text = null;
        /*
        If only one operand expression is of type String,
        then string conversion is performed on the other operand to produce a string at run time.
         */
        // System.out.println(text.repeat(3)); // NullPointerException
        System.out.println(null + "null" + null); // nullnullnull
        System.out.println(text += "null".repeat(2));// nullnullnull
        text = null;
        System.out.println(text + text + text);// nullnullnull

        text += null;
        // System.out.println((text.concat(null))); // NullPointerException


        // ---  valueOf methods ---

        // Example of : valueOf(char[] data)
        // Returns a String
        String charsToString = String.valueOf(new char[]{'a', 'b', 'c', 'd', 'e'});

        // Example of : valueOf(char[] data, int offset, int count)
        // Returns a String
        String charsToStringPartial = String.valueOf(new char[]{'a', 'b', 'c', 'd', 'e'}, 1, 3);
        String subString = charsToString.substring(1, 3);

        System.out.println("charsToString = " + charsToString);
        System.out.println("charsToStringPartial = " + charsToStringPartial
                + ", subString = " + subString);

    }
}
