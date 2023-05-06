package collection;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Comparator interface
*/

import java.util.*;

// Create a comparator to sort names using last names
class LastNameComparator implements Comparator<String> {

    // Do not want natural order, want to sort by the last name if one
    // exists. Assume no titles and suffixes in the names
    public int compare(String o1, String o2) {
        // Deal with nulls
        if (o1 == null || o2 == null) return -1;

        // Split names on whitespace
        String[] names1 = o1.split("\\s");
        String[] names2 = o2.split("\\s");

        // Assumption is last String is the last name, leverage
        // compareTo method of String which implements Comparable
        return names1[names1.length - 1].compareTo(names2[names2.length - 1]);
    }
}

public class ComparatorExample {
    public static void main(String[] args) {

        // Create an array of different names to test the compare method
        String[] names = {
                "Ralph Smith",
                "Martha G. Jones",
                "Anne Margaret Caroline Green",
                "Owen White",
                "Irene Funk",
                "Philip",
                "Joe Ford",
                "Aruni Mishra"};

        System.out.println("------ Unsorted initial List ------");
        for (String name : names) {
            System.out.println(name);
        }

        // Uses natural order... Strings implement Comparable
        Arrays.sort(names);
        System.out.println("------ Arrays.sort(String[]) ------");

        for (String name : names) {
            System.out.println(name);
        }


        // Use collections class, ArrayList
        List<String> namesList = new ArrayList<>(List.of(names));
        System.out.println("------ Sorted initial List ------");
        namesList.forEach(System.out::println);

        // Use static method reverseOrder on Comparator to sort
        namesList.sort(Comparator.reverseOrder());
        System.out.println("---- List.sort(Comparator.reverseOrder()) ----");
        namesList.forEach(System.out::println);

        // Use static method naturalOrder on Comparator to sort
        namesList.sort(Comparator.naturalOrder());
        System.out.println("---- List.sort(Comparator.naturalOrder()) ----");
        namesList.forEach(System.out::println);


        // Create instance of custom Comparator
        LastNameComparator l = new LastNameComparator();

        // Passing custom Comparator to List.sort
        namesList.sort(l);
        // Collections.sort(namesList, l); // valid: but Collections.sort could be replaced with List.sort
        System.out.println("--- ArrayList.sort(collection.LastNameComparator) ---");
        namesList.forEach(System.out::println);

        // Passing custom Comparator to Arrays.sort.
        Arrays.sort(names, l);
        System.out.println("-- Arrays.sort(String[], " +
                "collection.LastNameComparator) --");
        namesList.forEach(System.out::println);


        // Comparator interface has a reversed() default method
        namesList.sort(l.reversed());
        System.out.println("--- ArrayList.sort(" +
                "collection.LastNameComparator.reversed()) ---");
        namesList.forEach(System.out::println);


        //  Add a null value to the ArrayList
        namesList.add(null);
        namesList.sort(l); // "The sort() method in List does not throw a NullPointerException".
        System.out.println("--- ArrayList.sort(" +
                "collection.LastNameComparator) with null ---");
        namesList.forEach(System.out::println);

        // Arrays.sort((int[]) null); // Arrays.sort() does (if passed null).


        // Comparator interface has static methods which are helpful,
        // such as allowing control over where nulls end up in sorted list
        // you can list nulls first
        namesList.sort(Comparator.nullsFirst(l.reversed()));
        System.out.println("--- ArrayList.sort(Comparator." +
                "nullsFirst(reversed))) ---");
        namesList.forEach(System.out::println);

        // you can list nulls last
        namesList.sort(Comparator.nullsLast(l.reversed()));
        System.out.println("--- ArrayList.sort(Comparator." +
                "nullsLast(reversed))) ---");
        namesList.forEach(System.out::println);


    }
}
