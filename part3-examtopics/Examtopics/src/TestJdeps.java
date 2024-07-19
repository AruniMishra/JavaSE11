import java.sql.Timestamp;

/*
jdeps -summary TestJdeps.class
TestJdeps.class -> java.base
TestJdeps.class -> java.sql
 */

public class TestJdeps {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(1);
    }
}
