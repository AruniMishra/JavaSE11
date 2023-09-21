package JavaFeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtility {
    public static void main(String[] args) {

        String multilineString = "first line \n \n second line \n demo";

        List<String> multStringList = new ArrayList<>(Collections.singleton(multilineString));
        multStringList.forEach(System.out::println);

        System.out.println("----------------------------------");
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());

        lines.forEach(System.out::println);
        System.out.println("----------------------------------");


        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());
        System.out.println(" l r ".strip());
        System.out.println(" l r ".stripLeading());
        System.out.println(" l r ".stripTrailing());

        Person person = new Person();

        System.out.println(person.name.isBlank());
    }

}

class Person {
    String name = null;

}
