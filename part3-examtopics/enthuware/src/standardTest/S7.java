package standardTest;

import java.util.*;

public class S7 {
}


class LowBalanceException extends WithdrawalException {  // 1
    public LowBalanceException(String msg) {
        super(msg);
    }
}

class WithdrawalException extends Exception { // 2
    public WithdrawalException(String msg) {
        super(msg);
    }
}

class Account8 {
    double balance;

    public static void main(String[] args) {
        try {
            Account8 a = new Account8();
            a.withdraw(100.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(double amount) throws WithdrawalException {
        try {
            throw new RuntimeException("Not Implemented");
        } catch (Exception e) {
            throw new LowBalanceException(e.getMessage());
        }
    }
}

class s7T20 {

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int z = x++;
        int a = --y;
        int b = z--;
        b += ++z;

        int answ = x > a ? y > b ? y : b : x > z ? x : z;
        System.out.println(answ);
    }
}

//-----------------------------------
class MyGenericClass<T> {
    public <T> String transform(T t) {
        return t.toString() + "-" + t.hashCode();
    }
}

class s7T22 {
    public static void main(String[] args) {

        Integer a = 1;

        System.out.println(a.hashCode());

        MyGenericClass gc = new MyGenericClass();
        System.out.println(gc.transform(a)); // 1
        System.out.println(gc.transform("hello")); // 2
        MyGenericClass<String> gcStr = new MyGenericClass<String>();
        System.out.println(gcStr.transform(1.0)); // 3
    }
}

class s7T25 {

    public static void main(String[] args) {
        ArrayList<String> als = new ArrayList<>(List.of("a", "b", "c"));
        Set<String> ss = new HashSet();
        ss.addAll(als); // 1
        als.clear();    // 2
        System.out.println(ss.size());
    }
}


class s7TestClass42 {
    public static void main(String[] args) {
        String s = "aaa";
        StringBuilder sb = new StringBuilder("bbb");
        new s7TestClass42().testRefs(s, sb);
        System.out.println("s=" + s + " sb=" + sb);
    }

    public void testRefs(String str, StringBuilder sb) {
        str = str + sb.toString();
        sb.append(str);
        str = null;
        sb = null;
    }
}


class NewException extends Exception {
}

class AnotherException extends Exception {
}

class ExceptionTest implements AutoCloseable {
    public static void main(String[] args) throws Exception {
        try (ExceptionTest exceptionTest = new ExceptionTest()) {
            m2();
        } catch (NewException e) {

        } finally {
            // m3();
        }
    }

    public static void m2() throws NewException {
        throw new NewException();
    }

    public static void m3() throws AnotherException {
        throw new AnotherException();
    }

    @Override
    public void close() throws Exception {
        System.out.println("closed");
        throw new RuntimeException("rte");

    }
}


class OuterWorld {
    public InnerPeace i = new InnerPeace("none"); // 1

    public static void main(String[] args) {
        var ip = new InnerPeace("yoga"); // 2
        var out = new OuterWorld();
        System.out.println(out.i.reason); // 3
    }

    void nonStatic() {
        var ip = new InnerPeace("yoga");
        var out = new OuterWorld();
        System.out.println(out.i.reason);
    }

    static class InnerPeace {
        private String reason = "none";

        InnerPeace(String reason) {
            this.reason = reason;
        }
    }

}


class s7Book48 {
    private int id;
    private String title;
    private String genre;
    private String author;

    public s7Book48(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public static void main(String[] args) {
        List<s7Book48> books = Arrays.asList(new s7Book48("30 Days", "fiction", "K Larsen"),
                new s7Book48("Fast Food Nation", "non-fiction", "Eric Schlosser"),
                new s7Book48("Wired", "fiction", "D Richards"));

        books.stream()

                // .filter(new s7Book48.BookFilter()) // LINE 10

                .filter(BookFilter::isFiction)

                .forEach((s7Book48 b) -> System.out.print(b.getTitle() + ", "));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    // accessors for instance fields not shown here

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static class BookFilter {
        public static boolean isFiction(s7Book48 b) {
            return b.getGenre().equals("fiction");
        }

    }
}
