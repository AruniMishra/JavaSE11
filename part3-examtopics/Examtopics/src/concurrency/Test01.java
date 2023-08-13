package concurrency;

import java.util.concurrent.*;

public class Test01 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Callable<String> r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ATTACK";
        };

        var es = Executors.newSingleThreadExecutor();
        var f = es.submit(r);
        System.out.println(f.get(6000, TimeUnit.MILLISECONDS));
        es.shutdown();
    }
}
