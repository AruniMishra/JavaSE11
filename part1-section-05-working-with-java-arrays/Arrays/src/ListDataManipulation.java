import java.util.Arrays;
import java.util.List;

public class ListDataManipulation {
    public static void main(String[] args) {

        // Set up some test data for use in our tests
        String[] primaryColors = {"red", "blue", "yellow"};
        String[] secondaryColors = {"green", "orange", "purple"};

        System.out.println("--- Manipulating array data using a List," +
                " backed by an array");

        // The Arrays.asList returns a list backed by the array;
        List<String> colorList = Arrays.asList(primaryColors);
        System.out.println("colorList: " + colorList.toString());

        // Use get method to get an element in the array
        String firstColor = colorList.get(0);
        System.out.println("firstColor is " + firstColor);

        // Sort the array via the List reference
        colorList.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("\ncolorList after sort: "
                + colorList.toString());

        System.out.println("primaryColors "
                + Arrays.toString(primaryColors));

        // Set the value of an array element using set method
        colorList.set(0, "cyan");
        System.out.println("\ncolorList after after changing 1st value : "
                + colorList.toString());

        System.out.println("primaryColors "
                + Arrays.toString(primaryColors));

        // Use replaceAll method to change all values in the array via
        // List reference
        colorList.replaceAll((s) -> s + "ish");
        System.out.println("\ncolorList  after replacing all values: "
                + colorList.toString());

        System.out.println("primaryColors " + Arrays.toString(primaryColors));

        // And what happens when we change underlying array?
        primaryColors[0] = "blueish";
        System.out.println("\ncolorList after array changed: "
                + colorList.toString());

        System.out.println("primaryColors "
                + Arrays.toString(primaryColors));


        System.out.println("\n--- List.of and List.copyOf Examples");

        // List.of method can take an array and make it a list
        List secondColorList = List.of(primaryColors);


         /*
         The list/set returned by the of/copyOf methods is completely independent of the original collection.

        If you pass it a collection, it will be treated as a regular object i.e. it will return a list/set containing
        the same collection object instead of returning a list/set containing the objects that the passed collection
        contains.
         */
        List<List<String>> tempColorList = List.of(Arrays.asList(primaryColors));
        System.out.println("tempColorList : "
                + tempColorList.toString()); // [[blueish, redish, yellowish]]


        // List.copyOf method takes a list and makes another list
        /*
        The copyOf, on the other hand, accepts only a Collection.
        It iterates through the passed Collection and adds all the elements of that Collection in the returned list/set.
         */
        List thirdColorList = List.copyOf(Arrays.asList(primaryColors));


        System.out.println("\nsecondColorList : "
                + secondColorList.toString());

        System.out.println("thirdColorList : "
                + thirdColorList.toString());

        // Change value on original array
        primaryColors[0] = "blue";

        System.out.println("\nprimaryColors after making first element blue: "
                + Arrays.toString(primaryColors));

        System.out.println("secondColorList after array changed : "
                + secondColorList.toString());

        System.out.println("thirdColorList after array changed : "
                + thirdColorList.toString());

        System.out.println("tempColorList after array changed : "
                + tempColorList.toString()); // note: contains a single element which is the reference to the collection.

        // secondColorList created from List.of method is immutable
        try {
            secondColorList.set(0, "cyan");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // thirdColorList created from List.copyOf method is also immutable
        try {
            thirdColorList.set(0, "cyan");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}