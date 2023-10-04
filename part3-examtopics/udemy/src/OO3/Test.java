package OO3;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        System.out.println("--");
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


interface Super {
    String name = "SUPER"; // Line n1
}

interface Sub extends Super { // Line n2
    String name = "Sub"; // Line n1
}

class Test16 {
    public static void main(String[] args) {
        Sub sub = null;
        System.out.println(sub.name); // Line n3
    }
}


class Test46 {
    public static void main(String[] args) {
        try {
            System.out.println(args[1].length());
        } catch (RuntimeException ex) {
            System.out.println("ONE");
        }
        // Java doesn't allow to catch specific checked exceptions
        // if these are not thrown by the statements inside try block.
        /* catch (FileNotFoundException ex) {
            System.out.println("TWO");
        } */
        System.out.println("THREE");
    }
}


class Test47 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try {
            for (; ; ) {
                sb.append("1Z0-819");
            }
        } catch (Exception e) {
            System.out.println("Exception!!!");
        } finally {
            System.out.println("Finally : Main ends!!!");
        }
    }
}

class Test48 {
    public static void main(String[] args) {
        try {
            main(args);
        } catch (Exception ex) {
            System.out.println("CATCH-"); // Line n1
        } finally {
            System.out.println("Finally : Main ends!!!");
        }
        System.out.println("OUT"); // Line n2
    }
}