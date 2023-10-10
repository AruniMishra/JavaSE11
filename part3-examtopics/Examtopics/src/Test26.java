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