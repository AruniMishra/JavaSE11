public class Test2 {
    static int testVariable;

    public static void main(String[] args) {
        for (int i = 0; i++ < 10; i-- , i += 1){

            System.out.print(i++ + ",");
        }
    }
}