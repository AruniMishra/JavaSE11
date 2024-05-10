package standardTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Eatable10 {
    static int types = 10;
}

public class S15 {
}

class ArrayTest08 {
    public static void main(String[] args) {
        var ia = new int[][]{{1, 2}, null};
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                System.out.println(ia[i][j]);
    }
}

class Food10 implements Eatable10 {
    public int types = 20;
}

class Fruit10 extends Food10 implements Eatable10 { // LINE1
    public static void main(String[] args) {
        // int a = Eatable10.types;
        new Food10().types = 30; // LINE 2
        System.out.println(Eatable10.types); // LINE 3
    }
}


class DatabaseWrapper14 {
    static String url = "jdbc://derby://localhost:1527//mydb";

    static DatabaseWrapper14 getDatabase() {
        System.out.println("Getting DB");
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getDatabase().url);
    }
}


class s15T16 {
    int a;

    // Since the method is static, this access will only be valid if variable 'a' is declared static within the class.
    static int f() {
        return new s15T16().a;
        // return a; // invalid
    }    //  (4)

    public static void main(String[] args) {

    }
}

class s14T22 {

    public static void main(String[] args) {
        int b, x;
        // for (int i = 0; false; i++) {x = 3;};

        do {
            x = 3;
        } while (false);
    }
}

class s15BaseT24 {
    public List<Number> transform(Set<Integer> list) {
        // valid code
        return null;
    }
}

class Derived24 extends s15BaseT24 {

    List<? extends Number> l = new ArrayList<Number>(); // valid here

    // public List<? extends Number> transform(Set list){  // valid too
    public ArrayList<Number> transform(Set list) {
        // valid code
        return null;
    }
}


class s15Onion34 {
    private String data = "skin";

    public static void main(String[] args) {
        var o = new s15Onion34();
        System.out.println(o.getData());
    }

    public String getData() {
        return new Layer().getData(); // this.new Layer().getData();
    }

    void demo() {
        System.out.println("demo");
    }

    private class Layer extends s15Onion34 {
        String data = "thegoodpart";

        @Override
        public String getData() {
            demo();
            return data;
        }
    }
}


class TestClass45 {
    public static void main(String args[])
    // throws Exception
    {

        int[][] ab = {{1, 2, 3}, {4, 5}};
        for (var i = 0; i < ab.length; i++) {
            for (var j = 0; j < ab[i].length; j++) {
                System.out.print(ab[i][j] + " ");
                if (ab[i][j] == 2) {
                    System.out.println("--");
                    break;
                }
            }
            continue;
        }


        ArrayList<Double> al = new ArrayList<>();
        System.out.println(al.contains("string"));

        Exception e = null;
        // throw e;
    }
}


class TestClass30 {
    static String[] sa = {"a", "aa", "aaa", "aaaa"};

    static {
        Arrays.sort(sa);
    }

    public static void main(String[] args) {
        String search = "a";
        if (args.length != 0) search = args[0];
        System.out.println(Arrays.binarySearch(sa, search)); // Any number from -5 to 3
    }
}

class s1T42 {
    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17); // 1
        Stream<Integer> primeStream = primes.stream(); // 2

        Predicate<Integer> test1 = k -> k < 10; // 3
        // long count1 = primeStream.filter(test1).count();// 4

        Predicate<Integer> test2 = k -> k > 10; // 5
        // long count2 = primeStream.filter(test2).count(); // 6
        // System.out.println(count1 + " " + count2); // 7

        primeStream.collect(Collectors.partitioningBy(test1, Collectors.counting()))
                .values().forEach(System.out::print);


    }
}


class Base48 {
    public List<? extends CharSequence> transform(Set<CharSequence> list) {
        // valid code
        return null;
    }

    ;
}

class Derived48 extends Base48 {

    @Override
    public ArrayList<CharSequence> transform(Set<CharSequence> list) {

        // valid code
        return null;
    }
}