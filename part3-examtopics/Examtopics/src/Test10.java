import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Test10 {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CyclicBarrier barrier = new CyclicBarrier(2, () ->
                System.out.print(Thread.currentThread().getName() + list));


        IntStream.range(0, 5).forEach(n -> executorService.execute(() ->
        {
            try {
                list.add(n);
                barrier.await(); //Infinite
                // barrier.await(5, TimeUnit.SECONDS); // TimeoutException
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println("\n"+Thread.currentThread().getName() + " Exception");
            }
            /*catch (TimeoutException e) {
                System.out.println("\n"+Thread.currentThread().getName() + " TimeoutException");
                //throw new RuntimeException(e);
            } */
            finally {

            }
        }));
        executorService.shutdown();
    }
}