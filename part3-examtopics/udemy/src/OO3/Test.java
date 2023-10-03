package OO3;

public class Test {
    public static void main(String[] args) {
        System.out.println("--");
    }
}

interface M {
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