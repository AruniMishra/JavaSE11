import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

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

interface Printer1 {
    String print();

    // Default method 'toString' overrides a member of 'java.lang.Object'
    // default String toString() {
    //     return "*";
    // }

}

interface ObjectCreator<T> {
    T create(String str);
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

        //-------

        Collection<Integer> list = List.of(100, 100, 100); // Line n1
        Collection<Integer> set = new LinkedHashSet<>(list); // Line n2

        // set.forEach((set) -> System.out.print(set)); //Line n3


        Stream.of(new StringBuilder()).map(s -> s.reverse()).forEach(System.out::println);
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

class Test4 {
    public static void main(String[] args) {
        Printer1 obj = () -> "PRINTER";
        System.out.print(obj);
        System.out.print(obj.print());
    }
}

class Test5 {
    public static void main(String[] args) {
        ObjectCreator<Integer> obj = Integer::valueOf;
        System.out.println(obj.create("603"));

        System.out.println("1----------------------------------------------------");
        Boolean[] booleans = {true, false, true};
        /*
        count() is a terminal method, which returns the count of elements in this stream.
        If result of count() can directly be computed from the stream source,
        then the implementation may choose to not execute the stream pipeline.
        In this case, functions map and peek don't change the number of elements in the given stream,
        hence these are not executed.
        Program executes successfully but nothing is printed on to the console.
         */
        Stream.of(booleans)
                .map(b -> b.equals(false))
                .peek(System.out::println)
                .count();


        System.out.println("2----------------------------------------------------");
        List<Integer> list = Arrays.asList(-80, 100, -40, 25, 200);
        Predicate<Integer> predicate = num -> {
            int ctr = 1;
            boolean result = num > 0;
            System.out.print(ctr++ + ".");
            return result;
        };

        list.stream()
                .filter(predicate)
                .count();


        System.out.println("\n\n3----------------------------------------------------");
        List<String> list1 = Arrays.asList("7 Seven", "Lucky 7", "77", "O7ne");
        list1.stream()
                .filter(str -> str.contains("7"))
                .forEach(System.out::println);


        System.out.println("\n\n3----------------------------------------------------");
        UnaryOperator<Character> operator = c -> (char) (c + 1);


        System.out.println("\n\n4----------------------------------------------------");
        class MyString {
            String str;

            MyString(String str) {
                this.str = str;
            }
        }

        var list3 = List.of(new MyString("Y"),
                new MyString("E"),
                new MyString("S"));

        list3.stream()
                .map(s -> s)
                .forEach(System.out::print);


        Comparator<Integer> comp = (i1, i2) -> i2.compareTo(i1);


        System.out.println("\n\n5----------------------------------------------------");
        Stream<String> stream = Stream.of("d", "a", "mm", "bb", "zzz", "www");
        Comparator<String> lengthComp = (s1, s2) -> s1.length() - s2.length();
        // stream.sorted(lengthComp).forEach(System.out::println);
        System.out.println();
        stream.sorted(lengthComp.thenComparing(String::compareTo)).forEach(System.out::println);
    }
}