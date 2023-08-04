import java.util.ArrayList;
import java.util.List;

interface Equality {
    /*
    Functional interface must have only one non-overriding abstract method but Functional interface can have constant
    variables, static methods, default methods, private methods and
    overriding abstract methods [equals(Object) method, toString() method etc. from Object class].
     */
    boolean equals1(Object obj);
}

interface Printable1 {
    public abstract void print();

    boolean equals(Object obj);
}

interface Printer {
    void print();
}

interface Display {
    void disp(String s);
}

interface Operation {
    int operate(int x, int y);
}

class Test {
    public static void main(String[] args) {
        Equality eq = x -> true;
        System.out.println(eq.equals(null));
    }
}

class Father {
}

class Son extends Father {
}

class GrandSon extends Son {
}

abstract class Super2 {
    abstract List<Father> get();

    abstract Father get1();
}

class Sub2 extends Super2 {
    /*
    There are 2 rules related to return types of overriding method:
    1. If return type of overridden method is of primitive type, then overriding method should use same primitive type.
    2. If return type of overridden method is of reference type,
    then overriding method can use same reference type or its subtype (also known as covariant return type).
    */

    // ArrayList<Object> get() {return null;} // invalid
    // List<Son> get() {return null;} // List<Son> is not subtype of List<Father>

    List<Father> get() {
        return null;
    }

    Son get1() {

        return null;

    }
}

public class Test25 {

    public static void main(String[] args) {

        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add("3"); // Line n1
        // list.removeIf(i -> i % 2 == 1); //Line n2
        System.out.println(list);


        Display obj = s -> {
            System.out.println(s.toUpperCase());

            return;
        };

    }
}

class Test2 {
    static int i = 400;

    public static void main(String[] args) {


        // Variable 'y' is a local variable and it is used in the lambda expression.
        // So, it should either be final or effectively final.
        int y = 400;

        Printer obj = () -> System.out.println(i);
        obj.print();
        System.out.println(++i);

        // Printer objy = () -> System.out.println(y);
        // objy.print();
        System.out.println(++y);
    }
}

class Test3 {
    public static void main(String[] args) {
        int x1 = 10;
        int y = 20;
        Operation o1 = (a, b) -> {
            System.out.println(y);
            return a * b;
        };
        System.out.println(o1.operate(5, 10));
    }
}