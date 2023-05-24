/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Reductions using stream terminal operations, sum, average and reduce
*/

import java.util.stream.Stream;

public class ParallelReduction {

    public static void main(String[] args) {

        // The sum() terminal operation available to an IntStream
        // Serial Stream<Integer> gets mapped to IntStream first.
        long sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .mapToInt(s -> s)
                .sum();
        System.out.println("serial sum using sum() = " + sum);

        // The average() terminal operation available to an IntStream
        // Serial Stream<Integer> gets mapped to IntStream first.
        double avg = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .mapToInt(s -> s)
                .average().getAsDouble();
        System.out.println("serial average using average() = " + avg);

        // Use the reduce() terminal operation on a serial stream
        sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .reduce(0, Integer::sum);
        System.out.println("serial sum using method reference" +
                "(Integer::sum) as accumulator = " + sum);

        // Use the reduce() terminal operation on a parallel stream
        sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .parallel()
                // single args reduce method, accumulator
                .reduce(Integer::sum).get();
        System.out.println("parallel sum using method reference" +
                "(Integer::sum) as accumulator = " + sum);

        // The average() terminal operation available to an IntStream
        // Stream<Integer> to parallel Stream gets mapped to IntStream .
        avg = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .parallel()
                .mapToInt(s -> s)
                .average().getAsDouble();
        System.out.println("parallel average using average() = " + avg);

        // Use the reduce terminal operation on a parallel stream
        sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .parallel()
                // two args reduce method, identifier, accumulator
                .reduce(0, (s1, s2) -> s1 + s2);
        System.out.println("parallel sum using lambda expression " +
                "((s1, s2) -> s1 + s2) as accumulator = " + sum);

        // Use the reduce terminal operation on a parallel stream
        sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .parallel()
                // three args reduce method
                .reduce(0, (s1, s2) -> s1 + s2, (s1, s2) -> s1 + s2);
        System.out.println("parallel sum using lambda expression " +
                "((s1, s2) -> s1 + s2) as accumulator\n\t" +
                "and ((s1,s2) -> s1 + s2) as combiner= " + sum);


        // below generate same result as previous(without parallel & single combiner)
        // because the serial stream doesn't use the combiner parameter
        // Use the reduce terminal operation on a parallel stream
        sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                //.parallel()
                // three args reduce method
                .reduce(0, (s1, s2) -> s1 + s2, (s1, s2) -> s1); // note the combiner is discarded here
        System.out.println("parallel sum using lambda expression " +
                "((s1, s2) -> s1 + s2) as accumulator\n\t" +
                "and ((s1,s2) -> s1) as combiner= " + sum);

    }
}
