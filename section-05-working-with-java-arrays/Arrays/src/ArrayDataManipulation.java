
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ArrayDataManipulation {
    public static void main(String[] args) {

        System.out.println("--- Manipulating data with Arrays static methods");

        // Create array of Integer
        Integer[] intArray = new Integer[10];
        System.out.println("Array values initially: "
                + Arrays.toString(intArray));

        // Fill array with a single value
        Arrays.fill(intArray, 5);
        System.out.println("Array values after fill: "
                + Arrays.toString(intArray));

        // You can fill a partial range with Arrays.fill overloaded method
        int partialFillValue = 9;
        Arrays.fill(intArray, 5, 10, partialFillValue);
        System.out.println("Array values after partial fill: "
                + Arrays.toString(intArray));

        // setAll was introduced in Java 8
        // It uses lambda expressions, but demonstrates sample here
        Arrays.setAll(intArray, (index) -> index + 1);
        System.out.println("Array values after setAll: "
                + Arrays.toString(intArray));

        // You can sort non-primitive data type arrays in reverse this way
        Arrays.sort(intArray, Collections.reverseOrder());
        System.out.println("Array values after reverse sort: "
                + Arrays.toString(intArray));

        // Similar to setAll and parallelSetAll, except this method
        // supports binary operations.
        Arrays.parallelPrefix(intArray, (left, right) -> left + right);
        System.out.println("Array values after parallelPrefix: "
                + Arrays.toString(intArray));

    }
}