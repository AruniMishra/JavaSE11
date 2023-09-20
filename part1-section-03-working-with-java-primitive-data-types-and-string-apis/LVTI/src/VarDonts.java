/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 3: Working with Java Primitive Data Types and String APIs
Topic: Local Variable Type Inference
*/

import java.util.ArrayList;

public class VarDonts {

    // Invalid - Static class variables cannot be declared with var
    // static var classVariable = 10;
    //
    // Invalid - class instance variables cannot be declared with var
    // var instanceVariable = 20;

    public static void main(String[] args) {
        var instanceVariable = 20;

        var i0 = 10;
        for (; i0 > 0; i0--) {
            ;
        }

        for (int i = 0, j = 10; i < j; i++, --j) {
            ;
        }

        var list2 = new ArrayList(); // Line n4


        // var type cannot be the target type of lambda expressions and method references.
        // var lambda1 = () -> System.out.println("Hello"); // invalid
    }

    // Invalid, cannot have a method return type of var
    // public static var returnThis(String[] args) {
    //     return args;
    // }

    // Invalid, cannot have method parameter of var
    // public static String[] returnThat(var args) {
    //     return args;
    // }


}