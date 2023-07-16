interface myA {
     default void action() {
        System.out.println("actionA");
    }
}

interface myB {
    void action();

}

public class Test05 implements myA, myB {

    public static void main(String[] args) {

        myB b = new Test05();
        b.action();

        System.out.println("\n\n------------------------");
        for (var i = 0; i < 10; i++) {
            switch (i % 5) {
                case 2:
                    i *= 2 * i;
                    break;
                case 3:
                    i++;
                    break;
                case 1:
                case 4:
                    i++;
                    continue;
                default:
                    break;
            }
            System.out.print(i + " ");
            i++;

        }
    }

    public void action() {
        System.out.println("Test05 Action");

    }

}
