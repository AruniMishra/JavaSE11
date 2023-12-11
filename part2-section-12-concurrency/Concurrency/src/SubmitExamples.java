/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Using ExecutorService's three submit methods
*/

import java.util.Random;
import java.util.concurrent.*;

public class SubmitExamples {

    public static void main(String[] args) {

        ExecutorService executorService = null;

        try {
            executorService = Executors.newSingleThreadExecutor();

            // Submits Runnable and returns void
            Future<?> firstResult = executorService.submit(
                    () -> new Random().ints(1, 1000)
                            .limit(5)
                            .forEach(System.out::println));

            // Allow thread to complete before proceeding using while loop
            //  and checking Future.isDone() method.  Polling.
            while (!firstResult.isDone()) {
                Thread.sleep(250);
            }

            // Future.get() returns a null with single argument and
            // Runnable is first argument
            System.out.println("firstResult = " + firstResult);
            System.out.println("firstResult.get() = " + firstResult.get());


            System.out.println("\n\n-------------------------------------------");
            // Submits Runnable and returns second argument as the result
            Future<String> secondResult = executorService.submit(
                    () -> new Random().ints(1, 1000)
                            .limit(5)
                            .forEach(System.out::println),
                    "Thread is finished");

            // Allow thread to complete before proceeding using while loop
            //  and checking Future.isDone() method
            while (!secondResult.isDone()) {
                Thread.sleep(250);
            }

            // Future.get() returns the second argument when
            // two arguments passed to submit method
            System.out.println("secondResult = " + secondResult);
            System.out.println("secondResult = " + secondResult.get());


            System.out.println("\n\n-------------------------------------------");
            // Submits a Callable that returns a value,
            // value is passed to the Future
            Future<?> thirdResult = executorService.submit(
                    () -> new Random().ints(1, 100_000)
                            .limit(1000)
                            .summaryStatistics()
            );

            // Replace while loop with Future.get() method passing specified
            // time.
            System.out.println("thirdResult = " + thirdResult.get(5, TimeUnit.SECONDS));
            System.out.println("thirdResult = " + thirdResult);

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) executorService.shutdown();
        }
    }
}