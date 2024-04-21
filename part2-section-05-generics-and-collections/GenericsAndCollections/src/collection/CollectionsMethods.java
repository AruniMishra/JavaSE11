package collection;
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections class
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsMethods {
    public static void main(String[] args) {

        // Set up some test data
        List<String> namesList = new ArrayList<String>(List.of("Anne", "Barry", "Charles", "David", "Edward"));

        // Swapping elements, first and last
        System.out.println("Initial State : " + namesList);
        Collections.swap(namesList, 0, namesList.size() - 1);
        System.out.println("After swapping first/last element : " + namesList);

        // Randomizing elements with shuffle
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(namesList);
            System.out.println("After randomizing elements : " + namesList);
        }

        // Sorting using sort method on List
        namesList.sort(Comparator.reverseOrder());
        System.out.println("After sorting (List.sort reverse) elements : " + namesList);

        // Sorting using Collections.sort
        Collections.sort(namesList);
        System.out.println("After sorting (Collections.sort) elements : " + namesList);

        // Sorting using Collections.reverse
        Collections.reverse(namesList);
        System.out.println("After reverse (Collections.reverse) elements : " + namesList);

        // Using Collections.min method
        System.out.println("min value: " + Collections.min(namesList));

        // Using Collections.max method
        System.out.println("min value: " + Collections.max(namesList));

        // Use Collections.fill (similar to Arrays.fill)
        Collections.fill(namesList, "Unknown");
        System.out.println("After filling with Unknown elements : " + namesList);


        // Similar to List.copyOf(namesList), more aptly named..
        List<String> newList = Collections.unmodifiableList(namesList);
        System.out.println("Copied List using Collections." + "unmodifiableList : " + newList);

        // newList.add("demo"); // UnsupportedOperationException

        // Example of List.copyOf
        List<String> copiedList = List.copyOf(namesList);
        System.out.println("Copied List using List.copyOf" + copiedList);

        // copiedList.sort(Comparator.reverseOrder()); // UnsupportedOperationException

        // The singleton{Type} methods on Collections return sets of one
        // element and the sets are immutable:
        // singletonList, singletonMap, singleton which returns a Set
        List b = Collections.singletonList(namesList.get(2));
        // Sorting a single element list does nothing, therefore no error
        Collections.sort(b); // alowed;

        // b.add("Mary"); // invalid


        // Create an ArrayList passing the results of
        // Collections.singletonList.
        List<String> l2 = new ArrayList<>(Collections.singletonList("One"));
        l2.add("Four"); // if commented(this line only), copy() throws IndexOutOfBoundsException
        List<String> l01 = new ArrayList<>(List.of("Two", "Three"));
        Collections.copy(l2, l01); // l01 to l2
        System.out.println("\nCopied List using Collections.copy l2: " + l2);
        // l2.add("Five"); // IndexOutOfBoundsException
        // System.out.println("After adding Five : " + l2);


        List<String> l1 = new ArrayList<>(List.of("Two", "Three"));
        Collections.copy(l1, l2); // l2 to l1
        System.out.println("\nCopied List using Collections.copy : " + l1);
        l1.add("Five");
        System.out.println("After adding Five : " + l1);


        List<String> immutableList = Collections.nCopies(10, null);
        System.out.println("\nCollections.nCopies(10, null) : " + immutableList);
        // immutableList.set(0,"something");

        List<String> mutableList = new ArrayList<>(Collections.nCopies(10, null));
        mutableList.set(0, "something");
        System.out.println("new ArrayList<>(Collections.nCopies(10, null) : " + mutableList);
    }
}
