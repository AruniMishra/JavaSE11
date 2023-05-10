/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 6: Built-in Functional Interfaces
Topic:  Consumer Interface Example
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>(List.of("demo", "list", "goes", "here"));
        arrayList.forEach(s -> System.out.println(s));

        // Consumer variable assigned a lambda expression which
        // simply prints out String passed to it
        Consumer<String> c = (s) -> System.out.println("This is " + s);

        // Consumer variable assigned a lambda expression which uses
        // the local variable c of type Consumer.
        Consumer<List<String>> cb = (t) -> t.forEach(c);

        System.out.print("Consumer.accept(\"Testing Consumer Accept\") = ");
        // Consumer return type is void...
        c.accept("Testing Consumer Accept");

        // Print the heading
        System.out.println("Consumer.accept(One,Ten,Twelve,Three,Four) = ");
        // Execute accept on List<String> - prints each element using
        // local variable Consumer c.
        cb.accept(List.of("One", "Ten", "Twelve", "Three", "Four"));


        // BiConsumer variable has two arguments, List and Consumer ...
        BiConsumer<List<String>, Consumer<String>> bi = (s, t) -> s.forEach(t);

        // Print the heading
        System.out.println("BiConsumer.accept(One,Ten,Twelve,Three,Four) = ");
        // Execute accept on a List<String> using a Consumer (a lambda expression)
        bi.accept(List.of("One", "Ten", "Twelve", "Three", "Four"),
                (s) -> System.out.println("\tCounting... " + s));


        // Create a second BiConsumer variable to demonstrate andThen...
        BiConsumer<List<String>, Consumer<String>> biConsumerAndThen =
                (s, t) -> s.forEach(System.out::print);

        // Executing andThen on it's own does nothing
        System.out.println("\n--- Executing just BiConsumer.andThen ---");
        // bi.andThen(biConsumerAndThen); // only addThen doesn't execute without chaining it to accept method
        bi = bi.andThen(biConsumerAndThen);

        bi.accept(
                List.of("One", "Ten", "Twelve", "Three", "Four"),
                (s) -> System.out.println("\t" + s));


        // Executing andThen() method on it's own does nothing, must
        // be chained to the accept() method.
        System.out.println("\n--- Executing BiConsumer.andThen(" +
                "biConsumerAndThen).accept ---");
        bi.andThen(biConsumerAndThen).accept(
                List.of("One", "Ten", "Twelve", "Three", "Four--"),
                (s) -> System.out.println("\t" + s));


    }
}
