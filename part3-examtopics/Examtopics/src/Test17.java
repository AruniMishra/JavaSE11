import java.util.Collection;
import java.util.List;

// Line 1
public class Test17<N extends Number, C extends Collection<N>> {
    public static void main(String... args) {
        var numbers = List.of(5, 4, 6, 3, 7, 2, 8, 1, 9); // Line 5
        Test17<Integer, List<Integer>> c = new Test17<>();
        System.out.println(c.sum(numbers));


        int ___50 = 0;
        int z = ___50;


        byte b1 = 12; // Line n1
        int i1 = b1; // Line n2
        byte b2 = (byte) i1; // Line n3

        final int i2 = 10;
        byte b3 = i2;
        System.out.println(b1 + i1 + b2);


        // with final variable and the value is within the range,
        // then final variable is implicitly casted to target type.
        final int i4 = 32767;
        short s3 = i4;

        int i7 = 10;
        short s7 = (short) i7;


        Boolean b01 = Boolean.valueOf("tRuE");
        Boolean b02 = Boolean.valueOf("fAlSe");
        Boolean b03 = Boolean.valueOf("abc");
        Boolean b04 = null;
        System.out.println(b01 + ":" + b02 + ":" + b03 + ":" + b04);


        // Compiler can 't convert null to double primitive type, so 2nd argument is tagged to Double reference type.
        add(10.0, null);
    }

    private static void add(double d1, double d2) {
        System.out.println("double version: " + (d1 + d2));
    }

    private static void add(Double d1, Double d2) {
        System.out.println("Double version: " + (d1 + d2));
    }

    public double sum(C collection) {

        double sum = 0.0;
        for (N n : collection) {
            sum += n.doubleValue();
        }
        return sum;
    }
}