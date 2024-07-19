interface Perishable1 {
    default int maxDays() {
        return 1;
    }
}

interface Perishable2 extends Perishable1 {
    public default int maxDays() {
        return 2;
    }
}

interface Moveable {
    public abstract void move();
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

class Milk implements Perishable2, Perishable1 {
}

public class Test20 implements Perishable2, Perishable1 {
    public static void main(String[] args) {
        Perishable1 obj = new Milk();
        System.out.println(obj.maxDays());


        M obj1 = new MyClass();
        // obj1.log(); //Line n1

    }

    void testNonStatic() {
        // Perishable1.super.maxDays();
    }
}

abstract class Animal {
    // should declare as public, else it is package scope
    public void move() {
        System.out.println("ANIMAL MOVING");
    }
}

class Dog extends Animal implements Moveable {
}

abstract class A2 {
    public static void log() {
        System.out.println("N");
    }
}

class MyClass extends A2 implements M {
}

abstract class Log {
    public static void log() {
        System.out.println("Log");
    }
}

/*
java: log() in Log cannot implement log() in ILog
  overriding method is static

 MyLogger class has instance method log() [inherited from ILog interface] and
  static method log() [from Log class] and this causes conflict.
  Static and non-static methods with same signature are not allowed in one scope,
  therefore class MyLogger fails to compile.
 */
// class MyLogger extends Log implements ILog {
// }




