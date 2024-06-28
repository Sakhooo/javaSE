package multithread.lesson1.notifay;

import java.util.Queue;

public class Buyerthread implements Runnable{

    public final Queue<Cashbox> cashboxes;

    public Buyerthread(Queue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }


    @Override
    public void run() {

        synchronized (cashboxes) {
            while (true) {
                try {
                    if (!cashboxes.isEmpty()) {
                        Cashbox cashbox = cashboxes.remove();
                        System.out.println(Thread.currentThread().getName() + " обслуживется в кассе " + cashbox);
                        cashboxes.wait(5L);

                        System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
                        cashboxes.add(cashbox);
                        cashboxes.notifyAll();
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " Ожидаю кассу " );
                        cashboxes.wait();
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
