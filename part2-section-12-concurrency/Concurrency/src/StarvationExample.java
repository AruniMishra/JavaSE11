/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Starvation Example
*/

import java.util.Arrays;

public class StarvationExample {
    // Create the shared Object that will cause the contention issues
    private static Object sharedObject = new Object();

    // Method will test which threads are starved.
    public static void main(String[] args)
            throws InterruptedException {

        // Create an array of CounterThread threads
        Thread[] threads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            threads[i] = new CounterThread();
        }

        // Start each thread running
        for (Thread th : threads) {
            th.start();
        }

        // Report on the progress of each thread...
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("-----Progress after: " + (i + 1) + " seconds----");

            Arrays.stream(threads)
                    .forEach(System.out::println);
        }

        // Interrupt each thread
        for (Thread th : threads) {
            th.interrupt();
        }

        // Print out final report
        System.out.println("------- Final results -------");
        Arrays.stream(threads)
                .forEach(System.out::println);
    }

    // Nested Thread class
    private static class CounterThread extends Thread {
        // Each thread maintains a counter that represents its progress
        private int counter;

        public void run() {

            // This loop will continue to run until the thread
            // is interrupted.
            while (true) {
                // sharedObject locked, preventing other threads from
                // accessing sharedObject until lock is released
                synchronized (sharedObject) {
                    // Increment counter
                    counter++;
                    try {
                        // Use Thread.sleep to consume a bit of time,
                        // to keep shared object blocked
                        // Thread.sleep(200);


                        // Thread waits until awakened, typically by being notified
                        // or interrupted, or until time specified has elapsed.
                        sharedObject.wait(200);

                    } catch (InterruptedException e) {
                        break;

                    }
                }
            }
        }

        // Format a simple output string
        public String toString() {
            return getName()
                    + ": counter = " + counter;
        }
    }
}
