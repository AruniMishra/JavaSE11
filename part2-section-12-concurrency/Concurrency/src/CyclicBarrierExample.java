/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Using CyclicBarrier
*/

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) throws Exception {

        // Construct a CyclicBarrier,
        // First arg # of parties (tasks)
        // Second arg Action is a Runnable
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,
                // CyclicBarrier executes twice, once for each set of 2 threads which pass
                // through the barrier.
                // new CyclicBarrier(2, // crates partial traffic jam
                () -> {
                    System.out.println("---Confirming step is complete");
                });

        // Set up a callable local variable
        Callable<Boolean> r = () -> {

            // All threads execute step 1
            step(1);

            // add this so that all step 1 are finished and then step 2 starts
            cyclicBarrier.await();


            /* if newFixedThreadPool(2)
            CyclicBarrier needs 4 threads (new CyclicBarrier(4,**)) to call await() method
            but as this is not going to happen, hence the program waits endlessly.
            To resolve this, add below code
             */
            /*
            try {
                // update newFixedThreadPool to 2
                cyclicBarrier.await(5, TimeUnit.SECONDS);
            } catch (BrokenBarrierException e) {
                System.out.println("Barrier broken = "
                        + cyclicBarrier.isBroken());
                System.out.println("Waited but then released...");
            }
            */

            // All threads execute step 2
            step(2);
            cyclicBarrier.await();

            return true;
        };

        // Fixed Threads = Will be parties on CyclicBarrier
        // passing 2 created deadlock, unless we call cyclicBarrier.await
        ExecutorService service = Executors.newFixedThreadPool(4);
        // Invoke four callable tasks, all the same
        service.invokeAll(List.of(r, r, r, r));

        System.out.println("Shutting service down");
        service.shutdown();

    }

    public static void step(int stepNo) throws Exception {
        int ms = new Random().nextInt(5) * 1000;
        System.out.println(Thread.currentThread().getName() + " waiting for " + ms + " milliseconds to start step " + stepNo);
        Thread.sleep(ms);

        System.out.println(Thread.currentThread().getName() + " completed step " + stepNo);

    }

}
