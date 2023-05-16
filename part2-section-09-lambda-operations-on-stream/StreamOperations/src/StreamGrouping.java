/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Stream Grouping
*/

import element.Pet;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGrouping {
    public static void main(String[] args) {

        // Print one Pet object
        System.out.println(new Pet());

        // Create a randomly generated list of 5000 pets.
        List<Pet> petPopulation = Stream.generate(Pet::new)
                .limit(1000)
                .collect(Collectors.toList());

        // Count the number of Dogs
        System.out.println("Number of Dogs = " +
                petPopulation.stream()
                        .filter((s) -> Objects.equals(s.getType(), "Dog"))
                        .count());

    }
}
