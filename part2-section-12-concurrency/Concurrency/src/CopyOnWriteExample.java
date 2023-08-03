/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  CopyOnWriteArrayList
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {
    public static void
    testList(List<String> currentList) {
        System.out.println("----------- Testing " + currentList.getClass().toGenericString());
        System.out.println("Original State: " + currentList);


        // Get Iterator
        Iterator<String> it = currentList.iterator();

        int i = 0;

        // Use iterator
        System.out.println("\nPrint first three elements: ");
        /* CopyOnWriteArrayList:
        the "iterator" did not reflect the mutation made while iterating
        nor did it throw a ConcurrentModificationException.
        Using the iterator after the changes did not reflect the changes made.
        However, the mutation occurred as shown
        by the print statement on the concurrent list variable at the bottom of the output.
        */

        while (it.hasNext()) {
            System.out.println(it.next());
            // Add some elements while iterating over elements
            if (i++ == 0) {
                currentList.addAll(List.of("James", "Jim", "Joe"));// valid with CopyOnWriteArrayList
                currentList.remove(it.next()); // valid with CopyOnWriteArrayList

                // it.remove(); // UnsupportedOperationException with CopyOnWriteArrayList
            }
            // break after third element
            else if (i == 3) break;
        }

        // Print remaining elements on iterator
        System.out.println("\nPrinting remaining elements");
        it.forEachRemaining(System.out::println);

        System.out.println("\nValues = " + currentList + "\n");
    }

    public static void main(String[] args) {

        // Create an ArrayList and initialize with 5 values
        List<String> alist = new ArrayList<>(List.of("0", "1", "2", "3", "4"));

        // Create a CopyOnWriteArrayList using previous list
        List<String> concurrentList = new CopyOnWriteArrayList<>(alist);

        testList(concurrentList);

        // regular list:
        // ConcurrentModificationException on addAll() & currentList.remove(it.next()); but works on it.remove();
        // but, note, java.util.ConcurrentModificationException will never be thrown for traditional for loop.
        // testList(alist);


        // but, note, java.util.ConcurrentModificationException will never be thrown for traditional for loop.
        List<StringBuilder> animals = new ArrayList<>();
        animals.add(new StringBuilder("Walrus"));
        animals.add(new StringBuilder("Anaconda"));
        animals.add(new StringBuilder("Alligator"));
        animals.add(new StringBuilder("Dog"));

        for (int i = 0; i < animals.size(); i++) {
            if (i == 0) {
                animals.remove(new StringBuilder("Alligator"));
            }
        }

        System.out.println(animals);
    }
}
