package JavaFeatures;

import java.util.List;
import java.util.function.Predicate;

public class PredicateNot {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7);

        Predicate<Integer> even = n -> n % 2 == 0;

        integerList.stream().filter(even).forEach(System.out::print);
        System.out.println("\n--");
        integerList.stream().filter(n -> PredicateNot.isEven(n)).forEach(System.out::print);


        System.out.println("\n--------------");
        integerList.stream().filter(even.negate()).forEach(System.out::print);
        System.out.println("\n--");
        integerList.stream().filter(Predicate.not(PredicateNot::isEven)).forEach(System.out::print);
    }

    public static boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }
}
