import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface InterfaceTwo {
}

public class Test27 {
}

abstract class AbstractClass {

}

class Over154 {

    public static void main(String[] args) {
        int[] nums = new int[10];

        // arrays are object in java
        new Over154().analyze(nums);
    }

    void analyze(Object[] o) {
        System.out.println("Object array");
    }

    void analyze(long[] o) {
        System.out.println("long array");
    }

    void analyze(Object o) {
        System.out.println("Object");
    }
}

class T165 {
    public static void main(String[] args) {
        Stream<Integer> data = IntStream.range(1, 100).boxed();

        Integer sum = data.mapToInt(a -> a).parallel().reduce(0, Integer::sum);

        OptionalInt value2 = data.mapToInt(a -> a).parallel().reduce((a, b) -> a + b);
        Integer sum2 = value2.getAsInt();

        Integer sum3 = data.map(a -> a).reduce(0, (a, b) -> a + b);


        String s = "10";
        int x = 0;
        x = Integer.parseInt(s, 2);
    }
}


interface A169 {
    abstract public void x();
}

abstract class B169{
    void x(){}
    public abstract void z();
}
 class C169 extends B169 implements A169{
     @Override
     public void x() { // must be public

     }

     @Override
     public void z() {

     }
 }