/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Reductions using reduce() method with Strings.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class ParallelReductionStrings {
    public static void main(String[] args) {

        ArrayList<String> a;
        String[] names = {"Anne", "Bob", "Carol", "David",
                "Evan", "Fred", "George", "Harold", "Ida", "Jack", "Kevin"};

        // If executing on a single thread, the identity, in this case the
        // comma, does not get used between elements
        String result = Arrays.stream(names)
                .peek(System.out::print)
                .reduce(",", (s1, s2) -> s1 + s2);

        System.out.println(":\n\t serial String concat = " + result);

        // If executing on multiple threads, the identity, in this case the
        // comma, MAY be used between elements.  Parallel suggests to
        // the processor to use multiple threads but it is not guaranteed...
        result = Arrays.stream(names)
                .parallel().peek(System.out::print)
                .reduce(",", (s1, s2) -> s1 + s2);

        System.out.println(":\n\t parallel String concat = " + result);

        // If the source is not ordered, the result will not be
        // ordered
        result = Set.of(names).stream()
                .parallel()
                .peek(System.out::print)
                .reduce("", (s1, s2) -> s1 + "~" + s2, (s1, s2) -> s1 + "_" + s2);

        System.out.println("::\n\t parallel String concat = " + result);

    }
}
