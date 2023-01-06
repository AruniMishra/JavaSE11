package a.d;

public class StaticImportTest1 {

    public static final String APP_NAME = "First";

    public static void log(String statement) {
        System.out.println("First Logging statement: " + statement);
    }

    public void printUniqueStatement() {
        System.out.println("I am First");
    }
}