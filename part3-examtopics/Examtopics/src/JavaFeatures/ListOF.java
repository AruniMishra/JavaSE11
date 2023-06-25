package JavaFeatures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOF {

    public static void main(String[] args) {

        String[] primaryColors = {"red", "blue", "yellow"};

        List<String> colorList = Arrays.asList(primaryColors);

        // Sort the array via the List reference
        colorList.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("colorList after sort: " + colorList.toString());


        // Set the value of an array element using set method
        colorList.set(0, "cyan");
        System.out.println("colorList after after changing 1st value : "
                + colorList.toString());

        //-------------------
        // List.of method can take an array and make it a list
        List secondColorList = List.of(primaryColors);

        // List.copyOf method takes a list and makes another list
        List thirdColorList = List.copyOf(Arrays.asList(primaryColors));

        System.out.println("\nsecondColorList : "
                + secondColorList.toString());

        System.out.println("thirdColorList : "
                + thirdColorList.toString());

        //-------------------

        // Change value on original array
        primaryColors[0] = "blue";

        System.out.println("\nprimaryColors after making first element blue: "
                + Arrays.toString(primaryColors));

        System.out.println("secondColorList after array changed : "
                + secondColorList.toString());

        System.out.println("thirdColorList after array changed : "
                + thirdColorList.toString());


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

        // Similar to List.copyOf(namesList), more aptly named..
        List<String> newList = Collections.unmodifiableList(colorList);
        System.out.println("\nCopied List using Collections. UnmodifiableList : " + newList);

    }
}
