package collection;



/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Sorting TreeSet
*/

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

// Class implements both Comparable & Comparator
class TreeElement implements
        Comparable<TreeElement>, Comparator<TreeElement> {

    private int id;
    private String value;

    // Constructor
    public TreeElement(int id, String value) {
        this.id = id;
        this.value = value;
    }

    // overriding Comparable.compareTo
    public int compareTo(TreeElement o) {
        // "Natural Order" = sorted by id ascending
        return this.id - o.id;
    }

    // overriding Comparator.compare
    public int compare(TreeElement o1, TreeElement o2) {
        // Order by value - descending, assume for now value is not null
        return o2.value.compareToIgnoreCase(o1.value);
    }

    public String toString() {
        return "{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}

// Test TreeSet ordering with Comparable and Comparator
public class TreeExamples {
    public static void main(String[] args) {

        List<TreeElement> setTestData = List.of(
                new TreeElement(2, "Sam"),
                new TreeElement(5, "Carol"),
                new TreeElement(1, "Mary"),
                new TreeElement(10, "Tim"));

        // option1
        // Create TreeSet passing data to constructor and print data
        TreeSet<TreeElement> treeSet0 = new TreeSet<>(setTestData);


        // option2: remove "implements Comparable<TreeElement>, Comparator<TreeElement>"
        /*
        TreeSet<TreeElement> treeSet = new TreeSet<>(
                // Comparator.comparing(TreeElement::getId)
                // Comparator.comparing(TreeElement::getId).reversed()
                Comparator.comparing(TreeElement::getValue).reversed()
        );
        treeSet.addAll(setTestData);
        */


        // This might look like I’m instantiating the tree set with a single element,but this is not the case,
        // because tree element implements comparator parsing the first element of the test data list,
        // is simply parsing a comparator to the tree set and not populating the tree set with any elements.
        // So, if I run this bearing in mind, we've still got a tree set add all on line 88.
        // The output confirms that the order used was determined by the tree element.compare method which
        // happens to be the same as what we had previously using dot reversed.
        TreeSet<TreeElement> treeSet = new TreeSet<>(setTestData.get(0));
        treeSet.addAll(setTestData);


        System.out.println("---- TreeSet Values ----");
        treeSet.forEach(System.out::println);
        System.out.println("---- Element lower than Sam ----");
        System.out.println(treeSet.lower(setTestData.get(0)));


    }
}