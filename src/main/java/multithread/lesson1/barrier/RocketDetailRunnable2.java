package multithread.lesson1.barrier;

import multithread.lesson1.latch.RockerDetail;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RocketDetailRunnable2 implements Runnable{
  private final RockerDetail2 rockerDetail;
  private final CyclicBarrier cyclicBarrier;

  public RocketDetailRunnable2(RockerDetail2 rockerDetail, CyclicBarrier cyclicBarrier) {
    this.rockerDetail = rockerDetail;
    this.cyclicBarrier = cyclicBarrier;
  }

  @Override
  public void run() {
    System.out.println("Prepare detail: " + rockerDetail);
    try {
      Thread.sleep(1000l);
      System.out.println("Detail is ready and waiting: " + rockerDetail);
      cyclicBarrier.await();
      System.out.println("Detail is used: " + rockerDetail);

    } catch (InterruptedException | BrokenBarrierException e) {
      throw new RuntimeException(e);
    }
  }
}
