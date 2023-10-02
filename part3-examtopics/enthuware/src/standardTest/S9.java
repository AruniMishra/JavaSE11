package standardTest;

public class S9 {
}

class NewExceptionT43 extends Exception {
}

class AnotherExceptionT43 extends Exception {
}

class ExceptionTestT43 {
    public static void main(String[] args) throws Exception {
        try {
            m2();
        } finally {
            m3();
        }
        // catch (NewException e){}
    }

    public static void m2() throws NewExceptionT43 {
        throw new NewExceptionT43();
    }

    public static void m3() throws AnotherExceptionT43 {
        throw new AnotherExceptionT43();
    }

}
