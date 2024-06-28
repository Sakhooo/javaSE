package multithread.lesson1.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    executours();
    test();

    ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
    threadPool.schedule(() -> System.out.println("ok!"), 3L, TimeUnit.SECONDS);
//    threadPool.schedule()


    threadPool.shutdown();
    threadPool.awaitTermination(1L, TimeUnit.HOURS);


  }

  private static void test() throws InterruptedException, ExecutionException {
    ExecutorService th = Executors.newFixedThreadPool(5);
    Future<Integer> future = th.submit(() -> {
      Thread.sleep(5000L);
      System.out.println("OJPhbTQK5J :: ");
      return 1;
    });

    System.out.println("Result: " + future.get());

    th.shutdown();
    th.awaitTermination(1L, TimeUnit.HOURS);
    System.out.println("End Main");
  }

  private static void executours() {
    Executors.newSingleThreadExecutor();
    Executors.newFixedThreadPool(5);
    Executors.newCachedThreadPool();

    Executors.newScheduledThreadPool(3);
    Executors.newWorkStealingPool();
  }
}
