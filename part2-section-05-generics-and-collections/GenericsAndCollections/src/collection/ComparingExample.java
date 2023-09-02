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
        List<Person> personArrayList = new ArrayList<>(List.of(new Person("George", "Ball"),
                new Person("Cathy", "Hart"),
                new Person("Bathy", "Hart"),
                new Person("Anne", "Ball"),
                new Person("Aruni", "Mishra"),
                new Person("Marty", "Hart")));

        // sort in a multi-dimensional way, using methods (getters here)
        // chaining the static methods on Comparator
        personArrayList.sort(
                Comparator.comparing(Person::getLastName)
                        .thenComparing(
                                Comparator.comparing(Person::getFirstName)));

        personArrayList.forEach(System.out::println);



        /*
        Manipulating a "stream" doesn't manipulate the backing source of the stream.
        Here, when you chain the sorted method to a stream, it returns a reference to a Stream that appears sorted.
        The original List which was used to create the stream will remain as it is.
        If you want to sort a List permanently, you should use one of the Collections.sort methods.

        2. There is another issue with this code. Stream.sorted is an intermediate operation.
        It will not be executed until a terminal operation is invoked on the stream.
        Therefore, in this case, the sorted method will not even be invoked.
         */
        personArrayList.stream().sorted(Comparator.comparing(Person::getLastName)
                .thenComparing(
                        Comparator.comparing(Person::getFirstName)));
    }
}