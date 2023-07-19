enum Flags {
    // Enum constructor is invoked once for every constant.
    TRUE, FALSE;

    Flags() {
        System.out.println("HELLO");
    }
}

public class Test23 {
    public static void main(String[] args) {
        System.out.println(Flags.valueOf("TRUE"));

        Flags flags = Flags.TRUE;
        System.out.println(flags);
    }
}
