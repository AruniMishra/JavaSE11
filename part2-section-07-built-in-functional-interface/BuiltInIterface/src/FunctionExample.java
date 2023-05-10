/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 6: Built-in Functional Interfaces
Topic:  Function Interface Example
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

        // Simplest Example, returns its own argument
        Function<String, String> f1 = (s) -> s;

        System.out.println("Function [(s) -> s]. apply(\"hello\") = "
                + f1.apply("hello"));

        // Function which splits a string on space, returns 1st element
        Function<String, String> f2 = (s) -> s.split("\\s")[0];

        System.out.println("Function [(s) -> s.split(\"\\\\s\")[0] ]." +
                " apply(\"hello there\") = " + f2.apply("hello there"));

        // Function returns sublist string with spaces not commas
        Function<List<Integer>, String> f3 =
                (s) -> s.subList(1, 4).toString().replace(',', ' ');

        System.out.println("Function" +
                " [s.subList(1,4).toString().replace(',',' ' ]." +
                " apply(List.of(10,20,30,40,50)) = " +
                f3.apply(List.of(10, 20, 30, 40, 50)));



        // Parsing the parts of the lambda expression into pre and post

        // First, sublist
        Function<List<Integer>, List<Integer>> fPre =
                (s) -> {
                    System.out.println("fPre executed");
                    return s.subList(1, 4);
                };

        // Second, make it a String - main function
        Function<List<Integer>, String> fResult =
                (s) -> {
                    System.out.println("fResult executed");
                    return s.toString();
                };

        // After its a String, replace comma with space
        Function<String, String> fPost =
                (s) -> {
                    System.out.println("fPost executed");
                    return s.replace(',', ' ');
                };


        // Executing by chaining Function local variables...
        // order: Compose, apply(on fresult) & andThen
        // note: apply method should be the last link in the chain
        System.out.println("fResult.compose(fPre).andThen(fPost).apply = " +
                fResult.compose(fPre).andThen(fPost).
                        apply(List.of(10, 20, 30, 40, 50)));



        // Executing by chaining Function local variables...
        System.out.println("fResult.compose(fPre).andThen(fPost).apply = " +
                fResult.andThen(fPost).compose(fPre).andThen(fPost).
                        apply(List.of(10, 20, 30, 40, 50)));


        // Executing by chaining lambda expressions - ugly but ok
        String newResult = (
                (Function<List<Integer>, String>) ((s) -> s.toString())).
                <List<Integer>>compose((s) -> s.subList(1, 4)).
                <String>andThen((s) -> s.replace(',', ' '))
                .apply(List.of(10, 20, 30, 40, 50));

        System.out.println("Chaining it all together: " + newResult);




        System.out.println("---- BiFunction Examples -----");
        // Example of BiFunction, accepts two String arguments, returns a
        // String value
        BiFunction<String, String, String> b1 = (s, t) -> s + " and " + t;
        System.out.println("BiFunction [b1 = (s, t) -> s + \" and \" + t] " +
                ".apply(\"Hello\",\"World\") = " + b1.apply("Hello", "World"));


        BiFunction<String, String, List<String>> b2 =
                (String s, String t) -> {
                    List<String> a = new ArrayList<>();
                    a.addAll(List.of(s.split("\\s")));
                    a.add(t);
                    return a;
                };

        System.out.println("BiFunction b2.apply(\"Hello my old friend\"," +
                "\"and world\") = " + b2.apply("Hello my old friend",
                "and world"));

    }
}

