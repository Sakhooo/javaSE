package multithread.lesson1.latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable{

  private final CountDownLatch countDownLatch;

  public Rocket(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    System.out.println("Rocket is beginning...");
    try {
      countDownLatch.await();
      System.out.println("Start ");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
