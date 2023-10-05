package OO3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

enum Flags {
    TRUE, FALSE;

    private Flags() {
        System.out.println("HELLO");
    }
}

enum TrafficLight {
    RED, YELLOW, GREEN;
}

interface M {
    // scope of static log() method of M is limited to interface M
    public static void log() {
        System.out.println("M");
    }
}

interface ILog {
    default void log() {
        System.out.println("ILog");
    }
}

interface Perishable1 {
    static int maxDays() {
        return 1;
    }
}


interface Perishable2 {
    public default int maxDays() {
        return 2;
    }
}

interface Super {
    String name = "SUPER"; // Line n1
}

interface Sub extends Super { // Line n2
    String name = "Sub"; // Line n1
}

interface I1 {
    public static void print(String str) {
        System.out.println("I1:" + str.toUpperCase());
    }
}

interface Printer {
    default void print() throws FileNotFoundException {
        System.out.println("PRINTER");
    }
}

interface Moveable5 {
    void move();
}

public class Test {
    public static void main(String[] args) {
        System.out.println("--");
    }
}

abstract class Log {
    public static void log() {
        System.out.println("Log");
    }
}

class MyLogger extends Log
        // implements ILog  // . Static and non-static methods with same signature are not allowed in one scope,
{
    public static void main(String[] args) {
        System.out.println();
    }
}

class Milk implements Perishable2, Perishable1 {
    public static void main(String[] args) {
        Perishable2 perishable2 = new Milk();

        System.out.println(perishable2.maxDays());

        System.out.println(Perishable1.maxDays());
    }

    void nothing() {
        Perishable2.super.maxDays();
    }
}

class Test16 {
    public static void main(String[] args) {
        Sub sub = null;
        System.out.println(sub.name); // Line n3
    }
}

class C1 implements I1 {
    /*
    Even though class C1 implements I1, it doesn't have static print(String) method in its scope,
    therefore class C1 compiles successfully.
     */
    void print(String str) {
        System.out.println("C1:" + str.toLowerCase());
    }
}

class Test23 {
    public static void main(String[] args) {
        I1 obj = new C1();
        // obj.print("Java"); // Static method may be invoked on containing interface class only
    }
}

class Test31 {
    public static void main(String[] args) {
        // Flags flags = new Flags(); // enum types may not be instantiated.
    }
}

class Test41 {
    public static void main(String[] args) {
        TrafficLight tl1 = TrafficLight.GREEN;
        // TrafficLight tl2 = tl1.clone(); //Line n1
        // System.out.println(tl2); //Line n2
    }
}

class Test62 {
    private static void getData() throws SQLException {
        try {
            throw new SQLException();
        } catch (Exception e) {
            e = new SQLException();
            // throw e;
        }
    }

    public static void main(String[] args) {
        try {
            getData();
        } catch (SQLException e) {
            System.out.println("SQL");
        }
    }
}

class Base {
    public void log() throws NullPointerException {
        System.out.println("Base: log()");
    }
}

class Derived extends Base {
    public void log() throws RuntimeException {
        System.out.println("Derived: log()");


        /*
        Only thing to remember is that if overridden method throws any unchecked exception or Error,
        then overriding method must not throw any checked exceptions.
         */
        // FileReader file = new FileReader("C:\\test\\a.txt");
        // // Reading content inside a file
        // BufferedReader fileInput = new BufferedReader(file);

    }
}

class Test74 {
    static String[] names = {"Williamson.pdf", "Finch.pdf", "Kohli.pdf", "Morgan.pdf"};

    public static void main(String[] args) {
        try {
            if (search("virat.pdf"))
                System.out.println("FOUND");

        } catch (FileNotFoundException ex) {
            System.out.println("NOT FOUND");
        }
    }

    private static boolean search(String name) throws FileNotFoundException {
        for (int i = 0; i <= 4; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        throw new FileNotFoundException();
    }
}

class Test77 {
    public static void main(String[] args) {
        try {
            find();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void find() throws Exception {
        try {
            System.out.print(1);
            throw new FileNotFoundException("FNF");
        } catch (FileNotFoundException ex) {
            System.out.print(2);
            throw new IOException("IO");
        } catch (IOException ex) {
            System.out.print(3);
            throw new Exception("EXP");
        } finally {
            System.out.print(4);
            throw new Exception("FINALLY");
        }
    }
}

class Test78 {
    public static void main(String[] args) {
        try {
            check();
        } catch (RuntimeException e) {
            System.out.println(e.getClass().getName()); // Line n1
        }
    }

    private static void check() {
        try {
            RuntimeException re = new RuntimeException(); // Line n2
            throw re; // Line n3
        } catch (RuntimeException e) {
            System.out.println(1);
            ArithmeticException ex = (ArithmeticException) e; // Line n4
            System.out.println(2);
            throw ex;
        }
    }
}

class FilePrinter implements Printer {
    public void print() { // Line n1
        System.out.println("FILE PRINTER");
    }
}

class Test80 {
    public static void main(String[] args) throws FileNotFoundException {
        Printer p = new FilePrinter(); // Line n2
        p.print(); // Line n3
        var fp = new FilePrinter(); // Line n4
        fp.print(); // Line n5
    }
}

abstract class Animal5 {
    public void move() {
        System.out.println("ANIMAL MOVING");
    }
}


class Dog5 extends Animal5 implements Moveable5 {
}


class Test5 {
    public static void main(String[] args) {
        Moveable5 moveable = new Dog5();
        moveable.move();
    }
}

interface Blogger {
    public default void blog() throws Exception {
        System.out.println("GENERIC");
    }
}