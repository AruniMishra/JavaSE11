// The Calculator class demonstrates overloading
// static methods.  Each method prints a unique message, so we can
// understand which method was picked by the JVM
class Calculator {
    public static long add(int a, Double f) {
        System.out.println("int + Double");
        long result = (long) (a + f);
        return result;
    }

//    public static long add(int...a ) {
//        System.out.println("int var arg");
//        int total = 0;
//        for (long val : a) {
//            total += val;
//        }
//        return total;
//    }

    public static long add(int a, long... b) {
        System.out.println("int a, Var args long b");
        int total = a;
        for (long val : b) {
            total += val;
        }
        return total;
    }

    public static long add(long... a) {
        System.out.println("Var args long a");

        int total = 0;
        for (long val : a) {
            total += val;
        }
        return total;
    }

    public static long add(int a, Long b) {
        System.out.println("int + Long");
        return a + b;
    }
}

public class OverloadTests {
    public static void main(String[] args) {

        // Testing Calculator with multiple primitive data types
        var result = Calculator.add(1, 2);
        System.out.println("result = " + result);

        result = Calculator.add(1, 2, 3);
        System.out.println("result = " + result);

        result = Calculator.add(1, 10l);
        System.out.println("result = " + result);

        result = Calculator.add(1, 12.3d);
        System.out.println("result = " + result);
    }
}