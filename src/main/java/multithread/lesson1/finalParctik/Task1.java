package multithread.lesson1.finalParctik;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task1 {
  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    while (scanner.hasNextInt()) {
      int second = scanner.nextInt();

      if (second < 0) {
        break;
      }
      executorService.submit(() -> {

        Integer counter = threadLocal.get();
        threadLocal.set(counter == null ? 1 : ++counter);

        System.out.println(String.format("Thread `%s`, tasks: `%d` ", Thread.currentThread().getName(), threadLocal.get()));
        Thread.sleep(second*1000);
        System.out.println(String.format("thread %s slept %d", Thread.currentThread().getName(), second));
        return second;
      });

    }
    executorService.shutdown();
    executorService.awaitTermination(10L, TimeUnit.MINUTES);

  }
}
