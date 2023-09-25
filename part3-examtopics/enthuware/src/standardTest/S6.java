package standardTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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

class s6T48FunWithOptional {
    public static String getValue() {
        return null;
    }

    public static void main(String[] args) {

        // Optional.of method throws NullPointerException if you try to create an Optional with a null value.
        // If you expect the argument to be null, you should use Optional.ofNullable method,
        // which returns an empty Optional if the argument is null.
        Optional<String> stro = Optional.of(getValue());// 1

        System.out.println(stro.isPresent());// 2

        // Calling get() on an empty Optional causes a java.util.NoSuchElementException to be thrown.
        // If you expect an Optional to be empty, you should use orElse(T ) method.
        System.out.println(stro.get());// 3

        // This method never throws any exception, not even if the argument is null.
        System.out.println(stro.orElse(null));// 4
    }
}