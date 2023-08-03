/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 6: Built-in Functional Interfaces
Topic:  Supplier Interface Example
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Set a local variable to a default String
        String s;
        if (args != null && args.length > 0) s = args[0];
        else s = "This that and the other and so forth";

        // Create the Supplier local variable with lambda Expression that
        // calls private method and uses local variable
        Supplier<List<String>> supplier = () -> getData(s);

        // Count # of words user entered or words in String default
        System.out.println("# of words entered = " + supplier.get().size());


        Empl empl = new Empl();
        Supplier<Empl> emplSupplier = () -> {
            empl.age = 1;
            return empl;
        };

        empl.age = 5;
        System.out.println(emplSupplier.get().age);
    }

    // Private method splits String into words, returns as list
    private static List<String> getData(String s) {
        return new ArrayList<String>(List.of(s.split("\\s")));

    }
}


class Empl {
    int age;
}