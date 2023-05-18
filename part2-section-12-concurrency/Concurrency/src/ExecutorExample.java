/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Using ExecutorService
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Class tests SingleThreadedExecutorService with two threads
public class ExecutorExample {

    // main method
    public static void main(String[] args) throws InterruptedException {


        // The ExecutorService used here was a SingleThreadExecutor,
        // which executes and manages threads one at a time.
        // This service guarantees that the second asynchronous thread
        // will not start until the first asynchronous thread is terminated.

        // Get new service using Executors class, static factory method
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Fire and Forget method of execution:  ThreadOne
        executorService.execute(ExecutorExample::doSomethingThreadOne);


        // Fire and Forget method of execution: ThreadTwo
        // executorService.execute(ExecutorExample::doSomethingThreadTwo);
        // executorService.submit(ExecutorExample::doSomethingThreadTwo); // same effect here
        // Fire and keep a reference to task
        var submittedThread = executorService.submit(
                ExecutorExample::doSomethingThreadTwo);


        // Output data from the main thread, demonstrating that
        // threads are running asynchronously.
        for (int i = 1; i < 11; i++) {
            System.out.println("Main thread: iteration " + i);
            Thread.sleep(250);
            if (i == 7) {
                // Use task reference to cancel the task
                if (!submittedThread.isDone()) {
                    submittedThread.cancel(true);
                    System.out.println("Was able to cancel using " +
                            submittedThread.getClass().getName());
                }
            }
        }



        /*
        for (int i = 1; i < 11; i++) {
            System.out.println("Main thread: iteration " + i);
            if (i == 10) executorService.execute(ExecutorExample::doSomethingThreadTwo);
            Thread.sleep(250);
        }
        */

        // Shutdown the service; does not immediately shut down executing task
        executorService.shutdown();

        // Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs,
        // or the current thread is interrupted, whichever happens first.
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("All done!!");
    }

    // Method will run asynchronously, printing numbers 1-5
    private static void doSomethingThreadOne() {
        for (int i = 1; i <= 5; i++) {

            System.out.println("--> First Thread: iteration " + i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException iex) {
                break;
            }
        }
    }

    // Method will run asynchronously, printing numbers 10-5
    private static void doSomethingThreadTwo() {
        for (int i = 10; i > 5; i--) {

            System.out.println("--> Second thread: iteration " + i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException iex) {
                break;
            }
        }
    }
}
