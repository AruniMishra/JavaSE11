package standardTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value = RUNTIME)
@Target(value = {TYPE_USE, TYPE_PARAMETER})
@interface NonNull {
}

interface T1 {
}

interface T2 {
    int VALUE = 10;

    void m1();
}


interface T3 extends T1, T2 {
    public void m1();

    public void m1(int x);
}

public class StandardTest2 {
}

class Test11 {
    public static void main(String[] args) {
        @NonNull String str = "";
        // var str = @NonNull "";
        var str1 = (@NonNull String) "";


        Function<Integer, String> f0 = (var val) -> Integer.toHexString(val);
        // Placement of @NonNull is incorrect. It should be (@NonNull var val)
        // Function<Integer, String> f = ( Integer @NonNull val ) -> Integer.toHexString(val);
        // Function<Integer, String> f = ( var @NonNull val ) -> Integer.toHexString(val);

        // While using applying annotation to lambda parameter,
        // the type of the parameter must also be present. Therefore, it needs to be changed to:
        Function<Integer, String> f1 = (@NonNull Integer a) -> Integer.toHexString((Integer) a);
        Function<Integer, String> f3 = (@NonNull Integer val) -> Integer.toHexString(val);


        double foo = 2;
    }
}

class TestClass16 {
    public static void main(String[] args) throws Exception {
        TestClass16 tc = new TestClass16();
        tc.myMethod();
    }

    public void myMethod() throws Exception {
        yourMethod();
    }

    public void yourMethod() throws Exception {
        throw new Exception();
    }
}

class Test17 {
    public static void main(String[] args) {
        var nameList = new ArrayList<String>();
        nameList.add("Ally");
        nameList.add("Billy");
        nameList.add("Cally");
        nameList.add("Billy");
        nameList.add("Ally");

        var nameSet1 = new HashSet<String>();
        for (var name : nameList) nameSet1.add(name);
        var nameSet2 = new HashSet<String>(nameList);
        System.out.println(nameList.size() + " " + nameSet1.size() + " " + nameSet2.size());
    }
}

class s2Test26 {
    public static void main(String[] args) {
        FileInputStream tempFis = null;
        try (FileInputStream fis = new FileInputStream("c:\\temp\\test.text")) {
            System.out.println(fis);
            tempFis = fis;
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
        // line 1
    }

}

class MyProcessor {
    Integer value;

    public MyProcessor(Integer value) {
        this.value = value;
    }

    public void process() {
        System.out.println(value + " ");
    }
}

class TestClass28 {

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3);

        ls.stream()
                .map(MyProcessor::new)
                .forEach(MyProcessor::process);


        ls.stream()
                .map(x -> {
                    // referring to MyProcessor's constructor that takes one Integer argument.
                    Function<Integer, MyProcessor> f = MyProcessor::new;

                    return f.apply(x); // passing the actual Integer argument.
                })
                .forEach(MyProcessor::process);

        /*

        // cannot pass arguments to a constructor or method while referring to method/constructor reference.
        ls.stream()
                .map(x -> MyProcessor::new (x))
        .forEach(MyProcessor::process);



        ls.stream()
                .forEach((x) -> process(MyProcessor::new));

        ls.stream()
                .forEach(x -> MyProcessor::new);
        */
    }
}


class Student29 {
    private String name;
    private int marks;

    public Student29(String s1, int m) {
        this.marks += m;
        this.name = s1;
    }

    // constructor and getters and setters not shown

    public void addMarks(int m) {
        this.marks += m;
    }

    public void debug() {
        System.out.println(name + ":" + marks);
    }
}

class s2Test29 {

    public static void main(String[] args) {
        List<Student29> slist = Arrays.asList(new Student29("S1", 40), new Student29("S2", 35),
                new Student29("S3", 30));
        Consumer<Student29> increaseMarks = s -> s.addMarks(10);
        slist.forEach(increaseMarks);
        slist.stream().forEach(Student29::debug);
    }
}


class StringArrayTest {
    public static void main(String args[]) {
        String[][][] arr = {{{"a", "b", "c"}, {"d", "e", null}},
                {{"x"}, null}, {{"y"}}, {{"z", "p"}, {}}
        };
        System.out.println(arr[0][1][2]);
    }
}


class myExc {

    public String callex() throws IOException{

        return "";
    }
}

class extended extends myExc{

    @Override
    public String callex(){
        return "";
    }
}

class MyCallable implements Callable<String> {
    public String call()  {
        //Thread.sleep(5000);
        return "DONE";
    }
}

class s2TestClass38 {

    // Future's get() will block until there is a value to return or there is an exception
    public static void main(String[] args) throws Exception {
        var es = Executors.newSingleThreadExecutor();
        var future = es.submit(new MyCallable());
        System.out.println(future.get()); // 1
        es.shutdownNow(); // 2
    }
}