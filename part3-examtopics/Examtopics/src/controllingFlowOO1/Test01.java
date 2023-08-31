package controllingFlowOO1;

public class Test01 {
}

class Test34 {
    public static void main(String[] args) {
        int sum = 0;
        for (var i = 0; i < 7; i++) { // Line n1
            if (i == 4)
                break;
            else
                continue;
            // sum += i; //Line n2
        }
        System.out.println(sum); // Line n3
    }
}


class Test42 {
    public static void main(String[] args) {
        var res = ""; // Line n1
        String[] arr = {"1", "2", "3"};
        for (var s : arr) { // Line n2
            res += String.join(".", s); // Line n3
        }
        System.out.println(res); // Line n4
    }
}

class A {
    private String str = "WINNERS NEVER QUIT";

    public class B {
        public B(String s) {
            if (s != null)
                str = s;
        }

        public void m1() {
            System.out.println(str);
        }
    }
}

class Test58 {
    public static void main(String[] args) {
        // Insert statement here
        // new A().new B().m1();
        new A().new B(null).m1();
    }

}