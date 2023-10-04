package OO3;

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