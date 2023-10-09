import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface A {
    public Iterable a();
}


abstract interface B extends A {
    public Collection a();
}

interface C extends A {
    public Path a();
}


/*
'a()' in 'C' clashes with 'a()' in 'B'; methods have unrelated return types
 */
// interface D extends B, C {}

// -----------------------------------------------
interface Worker {
    public void doProcess();
}

public class Test01 {

    static int myvar;

    public static void main(String[] args) {
        int x = 0, y = 6;
        for (; x < y; x++, y--) {
            if (x % 2 == 0) {
                continue;
            }
            System.out.println(x + "-" + y);
        }

        System.out.println(2 % 5);

        System.out.println("\n------------------------");
        System.out.println(myvar);
    }
}

class HardWorker implements Worker {
    public void doProcess() {
        System.out.println("doing things");
    }
}

class Cheater implements Worker {
    public void doProcess() {
    }
}


class Main1<T extends Worker> extends Thread { // Line 1
    private List<T> processes = new ArrayList<>();

    public void addProcess(HardWorker w) { // or,  public void addProcess(T w) {
        processes.add((T) w);
    }

    public void run() {
        processes.forEach((p) -> p.doProcess());
    }
}