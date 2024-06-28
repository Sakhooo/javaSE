package org.example.notifay;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Buyerthread implements Runnable{

    public final BlockingQueue<Cashbox> cashboxes;

    public Buyerthread(BlockingQueue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }


    @Override
    public void run() {

        try {
            Cashbox cashbox = cashboxes.take();
            System.out.println(Thread.currentThread().getName() + " обслуживется в кассе " + cashbox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
            cashboxes.add(cashbox);


        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
    }
}
