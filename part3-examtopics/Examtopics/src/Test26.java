import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

interface Builder {
    public A build(String str);
}

interface A80 {
    public default void me() {

    }
}

interface b80 {
    public void me();
}

public class Test26 {
}

class BuilderImpl implements Builder {

    @Override
    public final B build(String str) {
        return null;
    }
}

class T72 {
    public static void main(String[] args) {
        UnaryOperator<Integer> u = (var i) -> (i * 2);
        // UnaryOperator u1 = (int i) -> i * 2;
        UnaryOperator<Integer> u2 = (var i) -> {
            return i * 2;
        };
    }
}

// 88
class Price {
    private final double value;

    Price(double value) {
        this.value = value;
    }

    Price(String value) {
        this(Double.valueOf(value));
    }

    // Price(){ }// if this enabled, value needs to be initialized
}

class T87 {
    public static void main(String[] args) {
        String[] cats = {"a", "dd", "d", "b", "f", "c"};
        var carList = new ArrayList<>(Arrays.asList(cats));
        carList.sort((a, b) -> -a.compareTo(b));
        carList.forEach(System.out::println);

        byte b = 10;
        nothing(b);
    }

    static void nothing(Object a) {
        return;
    }
}


class X98 {
    private Collection collection;

    public void set(Collection collection) {
        this.collection = collection;
    }
}

class Y98 extends X98 {
    public void set(Map<String, String> map) {
        // super.set(map);
        super.set(map.values());
        map.forEach((k, v) -> set(Collections.singleton(v)));
        set(map);
    }
}

class Triple100 {
    public static void main(String[] args) {
        Function tripler = x -> {
            return (Integer) x * 3;
        };
        Function triplea = x -> {
            return (Integer) x * 3;
        };

        Function<Integer, Integer> tripleb = x -> {
            return x * 3;
        };

        Triple100.printValue(tripler, 4);
    }

    // public static <T100> void printValue(Function f, T100 num) { // valid
    // public static void printValue(Function f, Integer num) { // valid
    public static void printValue(Function f, int num) { // valid
        System.out.println(f.apply(num));
    }
}

class Test101 {

    static String prefix = "Mondial:";
    private String name = "domainmodel";


    public static void main(String[] args) {


        List vegetables = new ArrayList<>();
        vegetables.add("Kale");
        vegetables.add(0, "Lettuce");
        System.out.println(vegetables);
        List fish = new ArrayList<>();
        fish.add("Salmon");
        fish.add(0, "Seabass");
        System.out.println(fish);

        System.out.println("-----------");

        //--
        // System.out.println(name);

        try {
            Test101 t = new Test101();
            t.p();
            t.q();
        } catch (L | N e) {
            System.out.println("Exception caught");
            throw new RuntimeException(e);
        }
    }

    public void p() throws L {
        System.out.println(name);
        throw new M();
    }

    public void q() throws N {
        throw new N();
    }

    class L extends Exception {
    }

    class M extends L {
    }

    class N extends RuntimeException {
    }
}


class ConSuper {
    protected ConSuper() {
        this(2);
        System.out.println("3");
    }

    protected ConSuper(int a) {
        System.out.println(a);
    }
}

class ConSub extends ConSuper {
    ConSub() {
        this(4);
        System.out.println("1");
    }

    ConSub(int a) {

        System.out.println(a);
    }

    public static void main(String[] args) {
        new ConSub(4);
    }
}


class T120 {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.now(); // 1
        d1.plusDays(1); // 1
        d1 = d1.minusMonths(2); // 1
        LocalDate d2 = d1.plusWeeks(3); // 1
        d2.minusDays(4); // 1
        d2 = null;
    }
}


class City124 {
    public static void main(String[] args) {
        String[] town = {"boston", "paris", "bangkok", "oman"};
        Comparator<String> ms = (a, b) -> b.compareTo(a);
        Arrays.sort(town, ms);

        System.out.println(Arrays.binarySearch(town, "oman", ms));
    }
}


class T135 {
    public static void main(String[] args) {
        List<String> fruits = List.of("banana", "orange", "apple", "lemon");

        fruits.sort(new Comparator<String>() {
            @Override
            public int compare(String m, String n) {
                return n.compareTo(m);
            }
        });

        fruits.sort((m, n) -> n.compareTo(m));

        fruits.sort((String d, String e) -> (e.compareTo(d)));

        fruits.sort((a, b) -> {
            return b.compareTo(a);
        });
    }
}

class Foo137 {

    private String a() {
        return "hello";
    }

    public String b() {
        return a();
    }
}

class Bar137 extends Foo137 {

    protected String a() { // not an override
        return "Bonjour le monde!";
    }
}

class Baz137 extends Bar137 {

    public static void main(String[] args) {
        System.out.println(new Foo137().b());
        System.out.println(new Bar137().b());
    }

    public String b() {
        return a();
    }
}


class T139 {
    public static void main(String[] args) {


        StringBuilder txt1 = new StringBuilder("PPQRRRSTT");
        int i = 0;
        a:
        while (i < txt1.length()) {
            char x = txt1.charAt(i);
            int j = 0;
            i++;
            b:
            while (j < txt1.length()) {
                char y = txt1.charAt(j);
                if (i != j && y == x) {
                    txt1.deleteCharAt(j);
                    continue a; // line 1
                }
                j++;
            }
        }
        System.out.println(txt1);
    }



}


class T140{
    public static void main(String[] args) {
        // UnaryOperator uo = (var x) -> (x * 3);
        // UnaryOperator uo = (int x) -> x * 3;

        UnaryOperator<Integer> uo = x -> {return x * 3;};

    }

}