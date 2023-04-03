package packageA;

public interface Test {

    /**
     * all fields in interfaces are public static final
     */
    public static int counter = 0;

    private void doItPrivately() {
        System.out.println("A private method");
    }

    void doThat();

    default String doThat(String s) {
        return s;
    }
}