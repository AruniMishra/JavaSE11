/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 5: Functional Interface and Lambda Expressions
Topic:  Lambda Expression Examples
*/

import java.util.*;

interface Confuseable<String> extends Comparator<String> {

    default int compare(String s1, String s2) {
        System.out.println("In compare method [Default]");
        Random r = new Random();
        int i = r.nextInt();
        if (i % 2 == 0) i = -i;
        return i;
    }

    int dummy(String s1, String s2);
}

class Confused<T> implements Confuseable<String> {
    private String name;

    Confused(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public int dummy(String s1, String s2) {
        return 0;
    }

    @Override
    public int compare(String o1, String o2) {
        return 0;
    }
}

public class LambdaExtras {
    public static void main(String[] args) {

        // you might think it overrides the compare() method - it doesn't.
        Confuseable c = (s, t) -> {
            System.out.println("Executing this method [Confuseable]");
            return -1;
        };
        c.dummy("a", "b");
        List<Confused> list = new ArrayList<>();
        list.add(new Confused<String>("Jane"));
        list.add(new Confused<String>("Mark"));
        list.add(new Confused<String>("Emily"));

        Collections.sort(list, c);
        System.out.println(list);


        Comparator c1 = (s, t) -> {
            System.out.println("Executing this method [Comparator]");
            return -1;
        };

        Collections.sort(list, c1);
        System.out.println(list);
    }
}

