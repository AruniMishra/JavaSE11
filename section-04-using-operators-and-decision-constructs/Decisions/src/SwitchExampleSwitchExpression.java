public class SwitchExampleSwitchExpression {
    public static void main(String[] args) {
        // Example of a Switch statement with an expression in
        // the switch evaluation
        for (int i = 0; i < 4; i++) {
            System.out.println("-----------iteration " +
                    ((i + 1)) + " -------------------");

            switch (i * 10) {  // expression allowed here
                case 10:
                    System.out.println("result is 10");
                    break;
                case 20:
                    System.out.println("result is 20");
                    break;
                case (30):
                    System.out.println("result is 30");
                    break;
                default:
                    System.out.println("result for default, i =" + i);
            }

        }
    }
}