import java.util.List;

public class Test07 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        // Double d = list.get(0); // cannot cast from Integer to Double, Double.valueOf() is needed
        double f = list.get(0);
        Integer a = Integer.valueOf(list.get(0));
        Integer b = list.get(0);
        int c = list.get(0);
        Double e = Double.valueOf(list.get(0));
    }
}
