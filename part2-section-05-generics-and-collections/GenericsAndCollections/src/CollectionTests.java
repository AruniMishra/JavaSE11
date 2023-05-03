/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections Framework
*/

import java.util.Collection;
import java.util.List;

public class CollectionTests {

    public static <T> void doStuffWithCollection(Collection<T> h, T addedValue1, T addedValue2, T removedValue) {
        // Check if adding a null is valid or throws exception
        System.out.println("Start of method: " + h);
        try {
            System.out.println("After adding null " + h.add(null) + " : " + h);
        } catch (Exception e) {
            System.out.println("Exception adding null: " + e);
        }

        // Add an element
        System.out.println("After adding " + addedValue1 + " " + h.add(addedValue1) + " : " + h);

        //  Check if adding duplicate element is valid
        System.out.println("After adding " + addedValue2 + " " + h.add(addedValue2) + " : " + h);

        // Remove an element
        System.out.println("After removing  " + removedValue + " " + h.remove(removedValue) + " : " + h);

        try {
            System.out.println("After removing null " + h.remove(null) + " : " + h);
        } catch (Exception e) {
            System.out.println("Exception removing null " + e);
        }

        // Test bulk functions
        if (addedValue1 instanceof String) {
            performBulkFunctionsString((Collection<String>) h);
        } else if (addedValue1 instanceof Integer) {
            performBulkFunctions((Collection<Integer>) h);
        }

    }

    // Bulk functions with Integers
    private static void performBulkFunctions(Collection<Integer> h) {
        // Perform some bulk functions...
        System.out.println("After addSeveral:" + h.addAll(List.of(5, 10, 15, 25, 25)) + " : " + h);
        System.out.println("containAll(10, 20, 90, 100) : " + h.containsAll(List.of(10, 20, 90, 100)) + " : " + h);
        System.out.println("containAll(5, 10, 15, 20, 25) : " + h.containsAll(List.of(5, 10, 15, 20, 25)) + " : " + h);
        System.out.println("After removeSeveral:" + h.removeAll(List.of(20, 30)) + " : " + h);
        System.out.println("After retainAll:" + h.retainAll(List.of(10, 20, 30, 40, 50, 90)) + " : " + h);

    }

    // Bulk functions with Strings
    private static void performBulkFunctionsString(Collection<String> h) {
        // Perform some bulk functions...
        System.out.println("After addSeveral:" + h.addAll(List.of("George", "Harry", "Isabel")) + " : " + h);
        System.out.println("containAll(Fred ,Harry, Isabel) : " + h.containsAll(List.of("Fred", "Harry", "Isabel")) +
                " : " + h);
        System.out.println("containAll(Anne ,Harry, Isabel) : " + h.containsAll(List.of("Anne", "Harry", "Isabel")) +
                " : " + h);
        try {
            System.out.println("After removeSeveral:" + h.removeAll(List.of("Harry", "Isabel")) + " : " + h);
        } catch (Exception e) {
            System.out.println("Exception removing containAll " + e);
        }

        try {
            System.out.println("After retainAll:" + h.retainAll(List.of("Barry", "Charles", "David", "Edward")) +
                    " : " + h);
        } catch (Exception e) {
            System.out.println("Exception with retainAll " + e);
        }

    }
}

