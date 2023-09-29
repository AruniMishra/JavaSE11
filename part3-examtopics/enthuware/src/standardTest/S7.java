package standardTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void testRefs(String str, StringBuilder sb) {
        str = str + sb.toString();
        sb.append(str);
        str = null;
        sb = null;
    }

    public static void main(String[] args) {
        String s = "aaa";
        StringBuilder sb = new StringBuilder("bbb");
        new s7TestClass42().testRefs(s, sb);
        System.out.println("s=" + s + " sb=" + sb);
    }
}