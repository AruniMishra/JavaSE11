/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 6: Built-in Functional Interfaces
Topic:  Built-In Interface Examples
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

// Item class
class Item {
    String sku;
    String description;

    // No args constructor
    Item() {
        sku = "#AAAA";
        description = "unknown";
    }

    // Single args constructor
    Item(String sku) {
        this.sku = sku;
        description = "unknown";
    }

    // Multiple args constructor
    Item(String sku, String description) {
        this.sku = sku;
        this.description = description;
    }

    // Clone method
    public Item clone() {
        String firstPart = this.sku.split("-")[0];
        return new Item(firstPart + "-0001", "cloned");
    }

    // toString method
    public String toString() {
        return "Item{" + "sku='" + sku + '\'' + ", description='" + description + '\'' + '}';
    }


}

// Class which uses many built-in interface to do basically the
// same thing, create a new Item object ..
public class BuiltInInterfaceExamples {

    public static void mymethod() {
        System.out.println("demo");
    }

    public static void main(String[] args) {

        BuiltInInterfaceExamples builtInInterfaceExamples = new BuiltInInterfaceExamples();
        mymethod();

        // Supplier & Method reference
        Supplier<Item> s1 = Item::new;


        // Supplier & Lambda Expression
        Supplier<Item> s2 = () -> new Item("#ABCD-0000");

        // UnaryOperator  & Lambda Expression
        UnaryOperator<Item> s3 = s -> new Item(s.sku + "-0001", s.description);


        // UnaryOperator  & Method reference
        UnaryOperator<Item> s4 = Item::clone;
        UnaryOperator<Item> s42 = a -> a.clone(); // alernative
        // or,
        Item itemObj = new Item();
        Supplier<Item> s43 = itemObj::clone;


        // BiFunction & Lambda Expression
        BiFunction<String, String, Item> s5 = (s, t) -> new Item(s, t);

        // Consumer & Lambda Expression
        Consumer<List> s6 = s -> s.add(new Item("#EEEE-0000", "e Product"));

        // Predicate & Lambda Expression
        Predicate<List> s7 = s -> s.add(new Item("#FFFF-0000", "f Product"));

        // Create a new List of Item
        List<Item> list = new ArrayList<>();

        // Execute Suppliers
        list.add(s1.get());
        list.add(s2.get());

        // Execute UnaryOperators
        list.add(s3.apply(list.get(0)));
        list.add(s4.apply(list.get(1)));

        // Execute BiFunction
        list.add(s5.apply("#DDDD-0000", "d Product"));

        // Execute Consumer
        s6.accept(list);

        // Execute Predicate
        s7.test(list);

        // Print Results
        list.forEach(System.out::println);


        // Executing methods with built-in interface arguments
        createAndAddItem(list, s6);
        createAndAddItem(list, s7);


        // Ambiguous method call. Both createAndAddItem matches
        // createAndAddItem(list,  s -> s.add(new Item("#EEEE-0000", "e Product")));


        createAndAddItem(list, (Predicate<List>) s -> s.add(new Item("#EEEE-0000", "e Product")));


        // Setting Function and Supplier to the same code..
        Function<String, Item> function = Item::new; // a -> new Item(a); a of string type
        Supplier<Item> supplier = Item::new;

        // Pass method reference to method which accepts Supplier
        // Item i = createItem("Test", Item::new);   // Ambiguous method call


        Item i = createItem("Test", (Function<String, Item>) Item::new);

        Item i2 = createItem("Test", (Function<String, Item>) Item::new);

    }


    // Overloaded Method accepts Consumer
    private static void createAndAddItem(List<Item> l, Consumer<List> c) {
        c.accept(l);
    }

    // Overloaded Method accepts Predicate
    private static void createAndAddItem(List<Item> l, Predicate<List> p) {
        p.test(l);
    }


    // Method accepts Supplier which creates a new item with defaults
    private static Item createItem(String s, Supplier<Item> supplier) {
        Item i = supplier.get();
        i.sku = s;
        return i;
    }


    // Method accepts Function which creates a new item
    private static Item createItem(String s, Function<String, Item> function) {
        return function.apply(s);
    }


}
