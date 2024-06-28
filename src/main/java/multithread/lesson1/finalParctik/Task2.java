package multithread.lesson1.finalParctik;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Task2 {
  public static void main(String[] args) throws InterruptedException {
      int[] values = new int[1_000_000_000];
    Random random = new Random();
    for (int i = 0; i < values.length; i++) {
      values[i] = random.nextInt(300) + 1;
    }
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    trackTime(() -> {
      try {
        return findMaxParallel(values, executorService);
      } catch (ExecutionException | InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.MINUTES);

    trackTime(() -> findMax(values));
  }

  private static int trackTime(Supplier<Integer> task) {
    long startTime = System.currentTimeMillis();

    int result = task.get();
    System.out.println(result + ": " + (System.currentTimeMillis()-startTime));
    return result;
  }



  private static int findMax(int[] values) {
    return IntStream.of(values).max().orElse(Integer.MIN_VALUE);
  }

  private static int findMaxParallel(int[] values, ExecutorService executorService) throws ExecutionException, InterruptedException {
    return executorService.submit(() ->
    IntStream.of(values).parallel().max().orElse(Integer.MIN_VALUE)).get();
  }



}
