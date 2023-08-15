package concurrency;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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


class Test20 {
    private static long LIMIT = 1000000000;
    private static final int THREADS = 100;

    static class AdderTask extends RecursiveTask<Long> {
        long from, to;

        public AdderTask(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= LIMIT / THREADS) {
                long localSum = 0;
                for (long i = from; i <= to; i++) {
                    localSum += i;
                }
                return localSum;
            } else {
                long mid = (from + to) / 2;
                AdderTask first = new AdderTask(from, mid);
                AdderTask second = new AdderTask(mid + 1, to);
                first.fork();
                /*INSERT*/

                /*
                After invoking fork() on 1st subtask,
                it is necessary to invoke join() on 1st subtask and compute() on 2nd subtask.

                The order of execution of calling join() and compute() on divided subtasks is important in a fork/join framework.
                First invoke compute() on 2nd subtask and then join() on 1st subtask.
                 */
                // return first.join() + second.compute();
                return second.compute() + first.join();
            }
        }
    }

    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        ForkJoinPool pool = new ForkJoinPool(THREADS);
        long sum = pool.invoke(new AdderTask(1, LIMIT));
        System.out.printf("sum of the number from %d to %d is %d %n", 1, LIMIT, sum);
        LocalTime end = LocalTime.now();
        System.out.println(ChronoUnit.NANOS.between(start, end));
    }
}


class Counter implements Runnable {

    /*
    static variables may be cached for individual threads.
    In multi-threaded environment if one thread modifies its cached data,
    that may not reflect for other threads as they have a copy of it.

    volatile declaration makes sure that threads won't cache the data and uses the shared copy only.
     */
    private static int i = 3;

    /*
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

     */
    public void run() {
        // System.out.print(get());
        // System.out.print(get() + ": " + i--);
        System.out.println(i--);

    }
}

class Test26 {
    public static void main(String[] args) {
        var t1 = new Thread(new Counter());
        var t2 = new Thread(new Counter());
        var t3 = new Thread(new Counter());
        var threads = new Thread[]{t1, t2, t3};

        /*
        each thread has its own copy of the static member variable of the class
        Given program will print 3 digits but all 3 digits can be different or same
        as variable i is not accessed in synchronized manner.
         */
        for (var thread : threads) {
            thread.start();
        }
    }
}


class Test31 {
    public static void main(String [] args) throws InterruptedException, ExecutionException, TimeoutException {
        var es = Executors.newSingleThreadExecutor();
        var f1 = es.submit(() -> {});
        var f2 = es.submit(() -> 2);
        var f3 = es.submit(() -> {}, 3);
        System.out.println(f1.get(1, TimeUnit.HOURS));
        System.out.println(f2.get(2, TimeUnit.HOURS));
        System.out.println(f3.get(3, TimeUnit.HOURS));
        es.shutdown();
    }
}


class Player extends Thread {
    CyclicBarrier cb;

    public Player(){
        super();
    }

    public Player(CyclicBarrier cb) {
        this.cb = cb;
        this.start();
    }

    public void run() {
        try {
            // System.out.println("run: "+ cb.await());
            System.out.println("run: "+  cb.getParties() + ": " + cb.await());
        } catch (InterruptedException | BrokenBarrierException e) {}
    }
}

class Match implements Runnable {
    public void run() {
        System.out.println("Match is starting...");
    }
}

class Test32 {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        var match = new Match();
        var cb = new CyclicBarrier(2, match);
        var p1 = new Player(cb);
        /*INSERT*/
        System.out.println( cb.getParties() + ": " + cb.await());
    }
}
