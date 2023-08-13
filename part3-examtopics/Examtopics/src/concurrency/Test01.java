package concurrency;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test01 {
    static int var = 0; // Line n1

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        var results = new Future<?>[3];

        Stream.of("A", "R", "M").collect(Collectors.toList()).forEach(str -> {
            results[var++] = es.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                return str;
            }); // callable
        }); // Line n2

        for (var x = 0; x < results.length; x++)
            System.out.print(results[x].get() + "-");

        es.shutdown();
    }

}

class Test05 {
    private void increment(int start, int end) throws InterruptedException, ExecutionException {
        var es = Executors.newFixedThreadPool(10);
        var results = new Future<?>[26];
        /*
         for x = 0, Future object containing String object "A" will be stored at results[0] and for x = 1,
         Future object containing String object "B" will be stored at results[1] and so on...
         */
        IntStream.rangeClosed(start, end).parallel().forEach(x -> results[x] = es.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "; x:" + x);
            return new String(new char[]{(char) (x + 65)});
        }));
        System.out.println(results[0].get());
        es.shutdown();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new Test05().increment(0, 25);
    }
}


class Test07 {
    static int ctr = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*
        As there is fixed thread pool of 3 thread, hence tasks submitted by Line n1, Line n2
        and Line n3 may run in parallel and in any order.
         */
        var es = Executors.newFixedThreadPool(3);
        es.execute(() -> ctr++); // Line n1
        es.submit(() -> ctr++); // Line n2
        // System.out.println(ctr);
        var s = es.submit(() -> {
        }, "$".repeat(ctr++)); // Line n3
        System.out.println(s.get());
        es.shutdown();

        System.out.println("-------------------------------");
        var es1 = Executors.newSingleThreadExecutor();
        var f = es1.submit(() -> "HELLO"); // Callable
        System.out.println(f.get());
        var f1 = es1.submit(() -> System.out.println()); // Runnable
        System.out.println(f1.get());
        es.shutdown();


    }
}

class Test13 {
    private static void print() {
        System.out.println("PRINT");
    }

    private static Integer get() {
        return 10;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var es = Executors.newFixedThreadPool(10);
        Future<?> future1 = es.submit(Test13::print);
        Future<?> future2 = es.submit(Test13::get);
        System.out.println(future1.get());
        System.out.println(future2.get());
        es.shutdown();
    }
}

class Test15 {
    public static void main(String[] args) {
        var list = new CopyOnWriteArrayList<String>();
        list.add("Melon");
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        for (String s : list) {
            System.out.println(list.removeIf(str -> str.startsWith("M")));
            System.out.println(s);
        }
    }
}


class Test16 {
    public static void main(String[] args) throws InterruptedException {
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return "HELLO";
            }
        };

        var es = Executors.newFixedThreadPool(10);
        var list = Arrays.asList(c, c, c, c, c);
        var futures = es.invokeAll(list);
        System.out.println(futures.size());
        es.shutdown();
    }
}


class Adder extends RecursiveAction {
    private int from;
    private int to;
    int total = 0;

    Adder(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected void compute() {
        if ((to - from) <= 4) {
            int sum = 0;
            for (int i = from; i <= to; i++) {
                sum += i;
            }
            total += sum;
        } else {
            int mid = (from + to) / 2;
            Adder first = new Adder(from, mid);
            Adder second = new Adder(mid + 1, to);
            invokeAll(first, second);
            total = first.total + second.total;
        }
    }
}

class Test18 {
    public static void main(String[] args) {
        Adder adder = new Adder(1, 6); // Line 34
        ForkJoinPool pool = new ForkJoinPool(4);
        pool.invoke(adder);
        System.out.println(adder.total);
    }
}
