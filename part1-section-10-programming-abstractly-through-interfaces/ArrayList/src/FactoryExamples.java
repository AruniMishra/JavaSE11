import java.util.ArrayList;
import java.util.List;

public class FactoryExamples {
    public static void main(String[] args) {

        List<String> originalList = new ArrayList<>();
        originalList.stream().filter(s -> s.contains("_2"));
        for (int i = 0; i < 10; i++) originalList.add("TEST_" + (i + 1));

        System.out.println(originalList);

        // List.copyOf was added in Java 10
        List<String> copiedList = List.copyOf(originalList);
        System.out.println(copiedList);
        // copiedList is immutable..

        // Let's change original list's values, and insert a null
        for (int i = 0; i < 10; i++) {
            if (i != 5) originalList.set(i, "TEST_" + (i + 10));
            else originalList.set(i, null);
        }
        System.out.println(originalList);

        // Exception: requireNonNull
        // List.copyOf: The given Collection must not be null, and it must not contain any null elements.
        // copiedList = List.copyOf(originalList);

        // but below works
        // Let's try making a fresh copy
        copiedList = List.copyOf(originalList.subList(0, 5));
        System.out.println(copiedList);

        // Create some test data
        String[] stringArray = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU"};

        // List.of can accept an array.
        copiedList = List.<String>of(stringArray);
        System.out.println(copiedList);

        // List.of can accept a variable list of elements
        copiedList = List.<String>of("ABC", "DEF", "GHI", "JKL", "MNO");
        System.out.println(copiedList);

        // List.of can be called with no parameter at all
        copiedList = List.<String>of();
        System.out.println(copiedList);
    }
}