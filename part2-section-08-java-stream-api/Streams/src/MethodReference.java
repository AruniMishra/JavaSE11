/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Stream API
Topic:  Method References
*/

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

class TestPerson {


    // Private attributes...
    public static String[] namesArray = {"Allen", "Bob", "Caleb", "Don", "Fred",
            "Greg", "Howard", "Ira", "James", "Kevin"};
    private String name;

    // initializer give name at random
    {
        System.out.println("initializer");
        int i = new Random().nextInt(10);
        this.name = namesArray[i];
    }

    // Will use this method in a method reference
    public static void printStatic(String s) {
        System.out.print(s + " ");
    }

    public String toString() {
        return this.name + " ";
    }

    public String getName() {
        return this.name;
    }

    // Will use this method in a method reference
    public void printInstance(String s) {
        System.out.print(s + ", ");
    }
}

public class MethodReference {
    public static void main(String[] args) {

        // Method reference used to print each name
        Arrays.stream(TestPerson.namesArray)
                .forEach(System.out::println);

        System.out.println("------ Four types of Method References ------");
        System.out.println("Static Method on a class: ");
        Arrays.stream(TestPerson.namesArray)
                .forEach(TestPerson::printStatic);

        System.out.println("\nInstance Method on an object: ");
        Arrays.stream(TestPerson.namesArray)
                .forEach(new TestPerson()::printInstance);

        System.out.println("\nInstance Method on an arbitrary object: ");
        // Note that compareToIgnoreCase is not static method
        Arrays.sort(TestPerson.namesArray, String::compareToIgnoreCase);

        System.out.println("\nReference to Constructor: ");
        Stream.generate(TestPerson::new)  // Infinite stream
                .limit(15)                // Limit to 15
                .sorted((s, t) -> s.getName().compareToIgnoreCase(t.getName()))
                .forEach(System.out::print);

    }
}

