/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Collect and Reduce
*/

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ParallelExtras {
    public static void main(String[] args) {

        Set<String> set = new TreeSet<>(Set.of("b", "c", "d"));

        // Using reduce with String
        String firstResult = set
                // .stream()
                .parallelStream() // since source is ordered, parallelStream will be ordered
                .reduce(String::concat)
                // reduce returns Optional,
                // need to use get() to get value
                .get();
        System.out.println("firstResult = " + firstResult);


        // Using reduce with String
        String firstResult2 = set
                .stream()
                // Requires Identity(String here), and BinaryOperator
                // .reduce("", String::concat);
                // Requires Identity(String), BiFunction, BinaryOperator
                .reduce("", String::concat, String::concat);
        System.out.println("firstResult2 = " + firstResult2);


        /*
        for the reduce method, remember that a new StringBuilder is being created for each element
        and for each sub-stream. i.e. inconsistent result with .parallelStream()
         */
        // Using reduce with StringBuilder
        StringBuilder firstResult3 = set
                // .stream()
                .parallelStream()
                .map(s -> new StringBuilder(s))
                // Requires Identity(StringBuilder), BiFunction, BinaryOperator
                .reduce(new StringBuilder(),
                        (a, b) -> a.append(b),
                        (a, b) -> a.append(b));
        System.out.println("firstResult3 = " + firstResult3);

        StringBuilder firstResult4 = set
                // .stream()
                .parallelStream()
                .map(s -> new StringBuilder(s))
                // Requires Identity(StringBuilder), BiFunction, BinaryOperator
                .reduce(new StringBuilder(),
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));
        System.out.println("firstResult4 = " + firstResult4);


        // Using reduce with StringBuilder
        StringBuilder firstResult5 = set
                // .stream()
                .parallelStream() // Now the results are indeterminate based on the number of processes
                .map(s -> new StringBuilder(s))
                // Requires Identity(StringBuilder), BiFunction, BinaryOperator
                .reduce(new StringBuilder("a"),
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));
        System.out.println("firstResult5 = " + firstResult5);


        // Using collect with String
        String secondResult = set
                // .stream()
                .parallelStream()
                // collect requires Collector argument
                .collect(Collectors.joining());

        System.out.println("secondResult = " + secondResult);


        // Using collect with String
        String secondResult2 = set
                .stream()
                // collect requires Supplier, BiConsumer, BiConsumer
                // .collect("", String::concat, String::concat); // invalid, for reduce this works, but not for collect

                /*
                So the collect method is trying to mutate the String initially supplied by the supplier,
                which is that new method reference.

                But strings do not mutate if you recall.
                Remember that a BiConsumer does not return a value, so the result of String.concat
                on a String has no effect on a String.
                 */
                .collect(String::new, String::concat, String::concat);
        System.out.println("secondResult2 = " + secondResult2);


        /*
        The collect method on the other hand collects the results mutating the originally supplied item
        for each sub-stream, in this case an empty StringBuilder and appending elements to it.
         */
        // Using collect with StringBuilder
        StringBuilder secondResult3 = set
                // .stream()
                .parallelStream()
                .map(s -> new StringBuilder(s))
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(StringBuilder::new,
                        (a, b) -> a.append(b),
                        (a, b) -> a.append(b));

        System.out.println("secondResult3 = " + secondResult3);


        /*
        empty: because we are trying to append the empty StringBuilder to the element
        (which we have converted from String to StringBuilder using Map).
         */
        StringBuilder secondResult4 = set
                // .stream()
                .parallelStream()
                .map(s -> new StringBuilder(s))
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(StringBuilder::new,
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));

        System.out.println("secondResult4 = " + secondResult4);


        // Using collect with StringBuilder
        StringBuilder secondResult5 = set
                // .stream()
                .parallelStream() // Now the results are indeterminate based on the number of processes
                .map(s -> new StringBuilder(s))
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(() -> {
                            return new StringBuilder("a");
                        },
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));
        System.out.println("secondResult5 = " + secondResult5);

    }
}