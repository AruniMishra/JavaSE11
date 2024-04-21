package standardTest;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Flyer {
    String getName();
}


interface Shape {
    public abstract void draw();
}

class Bird implements Flyer {
    public String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Eagle extends Bird {
    public Eagle(String name) {
        super(name);

    }
}

class TestClass {
    public static void main(String[] args) throws Exception {
        Flyer f = new Eagle("American Bald Eagle");
        // PRINT NAME HERE

        // System.out.println(f.name); // invalid
        System.out.println(f.getName());
        System.out.println(((Eagle) f).name);
        System.out.println(((Bird) f).getName());
        // System.out.println(Eagle.name);
        // System.out.println(Eagle.getName(f));

    }
}

public class Test01 {
}

class Device implements AutoCloseable {
    String header = null;

    public static void main(String[] args) throws Exception {
        try (Device d = new Device()) {
            throw new Exception("test");
        }
    }

    public void open() throws IOException {
        header = "OPENED";
        System.out.println("Device Opened");
        throw new IOException("Unknown");
    }

    public String read() throws IOException {
        return "";
    }

    public void close() {
        System.out.println("Closing device");
        header = null;
        throw new RuntimeException("rte");
    }

}

class MarkTest {

    /*
    A Reader object just gives you a readable stream. Normally, you cannot go back in a stream to read the data that has already been read. However, some readers do allow this facility by maintaining the data in a buffer. The markSupported, mark, and reset methods help you go back and forth in the data stream if the underlying reader supports it.  They allow you to set a point in the stream by calling the mark method. This point is like a bookmark in a book. You can return back to the same point by calling the reset method. Any call to read after reset will return the data right after the bookmark.

    BufferedReader does provide this facility, therefore r.markSupported() returns true.

    Now, the mark method sets the bookmark in the stream right after A. The parameter 100 is the limit on the number of characters that may be read while still preserving the mark. The two readLines calls after calling mark will return B and C. The call to reset will move the reader back to point right after A and therefore, the subsequent call to readline will return B. The second call to reset will again move the reader back to the point after A. The final call to readLine will thus return B.
     */
    public static void main(String[] args) {

        try (Reader r = new BufferedReader(new FileReader("C:\\resources\\localdata\\github\\JavaSE11\\part3-examtopics\\test.txt"))) {
            if (r.markSupported()) {
                BufferedReader in = (BufferedReader) r;
                System.out.print(in.readLine());
                in.mark(100);
                System.out.print(in.readLine());
                System.out.print(in.readLine());
                in.reset();
                System.out.print(in.readLine());
                in.reset();
                System.out.println(in.readLine());
            } else {
                System.out.println("Mark Not Supported");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Circle implements Shape {
    public static void main(String[] args) {
        Function<Integer, String> integerStringFunction
                = Integer::toHexString;
    }

    @Override
    public void draw() {
        System.out.println("in draw...");
    }
}

class InitClass {
    static int i1 = 5;
    static int i2;

    static {
        i1++;
    }      // Static Initializer

    int m;
    int j = 100;
    int x;

    {
        j = 30;
        i2 = 40;
    }  // Instance Initializer

    public InitClass(int m) {
        System.out.println(i1 + "  " + i2 + "   " + x + "  " + j + "  " + m);
    }

    public static void main(String args[]) {
        InitClass obj = new InitClass(5);

        Stream<Integer> strm1 = Stream.of(2, 3, 5, 7, 11, 13, 17, 19); // 1
        // Stream<Integer> strm2 = strm1.map(i-> (i > 5) ? ((i < 15) ? i : null) : null);
        Stream<Integer> strm3 = strm1.collect(
                Collectors.partitioningBy(i -> {
                    return i > 5 && i < 15;
                })
        ).get(true).stream(); // .get("true") is invalid, keys in the Map produced by partitioningBy Collector are Boolean and not String
        strm3.forEach(System.out::print); // 3
    }
}

class Test14 {
    public static void main(String[] args) {
        HashMap<?, List<String>> box = new HashMap<String, List<String>>();


    }
}


class TestClass18 {
    public static Integer wiggler(Integer x) {
        Integer y = x + 10;
        x++;
        System.out.println(x);
        return y;
    }

    public static void main(String[] args) {
        Integer dataWrapper = new Integer(5);
        Integer value = wiggler(dataWrapper);
        System.out.println(dataWrapper + value);
    }
}

class BreakTest {
    public static void main(String[] args) {


        int i = 0, j = 5;
        lab1:
        for (; ; i++) {
            for (; ; --j) if (i > j) break lab1;
        }
        System.out.println(" i = " + i + ", j = " + j);
    }
}

class IOTest {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bfr = new BufferedReader(
                new FileReader("c:\\works\\a.java"))) {
            String line = null;
            while ((line = bfr.readLine()) != null) {
                System.out.println(line);
            }
        }

        // NoSuchFileException and AccessDeniedException are subclasses of IOException.
        // You cannot include classes that are related by inheritance in the same multi-catch block.
        // catch(
        //         // NoSuchFileException | IOException | AccessDeniedException e){
        //     e.printStackTrace();
        // }
    }
}

class Test26 {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        Stream<String> stream = Stream.of("old", "king", "cole", "was", "a",
                "merry", "old", "soul").parallel();
        stream.filter(e -> {
            ai.incrementAndGet();
            return e.contains("o");
        }).allMatch(x -> x.indexOf("o") > 0);

        System.out.println("AI = " + ai);
    }

}


class test34 {

    public static void main(String[] args) {
        var numA = new Integer[]{1, 4, 3}; // 1

        /*
        The list/set returned by the of/copyOf methods is completely independent of the original collection.
         */
        var list1 = List.of(numA); // 2
        var list2 = Collections.unmodifiableList(list1); // 3
        numA[1] = 2; // 4
        System.out.println(list1 + " " + list2);


        byte b = 1;
        char c = 1;
        short s = 1;
        int i = 1;

        // s  = (s *  b); // invalid
        s *= b;

        c += b;

    }
}


class PortConnector {
    public PortConnector(int port) throws IOException {

    }
}

class CleanConnector extends PortConnector {
    public CleanConnector(int port) throws Exception {
        super(port);
    }
}


class A {
    public A() throws IOException {
    }

    void m() throws IOException {
    }
}

class B extends A {
    // IOException is valid here, but FileNotFoundException is invalid
    public B() throws IOException {

    }

    // FileNotFoundException is valid here, but Exception is invalid
    @Override
    void m() throws FileNotFoundException {
    }
}






