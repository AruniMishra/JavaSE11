/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 6: Built-in Functional Interfaces
Topic:  andThen() and compose()
*/

import java.util.List;
import java.util.function.*;

public class AndThenExamples {
    public static void main(String[] args) {

        // Using andThen() and compose() with Function Interface
        System.out.println("----- Function andThen() and Compose() -----");
        // Declare a Function variable
        Function<String, String> function;

        // assign a lambda expression to function
        function = (s) -> {
            System.out.println("2. Doing the Main " + s);
            return s;
        };

        // invoke compose() on function?
        // function.<String>compose((s) -> {
        function = function.<String>compose((s) -> {
            System.out.println("1. Composing " + s + " --");
            return s;
        });

        // invoke andThen() on function?
        function = function.andThen((s) -> {
            System.out.println("3. And Then " + s);
            return s;
        });

        function.apply("Test");

        System.out.println("\nAdding on .....");

        String result = function.compose(s -> s + " COMPOSED")
                .andThen(s -> {
                    System.out.println("4. AndThen");
                    return s + " FINALLY";
                })
                .apply("INPUT_STRING");

        System.out.println("Result of function = " + result);


        UnaryOperator<String> unary = String::toUpperCase;
        result = unary.compose(s -> "---> " + s)
                .andThen(s -> s + " <----")
                .apply("hello");
        System.out.println("\nResult of UnaryOperator: " + result);


        // Using BiFunction with andThen()
        BiFunction<String, String, String> bifunction = (s, t) ->
                "---> " + s + " + " + t;
        result = bifunction
                .andThen(s -> s + " <---").apply("One", "Two");
        System.out.println("Result of BiFunction: " + result);


        // Using BinaryOperator with andThen()
        BinaryOperator<String> bi = (s, t) ->
                ">> " + String.join(" + ", s, t);
        result = bi.andThen(s -> s + " <<").apply("One", "Two");
        System.out.println("Result of BinaryOperator: " + result);


        // Using Consumer
        Consumer<List<String>> c;
        c = s -> s.forEach(System.out::println);
        c = c.andThen(s -> s.forEach(System.out::print));
        c.accept(List.of("January", "February", "March"));


    }
}