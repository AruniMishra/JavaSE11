/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Using  wrapper classes, operators
*/

public class WrapperOperators {
    public static void main(String[] args) {

        Integer i = 10;
        short j = 10;

        // A wrapper used in most operations is unboxed prior to the
        // operation

        // result of a wrapper and primitive can be assigned to a primitive
        // variable
        int intResult = i + j;

        // result of a wrapper and primitive can be assigned to a wrapper
        // variable
        Integer integerResult = i + j;

        // result of a wrapper and primitive can be assigned to a
        // LVTI variable using var
        var result = i + j;

        System.out.println("intResult (type int) = " + intResult);
        System.out.println("integerResult (type Integer) = " + integerResult);
        System.out.println("result (LVTI) = " + result);

        // // What is result?
        // System.out.println(result.getClass().getName());
        //
        // // Can we assign the value to a short?
        // short shortResult = i + j;
        //
        // // Can we assign the value to a Short?
        // Short shortWrapperResult = i + j;


        Integer k = 10;
        // Short s = 10;
        Number s = Short.valueOf("10");
        int m = 10;
        /*if (m instanceof Integer) {
            System.out.println(" m is instance of Integer ");
        }*/

        // instanceof is one example where autoboxing doesn't occur
        if (s instanceof Number) {
            System.out.println(" s is instance of Number ");
            if (s instanceof Integer) {
                System.out.println(" m is instance of Integer ");
            }
        }
    }
}
