// For all the examples below, the initializers reference variables
// declared after the blocks.
class Thing {

    // Constructor
    Thing() {
        secondString = "b" + secondString;
        System.out.println("3. inside constructor: " + secondString);
    }

    // Initializer
    {
        firstString = "a" + thirdString; //valid
        System.out.println("2. inside initializer");
        firstString = this.secondString; //this should be used to refer secondString

    }

    // Static Initializer
    static {
        //A static initializer cannot use a static variable, declared below it in a statement,
        //System.out.println(thirdString); //Illegal forward reference
        System.out.println("1. inside static");
        thirdString = "c";
    }

    // Two instance variables
    String firstString;
    String secondString;

    // static variable
    static String thirdString;

    public String toString() {
        return firstString + secondString + thirdString;
    }
}

public class ForwardReference {
    public static void main(String[] args) {
        Thing one = new Thing();
        System.out.println(one);
    }
}