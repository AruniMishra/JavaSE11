import java.util.Arrays;
import java.util.List;

public class ArrayClone {
    public static void main(String[] args) {
        String[] stringArray = {"abc", "def", "ghi"};
        System.out.println("stringArray " + Arrays.toString(stringArray));

        // 1. using stringArray.clone()
        // Mutable, shallow copy
        System.out.println("\n----1. stringArray.clone()----");
        String[] clonedArray = stringArray.clone();
        System.out.println("clonedArray before\t" + Arrays.toString(clonedArray));
        clonedArray[1] = "new";
        System.out.println("stringArray after\t " + Arrays.toString(stringArray));
        System.out.println("clonedArray after\t " + Arrays.toString(clonedArray));


        // 2. using Arrays.copyOf()
        // Mutable, shallow copy
        System.out.println("\n----2. using Arrays.copyOf()----");
        String[] copiedArray = Arrays.copyOf(stringArray, stringArray.length);
        System.out.println("copiedArray before\t" + Arrays.toString(copiedArray));
        copiedArray[1] = "new";
        System.out.println("stringArray after\t" + Arrays.toString(stringArray));
        System.out.println("copiedArray after\t" + Arrays.toString(copiedArray));


        // 3. using Arrays.copyOfRange()
        // Mutable, shallow copy
        System.out.println("\n----3. using Arrays.copyOfRange()----");
        String[] copiedArrayRange = Arrays.copyOfRange(stringArray, 0, stringArray.length);
        System.out.println("copiedArrayRange before\t" + Arrays.toString(copiedArrayRange));
        copiedArrayRange[1] = "new";
        System.out.println("stringArray after\t\t" + Arrays.toString(stringArray));
        System.out.println("copiedArrayRange after\t" + Arrays.toString(copiedArrayRange));


        // 4. using Arrays.copyOfRange()
        // Immutable, shallow copy
        System.out.println("\n----4. using List.copyOf()----");
        List<String> listCopy = List.copyOf(Arrays.asList(stringArray));
        System.out.println("listCopy(immutable)\t" + listCopy);
        // listCopy.set(1, "new"); //not allowed, since List is immutable
        String[] arrayFromList = listCopy.toArray(new String[0]); // but array from toArray is not immutable
        arrayFromList[1] = "new";
        System.out.println("stringArray after\t" + Arrays.toString(stringArray));
        System.out.println("arrayFromList after\t" + Arrays.toString(arrayFromList));
        System.out.println("listCopy(immutable)\t" + listCopy);


        // 5. using System.arraycopy()
        // Immutable, shallow copy
        System.out.println("\n----5. using System.arraycopy()----");
        String[] systemClonedArray = new String[stringArray.length];
        System.arraycopy(stringArray, 0, systemClonedArray, 0, stringArray.length);
        System.out.println("systemClonedArray before" + Arrays.toString(systemClonedArray));
        systemClonedArray[1]="new";
        System.out.println("stringArray after\t\t" + Arrays.toString(stringArray));
        System.out.println("systemClonedArray after\t" + Arrays.toString(systemClonedArray));

    }
}
