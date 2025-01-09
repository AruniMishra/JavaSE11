package part1.OO3;

import java.io.FileNotFoundException;
import java.sql.SQLException;

enum Flags {
    TRUE, FALSE;

    private Flags() {
        System.out.println("HELLO");
    }
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
        long g = 012 ;
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

class Test54 {
    private static String s;

    public static void main(String[] args) {
        try {
            System.out.println(s.length());
        } catch (RuntimeException ex) {
            System.out.println("DONE");
        }
    }

    void nothing() {
        System.out.println(s.length());
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


class Test37 {
    private static void getData() throws SQLException {
        try {
            throw new SQLException();
        } catch (Exception e) {
            // e = new SQLException();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            getData();
        } catch(SQLException e) {
            System.out.println("SQL");
        }
    }
}



enum TrafficLight {
    RED, YELLOW, GREEN;
}

class Test41 {
    public static void main(String[] args) {
        TrafficLight tl1 = TrafficLight.GREEN;
        // TrafficLight tl2 = tl1.clone(); //Line n1
        // System.out.println(tl2); //Line n2
    }
}



class MyException1 extends RuntimeException {
}

class MyException2 extends RuntimeException{
}

class Test44 implements AutoCloseable {
    private static void m() {
        try {
            throw new RuntimeException();
        } catch(RuntimeException ex) {
            throw new MyException1();
        } finally {
            // If finally block throws exception, then exception thrown by try or catch block is ignored.
            throw new MyException2();
        }
    }

    public static void main(String[] args) {
        Test44 test44 = new Test44();

        try(test44) {
            m();
        } catch(MyException1 e) {
            System.out.println("MyException1");
        } catch(MyException2 e) {
            System.out.println("MyException2");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {

    }
}

interface Printer53 {
    default void print() throws FileNotFoundException {
        System.out.println("PRINTER");
    }
}

class FilePrinter implements Printer53 {
    public void print() { //Line n1
        System.out.println("FILE PRINTER");
    }
}
class Test53 implements Printer53 {
    public static void main(String[] args)  {
        Printer53 p = new FilePrinter(); //Line n2
        try {
            p.print(); //Line n3
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        var fp = new FilePrinter(); //Line n4
        fp.print(); //Line n5
    }

    public void walk() {
        try {
            Printer53.super.print(); //Line n3
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}



