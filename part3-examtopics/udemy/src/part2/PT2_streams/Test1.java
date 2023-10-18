package part2.PT2_streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {
}

class Test4 {
    public static void main(String[] args) {
        IntStream stream = IntStream.generate(() -> new Random().nextInt(100)).limit(5);
        stream.filter(i -> i > 0 && i < 10).findFirst().stream();
    }
}

class Test5 {
    public static void main(String[] args) throws Exception {
        OptionalInt optional = OptionalInt.empty();
        System.out.println(optional.orElseThrow(Exception::new));
    }
}

class Test12 {
    public static void main(String[] args) {
        var list = List.of(10, 20, 8);

        System.out.println(list.stream().max(Comparator.comparing(a -> a)).get()); //Line 1

        System.out.println(list.stream().max(Integer::compareTo).get()); //Line 2

        System.out.println(list.stream().max(Integer::max).get()); //Line 3

        Stream<String> stream = Stream.of("ocp");

        stream.flatMapToInt(s -> s.chars())
                .forEach(i -> System.out.print((char)i));
    }
}


class Rope {
    int length;
    String color;

    Rope(int length, String color) {
        this.length = length;
        this.color = color;
    }

    public String toString() {
        return "Rope [" + color + ", " + length + "]";
    }

    static class RedRopeFilter {
        boolean  filter(Rope rope) {
            return rope.color.equalsIgnoreCase("Red");
        }
    }
}

class Test {
    public static void main(String[] args) {
        var list = List.of(new Rope(5, "red"),
                new Rope(10, "Red"), new Rope(7, "RED"),
                new Rope(10, "green"), new Rope(7, "Blue"));

        list.stream().filter(new Rope.RedRopeFilter()::filter).forEach(System.out::println); //Line n1
    }
}