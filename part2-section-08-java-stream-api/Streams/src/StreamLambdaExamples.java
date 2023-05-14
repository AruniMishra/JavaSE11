/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Stream API
Topic:  Lambda Expressions
*/

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLambdaExamples {
    public static void main(String[] args) {

        // Create array of names for testing
        String[] namesArray = {"Allen", "Bob", "Caleb", "Don", "Fred",
                "Greg", "Howard", "Ira", "James", "Kevin"};

        System.out.println("filter and count example: (length > 3 and" +
                " length < 6) : " +
                // Arrays static method will turn array into a stream..
                Arrays.stream(namesArray)
                        // filter uses a Predicate [ boolean test(T) ]
                        .filter((s) -> s.length() > 3)
                        // You can add as many filters as you wish
                        .filter((s) -> s.length() < 6)
                        // count returns a long, in this case a count of
                        // elements that met the criteria 
                        .count());

        System.out.println("dropWhile Example: Drop names until Howard: " +
                Arrays.stream(namesArray)
                        // dropWhile uses a Predicate and drops values until
                        // predicate becomes true
                        .dropWhile(s -> !s.equals("Howard"))
                        // collect method returns results in the type
                        // requested, here as List
                        .collect(Collectors.toList()));

        System.out.println("takeWhile Example: Add names until Howard: " +
                Arrays.stream(namesArray)
                        // takeWhile uses a Predicate and includes values until
                        // predicate becomes true
                        .takeWhile(s -> !s.equals("Howard"))
                        // collect method returns results as List
                        .collect(Collectors.toList()));

        System.out.println("skip Example: skip first two names: " +
                Arrays.stream(namesArray)
                        // skip first 2 elements
                        .skip(2)
                        // collect method returns results as List
                        .collect(Collectors.toList()));

        System.out.println("reduce example: Sum of the numbers = " +
                Stream.iterate(5, (t) -> t <= 100, (t) -> t + 5)
                        // Example of BinaryOperator, a represents the sum
                        // b here represents value being added to sum
                        .reduce((a, b) -> (a + b)).get());


        // reduce take BinaryOperator and must have only 2 params with same return type
        System.out.println("reduce example: Sum of the numbers = " +
                Stream.iterate(5, (t) -> t <= 100, (t) -> t + 5)
                        .reduce(StreamLambdaExamples::sum).get());
        // .reduce(Integer::sum).get()); // valid


        // We can't define the lambda
        // expression with a primitive int and assign it to a BinaryOperator
        // but obviously in this case we're doing a similar thing in line 66
        // when we're using a method reference and that works fine, hence method
        // references being a little bit more forgiving than a lambda expression.
        // BinaryOperator<Integer> bi = (int a, Integer b) -> a + b;
    }

    // valid 1
    // BinaryOperator must have 2
    // parameters of the same type which also must match the return type
    // private static int sum(int a, int b) {
    //     return a + b;
    // }

    // not a BinaryOperator
    private static long sum(int a, int b, int c) {
        return a + b;
    }


    // cannot convert long to java.lang.Integer: not a BinaryOperator(different return type)
    // private static long sum(int a, long b) {
    //     return a + b;
    // }


    // Reference to 'sum' is ambiguous, both 'sum(int, int)' and 'sum(int, Integer)' match
    private static int sum(int a, Integer b) {
        return a + b;
    }


}

