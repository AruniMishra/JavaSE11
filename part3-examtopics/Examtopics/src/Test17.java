import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

// Line 1
public class Test17<N extends Number, C extends Collection<N>> {

    static int myint = 666;
    private static int i;
    private static int[] primes = {2, 3, 5, 7};
    private static String result = "";

    public static void main(String... args) {

        int myint = Test17.myint;

        //-----------------
        System.out.println("------------------------");

        var numbers = List.of(5, 4, 6, 3, 7, 2, 8, 1, 9); // Line 5
        Test17<Integer, List<Integer>> c = new Test17<>();
        System.out.println(c.sum(numbers));

        //-----------------
        System.out.println("------------------------");


        int ___50 = 0;
        int z = ___50;


        byte b1 = 12; // Line n1
        int i1 = b1; // Line n2
        byte b2 = (byte) i1; // Line n3

        final int i2 = 10;
        byte b3 = i2;
        System.out.println(b1 + i1 + b2);


        final int i03 = 10;
        short s03 = i03;

        // with final variable and the value is within the range,
        // then final variable is implicitly casted to target type.
        final int i4 = 32767;
        // final int i4 = 327670; // invalid
        short s3 = i4;

        int i7 = 10;
        short s7 = (short) i7;


        Boolean b01 = Boolean.valueOf("tRuE");
        Boolean b02 = Boolean.valueOf("fAlSe");
        Boolean b03 = Boolean.valueOf("abc");
        Boolean b04 = null;
        System.out.println(b01 + ":" + b02 + ":" + b03 + ":" + b04);


        // Compiler can 't convert null to double primitive type, so 2nd argument is tagged to Double reference type.
        // add(10.0, null);


        extractInt(2.7);
        // extractInt(2);


        System.out.println("Password" + 1 + (2 + 3) + 4);

        System.out.println(1 + 2 + 3 + (4 + "Running"));


        System.out.println("1" + "2" + "3" == "1" + "2" + "3");


        byte var = 127;
        System.out.println(var += 1); // converts to var = (byte) (var + 1) and hence it compiles successfully.
        // System.out.println(var = var + 1); // invalid


        //-----------------
        System.out.println("------------------------");
        String text = null;
        text = text + new A1(); // Line n1
        System.out.println(text);
        System.out.println(text.length()); // Line n2

        System.out.println("------------------------");
        StringBuilder sb = new StringBuilder("INHALE ");
        String s = sb.toString() + (sb.append("EXHALE "));
        System.out.println(s + ":\n" + s.strip());
        System.out.println(s.strip().length());

        System.out.println("------------------------");
        boolean flag = false;
        System.out.println((flag = true) | (flag = false) || (flag = true));
        System.out.println(flag);

        System.out.println("------------------------");
        boolean status = true;
        System.out.println(status = true || (status = false) | (status = false));
        System.out.println(status);


        System.out.println("------------------------");
        int x = 7;
        boolean res = x++ == 7 && ++x == 9 || x++ == 9;
        System.out.println("x = " + x);
        System.out.println("res = " + res);


        System.out.println("------------------------");
        x = 2;
        switch (x) {
            default:
                System.out.println("Still no idea what x is");
            case 1:
                System.out.println("x is equal to 1");
                break;
            case 2:
                System.out.println("x is equal to 2");
                break;
            case 3:
                System.out.println("x is equal to 3");
                break;
        }

        System.out.println("------------------------");
        long var1 = 10;
        // required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum
        switch ((int) var1) {
            case 10:
                System.out.println("TEN");
                break;
            default:
                System.out.println("DEFAULT");
        }


        System.out.println("------------------------");
        // code prints 51, as ASCII code of char ‘3’ is 51.
        int x1 = '3';
        System.out.println(x1);
        char c1 = '3';
        int i01 = '3';
        System.out.println(c1 == i01); // true

        int day = '3';
        // you are trying to compare character value '3' (equivalent decimal value is 51).
        switch (day) {
            case '3':
                System.out.println("BUY 2 GET 1 FREE");
                break;
            default:
                System.out.println("SORRY!!! NO SALE");
        }


        foo(n -> String.valueOf(n + 1));
        foo(n -> Integer.toHexString(n));
        // foo( n -> Integer::toHexString ); // invalid
        foo(Integer::toHexString);


        System.out.println("------------------------");
        /*
        private static int i;
        private static int[] primes = {2, 3, 5, 7};
        private static String result = "";
         */
        while (i < primes.length) {
            if (i == 3) {
                break;
            }
            i++;
            result += primes[i];
        }
        System.out.println(result);


        System.out.println("------------------------");
        List<String> list1 = new ArrayList<>(List.of("Earth", "Wind", "Fire"));
        List<String> list2 = List.copyOf(list1);

        list1.sort((String item1, String item2) -> item1.compareTo(item2));
        // list2.sort((String item1, String item2) -> item1.compareTo(item2)); // UnsupportedOperationException
        System.out.println(list2.equals(list1));


        System.out.println("------------------------");

    }

    private static void add(double d1, double d2) {
        System.out.println("double version: " + (d1 + d2));
    }

    private static void add(Double d1, Double d2) {
        System.out.println("Double version: " + (d1 + d2));
    }

    private static void extractInt(Double obj) {
        System.out.println(obj.intValue());
    }

    public static void foo(Function<Integer, String> fun) {

        System.out.println(fun.apply(2));

    }

    public double sum(C collection) {
        double sum = 0.0;
        for (N n : collection) {
            sum += n.doubleValue();
        }
        return sum;
    }
}


class A1 {
    public String toString() {
        return null;
    }
}


class Super {
    final int num; // line nl

    public Super(int num) {
        this.num = num;
    }

    final private void method() {
        System.out.println("Output from Super");
    }
}

class Sub extends Super {
    int num; // line n2

    Sub(short num) { // line n3
        super(num);
        method();
    }

    void method() { // line n4
        System.out.println("Output from Sub");
    }
}

