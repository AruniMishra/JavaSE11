import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.UnaryOperator;

interface Builder {
    public A build(String str);
}

public class Test26 {
}

class BuilderImpl implements Builder {

    @Override
    public final B build(String str) {
        return null;
    }
}

class T72 {
    public static void main(String[] args) {
        UnaryOperator<Integer> u = (var i) -> (i * 2);
        // UnaryOperator u1 = (int i) -> i * 2;
        UnaryOperator<Integer> u2 = (var i) -> {
            return i * 2;
        };
    }
}

interface A80 {
    public default void me() {

    }
}

interface b80 {
    public void me();
}

class T87 {
    public static void main(String[] args) {
        String[] cats = {"a", "dd", "d", "b", "f", "c"};
        var carList = new ArrayList<>(Arrays.asList(cats));
        carList.sort((a, b) -> -a.compareTo(b));
        carList.forEach(System.out::println);

        byte b = 10;
        nothing(b);
    }

    static void  nothing(Object a){
        return;
    }
}