/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections, Sets TreeSet, HashSet, LinkedHashSet
*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        // Initialize some data
        List<Integer> initialData = List.of(10, 20, 50, 40, 30);

        // Create a set from this list, best practice to declare variables
        // to the interface type as shown here.
        Set<Integer> h = new HashSet<>(initialData);
        System.out.println("----------- HashSet(order is unpredictable) -----------");
        System.out.println("Original values entered: " + initialData);

        // Call static method on CollectionTests to exercise the Collections methods
        CollectionTests.doStuffWithCollection(h, 60, 50, 10);


        Set<Integer> t = new TreeSet<>(initialData);
        System.out.println("\n----------- TreeSet(ordered numerically) -----------");
        System.out.println("Original values entered: " + initialData);
        CollectionTests.doStuffWithCollection(t, 60, 50, 10);


        // two "set" consider as equals, regardless of the implementation of "set"
        if (h.equals(t)) {
            System.out.println("HashSet h is equal to TreeSet t");
        } else {
            System.out.println("HashSet h is NOT equal to TreeSet t");
        }
    }
}
