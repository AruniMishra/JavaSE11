public class Test {
    public static void main(String[] args) {
        int x = 0, y = 6;
        for (; x < y; x++, y--) {
            if (x % 2 == 0) {
                continue;
            }
            System.out.println(x + "-" + y);
        }
    }
}
