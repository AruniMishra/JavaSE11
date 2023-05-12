/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Java Stream API
Topic:  The Stream interface, Stream creation
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationExample {
    public static void main(String[] args) {

        // Stream.empty() creates empty Stream
        Stream<String> argsStream = Stream.empty();

        // Stream.of() creates Stream of elements passed
        Stream<String> stringStream = Stream.of("First", "Second", "Third");

        // Stream.ofNullable (if value passed null, empty Stream, otherwise
        // Stream of one element
        String argumentString =
                (args != null && args.length > 0) ? args[0] : null;
        Stream<String> argStream = Stream.ofNullable(argumentString);

        argStream.forEach(System.out::println);

        System.out.println("\n----Infinite Stream created by " +
                "Supplier limited to 10 ");

        // Stream.generate takes a Supplier to generate a stream
        Stream<Double> infinitelyRandom = Stream.generate(Math::random);
        // infinitelyRandom.forEach(System.out::println);
        infinitelyRandom.limit(10).forEach((t) ->
                System.out.println(String.format("%.4f  ", t)));

        System.out.println("\n----Streams can be created from " +
                "Collection implementing types ");
        // Collection interface has method stream() so List, Set, Queue all
        // can produce a stream..
        List<String> l = new ArrayList<>(List.of("First", "Second", "Third"));
        Stream<String> listStream = l.stream();
        listStream.forEach(System.out::println);


        // Stream.iterate introduced in Java 9

        // Create a stream with a Unary Operator based lambda expression
        // numbers 5, 10, 15, 20, infinite stream
        Stream<Integer> infiniteStream = Stream.iterate(5, (t) -> t + 5);

        System.out.println("\n----Infinite Stream created by " +
                "UnaryOperator limited to 10 ");
        // Limiting an Infinite Stream in the pipeline
        infiniteStream.limit(10).forEach((t) -> System.out.print(t + " "));

        System.out.println("\n---- Finite Stream created by " +
                "UnaryOperator limited to <= 100  ");
        // Stops at 100, uses lambda expression Predicate
        Stream<Integer> finiteStream = Stream.iterate(5, (t) -> t <= 100, (t) -> t + 5);

        finiteStream.forEach((t) -> System.out.print(t + " "));


        // Stream.concat
        for (String arg : args) {

            Stream<String> inputStream = Stream.of(arg.split("\\s"));

            // Concat each stream to argsStream (created initially as
            // an empty stream).  Result is combined stream of elements
            argsStream = Stream.concat(argsStream, inputStream);
        }

        System.out.println("\n---- Stream of words from concatenated streams");
        argsStream.forEach(System.out::println);


        Stream.Builder<String> wordStreamBuilder = Stream.<String>builder();
        for (String arg : args) {
            for (String s : arg.split("\\s")) {
                wordStreamBuilder.accept(s);
            }
        }
        Stream<String> wordStream = wordStreamBuilder.build();
        System.out.println("\n---- Stream of words using Stream.Builder");
        wordStream.forEach(System.out::println);
    }
}

