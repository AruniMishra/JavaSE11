import t1.A;
import t2.B;

import java.util.ArrayList;
import java.util.List;

public class A01 {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.x);

        System.out.println("-----------");

        ArrayList<Cat> mList = new ArrayList<>();

        mList.stream()
                .filter(c -> c.getName().startsWith("M"))
                .forEach(System.out::println);
    }

    static int sum(Cat a) {
        a.getName();
        return 1;
    }
}

class Cat {
    String name;

    public Cat(String a) {
        this.name = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
