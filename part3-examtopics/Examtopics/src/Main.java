import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Main {
    public static void main(String... args) {

        Stream.of("12/31/2014", "01-01-2015", "2016")
                .filter(getStringPredicate())
                .forEach(out::println);

        // Predicate<String> demo = Main::getStringPredicate; // invalid
    }


    private static Predicate<String> getStringPredicate() {
        return s -> s.length() > 2;
    }


    public static Predicate<String> valid() {
        return s -> s.length() > 3;
    }
}