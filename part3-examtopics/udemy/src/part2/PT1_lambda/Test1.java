package part2.PT1_lambda;


import java.util.*;
import java.util.function.*;

public class Test1 {
}


class Test {
    public static void main(String[] args) {
        Function<char[], String> obj = (char[] value) -> new String(value); // Line n1
        String s = obj.apply(new char[]{'j', 'a', 'v', 'a'}); // Line n2
        System.out.println(s);
    }
}

interface Printer {
    void print();
}

class Test14 {
    public static void main(String[] args) {
        int i = 400;
        Printer obj = () -> System.out.println(i);
        obj.print();
        // System.out.println(++i);
    }
}

class Test22 {
    public static void main(String[] args) {
        Collection<Integer> list = List.of(100, 100, 101); //Line n1
        Collection<Integer> set = new LinkedHashSet<>(list); //Line n2

        set.forEach((set1) -> System.out.print(set1)); //Line n3
    }
}

interface Printer25 {
    String print();
    String toString();
}

class Test25 {
    public static void main(String[] args) {
        Printer25 obj = () -> "PRINTER";
        System.out.print(obj);
        System.out.print(obj.print());
    }
}



interface Operation<T extends Integer> {
    T operate(T x, T y);
}
class Test26 {
    public static void main(String[] args) {
        Operation o1 = (x, y) -> x + y;
        System.out.println(o1.operate(5, 10));
    }
}


interface ObjectCreator<T> {
    T create(String str);
}

interface Logger {
    String log(byte i, byte j, byte k);
}

class Test31 {
    private static String print(Number i, Number j, Number k) {
        return i + ", " + j + ", " + k;
    }

    public static void main(String[] args) {
        Logger obj = (i, j, k) -> print(i, j, k); //Line n1
        System.out.println(obj.log((byte)11, (byte)22, (byte)33)); //Line n2
    }
}

class Test32 {
    public static void main(String[] args) {
        ObjectCreator<Integer> obj = Integer::valueOf;
        System.out.println(obj.create("603"));
    }
}


interface DoubleToByte {
    byte getValue();
}

class Test40 {
    public static void main(String[] args) {
        // DoubleToByte obj = () -> Double.valueOf("123").byteValue();
        DoubleToByte obj = Double.valueOf("123")::byteValue;
        System.out.println(obj.getValue());


        Function<char [], String> obj1 = value -> new String(value);
    }
}

class Test58 {
    public static void main(String[] args) {
        Function<String, Integer> f1 = Integer::new;
        Function<String, String> f2 = s -> new StringBuilder(s).reverse().toString();
        System.out.println(f1.compose(f2).apply("12345"));


        Predicate<String> predicate = p -> p.length() > 0;
    }
}

class Test71 {
    public static void main(String[] args) {
        Consumer<Integer> consumer = System.out::print;
        Integer i = 5;
        consumer.andThen(consumer).accept(i++); // Line n1
        System.out.println(i);


        BinaryOperator<String> operator = BinaryOperator.maxBy((s1, s2) -> s2.length() - s1.length()); //Line n1
    }
}


class Test100 {
    public static void main(String[] args) {
        Integer i = 10;
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(i *= 2);
        list.add(i);

        System.out.println(list);

        list.removeIf(a -> a == 10);

        System.out.println(list);
    }
}


class Test116 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList (2, 3, 4);
        UnaryOperator<Integer> operator = s -> s*s*s;
        list.replaceAll(operator);
        list.forEach(System.out::println);
    }
}
