package standardTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

interface House {
    public default String getAddress() {
        return "101 Main Str";
    }
}

interface Bungalow extends House {
    public default String getAddress() {
        return "101 Smart Str";
    }
}


@interface MyArtifact {
    int id() default 0;

    String name();
}

interface Tone {
    void up();
}

public class S4 {
}

class s4T3 {
    public static void main(String[] args) {
        String str = "10";
        int iVal = 0;
        Double dVal = 0.0;
        try {
            iVal = Integer.parseInt(str, 2);  // 1
            System.out.println(iVal);
            if ((dVal = Double.parseDouble(str)) == iVal) { // 2
                System.out.println("Equal");
            }
        } catch (NumberFormatException e) {
            System.out.println("Exception in parsing");
        }
        System.out.println(iVal + " " + dVal);


        Double Double1 = 1000.0;
        double d2 = 1000.0;
        int i1 = 1000;
        Integer Integer2 = Integer.valueOf(1000); // returns an new Integer object containing 1000
        Integer Integer3 = Integer.valueOf(1000); // returns an new Integer object containing 1000

        System.out.println(Double1 == d2); // prints true, Double1 is unboxed
        // and both the values are the same

        System.out.println(Double1 == i1); // prints true, Double1 is unboxed
        // and both the values are the same

        // sum((double) i1);// valid, but casting is needed here.

        System.out.println(i1 == Integer2); // prints true, integer is unboxed
        // and both the values are the same

        System.out.println(Integer2 == Integer3); // prints false, integer and Integer3 point to
        // two different Integer objects

        Integer2 = Integer.valueOf(100); // returns a cached Integer object because
        // the integer value is between -128 and 127

        Integer3 = Integer.valueOf(100); // returns the same cached Integer object
        // because the integer value is between -128 and 127

        System.out.println(Integer2 == Integer3); // prints true, because integer and Integer3
        // point to the same Integer object

        // System.out.println(Double1 == integer); // will not compile. No unboxing here
        // because neither of the operands are primitive.
    }

    static void sum(Double D1) {

    }

}

class MyHouse implements Bungalow, House {

}

class s4TestClass4 {

    public static void main(String[] args) {
        House ci = new MyHouse();  // 1
        System.out.println(ci.getAddress()); // 2
    }
}

@MyArtifact(id = 10, name = "class")
class s4TestClass5 {

    void someMethod(@MyArtifact(name = "param") int index) {
    }

}

class Book {

    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static void main(String[] args) {


        List<List<Book>> books = Arrays.asList(
                Arrays.asList(
                        new Book("Windmills of the Gods", 7.0),
                        new Book("Tell me your dreams", 9.0)),
                Arrays.asList(
                        new Book("There is a hippy on the highway", 5.0),
                        new Book("Easy come easy go", 5.0)));

        double d = books.stream()
                .flatMap(bs -> bs.stream())
                .mapToDouble(book -> book.getPrice())
                .sum();
        System.out.println(d);
    }

    private double getPrice() {
        return this.price;
    }
}

class s4TestClass18 {
    // public void method(java.io.FileNotFoundException s){
    //     System.out.println("java.io.FileNotFoundException Version");
    // }
    // public void method(java.io.IOException s){
    //     System.out.println("IOException Version");
    // }
    public static void main(String args[]) {
        s4TestClass18 tc = new s4TestClass18();
        tc.method(null);
    }

    public void method(Object o) {
        System.out.println("Object Version");
    }
}

class Speak {
    public static void main(String[] args) {
        Speak s = new GoodSpeak();

//        s.up();
        ((Tone) s).up();
        ((GoodSpeak) s).up();
        ((Tone) (GoodSpeak) s).up();


    }
}

class GoodSpeak extends Speak implements Tone {
    public void up() {
        System.out.println("UP UP UP");
    }
}


class Calculator {
    public static void main(String[] args) {
        double principle = 100;
        int interestrate = 5;
        double amount = compute(principle, x -> x * interestrate);
    }

    public static double compute(double base, Function<Integer, Integer> func) {
        return func.apply((int) base);
    }
}