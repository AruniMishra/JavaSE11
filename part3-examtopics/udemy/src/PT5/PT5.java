package PT5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    }
}