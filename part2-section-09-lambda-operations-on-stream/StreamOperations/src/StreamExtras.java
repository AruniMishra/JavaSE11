/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: additional Collectors.toMap and Collectors.groupingBy
*/

import element.Pet;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExtras {
    public static void main(String[] args) {

        List<Pet> petPopulation = Stream.generate(Pet::new)
                // .distinct() // allow to remove Duplicate key (i.e. only unique Pet type) with equals method only
                .limit(5)
                .collect(Collectors.toList());
        petPopulation.forEach(System.out::println);


        System.out.println("\n\n--- Group by Pet using groupingBy ---");
        // Take list of Pet, collect into a Map using groupingBy
        // chain to stream of Entry and print key,values.

        // the map generated by the collectors.groupingBy
        // is a map of string, firstly, and then a list of pet, the string being the
        // key, list of pet being the value.
        petPopulation.stream()
                .collect(
                        // groupingBy with a single argument
                        Collectors.groupingBy(Pet::getType))
                .entrySet()
                .stream()
                .forEach(System.out::println);


        // the map generated by the Collectors.toMap is a map of string and pet(Object).
        // So no list in the second scenario.

        // note: this will crash if petPopulation is created without distinct and there are duplicate key(Pet type)
        System.out.println("\n\n--- Group by Pet using toMap ---");
        // Take list of Pet, collect into a Map using toMap
        // chain to stream of Entry and print key,values.

        petPopulation.stream()
                .collect(
                        // toMap requires at least 2 arguments
                        Collectors.toMap(Pet::getType, p -> p))
                .entrySet()
                .stream()
                .forEach(System.out::println);


        System.out.println("\n\n--- distinct() & Group by Pet using toMap(key=\"type_name\") ---");
        petPopulation.stream()
                .distinct()
                .collect(
                        // toMap requires at least 2 arguments
                        Collectors.toMap(
                                p -> p.getType() + "_" + p.getName(),
                                p -> p))
                .entrySet()
                .stream()
                .forEach(System.out::println);


        System.out.println("\n\n--- Group by Pet using groupingBy; Sorted---\"");
        petPopulation.stream()
                .collect(
                        // groupingBy with a single argument
                        Collectors.groupingBy(Pet::getType,
                                TreeMap::new,
                                Collectors.toList()))
                .entrySet()
                .forEach(System.out::println);


        System.out.println("\n\n---  Collectors.toMap; Sorted---\"");
        petPopulation.stream()
                // .distinct()
                .collect(
                        // toMap requires at least 2 arguments
                        Collectors.toMap(
                                p -> p.getType() + "_" + p.getName(),
                                p -> p,
                                // merge function ignored if not parallel
                                (existing, replacement) -> existing,
                                TreeMap::new))
                .entrySet()
                .forEach(System.out::println);
    }
}