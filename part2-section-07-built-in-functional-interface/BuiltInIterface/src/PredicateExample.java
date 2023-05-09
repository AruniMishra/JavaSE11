/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 6: Built-in Functional Interfaces
Topic:  Predicate Example
*/

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        // Predicate with Object argument, lambda expression
        // always returns true.
        Predicate b1 = s -> true;
        System.out.println("The value of " +
                "Predicate [s -> true].test(null) = " + b1.test(null));

        // Predicate with Object argument, lambda expression
        // returns true if arugment is null
        Predicate b2 = s -> s == null;
        System.out.println("The value of " +
                "Predicate [s -> s == null].test(null) = " + b2.test(null));

        // Predicate typed to Boolean, lambda expression
        // returns boolean value of the value passed
        Predicate<Boolean> b3 = b -> b;
        System.out.println("The value of Predicate [b -> b].test(" +
                "Boolean.valueOf('true')) = " +
                b3.test(Boolean.valueOf("true")));

        // Predicate typed to String, lambda expression uses declared
        // parameter type, and {} body with return value
        Predicate<String> b4 = (String s) -> {
            return s.equals("hello");
        };
        System.out.println("The value of Predicate [(String s) ->" +
                " { return s.equals(\"hello\");}].test(\"hello\") = " +
                b4.test("hello"));


        System.out.println("\nTesting Default Methods");
        // Negate the last Predicate using default method on Predicate
        Predicate<String> b5 = b4.negate();

        System.out.println("The value of Predicate negated [(String s) ->" +
                " { return s.equals(\"hello\");}].test(\"hello\") = " +
                b5.test("hello"));


        Predicate<Integer> firstTest = i -> {
            System.out.println("\tFirst Test");
            return i > -10;
        };
        Predicate<Integer> secondTest = i -> {
            System.out.println("\tSecond Test");
            return i < 10;
        };

        // Assign the joined predicates to another Predicate variable
        // note: if firstTest evaluates to true then secondTest doesn't execute.
        Predicate<Integer> bFinal = firstTest.or(secondTest);
        System.out.println("Executing firstTest[i > -10].or(secondTest" +
                "[i < 10]).test(-11)");
        System.out.println("\tResult = " + bFinal.test(-11));

        System.out.println("\tResult = " + bFinal.test(0));


        // Execute the joined predicates directly as shown:
        System.out.println("Executing firstTest[i > -10].and(secondTest" +
                "[i < 10]).test(0)");
        System.out.println("\tResult = " + firstTest.and(secondTest).test(0));


        // Short-circuiting and
        System.out.println("Executing firstTest[i > -10].and(secondTest" +
                "[i < 10]).test(-11)");
        System.out.println("\tResult = " + firstTest.and(secondTest).test(-11));

        // Short-circuiting or
        System.out.println("Executing firstTest[i > -10].or(secondTest" +
                "[i < 10]).test(0)");
        System.out.println("\tResult = " + firstTest.or(secondTest).test(0));


        // Add negate...
        System.out.println("Executing firstTest[i > -10].or(secondTest" +
                "[i < 10]).negate().test(0)");
        System.out.println("\tResult = " + firstTest.or(secondTest).negate().test(0));


        System.out.println("The value of Predicate.isEqual(\"hello\") with " +
                "value of \"hello\" = " +
                Predicate.isEqual("hello").test("hello"));

        System.out.println("The value of Predicate.not(" +
                "Predicate.isEqual(\"hello\")) with value of \"hello\" = " +
                Predicate.not(Predicate.isEqual("hello")).test("hello"));


    }
}
