/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic:  Using flatMap
*/

import element.Pet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExtras {
    public static void main(String[] args) {

        // Create three different Lists of Pet objects
        List<Pet> petList1 = List.of(new Pet(), new Pet(), new Pet());
        List<Pet> petList2 = List.of(new Pet(), new Pet(), new Pet());
        List<Pet> petList3 = List.of(new Pet(), new Pet(), new Pet());

        // Create List of List of Pets
        List<List<Pet>> listOfPets
                = List.of(petList1, petList2, petList3);

        System.out.println("--- List of lists ---");
        listOfPets.forEach(System.out::println);


        System.out.println("\n\n--- Full list with Map ---");
        // Create a list (outside of the stream)
        List<Pet> fullList = new ArrayList<Pet>();
        listOfPets.stream()
                // Collect all elements into fullList
                .map(s -> fullList.addAll(s))
                // short-circuiting terminal operation
                .allMatch(p -> p != null);

        fullList.forEach(System.out::println);


        System.out.println("\n\n--- Create Full list with flatMap---");
        listOfPets.stream()
                // Turns a List<Pet> to Stream<Pet> i.e
                // execute the stream method on a list of Pet.
                .flatMap(s -> s.stream())
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("\n\n--- Create Full list with flatMap(Stream::of)---");
        listOfPets.stream()
                // Turns a List<Pet> to Stream<List<Pet>> i.e
                // executing stream that passed in a single element, a list of Pet and therefore,
                // haven't flattened anything.
                .flatMap(Stream::of)
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("\n\n--- Putting it all together---");
        listOfPets.stream()
                // flat the map to Stream<Pet>
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Pet::getType))
                .entrySet()
                .stream()
                .forEach(System.out::println);


    }
}

