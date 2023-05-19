
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Using ExecutorService with Schedule ExecutorService
*/

import java.util.IntSummaryStatistics;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class ScheduleMultiples {
    private static long talley;

    private static void addToTalley(long count) {
        talley += count;

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Create some callable lambda expressions
        Runnable r1 = () -> {
            IntSummaryStatistics sums = ScheduleMultiples
                    .doSomething(3, 15);
            System.out.println(sums);
            // Each task increments talley by 5
            ScheduleMultiples.addToTalley(sums.getCount());
        };

        // Set up variables for result of scheduling task
        ScheduledFuture<?> result1 = null;

        // Create a new service using Executors class
        ScheduledExecutorService scheduledService = null;
        try {
            // Factory method to get single threaded Scheduled executor
            scheduledService = Executors.newSingleThreadScheduledExecutor();

            // Schedule task
            result1 = scheduledService.scheduleWithFixedDelay(r1, 2, 2, TimeUnit.SECONDS);

            // When talley = 25, 5 tasks were executed
            while (ScheduleMultiples.talley < 25) {
                Thread.sleep(3000);
            }

        } finally {
            if (scheduledService != null) {
                scheduledService.shutdown();

                // Wait no longer than 4 seconds for completion confirmation
                scheduledService.awaitTermination(4, TimeUnit.SECONDS);

                System.out.println("Final talley = " + talley);
            }
        }
    }

    // Method returns a Stream pipeline that counts by the seed number
    // up until maxNumber is reached.
    private static IntSummaryStatistics doSomething(int seed, int maxNumber) {
        return Stream.iterate(seed, (s) -> s <= maxNumber, (t) -> t + seed)
                .mapToInt((s) -> s)
                .peek((s) -> {
                    System.out.print("[" + seed + "'s] " + s + ", ");
                    if (s == maxNumber) System.out.println("");
                })
                .summaryStatistics();

    }
}