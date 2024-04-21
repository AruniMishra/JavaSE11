package part2.PT2_streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum Color {
    RED, YELLOW, GREEN
}

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

        System.out.println(list.stream().max(Comparator.comparing(a -> a)).get()); // Line 1

        System.out.println(list.stream().max(Integer::compareTo).get()); // Line 2

        System.out.println(list.stream().max(Integer::max).get()); // Line 3

        Stream<String> stream = Stream.of("ocp");

        stream.flatMapToInt(s -> s.chars())
                .forEach(i -> System.out.print((char) i));
    }
}

class Test13 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("ocp");
        stream.flatMapToInt(s -> s.chars()).forEach(i -> System.out.print((char) i));
    }
}

class Test31 {
    public static void main(String[] args) {
        Stream<Double> stream = Stream.generate(() -> Double.valueOf("1.0"));
        // System.out.println(stream.sorted().findFirst()); // infinite
        System.out.println(stream.findFirst()); // works; Optional[1.0]
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
        boolean filter(Rope rope) {
            return rope.color.equalsIgnoreCase("Red");
        }
    }
}

class Test {
    public static void main(String[] args) {
        var list = List.of(new Rope(5, "red"),
                new Rope(10, "Red"), new Rope(7, "RED"),
                new Rope(10, "green"), new Rope(7, "Blue"));

        list.stream().filter(new Rope.RedRopeFilter()::filter).forEach(System.out::println); // Line n1
        /*
        If 'filter(Rope)' is declared as static, then to achieve same output,
        you will have to change the method reference syntax to: `filter(Rope.RedRopeFilter::filter)`.
         */

        if (false) ;
        else ;
    }
}

class Test32 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Z", "Y", "X"));
        list.stream()
                .sorted()
                .findFirst()
                .get();
        System.out.println(list.get(2));


    }
}

class Test40 {
    public static void main(String[] args) {
        var names = List.of("John", "william", "Claire", "HOPE", "Clark", "Hunter", "Kirk");

        search(names, "jack")
                .or(() -> search(names, "John"))
                .or(() -> search(names, "hope"))
                .or(() -> search(names, "Clark"))
                .ifPresent(System.out::print);
    }

    static Optional<String> search(List<String> list, String textToSearch) {
        return list.stream()
                .filter(s -> s.equalsIgnoreCase(textToSearch))
                .findFirst();
    }
}

class Test46 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("d", "cc", "bbb", "aaaa");
        stream.sorted()
                .forEach(System.out::println);
    }
}

class Test47 {
    public static void main(String[] args) {
        var list = List.of("MANGO", "BANANA", "ORANGE", "PEARS", "GRAPES");
        Predicate<String> predicate = str -> {
            int ctr = 1;
            boolean result = str.indexOf("N") != -1;
            System.out.print(ctr++ + "." + result);
            return result;
        };

        // List<String> collect =
        list.stream()
                .filter(predicate)
                .sorted() // sorted() is an intermediate operation
                .collect(Collectors.toList())
        ;

        System.out.println("---");
        // collect.forEach(System.out::println);
    }
}

class Fruit implements Comparable<Fruit>, Comparator<Fruit> {
    String name;
    String countryOfOrigin;

    Fruit() {
    }

    Fruit(String name, String countryOfOrigin) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
    }

    public static int comp(String s1, String s2) {
        return s2.compareToIgnoreCase(s1);
    }

    public String toString() {
        return name + ":" + countryOfOrigin;
    }

    @Override
    public int compareTo(Fruit o) {
        System.out.println("-compareTo-");
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public int compare(Fruit o1, Fruit o2) {
        System.out.println("-compare-");
        return o1.countryOfOrigin.compareToIgnoreCase(o2.countryOfOrigin);
    }
}

class Test51 {
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("Olive", "Middle East"));
        list.add(new Fruit("Mango", "India"));
        list.add(new Fruit("Cranberry", "North America"));
        list.add(new Fruit("Watermelon", "Africa"));
        list.add(new Fruit("Peach", "China"));
        list.add(new Fruit("Fig", "Middle East"));
        list.add(new Fruit("Blueberry", "North America"));

        /* INSERT */

        list.stream().sorted(new Fruit()).forEach(System.out::println);

        System.out.println("------------------");

        list.stream().sorted(Comparator.comparing(f -> f.countryOfOrigin, Fruit::comp))
                .forEach(System.out::println);
    }
}

class Test61 {
    public static void main(String[] args) {
        IntStream stream = IntStream.generate(() -> new Random().nextInt(100)).limit(5);
        stream.filter(i -> i > 0 && i < 10).findFirst().ifPresent(System.out::println);
        stream.filter(i -> i > 0 && i < 10).findFirst().stream();
    }
}

class MyException extends Exception {
}

class Test62 {
    public static void main(String[] args) throws MyException {
        OptionalInt optional = OptionalInt.empty();
        System.out.println(optional);
        System.out.println(optional.orElse(12));

        Arrays.asList(1, 2, 3, 4, 5).stream()
                .mapToInt(s -> s)
                .sum();

    }
}

class Test76 {
    public static void main(String[] args) {
        String text = "I am going to pass OCP exam in first attempt";
        Stream<String> stream = Arrays.stream(text.split(" "));
        IntSummaryStatistics stat = stream.mapToInt(String::length)
                .summaryStatistics();
        System.out.println(stat);
        System.out.println(stat.getMax());


        int res = 1;
        IntStream intStream = IntStream.rangeClosed(1, 5);
        System.out.println(intStream.reduce(1, Integer::sum));

        int res78 = 1;
        IntStream stream78 = IntStream.rangeClosed(1, 4);
        System.out.println(stream78.reduce(res78++, (i, j) -> i * j));


        Boolean.valueOf(null);

        Stream<Integer> integerStream = Arrays.asList(1, 2, 9, 4, 5, 8).stream();
        System.out.println(integerStream.max(Comparator.comparingInt(o -> o)));

        Stream<Double> doubleStream = Stream.of(9.8, 2.3, -3.0);
        System.out.println(doubleStream.min(Double::compareTo));


        int res2 = 1;
        IntStream stream2 = IntStream.rangeClosed(1, 4);

        System.out.println(stream2.reduce(res++, (i, j) -> i * j));


        Stream<Double> doubleStream1 = Arrays.asList(1.8, 2.2, 3.5).stream();
        doubleStream1.mapToDouble(a -> a).sum();


        Stream<Double> doubleStream2 = Arrays.asList(1.8, 2.2, 3.5).stream();
        System.out.println(doubleStream2.reduce((d1, d2) -> d1 + d2)); // Line n1
    }
}

class Test90 {
    public static void main(String[] args) {
        var a = DoubleStream.iterate(Double.valueOf(1.0), i -> i <= 3.0, i -> i + 1);
        var b = a.mapToObj(i -> "" + i)
                .collect(Collectors.joining(", "));
        System.out.println(b);
    }
}


class Test92 {
    public static void main(String[] args) {
        String str = Stream.of("a", "an", "and", "alas", "after")
                .dropWhile(s -> s.length() > 4)
                .collect(Collectors.joining(", "));
        System.out.println(str);
    }
}

class Certification {
    String studId;
    String test;
    int marks;

    Certification(String studId, String test, int marks) {
        this.studId = studId;
        this.test = test;
        this.marks = marks;
    }

    public String toString() {
        return "{" + studId + ", " + test + ", " + marks + "}";
    }

    public String getStudId() {
        return studId;
    }

    public String getTest() {
        return test;
    }

    public int getMarks() {
        return marks;
    }
}

class Test93 {
    public static void main(String[] args) {
        Certification c1 = new Certification("S001", "OCA", 87);
        Certification c2 = new Certification("S002", "OCA", 82);
        Certification c3 = new Certification("S001", "OCP", 79);
        Certification c4 = new Certification("S002", "OCP", 89);
        Certification c5 = new Certification("S003", "OCA", 60);
        Certification c6 = new Certification("S004", "OCA", 88);

        Stream<Certification> stream = Stream.of(c1, c2, c3, c4, c5, c6);
        Map<Boolean, List<Certification>> map =
                stream.collect(Collectors.partitioningBy(s -> s.equals("OCA")));
        System.out.println(map.get(true));
    }
}

class Book {
    String title;
    String author;
    double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getAuthor() {
        return this.author;
    }

    public String toString() {
        return "{" + title + "," + author + "," + price + "}";
    }
}

class Test95 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Head First Java", "Kathy Sierra", 24.5),
                new Book("OCP", "Udayan Khattry", 20.99),
                new Book("OCA", "Udayan Khattry", 14.99));
        books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor))
                .forEach((a, b) -> System.out.println(a));
    }
}

class TrafficLight {
    String msg;
    Color color;

    TrafficLight(String msg, Color color) {
        this.msg = msg;
        this.color = color;
    }

    public String getMsg() {
        return msg;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "{" + color + ", " + msg + "}";
    }
}

class Test96 {


    static StringBuilder RES = new StringBuilder();

    public static void main(String[] args) {
        TrafficLight tl1 = new TrafficLight("Go", Color.GREEN);
        TrafficLight tl2 = new TrafficLight("Go Now!", Color.GREEN);
        TrafficLight tl3 = new TrafficLight("Ready to stop", Color.YELLOW);
        TrafficLight tl4 = new TrafficLight("Slow Down", Color.YELLOW);
        TrafficLight tl5 = new TrafficLight("Stop", Color.RED);

        List<TrafficLight> list = Arrays.asList(tl1, tl2, tl3, tl4, tl5);

        list.stream()
                .collect(Collectors.groupingBy(TrafficLight::getColor))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("------------------------");

        Map<Color, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(TrafficLight::getColor,
                        Collectors.mapping(TrafficLight::getMsg, Collectors.toList())));

        map.entrySet().forEach(System.out::println);
        System.out.println("---------------------");

        System.out.println(map.get(Color.YELLOW));


        System.out.println("---------------------");
        var list1 = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        list1.parallelStream().forEach(RES::append);
        System.out.println(RES);

        System.out.println("\n---------------------");

        for (int i = 0; i < 1; i++) {
            var s1 = List.of("A", "E", "I", "O", "U").stream()
                    .reduce("_", String::concat);
            var s2 = List.of("A", "E", "I", "O", "U").parallelStream()
                    .reduce("_", String::concat);
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1.equals(s2));
        }

        var str1 = List.of("S", "P", "O", "R", "T").stream()
                .reduce("", String::concat);
        var str2 = List.of("S", "P", "O", "R", "T").parallelStream()
                .reduce("", String::concat);
        System.out.println();
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1.equals(str2));

    }
}


class Test112 {
    public static void main(String[] args) {
        var str1 = Stream.iterate(1, k -> k <= 10, i -> i + 1)
                .reduce("", (i, s) -> i + s, (s1, s2) -> s1 + s2);
        var str2 = Stream.iterate(1, k -> k <= 10, i -> i + 1)
                .parallel()
                .reduce("", (i, s) -> i + s, (s1, s2) -> s1 + s2);
        System.out.println(str1.equals(str2));
    }
}
