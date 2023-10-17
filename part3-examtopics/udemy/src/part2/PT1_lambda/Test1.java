package part2.PT1_lambda;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test1 {
}


class Test {
    public static void main(String[] args) {
        Function<char[], String> obj = (char[] value) -> new String(value); // Line n1
        String s = obj.apply(new char[]{'j', 'a', 'v', 'a'}); // Line n2
        System.out.println(s);
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

    }
}

