/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Develop the code that uses parallel stream
*/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamTests {
    public static void main(String[] args) {

        int tests = 10;

        // Local variable to house random list of Integer
        List<Integer> randomIntegerList;

        // Set up some arrays to store results of pipeline operations
        double[] parallelAverages = new double[tests];
        double[] serialAverages = new double[tests];
        int[] parallelFirsts = new int[tests];
        int[] parallelAnys = new int[tests];
        int[] serialFirsts = new int[tests];
        int[] serialAnys = new int[tests];

        randomIntegerList =
                // IntStream of ints,  between 1 and 100,000
                Stream.iterate(1, (t) -> t <= 100000, (t) -> t + 1)
                        // collect into list
                        .collect(Collectors.toList());

        // Test for (predetermined) iterations
        for (int i = 0; i < tests; i++) {

            // average reduction method on intStream in parallel
            /*
            skip and limit: These two operations actually enforce the sort on the elements
            to produce determinant results as shown.
             */
            OptionalDouble parallelAvg = randomIntegerList
                    .parallelStream()
                    .mapToInt((s) -> s)
                    .skip(1000)
                    .limit(50000)
                    .average();

            parallelAverages[i] = parallelAvg.getAsDouble();

            // average reduction method on intStream in serial
            OptionalDouble serialAvg = randomIntegerList
                    .stream()
                    .mapToInt((s) -> s)
                    .skip(1000)
                    .limit(50000)
                    .average();

            serialAverages[i] = serialAvg.getAsDouble();

            // findAny is nondeterministic
            Optional findAnyParallel = randomIntegerList
                    .parallelStream()
                    .findAny();

            parallelAnys[i] = (Integer) findAnyParallel.get();

            Optional findAnySerial = randomIntegerList
                    .stream()
                    .findAny();

            serialAnys[i] = (Integer) findAnySerial.get();

            // findFirst works the same in parallel or serial
            Optional findFirstParallel = randomIntegerList
                    .parallelStream()
                    .findFirst();

            parallelFirsts[i] = (Integer) findFirstParallel.get();

            Optional findFirstSerial = randomIntegerList
                    .stream()
                    .findFirst();

            serialFirsts[i] = (Integer) findFirstSerial.get();

        }

        System.out.println("------ Parallel Results ------");
        System.out.println("Averages: " + Arrays.toString(parallelAverages));
        System.out.println("First: " + Arrays.toString(parallelFirsts));
        System.out.println("Anys: " + Arrays.toString(parallelAnys));
        System.out.println("------ Serial Results ------");
        System.out.println("Averages: " + Arrays.toString(serialAverages));
        System.out.println("First: " + Arrays.toString(serialFirsts));
        System.out.println("Anys: " + Arrays.toString(serialAnys));
    }
}
