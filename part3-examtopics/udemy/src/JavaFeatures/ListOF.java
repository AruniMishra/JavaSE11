package JavaFeatures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOF {

    public static void main(String[] args) {

        String[] primaryColors = {"red", "blue", "yellow"};

        List<String> colorList = Arrays.asList(primaryColors);

        // Sort the array via the List reference
        colorList.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("colorList after sort: " + colorList.toString());


        // Set the value of an array element using set method
        colorList.set(0, "cyan");
        System.out.println("colorList after after changing 1st value : " + colorList.toString());

        //-------------------
        // List.of method can take an array and make it a list
        List secondColorList = List.of(primaryColors);

        // List.copyOf method takes a list and makes another list
        List thirdColorList = List.copyOf(Arrays.asList(primaryColors));

        System.out.println("\nsecondColorList : " + secondColorList.toString());

        System.out.println("thirdColorList : " + thirdColorList.toString());

        //-------------------


        // Change value on original array
        /*
        The list/set returned by the of/copyOf methods is completely independent of the original collection.
        Thus, if you modify the original collection after passing it to of/copyOf methods,
        those changes will not be reflected in the list returned by the of/copyOf methods.
         */
        primaryColors[0] = "blue";

        System.out.println("\nprimaryColors after making first element blue: " + Arrays.toString(primaryColors));

        System.out.println("secondColorList after array changed : " + secondColorList);

        System.out.println("thirdColorList after array changed : " + thirdColorList);


        //-------------------
        // secondColorList created from List.of method is immutable
        try {
            // secondColorList.set(0, "cyan");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // thirdColorList created from List.copyOf method is also immutable
        try {
            // thirdColorList.set(0, "cyan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //-------------------

        // Returns an unmodifiable view, backed by original list... Java 10
        List<String> newList = Collections.unmodifiableList(colorList);
        System.out.println("\nCopied List using Collections. UnmodifiableList : " + newList);
        colorList.set(0, "black");
        System.out.println("colorList : " + colorList);
        System.out.println("UnmodifiableList : " + newList);


        System.out.println();
        List<String> newUnmodifiableList = colorList.stream()
                .filter(i -> i.length() > 3)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(newUnmodifiableList);
        // newUnmodifiableList.add("red");

        //-------- java 11

        System.out.println("\n\n-----------------------------");
        System.out.println("colorList : " + colorList);

        String[] arrayFromList = colorList.toArray(String[]::new); // but array from toArray is not immutable
        arrayFromList[1] = "new";
        System.out.println("arrayFromList after\t" + Arrays.toString(arrayFromList));
        System.out.println("colorList(immutable)\t" + colorList);


        //-------- Java 9
        Map<String, Integer> immutableMap = Map.ofEntries(
                Map.entry("Joe", 5),
                Map.entry("John", 10),
                Map.entry("James", 15));
        System.out.println(immutableMap);


        // Immutable object is modified
        // immutableMap.putAll(Map.ofEntries(
        //         Map.entry("Martha", 15),
        //         Map.entry("Carol", 35)));
        // System.out.println(immutableMap);


        Map immutableMap2 = Map.copyOf(immutableMap);
        Map immutableMap3 = Map.of(
                "Carol", 5,
                "Martha", 46,
                "Mark", 33);


        // Create a stream with a Unary Operator based lambda expression
        // numbers 5, 10, 15, 20, infinite stream
        Stream<Integer> infiniteStream = Stream.iterate(5, (t) -> t + 5);

        System.out.println("\n----Infinite Stream created by " +
                "UnaryOperator limited to 10 ");
        // Limiting an Infinite Stream in the pipeline
        infiniteStream.limit(10).forEach((t) -> System.out.print(t + " "));


        //-------------------------------


        // Stream.ofNullable (if value passed null, empty Stream, otherwise
        // Stream of one element
        String argumentString =
                (args != null && args.length > 0) ? args[0] : null;
        System.out.println("\nargumentString: " + argumentString);

        Stream<String> argStream = Stream.ofNullable(argumentString);

        argStream.forEach(System.out::println);


        //------------------------------------


        // Create array of names for testing
        String[] namesArray = {"Allen", "Bob", "Caleb", "Don", "Fred",
                "Greg", "Howard", "Ira", "James", "Kevin"};

        System.out.println("dropWhile Example: Drop names until Howard: " +
                Arrays.stream(namesArray)
                        // dropWhile uses a Predicate and drops values until
                        // predicate becomes true
                        .dropWhile(s -> !s.equals("Howard"))
                        // collect method returns results in the type
                        // requested, here as List
                        .collect(Collectors.toList()));

        System.out.println("takeWhile Example: Add names until Howard: " +
                Arrays.stream(namesArray)
                        // takeWhile uses a Predicate and includes values until
                        // predicate becomes true
                        .takeWhile(s -> !s.equals("Howard"))
                        // collect method returns results as List
                        .collect(Collectors.toList()));

    }
}
