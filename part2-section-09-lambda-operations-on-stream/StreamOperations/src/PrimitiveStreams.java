/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic:  Using IntStream, LongStream, DoubleStream;
*/

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {

        // Create a IntStream, using static method range
        // Second argument is exclusive
        IntSummaryStatistics intStats = IntStream.range(1, 10)
                .summaryStatistics();
        System.out.println(intStats);

        // Create LongStream, using static method rangeClosed
        // Second argument is inclusive
        LongSummaryStatistics longStats = LongStream.rangeClosed(1, 10)
                .summaryStatistics();
        System.out.println(longStats);

        // Create DoubleStream, using iterate
        DoubleSummaryStatistics doubleStats =
                DoubleStream.iterate(1.0, s -> s < 10.0, s -> s + 1)
                        .summaryStatistics();
        System.out.println(doubleStats);


        System.out.println("--- Reduction operations ----");
        System.out.println("Max = " + IntStream.range(1, 10).max());
        System.out.println("Min = " + LongStream.range(100, 1000).min());
        System.out.println("Average = " + DoubleStream.iterate(
                1.0, s -> s < 10.0, s -> s + 1).average());

        System.out.println("Sum = " + IntStream.iterate(
                5, s -> s < 100, s -> s + 5).sum());


        System.out.println(
                // Start with a Stream<Integer>
                Stream.iterate(1, s -> s <= 100, s -> s + 5)
                        // transform to IntStream
                        .mapToInt(s -> s)
                        // transform to Stream<Integer>
                        .boxed()
                        // transform to DoubleStream
                        .mapToDouble(s -> s)
                        .summaryStatistics()
        );


    }
}