package standardTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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