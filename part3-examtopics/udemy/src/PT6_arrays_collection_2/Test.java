package PT6_arrays_collection_2;

import java.util.ArrayList;
import java.util.List;

public class Test {
}

class Test3 {
    public static void main(String[] args) {

        List list1 = new ArrayList<String>(); // Line n5
        List<String> list2 = new ArrayList(); // Line n6
        // List<> list3 = new ArrayList<String>(); //Line n7
        List<String> list4 = new ArrayList<String>(); // Line n8
        List<String> list5 = new ArrayList<>(); // Line n9
    }
}

class Test53 {
    public static void main(String[] args) {
        var list = new ArrayList<String>(); //Line n1
        list.add("A");
        list.add("M");
        var list_of_list = List.of(list); //Line n2
        list_of_list.get(0).set(1, "N"); //Line n3
        list_of_list.get(0).forEach(System.out::print); //Line n4
    }
}