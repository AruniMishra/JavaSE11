import java.util.Comparator;

public class Test09 implements Comparator<String> {

    public static void main(String[] args) {

        new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
    }
    // implements Comparator
    // @Override
    // public int compare(Object o1, Object o2) {
    //     return 0;
    // }

    // implements Comparator<String>
    @Override
    public int compare(String o1, String o2) {
        return 0;
    }
}
