package standardTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

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
    //accessors not shown
}

class BankAccount extends Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public BankAccount(String id, double balance) {
        super(id);
        this.balance = balance;
        System.out.println("BankAccount: " + id + "::" + balance);
    }

    //accessors not shown


    public static void main(String[] args) {
        Map<String, Account> myAccts = new HashMap<>();
        myAccts.put("111", new Account("111"));
        myAccts.put("222", new BankAccount("111", 200.0));

        System.out.println("------");

        BiFunction<String, Account, Account> bif =
                (a1, a2) -> a2 instanceof BankAccount ?
                        new BankAccount(a1, 300.0) : new Account(a1); //1

        myAccts.computeIfPresent("222", bif);//2
        BankAccount ba = (BankAccount) myAccts.get("222");
        System.out.println(ba.getBalance());



        List<Double> dList = Arrays.asList(10.0, 12.0);
        dList.stream().forEach(x->{ x = x+10; return;});
    }
}