package collection;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections Framework
SubTopic:  Views backed by collections
*/

import java.util.*;

public class CollectionViews {

    // Method accepts a List and performs a set of operations on it
    private static void doStuffWithSubList(List<String> list) {
        Random r = new Random();

        // Modifying the view elements by appending random number to value
        list.replaceAll((s -> s + " " + r.nextInt(99)));
        System.out.println("\tSuccessfully replaced elements in sublist: "
                + list);

        // Sort full view alphabetically
        // list.sort(Comparator.naturalOrder()); //Comparator: valid
        Collections.sort(list); // Comparable: also valid
        System.out.println("\tAfter sorting sublist: " + list);

        // Get a smaller view, elements 1 - 3
        List<String> newSubList = list.subList(1, 4);

        // Sort just elements 1 - 3 in reverse order
        newSubList.sort(Comparator.reverseOrder());
        System.out.println("\tAfter creating another sublist and sorting: "
                + list);

        // Catch & print any exceptions for next operations
        try {
            list.add("Ralph");
            System.out.println("\tSuccessfully added element in sublist: "
                    + list);
        } catch (Exception e) {
            System.out.println("\tError Adding element to sublist: " + e);
        }

        try {
            list.clear();
            System.out.println("\tSuccessfully cleared all elements from" +
                    " sublist: " + list);
        } catch (Exception e) {
            System.out.println("\tError Clearing elements form sublist: "
                    + e);
        }

    }

    // Method creates two sublists, one from an array and one from an
    // ArrayList and invokes doStuffWithSubList method on each sublist
    public static void main(String[] args) {

        System.out.println("------- Using view backed by String[] -----");
        // Initialize some data
        String[] names = {"David", "George", "Anne", "Bailey", "Carol"};
        System.out.println("Original State of Array : "
                + Arrays.toString(names));

        // Arrays.asList creates a List backed by array
        List<String> namesView = Arrays.asList(names);
        doStuffWithSubList(namesView);

        // Look at array after modifications t
        // o sublist
        System.out.println("Final State of Array : " +
                Arrays.toString(names));

        System.out.println("\n------- Using view backed by " +
                "ArrayList<String> -----");

        // Initialize some data
        // List<String> biggerList = new ArrayList<>(List.of(names));
        List<String> biggerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) biggerList.add("TEST");

        System.out.println("Original State of ArrayList biggerList: "
                + biggerList);

        // List.subList creates a sublist backed by ArrayList<String>
        List<String> subList1 = biggerList.subList(0, 5);
        doStuffWithSubList(subList1);

        System.out.println("Final State of ArrayList biggerList: "
                + biggerList);

    }

}
