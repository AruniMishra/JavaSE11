public class Operator {


    public static void main(String[] args) {
        int a = 1;

        int b, c = 0, d = 0;

        d = c = b = a++;

        System.out.println(a + ",  " + b + ",  " + c + ",  " + d);
    }
}
