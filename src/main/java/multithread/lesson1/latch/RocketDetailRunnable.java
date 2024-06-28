package multithread.lesson1.latch;

import java.util.concurrent.CountDownLatch;

public class RocketDetailRunnable implements Runnable{
  private final RockerDetail rockerDetail;
  private final CountDownLatch countDownLatch;

  public RocketDetailRunnable(RockerDetail rockerDetail, CountDownLatch countDownLatch) {
    this.rockerDetail = rockerDetail;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    System.out.println("Prepare detail: " + rockerDetail);
    try {
      Thread.sleep(1000l);
      System.out.println("Detail is ready: " + rockerDetail);
      countDownLatch.countDown();

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
