import java.util.Optional;

public class Test16 {
    public static int reduce(int x) {
        int y = 4;
        class Computer {
            int reduce(int x) {
                return x - y; // y-- invalid
            }
        }

        Computer a = new Computer();
        return a.reduce(x);
    }

    public static void main(String[] args) {
        System.out.print(reduce(1));


        // System.out.println("Ans : " + convert("a").get());


        System.out.println("\n------------------------");
        // System.out.println("Ans : " + convert("a").get());
        System.out.println("Ans : " + convert("a").or(() -> {
                    System.out.println(
                            "In Supplier Code for ");
                    return Optional.of((5));
                })
                .get());
    }

    private static Optional<Integer> convert(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}


