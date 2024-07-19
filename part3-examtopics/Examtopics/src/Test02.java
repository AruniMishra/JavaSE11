import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Alpha {
    A, B, C;

    final static String getFirstLetter() { return A.toString(); }

    static String getLetter() {
        String aValue = Alpha.values()[0].toString();
        System.out.println("aValue:" + aValue);
        System.out.println(Alpha.valueOf("A"));
        // By default, an enum's toString() prints the enum name but you can override it to print anything you want.
        System.out.println(A.toString());
        return A.toString();
    }
}

interface ExampleInterface {

    /*
    https://stackoverflow.com/questions/10673209/why-interface-methods-cannot-be-static-final
     */
    // public int x; // invalid, initialization is must

    // All variables are implicitly public static and final in interfaces.
    public int x = 0; // valid

    static void methodG() {
        System.out.println("G");
    }

    private static void methodF() {
        System.out.println("F");
    }

    public abstract String methodD(); // valid

    // final void methodE1();

    public abstract void methodB();

    // private abstract void methodC();

}

public class Test02 {

    int aCount;
    int tCount;
    int cCount;
    int gCount;


    Test02(int a, int tCount, int c, int g) {
        setGCount(g);
        aCount = a;
    }

    public static void main(String[] args) {

        var i68 = 10;
        var j = 5;
        i68 += (j * 5 + i68) / j - 2;
        System.out.println(i68);
        System.out.println("\n------------------------");

        Test02 pop = new Test02(1, 2, 3, 4);
        System.out.println(pop.aCount + " " + pop.cCount + " " + pop.gCount); // 1 3 4

        System.out.println("\n------------------------");
        System.out.println(Alpha.getLetter());


        System.out.println("\n------------------------");
        var c = new CopyOnWriteArrayList<>(List.of("1", "2", "3", "four")); // [1, 2, 3, 4]
        c.set(3, "4");
        c.forEach(System.out::print);
        System.out.println();
        Runnable r = () -> {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            c.set(3, "four1");
            System.out.print(c + "-");
        };
        Thread t = new Thread(r);
        t.start();
        for (var s : c) {
            System.out.print(s + " ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


        System.out.println("\n\n------------------------");
        UnaryOperator<Integer> u = (var i) -> (i * 2);
        System.out.println(u.apply(2));


        System.out.println("\n\n------------------------");
        String fileName = "C:\\resources\\localdata\\github\\JavaSE11\\part3-examtopics\\lines.txt";
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream.filter(line -> !line.equalsIgnoreCase("JAVA")).map(String::toUpperCase).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        list.forEach(System.out::println);


        System.out.println("\n\n------------------------");
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            if (itr.next() == 2) {
                // al.remove(2);
                System.out.println(itr.next());

            }
        }


        System.out.println("\n\n------------------------");
        Integer i = 11;
        // Double c = (Double) i;
        Double b = Double.valueOf(i);
        // Double a = i;
        // double e = Double.parseDouble(i);
        double d = i;




    }

    int setCCount(int c) {
        return c;
    }

    void setGCount(int gCount) {
        this.gCount = gCount;
    }


}

