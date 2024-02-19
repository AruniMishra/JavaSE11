package part1.PT5_array_collection_1;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface M {
}

interface N {
}

public class PT5 {
}

class Test4 {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("C:/temp.txt")) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class A {
    void nothing() throws IOException {
        System.out.println("A");
    }
}

class B extends A {
    void nothing() {
        System.out.println("B");
    }
}

class MyResource implements AutoCloseable {
    public void execute() {
        System.out.println("Executing");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing");
    }
}

class Test9 {
    public static void main(String[] args) throws Exception {
        try (MyResource resource = new MyResource()) {
            resource.execute();
        }
    }
}

class MyResource11 implements AutoCloseable {
    @Override
    public void close() throws IOException {
        System.out.println("--closing--");
        throw new IOException("IOException");
    }

    public void execute() throws SQLException {
        throw new SQLException("SQLException");
    }
}

class Test11 {
    public static void main(String[] args) {
        try (MyResource11 resource = new MyResource11()) {
            // try { MyResource11 resource = new MyResource11();
            resource.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSuppressed()[0].getMessage());
        }
    }
}

class demo {

    public static void main(String[] args) {
        A a = new B();
        try {
            a.nothing();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Arrays.compare(new int[]{10}, null));


        // java.util.Arrays.compare(null, null); // compilation failure as it is an ambiguous call.
        Arrays.compare((int[]) null, (int[]) null); //  returns 0.


        var arr = new int[6][6]; // Line n1
        arr[1][4] = 100;
        // arr[6][6] = 200;
        // arr[3][6] = 300;
    }
}

class Printer56<String> {
    private String t;

    Printer56(String t) {
        this.t = t;
    }
}

class Test56 {
    public static void main(String[] args) {
        Printer56<Integer> obj = new Printer56<>(100);
        System.out.println(obj);
    }
}

class Printer57<String> {
    private String t;

    Printer57(String t) {
        this.t = t;
    }

    public <String> String toString1() {
        return null;
    }

    public java.lang.String toString() {
        return null;
    }
}

class Test57 {
    public static void main(String[] args) {
        Printer57<Integer> obj = new Printer57<>(100);
        System.out.println(obj);
    }
}

class Test51 {
    public static void main(String[] args) {
        String[][] arr = {{"7", "6", "5"}, {"4", "3"}, {"2", "1"}};
        for (int i = 0; i < arr.length; i++) { // Line n1
            for (int j = 0; j < arr[i].length; j++) { // Line n2
                switch (arr[i][j]) { // Line n3
                    case "2":
                    case "4":
                    case "6":
                        break; // Line n4
                    default:
                        continue; // Line n5
                }
                System.out.print(arr[i][j]); // Line n6
            }
        }
    }
}

class T {
    @Override
    public String toString() {
        return "TTT";
    }
}

class Printer<T> {
    private T t;

    Printer(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        System.out.println("---");
        return t.toString();
    }
}

class Test55 {
    public static void main(String[] args) {
        Printer<T> obj = new Printer<>(new T());
        System.out.println(obj);

    }
}

class GenericPrinter<T> {
}


//---

abstract class AbstractGenericPrinter<X, Y, T> extends GenericPrinter<T> {
}

abstract class AbstractGenericPrinter2<X, Y> extends GenericPrinter<String> {
}

class A59 {
}

class B59 extends A {
}

class C extends A59 implements M {
}

class D extends A59 implements M, N {
}

class Generic59<T extends A59 & M & N> {
}


class Test59 {
    public static void main(String[] args) {
        /*INSERT*/

        Generic59<D> generic59 = new Generic59<D>();
    }
}


class Test64 {
    public static <T> T get(T t) {
        return t;
    }

    public static void main(String[] args) {
        String str = get("HELLO");
        System.out.println(str);
    }
}


class Animal65 {
}

class Dog65 extends Animal65 {
}

class Cat65 extends Animal65 {
}

class A65<T> {
    T t;

    void set(T t) {
        this.t = t;
    }

    T get() {
        return t;
    }
}

class Test65 {
    public static <T> void print1(A65<? extends Animal65> obj) {
        // obj.set(new Dog65()); //Line n1
        System.out.println(obj.get().getClass());
    }

    public static <T> void print2(A65<? super Dog65> obj) {
        obj.set(new Dog65()); // Line n2
        System.out.println(obj.get().getClass());
    }

    public static void main(String[] args) {
        A65<Dog65> obj = new A65<Dog65>();
        print1(obj); // Line n3
        print2(obj); // Line n4

        A65<Animal65> obj3 = new A65<Animal65>();
        print1(obj3);
        print2(obj3);


        A65<? super Dog65> obj4 = new A65<Dog65>();

    }
}

class Test66 {
    private static <T extends Number> void print(T t) {
        System.out.println(t.intValue());
    }

    public static void main(String[] args) {
        print(Double.valueOf(5.5));
    }
}


class Test68 {
    public static void main(String[] args) {
        List<? extends String> list = new ArrayList<>(Arrays.asList("A", "E", "I", "O")); // Line n1
        // list.add("U"); //Line n2
        list.forEach(System.out::print);
    }
}

class Test69 {
    public static void main(String[] args) {
        List<? super String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        for (Object str : list) {
            System.out.print(str);
        }
    }
}


abstract class Animal {
}

class Dog extends Animal {
}

class Test73 {
    public static void main(String[] args) {
        /*
        Animal is super type and Dog is sub type, hence Animal a = new Dog(); is valid syntax. Both depicts Polymorphism.
        But in generics syntax, Parameterized types are not polymorhic, this means ArrayList<Animal> is not super type of ArrayList<Dog>.
         */
        List<Animal> list = new ArrayList<>();
        // ArrayList<Animal> list2 = new ArrayList<Dog>();
        list.add(0, new Dog());
        System.out.println(list.size() > 0);
    }
}