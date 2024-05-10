package standardTest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface Account50 {
    public default String getId() {
        return "0000";
    }
}

interface PremiumAccount50 extends Account50 {
    public String getId();
}


public class S14 {
}

class Test1 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));
    }
}

class T16 {
    public static void main(String[] args) {
        List<Integer> iList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Predicate<Integer> p = x -> x % 2 == 0;
        List newList = iList.stream().filter(p).filter(x -> x > 3).collect(Collectors.toList());
        System.out.println(newList);
    }
}

class X17 {
    int val = 10;
}

class Y extends X17 {
    Y val = null; // 1
}

class TestClass17 extends X17 {

    public static void main(String[] args) {
        Y y = new Y();
        // int k = (X17) y.val ; //2
        // System.out.println(k);

    }
}

class Student39 {
    int marks;
}

class TestClass39 {
    // var k = new Student39(); //1
    Student39 k = new Student39();

    public static void main(String[] args) {

        var s = new Student39() {    // 2
            @Override
            public String toString() {
                return "student obj";
            }
        };

        var slist = Set.of(new Student39()); // 3

        for (var i : slist) {  // 4
            System.out.println(i);
        }

        slist.removeIf((var s1) -> s1.marks < 0); // 5
    }
}

class BankAccount50 implements PremiumAccount50 {
    public static void main(String[] args) {
        Account50 acct = new BankAccount50();
        System.out.println(acct.getId());
        // System.out.println(Account50.super.getId());
    }

    public void hello() {
        // <InterfaceName>.super.<methodName>: cannot be used to invoke a default method provided by an interface
        // that is not directly implemented (or extended) by the caller.
        // System.out.println(Account50.super.getId());
    }

    @Override
    public String getId() {
        return "0002";
    }
}


