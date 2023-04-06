public class AnonymousSecondExample {

    // A pass through method to invoke getTotal method on an object
    // that implements Summable interface
    public static void invokeSummable(Summable summable, float[] data) {
        System.out.println("Total = " + String.format("%.2f", summable.getTotal(data)));
    }

    public static void main(String[] args) {

        // Note that we are passing an anonymous class expression as a
        // parameter to the invokeSummable method .
        invokeSummable(
                new Summable() {  // Begin anonymous class expression

                    // implement Summable.getTotal(float[]) method
                    public double getTotal(float[] values) {
                        double total = 0.0;
                        for (float value : values) total += value;
                        return total;
                    } // end of getTotal method

                }  // End of anonymous class expression
                , new float[]{12.4f, 13.4f, 5f, 12.0f, 11f, 7.5f}
        );  // End of method invocation
    }

    // You can define a private interface in your class
    private interface Summable {
        double getTotal(float[] data);
    }
}