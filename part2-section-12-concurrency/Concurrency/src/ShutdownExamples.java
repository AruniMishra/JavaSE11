/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  ExecutorService. Shutdown
*/

import java.util.List;
import java.util.concurrent.*;

public class ShutdownExamples {
    public static void main(String[] args) throws Exception {

        // Use a fixed thread pool service
        // ExecutorService service = Executors.newFixedThreadPool(1);

        // Use a fixed thread pool service
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        // Create a Runnable task
        Runnable task = () -> {
            try {
                System.out.println("Kicking off Runnable Hello");
                Thread.sleep(1000);
                System.out.println("Finishing Runnable Hello");
            } catch (InterruptedException e) {
                throw new RuntimeException("Runnable Hello", e);
            }
        };

        // Create a Callable task
        Callable<String> call = () -> {
            try {
                System.out.println("Kicking off Callable Hello");
                Thread.sleep(500);
                System.out.println("Finishing Callable Hello");
                return "Hello";
            } catch (InterruptedException e) {
                throw new RuntimeException("Callable Hello", e);
            }
        };

        // Use submit to submit a Runnable, second argument is returned
        // as result
        Future<String> future1 = service.submit(task, "Goodbye");

        // Use submit to submit a Callable, the result of the Callable
        // expression is returned.
        Future<String> future2 = service.submit(call);


        // Schedule a task to occur 2 seconds from now
        ScheduledFuture<?> future3 = service.schedule(task, 2, TimeUnit.SECONDS);

        // Execute shutdown
        // service.shutdown();


        // Print out data in the Future object
        try {
            System.out.println("\nfuture1.get() = " + future1.get(100, TimeUnit.MILLISECONDS));
        } catch (TimeoutException te) {
            te.printStackTrace(System.out);
        }

        // Execute shutdown
        List<Runnable> list = service.shutdownNow();

        System.out.println("\nAre there remaining tasks? " + list.size());
        if (list.size() > 0) {
            System.out.println("------- Waiting Runnables -------");
            list.stream().forEach(System.out::println);
            System.out.println("---------------------------------\n");
        }

        // Print out future objects
        System.out.println("future1: " + future1);

        // future1.get() generates InterruptedException if called after shutdownNow
        // System.out.println("future1.get() = " + future1.get()); // get wait until runnable task finished
        System.out.println("future2: " + future2);

    }
}

