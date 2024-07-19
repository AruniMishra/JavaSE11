package standardTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

interface Runner {
    public void run();
}

interface Runner2 {
    public int run();
}


@interface Authors {
    Author[] value();
}

@Repeatable(Authors.class)
@interface Author {
    int id() default 0;

    String value();
}

public class StandardTest3 {
}

class s3Test1 {
    public static void main(String[] args) {
        List<String> vowels = new ArrayList<String>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        Function<List<String>, List<String>> f = list -> list.subList(2, 4);
        List<String> stringList = f.apply(vowels);
        stringList.stream().forEach(System.out::println);
        vowels.forEach(System.out::print);
    }
}

class Writer {
    private static final int LOOPSIZE = 5;

    public synchronized void write(Data... da) {
        for (int i = 0; i < LOOPSIZE; i++) {
            while (!da[0].own(this)) ;
            while (!da[1].own(this)) ;
            da[0].write(i);
            da[1].write(i);
            da[1].release();
            da[0].release();
        }
    }
}

class Data {
    Writer writer;
    int id;

    public Data(int id) {
        this.id = id;
    }

    public synchronized boolean own(Writer w) {
        if (writer == null) {
            writer = w;
            return true;
        } else return false;
    }

    public synchronized void release() {
        writer = null;
    }

    public void write(int i) {
        System.out.println("data written W" + i + " D" + id);
    }
}

class s3TestClass4 {
    public static void main(String[] args) {
        var w1 = new Writer();
        var w2 = new Writer();
        var d1 = new Data(1);
        var d2 = new Data(2);
        new Thread(() -> {
            w1.write(d1, d2);
        }).start();
        new Thread(() -> {
            w2.write(d1, d2);
        }).start();
    }
}

class Course {
    String category;
    int passPercent;

    Course(String category) {
        this.category = category;
    }

    public static void main(String[] args) {
        List<Course> s1 = List.of(new Course("Java"), new Course("Python"));
        String testCategory = "Java";
        Integer comparisonCode = 0;
        long l = s1.stream()
                .peek(new Consumer<Course>() {
                    public void accept(Course c) {
                        c.printPassPercent();
                    }
                })
                .map(c -> testCategory.compareToIgnoreCase(c.getCategory()))
                .filter(a -> comparisonCode.equals(a))
                .count();
        System.out.println(l);
    }

    void printPassPercent() {
        System.out.println("10");
    }

    String getCategory() {
        return category;
    }
}

class s3T7 {
    public static void main(String[] args) {
        List<String> letters = Arrays.asList("j", "a", "v", "a");
        String word = letters.stream().collect(Collectors.joining());
        System.out.println(word);


        System.out.println(letters.stream().reduce("", (a, b) -> a.concat(b)));
    }
}

class s3T10 {
    public static int getSwitch(int x) {
        return x - 20 / x + x * x;
    }

    public static void main(String args[]) {
        switch (getSwitch(10)) {
            case 1:
            case 2:
            case 3:
            default:
                break;
        }

        try {
            int a = 1;
            int i = a / 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("exc");
            // a=0;
        }
    }

    public void processUploads(String listOfFilesFile) throws IOException {
        // 1
        File f = new File(listOfFilesFile);
        f.getCanonicalFile();
        List<BufferedReader> al = new ArrayList<BufferedReader>();
        try (var bfr = new BufferedReader(new FileReader(f))) {
            // 2
            String uploadedFileName = null;
            while ((uploadedFileName = bfr.readLine()) != null) {
                var fbfr = new BufferedReader(new FileReader(uploadedFileName));
                al.add(fbfr);
                // 3
                // loadXML(fbfr);
                // 4
            }
        } finally {
            for (var openReader : al) {
                try {
                    openReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

class s3TestClass26 {
    public static void main(String args[]) {
        try {
            m1();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1");
            /*
            As this exception is not thrown inside the try block, it will not be caught by any of the remaining catch
             blocks. It will actually be sent to the caller of the main() method after the finally block is executed.
              (Hence '4' in the output.)
             */
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("2");
            return;
        } catch (Exception e) {
            System.out.println("3");
        } finally {
            System.out.println("4");
        }
        System.out.println("END");
    }

    static void m1() {
        System.out.println("m1 Starts");
        throw new IndexOutOfBoundsException("Big Bang ");
    }
}

class s3TestClass27 {
    public static void main(String[] args) {
        try {
            doTest();
        } catch (MyException me) {
            System.out.println(me);
        }
    }

    static void doTest() throws MyException {
        int[] array = new int[10];
        // array[10] = 1000;
        doAnotherTest();
    }

    static void doAnotherTest() throws MyException {
        throw new MyException("Exception from doAnotherTest");
    }
}

class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

class Doll {
    String name;

    Doll(String nm) {
        this.name = nm;
    }
}

class Barbie extends Doll {
    Barbie() {
        this("unknown"); // or,
        // super("");
        // 1


    }

    Barbie(String nm) {
        super("");
        // 2
    }
}

class s3TestClass33 {
    public static void main(String[] args) {
        Barbie b = new Barbie("mydoll");
    }
}

class S3Device35 implements AutoCloseable {
    /*
    Device D1 is created successfully but an IOException is thrown while creating Device D2.
    Thus, the control never enters the try block and throw new Exception("test") is never executed.
    Since one resource was created, its close method will be called (which prints Closing device D1).
    Any exception that is thrown while closing a resource is added to the list of suppressed exceptions of the
    exception thrown while opening a resource (or thrown from the try block.)
     */
    String header = null;

    public S3Device35(String name) throws IOException {
        header = name;
        if ("D2".equals(name)) throw new IOException("Unknown");
        System.out.println(header + " Opened");
    }

    public static void main(String[] args) throws Exception {
        try (S3Device35 d1 = new S3Device35("D1");
             S3Device35 d2 = new S3Device35("D2")) {
            System.out.println("--this does not run--");

            throw new Exception("test");


        }


    }

    public String read() throws IOException {
        return "";
    }

    public void close() {
        System.out.println("Closing device " + header);
        throw new RuntimeException("RTE while closing " + header);
    }

    void demo() {
        BiFunction<String, String, String> f = String::concat;
        return;
    }

}

class s3TestClass38 {

    public static void main(String[] args) {

        run(() -> voidMethod()); // will invoke run(Runner ) method.
        run(() -> intMethod());// will also invoke run(Runner ) method.

        run(() -> {
            voidMethod();
            return;
        }); // will invoke run(Runner ) method.
        run(() -> {
            return intMethod();
        });  // will not invoke run(Runner ) method.


        List<String> letters = Arrays.asList("j", "a", "v", "a");
        System.out.println(letters.stream().reduce("", (a, b) -> a.concat(b)));

    }

    public static void run(Runner x) {
        System.out.println("In runner");
        x.run();
    }

    public static void run(Runner2 x) {
        System.out.println("In runner2");
        x.run();
    }

    public static void voidMethod() {
        System.out.println("voidMethod");
    }

    public static int intMethod() {
        System.out.println("intMethod");
        return 0;
    }
}

class s3T9 {
    public static void main(String[] args) {

    }


    // @Author(id=1, value="null")
    // @Authors(@Author("bob"))
    @Author("bob") // id has default, and "value" can be skipped
    @Author(id = 1, value = "null")
    void someMethod(int index) {
    }
}


class s4A17 {
    private String s;

    // 1
    // @Override
    public boolean equals(s4A17 a) { // override the equals methods
        return this.s != null && this.s.equals(a.s);
    }
}
