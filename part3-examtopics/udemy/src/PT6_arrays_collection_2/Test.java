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

class Test14 {
    public static void main(String[] args) {
        /*
        In this case `animals.remove(new StringBuilder("Alligator"));` will never remove any items from the list as
         StringBuilder class doesn't override the equals(Object) method of Object class.

        StringBuilder instances created at "animals.add(new StringBuilder("Alligator"));"
        and "animals.remove(new StringBuilder("Alligator"));"
        are at different memory locations and equals(Object) method returns false for these instances.
         */
        List<StringBuilder> animals = new ArrayList<>();
        animals.add(new StringBuilder("Walrus"));
        animals.add(new StringBuilder("Anaconda"));
        animals.add(new StringBuilder("Alligator"));
        animals.add(new StringBuilder("Dog"));

        for(int i = 0; i < animals.size(); i++) {
            if(i == 0) {
                animals.remove(new StringBuilder("Alligator"));
            }
        }

        System.out.println(animals);
    }
}