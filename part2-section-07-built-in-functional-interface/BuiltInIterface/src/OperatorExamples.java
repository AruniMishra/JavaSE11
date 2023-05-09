/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 6: Built-in Functional Interfaces
Topic:  UnaryOperator and BinaryOperator
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

// Custom Unary Operator
interface MyUnaryOperator<T> {
    T apply(T t);
}

// Class that puts Unary Operator interfaces to work
public class OperatorExamples {
    public static void main(String[] args) {

        // Set up some Test data
        // a tree map guarantees that the keys will always be sorted according to the natural ordering of its keys or;
        // better still using a comparator if provided by the user at construction time.
        Map<String, Integer[]> map = new TreeMap<>();
        map.put("John", new Integer[]{31, 35, 50, 36, 40});
        map.put("Michael", new Integer[]{21, 27, 50, 30, 50});
        map.put("Laura", new Integer[]{15, 17, 55, 43, 90});
        map.put("Carol", new Integer[]{21, 30, 43, 31, 55});
        System.out.println(map.keySet());

        // Declaring lambda expressions using Generic Interfaces

        // UnaryOperator using Integer(accepts one argument of type
        // Integer and returns a value of type Integer)
        UnaryOperator<Integer> addFiveToFirst = (s) -> s + 5;
        System.out.println(addFiveToFirst.apply(9));

        // Using the interface declared above
        MyUnaryOperator<Integer> addFiveToFirstAgain = (s) -> s + 5;

        // BinaryOperator using Integer (accepts two arguments of type
        // Integer and returns a value of type Integer)
        BinaryOperator<Integer> averageFirstTwo = (s, t) -> (s + t) / 2;

        // Static method on BinaryOperator returns lambda expression
        // evaluating a max value
        BinaryOperator<Integer> maxOperator = BinaryOperator.maxBy(Comparator.naturalOrder());

        // Static method on BinaryOperator returns lambda expression
        // evaluating a max value
        BinaryOperator<Integer> minOperator = BinaryOperator.minBy(Comparator.naturalOrder());

        Integer[] vals;
        // Loop through values in a HashMap
        for (Map.Entry<String, Integer[]> e : map.entrySet()) {

            vals = e.getValue();
            // Print key information and Integer list
            System.out.println(e.getKey() + "'s List (" + Arrays.toString(vals) + ")");

            // Execute the 'apply' method on UnaryOperator
            System.out.println("\taddFiveToFirst = " + addFiveToFirst.apply(vals[0]));

            // Execute the 'apply' method on UnaryOperator
            System.out.println("\taddFiveToFirstAgain = " + addFiveToFirstAgain.apply(vals[0]));

            // Execute the 'apply' method on BinaryOperator
            System.out.println("\taverageFirstTwo = " + averageFirstTwo.apply(vals[0], vals[1]));

            // Execute the 'apply' method on maxOperator
            System.out.println("\tMax of (" + vals[3] + ", " + vals[4] + ") = " + maxOperator.apply(vals[3], vals[4]));

            // Execute the 'apply' method on minOperator
            System.out.println("\tMin of (" + vals[1] + ", " + vals[4] + ") = " + minOperator.apply(vals[1], vals[4]));
        }
    }
}