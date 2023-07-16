import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

interface Pastry {
    void getIngredients();
}


class Calculator {
    int calculate(int i1, int i2) {
        return i1 + i2;
    }

    double calculate(byte b1, byte b2) {
        return b1 % b2;
    }
}

class Car {
    void speed(Byte val) { // Line n1
        System.out.println("DARK"); // Line n2
    } // Line n3

    void speed(byte... vals) {
        System.out.println("LIGHT");
    }
}

public class Test19 {


    public static void main(String[] args) {


        byte b = 10; // Line n4
        new Car().speed(b); // Line n5


        System.out.println("\n----------------------------------");
        boolean flag = false; // Line n1 // final results in compile time error

        while (flag) {
            System.out.println("Good Morning!"); // Line n2
        }

        // doesn't make flag a compile time constant.
        final boolean flag1;
        flag1 = false; // this is fine
        while (flag) {
            System.out.println("Good Morning!"); // Line n2
        }


        do {
            System.out.println("SLOW-");
        } while (false);

        // System.out.println("DOWN");

        System.out.println("\n----------------------------------");
        int i1;
        outer:
        do {
            i1 = 5;
            inner:
            while (true) {
                System.out.println(--i1);
                if (i1 == 4) {
                    break outer;
                }
            }
        } while (true);


        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        subtext(str, 3, 8);


        System.out.println("\n----------------------------------");
        String str1 = null;
        System.out.println(String.join("-", str1));
        // System.out.println(String.join(str1, "-")); // NullPointerException

        System.out.println(String.join("::", new String[]{"James", null, "Gosling"}));


        System.out.println("\n----------------------------------");
        byte b1 = 100;
        int i = 20;
        System.out.println(new Calculator().calculate(b1, i));
    }

    private static boolean subtext(String str, int i, int i1) {

        return false;
    }

    private static int[] subtext1(String str, int i, int i1) {

        return null;
    }
}

abstract class Cookie implements Pastry {
}

class ChocolateCookie extends Cookie {
    public void getIngredients() {
    }
}

class CoconutChocolateCookie extends ChocolateCookie {
    void getIngredients(int x) {
    }
}

class Foo1 {
    public List<Integer> foo(Set<CharSequence> m) {
        return null;
    }
}

class Bar1 extends Foo1 {


    public ArrayList<Integer> foo(Set<CharSequence> m) {

        return null;
    }

    public List<Integer> foo(TreeSet<String> m) {
        return null;

    }
}
