/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Stream Operations min, max, count, reduce
*/

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamSimpleReductions {
    public static void main(String[] args) {

        // Local variable to house random list of Integer
        List<Integer> randomIntegerList;

        // Test count, min, max, 5x (change limit each iteration)
        // for (int i = 0, limit = 1; i < 5; i++) {
        for (int i = 0, limit = 0; i < 5; i++) {
            randomIntegerList =
                    //  returns an IntStream of random integers, here bound
                    // between 1 and 100,000 - introduced in Java 8
                    new Random().ints(1, 100_000)
                            // Transform from an IntStream to Stream<Integer>
                            .boxed()
                            // .peek(System.out::println)
                            // Limit by the limit variable which changes
                            .limit(limit)
                            .collect(Collectors.toList());

            // count method returns a long, not an Optional - result
            // equals limit value
            long count = randomIntegerList.stream().count();

            // max method returns an Optional, so use .get() to get value
            long max = randomIntegerList.stream()
                    // Max method requires Comparator, use static method
                    // on Comparator to use natural order for int
                    .max(Comparator.<Integer>naturalOrder())
                    // .get();
                    .orElse(-1);

            // min method returns an Optional, so use .get() to get value
            long min = randomIntegerList.stream()
                    .min(Comparator.<Integer>naturalOrder())
                    // .get();
                    .orElse(-1);

            // Alter limit, higher limit- range gets closer to 1 & max
            // limit *= 10;
            limit = (limit == 0) ? 1 : limit * 10;


            // Print data from stream terminal operations count, max, min
            System.out.println("Limit = " + count + ", min  = " + min
                    + ", " + "max = " + max);


            double average = randomIntegerList.stream()
                    // mapToInt transforms to IntStream, one to one mapping
                    .mapToInt((s) -> s)
                    // Use average method, returns OptionalInt
                    .average()
                    // If OptionalInt is empty, set it to -1
                    .orElse(-1);

            double sum = randomIntegerList.stream()
                    // mapToInt transforms to IntStream, one to one mapping
                    .mapToInt((s) -> s)
                    // Use sum method
                    .sum();


            double sumReduced = randomIntegerList.stream()
                    .reduce(Integer::sum) // without converting to IntStream
                    // .reduce((a, b) -> a + b)
                    // .reduce((total, currentElement) -> total + currentElement)
                    .orElse(-1);


            System.out.println("Limit = " + count + ", average  = " + average
                    + ", " + "sum = " + sum + ", sumReduced = " + sumReduced);


        }
    }
}
