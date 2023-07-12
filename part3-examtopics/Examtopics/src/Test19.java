import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

interface Pastry {
    void getIngredients();
}

public class Test19 {
    public static void main(String[] args) {
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
            System.out.print("SLOW-");
        } while (true);

        // System.out.println("DOWN");
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