package PT5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PT5 {
}

class Test4 {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("C:/temp.txt")) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class A {
    void nothing() throws IOException {
        System.out.println("A");
    }
}

class B extends A {
    void nothing() {
        System.out.println("B");
    }
}

class demo {

    public static void main(String[] args) {
        A a = new B();
        try {
            a.nothing();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Arrays.compare(new int[]{10}, null));


        // java.util.Arrays.compare(null, null); // compilation failure as it is an ambiguous call.
        Arrays.compare((int[]) null, (int[]) null); //  returns 0.


        var arr = new int[6][6]; // Line n1
        arr[1][4] = 100;
        // arr[6][6] = 200;
        // arr[3][6] = 300;
    }
}

class Printer56<String> {
    private String t;
    Printer56(String t){
        this.t = t;
    }
}

class Test56 {
    public static void main(String[] args) {
        Printer56<Integer> obj = new Printer56<>(100);
        System.out.println(obj);
    }
}

class Printer57<String> {
    private String t;
    Printer57(String t){
        this.t = t;
    }
    public <String> String toString1() {
        return null;
    }
}
 class Test57 {
    public static void main(String[] args) {
        Printer57<Integer> obj = new Printer57<>(100);
        System.out.println(obj);
    }
}
