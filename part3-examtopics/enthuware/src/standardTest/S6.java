package standardTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class S6 {
}

class s6T22 {
    public static void main(String[] args) {
        Collection<Number> col = new HashSet<>();
        col.add(1);
        var list1 = List.of(col); // 1
        System.out.println(list1);
        col.add(2); // 2
        var list2 = List.copyOf(col); // 3
        System.out.println(list1 + ", " + list2);
    }
}