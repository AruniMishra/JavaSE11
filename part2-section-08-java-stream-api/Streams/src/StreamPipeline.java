/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Java Stream API
Topic:  Stream pipelines

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

// Create a Person class to be used in a Stream pipeline
class Person {
    private String name;

    // Constructor
    Person(String name) {
        // System.out.println("Instantiating " + name);
        this.name = name;
    }

    // Getter
    public String getName() {
        return this.name;
    }

    public String toString() {
        return " [" + this.name + "]";
    }
}

public class StreamPipeline {

    // Method to  randomly create a Person Object
    private static Person getNewPerson() {
        String[] names = {"Mary", "Jim", "Joe", "Aaron"};
        int i = new Random().nextInt(4);
        return new Person(names[i]);
    }

    public static void main(String[] args) {

        // A single statement Stream Pipeline
        System.out.println("---- Process pipeline for First, Second ----");
        Stream.of("First", "Second").forEach((s) -> System.out.println(s));

        System.out.println("---- Created a personStream variable ----");
        // Declaring a Stream using Stream.generate with Supplier lambda expression
        Stream<Person> personStream = Stream.generate(() -> getNewPerson()); // generate is lazy

        // Do other stuff
        // demonstrating the pipeline processing has still not yet occurred.
        for (int i = 0; i < 3; i++) {
            System.out.println("\tJust looping for the heck of it");
        }
        // Assign intermediate operation to another Stream
        // Remember this is lazy
        System.out.println("------ Adding intermediate operation to pipeline -----");
        // Assign result of intermediate operation to self (local variable)
        personStream = personStream.limit(4); // does not invoke the invocation, since it is a lazy-invocation

        // Do other stuff
        for (int i = 0; i < 3; i++) {
            System.out.println("\tAgain looping for the heck of it");
        }
        System.out.println("---- Process pipeline for personStream ----");
        // Call terminal operation forEach, limit to 4 elements
        // execute the pipeline operations for the personStream when invoke the terminal operation forEach
        personStream.forEach((s) -> System.out.println(s)); // now getNewPerson() gets invoked


        // Create a list of 20 randomly generated persons.
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            personList.add(getNewPerson());
        }

        // Chained pipeline
        long jimCount = personList.stream()
                .filter((s) -> s.getName().equals("Jim"))
                .count();
        System.out.println("Randomly generated number of Jim Persons: " +
                jimCount + "/20");

        // Pipeline operations not chained
        Stream<Person> personsStream = personList.stream();
        personsStream = personsStream.filter(
                (s) -> s.getName().equals("Mary"));
        long maryCount = personsStream.count();
        System.out.print("Randomly generated number of Mary Persons: " +
                maryCount + "/20");


        // IllegalStateException: stream has already been operated upon or closed
        // personsStream.forEach((s) -> System.out.println(s));


        System.out.println("\n---- Creating another personStream variable ----");
        // Declaring Stream using generate with Supplier lambda expression
        Stream<Person> personStreamNext =
                Stream.generate(() -> getNewPerson()); // infinite stream

        System.out.println("Matched on Aaron on an infinite Stream = " +
                personStreamNext.anyMatch(
                        (s) -> s.getName().equals("Aaron"))); // short circuting a infinite stream

    }

}