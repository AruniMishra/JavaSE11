interface Flyable {

    public static final String name = "SUPER";

    static int horizontalDegree() { // Line n1
        return 20;
    }

    public static void shrinkPercentage() {
        System.out.println("80%");
    }

    default void fly() {
        System.out.println("Flying at " + horizontalDegree() + " degrees."); // Line n2
    }

    public abstract void land();
}

interface Sub1 extends Flyable {
}// Line n2

class AntMan implements Flyable {
    @Override
    public void land() {
        fly();
    }
}


class Test22 implements Flyable {
    public static void main(String[] args) {

        Sub1 sub1 = null;
        System.out.println(sub1.name); // Line n3
        new Test22().fly();
        new Test22().land();

        Flyable.shrinkPercentage();
        // Static method may be invoked on containing interface class only
        /*
        Correct and only way to access static method of an Interface is by using the name of the interface
         */
        // (new Test22()).shrinkPercentage(); // invalid

        // Test22.super.fly(); // super' cannot be referenced from a static context
        // Flyable.super.fly(); // super' cannot be referenced from a static context
    }

    public void land() {
        System.out.println("Landing at " + -Flyable.horizontalDegree() + " degrees."); // Line n3
        Flyable.super.fly();
    }
}


abstract interface I1 {

    /*
    the scope of print(String) method of I1 is limited to interface I1 and
    it can be invoked by using Interface name only, I1.print("").
     */
     public static void print(String str) {
        System.out.println("I1:" + str.toUpperCase());
    }
}

class C1 implements I1 {
    void print(String str) {
        System.out.println("C1:" + str.toLowerCase());

        I1.print("");

    }


}