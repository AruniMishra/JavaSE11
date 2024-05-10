package JavaFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VarType {

    // Invalid - Static class variables cannot be declared with var
    // static var classVariable = 10;
    //
    // Invalid - class instance variables cannot be declared with var
    // var instanceVariable = 20;

    public static void main(String[] args) {
        List<String> name1 = List.of("hello", "world");
        List<String> name2 = List.of("hello", "bye");

        List<List<String>> names = List.of(name1, name2);

        var names2 = List.of(name1, name2);

        names2.forEach(System.out::println);

        var var = new ArrayList<String>(Arrays.asList("one", "two", "three"));

        // And yes, you can name your method var...
        var(var);


        //----

        // Invalid var declarations:

        // // cannot use var declaration in a compound statement
        // var j = 0, k = 0;
        //
        // // again, cannot use var declaration in a compound statement
        // var m, n = 0;
        //
        // // Cannot declare a var variable without also initializing it
        // var someObject;
        //
        // // Cannot assign null to var variable, type cannot be inferred
        // var newvar = null;
        //
        // // Cannot use array initializer in var declaration/initialization
        // var myArray = {"A", "B"};
        //
        // // Cannot have an array of var
        // var[]newarray = new int[2];
        //
        // var ia2[][] = { {1, 2}, null };

        // var ia2 = { {1, 2}, null };

        int ia[][] = {{1, 2}, null};


        //---- valid

        var aClassWithAVeryLongName = new ANewClassWithAVeryLongName();

    }

    // You cannot have a method parameter of type var, but you can have
    // a method named "var" and a method parameter named "var"
    public static void var(ArrayList<String> var) {

        // var var =var;

        // How confusing can we make it?
        // Use LVTI to set local variable to our method parameter named var
        var x = var;

        // More so...
        for (var y : x) {
            System.out.println("var y =" + y);
        }
    }

    // Invalid, cannot have a method return type of var
    // public static var returnThis(String[] args) {
    //     return args;
    // }
}
