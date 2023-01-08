
import java.util.ArrayList;
import java.util.Arrays;

// You can name your class Var...
public class Var {

    public static void main(String[] args) {

        // Yes, you can name your LVTI variable "var"
        var var = new ArrayList<String>(Arrays.asList("one", "two", "three"));

        // And yes, you can name your method var...
        var(var);
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
}