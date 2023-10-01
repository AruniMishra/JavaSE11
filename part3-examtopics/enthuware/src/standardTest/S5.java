package standardTest;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class S5 {
}


class s5T54 {

    public static void main(String[] args) {
        DoubleStream ds = DoubleStream.of(1.0, 2.0, 3.0);

        /*
        6.0
        7.0
        8.0
        */
        DoubleFunction<DoubleUnaryOperator> doubleF = m -> n -> m + n;


        DoubleFunction<DoubleUnaryOperator> doubleF2 = (m) -> {
            System.out.println("m is " + m);
            return (n) -> {
                System.out.println("n is " + n);
                return m + n;
            };
        };
        ds.map(doubleF2.apply(5.0)).forEach(System.out::println);

    }
}

class Account {
    private String id;

    public Account(String id) {
        this.id = id;
        System.out.println("Account: " + id);
    }
    // accessors not shown
}

class BankAccount extends Account {
    private double balance;

    public BankAccount(String id, double balance) {
        super(id);
        this.balance = balance;
        System.out.println("BankAccount: " + id + "::" + balance);
    }

    public static void main(String[] args) {
        Map<String, Account> myAccts = new HashMap<>();
        myAccts.put("111", new Account("111"));
        myAccts.put("222", new BankAccount("111", 200.0));

        System.out.println("------");

        BiFunction<String, Account, Account> bif =
                (a1, a2) -> a2 instanceof BankAccount ?
                        new BankAccount(a1, 300.0) : new Account(a1); // 1

        myAccts.computeIfPresent("222", bif);// 2
        BankAccount ba = (BankAccount) myAccts.get("222");
        System.out.println(ba.getBalance());


        List<Double> dList = Arrays.asList(10.0, 12.0);
        dList.stream().forEach(x -> {
            x = x + 10;
            return;
        });
    }

    // accessors not shown

    public double getBalance() {
        return balance;
    }
}

class s5T29 {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("a", "b");
        List<String> l2 = Arrays.asList("1", "2");
        Stream.of(l1, l2).flatMap((x) -> Stream.of(x)).forEach((x) -> System.out.println(x));
        Stream.of(l1, l2).flatMap((x) -> x.stream()).forEach((x) -> System.out.println(x));
//        Stream.of(l1, l2).flatMap((x)->x.iterator()).forEach((x)->System.out.println(x));

    }
}


class s5Book31 {
    private String title;
    private String genre;

    public s5Book31(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
    // accessors and toString code not shown

    public static void main(String[] args) {
        var books = new ArrayList<s5Book31>(List.of(
                new s5Book31("The Outsider", "fiction"),
                new s5Book31("Becoming", "non-fiction"),
                new s5Book31("Uri", "non-fiction")));

        books.sort(Comparator.comparing(s5Book31::getGenre)
                .thenComparing(s5Book31::getTitle).reversed());
        System.out.println(books);

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

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "s5Book31{" +
                ", genre='" + genre + '\'' +
                "title='" + title + '\'' +
                '}';
    }
}


class Game {
    public void play() throws Exception {
        System.out.println("Playing...");
    }
}

class Soccer extends Game {
    public void play(String ball) {
        System.out.println("Playing Soccer with " + ball);
    }
}

class s5TestClass44 {
    /*
    demo
     */
    public static void main(String[] args) throws Exception {
        Game g = new Soccer();
        // 1
        Soccer s = (Soccer) g;
        // 2
    }
}

class Transaction<T, S extends T> {
    public Transaction(T t, S s) {
    }
}


class s5Movie53 {
    private String title;
    private String genre;

    public s5Movie53(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
    // accessors not shown

    public static void main(String[] args) {
        Stream<s5Movie53> sm = Stream.of(
                new s5Movie53("a1", "a"), new s5Movie53("a2", "a"),
                new s5Movie53("b1", "b"), new s5Movie53("c1", null));

        int count = sm.collect(Collectors.groupingBy(movie -> Optional.ofNullable(
                movie.getGenre()))).get(Optional.empty()).size();


        System.out.println(count);


        // int count2 = sm.collect(Collectors.groupingBy(s5Movie53::getGenre)).get(null).size(); // invalid
        // int count3 = sm.collect(Collectors.groupingBy(movie -> movie.getGenre()))
        //         .get(Optional.empty()).size();
        // int count4 = sm.collect(Collectors.groupingBy(s5Movie53::getGenre))
        //         .get(Optional.empty()).size();

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

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
