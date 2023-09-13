/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Using Collector
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {
    public static void main(String[] args) {

        // Create a List which will be used as source of stream pipelines
        List<String> originalList =
                new ArrayList<>(List.of("First", "Second", "Third"));

        // Using stream to add 'ish' to all elements,creating another list
        List<String> firstList = originalList.stream()
                .map((s) -> s + "ish")
                .collect(Collectors.toList());

        // Add another element to list returned from collect
        firstList.add("Fourthish");

        // Print both lists
        System.out.println("originalList = " + originalList);
        System.out.println("firstList = " + firstList);


        System.out.println("\n\n---- .collect(Collectors.joining) examples ----");
        // Joins with no delimiters
        String joinedExample1 = originalList.stream()
                .collect(Collectors.joining());

        // Joins Strings delimited by a comma
        String joinedExample2 = originalList.stream()
                .collect(Collectors.joining(", "));

        // Joins Strings delimited by a comma, prefixed/suffixed with
        // beginning/ending bracket
        String joinedExample3 = originalList.stream()
                .collect(Collectors.joining(", ", "List [", "]"));

        System.out.println("Collectors.joining - with no parameters: " +
                joinedExample1);
        System.out.println("Collectors.joining - with delimiter : " +
                joinedExample2);
        System.out.println("Collectors.joining - with delimiter," +
                " prefix and suffix : " + joinedExample3);


        System.out.println("\n\n---- .collect(Collectors.averaging) examples ----");
        // Create random list of numbers

        double average = new Random().ints(1, 100_000)
                // Limit to 1000 random numbers
                .limit(1000)
                .boxed() // transform to an Integer stream
                .collect(Collectors.averagingInt((s) -> s));

        System.out.println("average of random integers = " + average);

        double AverageGPA = Stream.of(new Student("Jeff", 2.7f),
                        new Student("Carol", 3.5f),
                        new Student("Andy", 1.7f))
                .collect(Collectors.averagingDouble(Student::getGpa));

        System.out.println(String.format("Average GPA = %.2f", AverageGPA));


        System.out.println("\n\n---- .collect(Collectors.summarizing) examples ----");
        // Get Summary Statistics from an IntStream
        IntSummaryStatistics firstStats = new Random().ints(1, 100_000)
                .limit(1000)
                .summaryStatistics();

        System.out.println(firstStats);

        // Get Summary Statistics from a Stream<Integer>
        IntSummaryStatistics secondStats = new Random().ints(1, 100_000)
                .limit(1000)
                .boxed()
                .collect(Collectors.summarizingInt((s) -> s));

        System.out.println(secondStats);

        // Get Summary Statistics (about the gpa) from a Stream<Student>
        DoubleSummaryStatistics gpaStats = Stream.of(new Student("Jeff", 2.7f),
                        new Student("Carol", 3.5f),
                        new Student("Andy", 1.7f))
                .collect(Collectors.summarizingDouble(Student::getGpa));

        System.out.println(gpaStats);


    }
}


// Student class
class Student {
    protected String name;
    private float gpa;

    // Constructor
    Student(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String toString() {
        return this.name + "[" + this.gpa + "]";
    }

    public float getGpa() {
        return this.gpa;
    }
}