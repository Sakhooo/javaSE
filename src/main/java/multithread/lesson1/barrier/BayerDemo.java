package multithread.lesson1.barrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BayerDemo {
  public static void main(String[] args) throws InterruptedException {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(RockerDetail2.values().length, () -> System.out.println("Run"));

    ExecutorService executorService = Executors.newCachedThreadPool();
    Arrays.stream(RockerDetail2.values())
            .map(detail -> new RocketDetailRunnable2(detail, cyclicBarrier))
            .forEach(executorService::submit);

    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.HOURS);



  }
}
