import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiPredicate;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

enum Status {

    BRONZE(5), SILVER(10), GOLD(15);
    private int rate;

    private Status(int rate) {
        this.rate = rate;
    }

    public static Status addStatus(int rate) {
        return null;
    }

    public int getRate() {
        return rate;
    }
}

/*
Element Type 	Element to be Annotated
Type 	        Class, interface or enumeration
 */
@Target({TYPE, METHOD})
@interface Resource178 {
}

class Test180 {
    public static void main(String[] args) {
        Status silver = Status.SILVER;

        // System.out.println(silver + silver.getRate());
        Status platinum = Status.addStatus(20);
        // System.out.println(platinum + platinum.getRate());
    }
}

public class Test28 {
}

class q170 {
    public static void main(String[] args) {
        List<Integer> original = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(original);

        Queue<Integer> clq = new ConcurrentLinkedQueue<>(original);
        for (Integer w : clq) {
            clq.remove(w);
        }
        System.out.println("clq: " + clq);

        // ConcurrentModificationException
        // List<Integer> al = new ArrayList<>(original);
        // for (Integer w : al) {
        //     al.remove(w);
        // }
        // System.out.println(al);

        List<Integer> cwa = new CopyOnWriteArrayList<>(original);
        for (Integer w : cwa) {
            cwa.remove(w);
        }
        System.out.println("cwa: " + cwa);


        // ConcurrentModificationException
        // List<Integer> sl = Collections.synchronizedList(original);
        // for (Integer w : sl) {
        //     sl.remove(w);
        // }
        // System.out.println("sl" + sl);

        System.out.println("original:" + original);
    }
}

class T174 {
    public static void main(String[] args) {
        // Function<Integer, Integer> func = x -> y -> x*y;
        IntFunction<IntUnaryOperator> func2 = x -> y -> x * y;
    }
}

@Resource178
class Manager178 extends
        // @Resource178 // not valid here
        Person {
    Manager178() {

    }

    @Resource178
    String getDepartment() {

        return "";
    }
}


class A186 {
}

class B186 extends A186 {
}

class C186 extends B186 {
}

class Test186 {
    public static void main(String args[]) {

        List<? extends A186> listA = new ArrayList<>();
        List<B186> listB = new ArrayList<B186>();
        List<? extends B186> listC = new ArrayList<>();

        //  A<B186> <<< A<? extends B186> <<< A<? extends A186>
        List<? extends A186> listA2 = new ArrayList<B186>();
        listA = listB;
        listC = listB;

        BiPredicate testEquality = (var x, var y) -> (x.equals(y));
    }
}


class Animal188 {
}

class Dog188 extends Animal188 {
}

class Petdog188 extends Dog188 {
}

class House188<A extends Animal188> {
    public House188<? super Dog188> build(A a) {

        // A<T> <<< A<? super T> <<< A<? super S>


        // A<Dog188> <<< A<? super Dog188> <<< A<? super S>
        // return new House188<Dog188>(); // valid


        // A<Animal188> <<< A<? super Animal188> <<< A<? super Dog188>
        return new House188<Animal188>();


        // House<Object>
        // return new House188<Object>();
    }

}