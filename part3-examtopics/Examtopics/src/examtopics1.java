import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Runner {
    public void run();
}

interface Runner2 {
    public int run();
}

public class examtopics1 {
}

class TestClass {

    public static void main(String[] args) {
        run(() -> voidMethod()); // will invoke run(Runner ) method.
        run(() -> intMethod());  // will not invoke run(Runner ) method.
    }

    public static void run(Runner x) {
        System.out.println("In runner");
        x.run();
    }

    public static void run(Runner2 x) {
        System.out.println("In runner2");
        x.run();
    }

    public static void voidMethod() {
        System.out.println("voidMethod");
    }

    public static int intMethod() {
        System.out.println("intMethod");
        return 0;
    }
}

class T15 {
    public static void main(String[] args) {
        List<Integer> list = List.of(11, 12, 13, 12, 13);

        // Double d = list.get(0);
        Double d = Double.valueOf(list.get(0));
        double f = list.get(0);
        Integer a = Integer.valueOf(list.get(0));
        Integer b = list.get(0);
        int c = list.get(0);
        Double e = Double.valueOf(list.get(0));

        //--------------


        BiPredicate<Integer, Integer> test = (var x, final var y) -> (x.equals(y));
        // BiPredicate<Integer, Integer> test2 = (Integer x, final var y) -> (x.equals(y));
        BiPredicate<Integer, Double> test3 = (Integer x, final Double y) -> (x.equals(y));

        //--------

        Runner runner = () -> System.out.println("running...");
    }
}

class Person {
    private String name = "Green";

    public void getName(String name) {

    }

    public void setName(String name) {
        name = "Mr." + name;
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class eTest23 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Blue");
        System.out.println(p);

    }
}


class sample {
    public static void main(String[] args) {
        int[][] iaa = {{1, 2}, {3, 4}, {5, 6}};
        long count = Stream.of(iaa)
                .flatMapToInt(IntStream::of)
                .map(i -> i + 1).filter(i -> i % 2 != 0)
                .peek(System.out::print)
                .count();
        System.out.println(count);
    }
}