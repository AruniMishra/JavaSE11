import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        // https://www.java67.com/2021/09/3-ways-to-sort-list-in-java-8-and-11.html
        System.out.println("helllo");

        Test test = new Test();

        List<Integer> unsorted = Arrays.asList(11, 2, 5, 3, 2, 55, 32, 34);

        unsorted = test.sortList(unsorted);

        System.out.println(unsorted);

    }

    List<Integer> sortList(List<Integer> unsorted) {

        unsorted.sort(null);

        return unsorted;
    }
}
