import java.util.Arrays;
import java.util.List;

public class ArrayComparison {
    public static void main(String[] args) {

        // Set up some array data for comparison.
        String[] firstString = {"abc", "def", "ghi", "jkl", "mno",
                "pqr", "stu", "vwx", "yz"};
        String[] copyOfFirstString = {"abc", "def", "ghi", "jkl", "mno",
                "pqr", "stu", "vwx", "yz"};
        String[] firstStringUnsorted = {"jkl", "mno", "pqr", "stu", "vwx",
                "yz", "abc", "def", "ghi"};
        String[] partialFirstString = {"abc", "def", "ghi", "jkl", "mno"};

        String firstStringReference[] = firstString;

        // Create pass-thru Lists from the arrays to test List equality
        List firstList = Arrays.asList(firstString);
        List secondList = Arrays.asList(copyOfFirstString);

        // First, compare arrays using object.equals
        System.out.println("------------- Object.equals ------------");
        System.out.println(" (firstString.equals(copyOfFirstString)) = "
                + firstString.equals(copyOfFirstString));
        System.out.println(" (firstString.equals(firstStringReference)) = "
                + firstString.equals(firstStringReference));

        // Compare arrays using Arrays.equals
        System.out.println("\n------------- Arrays.equals ------------");
        System.out.println(" (Arrays.equals(firstString,copyOfFirstString)) = "
                + Arrays.equals(firstString, copyOfFirstString));
        System.out.println(" (Arrays.equals(firstString,firstStringReference)) = "
                + Arrays.equals(firstString, firstStringReference));
        System.out.println(" (Arrays.equals(firstString,firstStringUnsorted)) = "
                + Arrays.equals(firstString, firstStringUnsorted));

        // Compare arrays using Arrays.compare
        System.out.println("\n------------- Arrays.compare ------------");
        System.out.println(" (Arrays.compare(firstString,copyOfFirstString)) = "
                + Arrays.compare(firstString, copyOfFirstString));
        System.out.println(" (Arrays.compare(firstString,firstStringReference)) = " +
                +Arrays.compare(firstString, firstStringReference));
        System.out.println(" (Arrays.compare(firstString,firstStringUnsorted)) = "
                + Arrays.compare(firstString, firstStringUnsorted));
        System.out.println(" (Arrays.compare(firstStringUnsorted,firstString)) = "
                + Arrays.compare(firstStringUnsorted, firstString));
        System.out.println(" (Arrays.compare(firstString,partialFirstString)) = "
                + Arrays.compare(firstString, partialFirstString));
        System.out.println(" (Arrays.compare(partialFirstString,firstString)) = "
                + Arrays.compare(partialFirstString, firstString));


        // More examples of Arrays.compare
        System.out.println("\n4------------- More Arrays.compare ------------");
        System.out.println(" (Arrays.compare(firstString,firstStringUnsorted)) = "
                + Arrays.compare(firstString, firstStringUnsorted));

        System.out.println("abc".compareTo("jkl"));

        // If we compare the first elements, we get the same result as comparing the full arrays...
        System.out.println("firstString[0].compareTo(firstStringUnsorted[0]  = "
                + firstString[0].compareTo(firstStringUnsorted[0]));

        //  New String array, only  first 3 elements are shared with firstString - the prefix.
        String[] notFullyPrefixedString = {"abc", "def", "ghi", "yz", "vwx", "stu"};
        System.out.println(" (Arrays.compare(firstString,notFullyPrefixedString)) = "
                + Arrays.compare(firstString, notFullyPrefixedString));

        // Verify that above result is same as comparing elements at  first non-matching index..
        System.out.println("firstString[3].compareTo(notFullyPrefixedString[3]  = " +
                firstString[3].compareTo(notFullyPrefixedString[3]));


        // Comparing subsets of elements in arrays
        System.out.println("\n5----  Arrays.compare for Element Ranges ----");

        // Set up arrays - note that both arrays contain "abc", "def", "ghi"
        String[] stringArray = {"abc", "def", "ghi", "jkl", "mno",
                "pqr", "stu", "vwx", "yz"};

        String[] stringUnsortedArray = {"jkl", "mno", "pqr", "stu",
                "vwx", "yz", "abc", "def", "ghi"};

        // We are going to compare the 1st 3 elements of the ordered array,
        // with the last 3 elements of the unsorted array:
        System.out.println(" (Arrays.compare(stringArray, 0, 3, stringUnsortedArray, 6, 9)) = "
                + Arrays.compare(stringArray, 0, 3, stringUnsortedArray, 6, 9));

        // Interestingly, you do not have to specify the same number of elements.
        System.out.println(" (Arrays.compare(stringArray, 0, 5, stringUnsortedArray, 6, 9)) = "
                + Arrays.compare(stringArray, 0, 5, stringUnsortedArray, 6, 9));

        System.out.println("\n------------- List.equals ------------");
        System.out.println(" (firstList.equals(secondList)) = "
                + firstList.equals(secondList));


        System.out.println("\n------------- misc ------------");

        var a = new int[]{1, 2, 3, 4, 5};
        var b = new int[]{1, 2, 3, 4, 3, 3};
        var c = new int[]{1, 2, 3, 4, 5, 6, 7};

        // If one array is the proper prefix of the other, then compare method returns a.length - b.length,
        // where a refers to 1st array and b refers to 2nd array.
        // For Character, Byte & Short; compare method returns x - y.
        // For Integer and Long; compare method returns -1 if x < y, it returns 1 if x > y, and it returns 0 if x == y.
        int x = Arrays.compare(a, c);
        int y = Arrays.compare(b, c);
        System.out.println(x + " " + y);
        System.out.println("---------------------------");


        // Finds and returns the index of the first mismatch between two int arrays,
        // otherwise return -1 if no mismatch is found.
        // The index will be in the range of 0 (inclusive) up to the length (inclusive) of the smaller array.

        // If the two arrays share a common prefix then the returned index is the length of the common prefix
        // and it follows that there is a mismatch between the two elements at that index within the respective arrays.

        // If one array is a proper prefix of the other than the returned index is the length of the smaller array
        // and it follows that the index is only valid for the larger array. Otherwise, there is no mismatch.
        x = Arrays.mismatch(a, c);
        y = Arrays.mismatch(b, c);
        System.out.println(x + " " + y); // 5 4
        System.out.println("---------------------------");


        int[] array1 = {};
        int[] array2 = {100, 200};
        System.out.println(Arrays.compare(array1, array2) + " " + Arrays.mismatch(array1, array2)); // -2 0
        System.out.println("---------------------------");


        char[] a1 = {'h', 'e', 'l', 'l'};
        char[] b1 = {};

        int x1 = Arrays.compare(a1, b1);
        int y1 = Arrays.mismatch(a1, b1);
        System.out.println(x1 + " " + y1); // 4 0
    }
}