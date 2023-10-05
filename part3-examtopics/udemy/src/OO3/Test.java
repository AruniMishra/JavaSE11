package OO3;

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
