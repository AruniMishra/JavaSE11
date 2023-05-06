package collection;
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Comparator static methods
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// collection.Person class with firstName & lastName
class Person {
    private String firstName;
    private String lastName;

    // Constructor takes both arguments
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // toString method
    public String toString() {
        return "collection.Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

// Sorting without using either a custom Comparator or a Comparable.
public class ComparingExample {
    public static void main(String[] args) {

        // Creating a list of person.
        List<Person> people = new ArrayList<>(List.of(new Person("George", "Ball"),
                new Person("Cathy", "Hart"),
                new Person("Anne", "Ball"),
                new Person("Aruni", "Mishra"),
                new Person("Marty", "Hart")));

        // sort in a multi-dimensional way, using methods (getters here)
        // chaining the static methods on Comparator
        people.sort(
                Comparator.comparing(Person::getLastName)
                        .thenComparing(
                                Comparator.comparing(Person::getFirstName)));

        people.forEach(System.out::println);
    }
}