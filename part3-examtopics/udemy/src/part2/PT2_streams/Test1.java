package part2.PT2_streams;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

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