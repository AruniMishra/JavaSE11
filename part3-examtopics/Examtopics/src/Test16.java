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
    }
}