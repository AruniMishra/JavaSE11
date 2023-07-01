import java.util.function.BiFunction;

public class Pair<T> {
    final BiFunction<T, T, Boolean> validator;
    T left = null;
    T right = null;

    private Pair() {
        validator = null;
    }

    Pair(BiFunction<T, T, Boolean> v, T x, T y) {
        validator = v;
        set(x, y);
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Boolean> biFunction = (a, b) -> a > b;
        Pair<Integer> pair = new Pair<>(biFunction, 3, 2);

        if (pair instanceof Pair) {
            System.out.println(pair.isValid());
        }
    }

    void set(T x, T y) {
        if (!validator.apply(x, y)) throw new IllegalArgumentException();
        setLeft(x);
        setRight(y);
    }

     private void setLeft(T x) {
        left = x;
    }

     private void setRight(T y) {
        right = y;
    }

    final boolean isValid() {
        return validator.apply(left, right);
    }
}