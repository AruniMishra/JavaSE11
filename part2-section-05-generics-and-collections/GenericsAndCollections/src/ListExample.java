/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections, Lists, ArrayList
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        // Create an ArrayList
        List<String> namesList = new ArrayList<>(
                List.of("Anne", "Barry", "Charles", "David", "Edward")
        );

        System.out.println("---- Executing Methods on Collections ----");
        CollectionTests.doStuffWithCollection(namesList, "Fred", "David", "David");


        System.out.println("\n----- Executing Methods on List -----");
        doSimpleListStuff(namesList);


        System.out.println("\n----- The subList View -----");
        // This grabs the names that start with A's using indices
        // First index is inclusive, Last index is exclusive so 3 elements
        List<String> shortList = namesList.subList(1, 4);
        System.out.println("namesList: " + namesList);
        System.out.println("shortList: " + shortList);

        // Reverse the order of the A List
        shortList.sort(Comparator.reverseOrder());
        System.out.println("shortList: " + shortList);
        System.out.println("namesList: " + namesList);

        // What if we alter the view?
        System.out.println("\n----- Add element to subList View -----");
        shortList.add("Aryn");
        System.out.println("shortList: " + shortList);
        System.out.println("namesList: " + namesList);

        // This implements sort of subList, using method reference
        shortList.sort(String::compareTo);
        System.out.println("shortList: " + shortList);
        System.out.println("namesList: " + namesList);


        // What if we alter the source list?
        System.out.println("\n----- Added Brad to namesList -----");

        namesList.add(6, "Brad");
        System.out.println(namesList);



    }


    // Methods associated with the List interface.
    private static void doSimpleListStuff(List<String> list) {

        // You'll note that add does not return a boolean.
        list.add(0, "Arnold");

        System.out.println("After adding Arnold at index 0 :" +
                " : " + list);

        System.out.println("After adding others at index 0 : " +
                list.addAll(0, List.of("Aaron", "Able")) + " : " + list);

        System.out.println("Setting name at index 2 : " +
                list.set(2, "Annette") + " : " + list);

        System.out.println("Arnold can be found at : " +
                list.indexOf("Arnold"));

        System.out.println("Annette can be found at : " +
                list.indexOf("Annette"));

        list.add(0, "David");
        System.out.println("After adding David at index 0 :" +
                " : " + list);

        System.out.println("The last David can be found at index : " +
                list.lastIndexOf("David"));
    }

}
