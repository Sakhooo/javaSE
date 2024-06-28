package multithread.lesson1.counter;

public class CounterDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterThread counterThread = new CounterThread(counter);
        CounterThread counterThread1 = new CounterThread(counter);
        CounterThread counterThread2 = new CounterThread(counter);
        CounterThread counterThread3 = new CounterThread(counter);

        counterThread.start();
        counterThread1.start();
        counterThread2.start();
        counterThread3.start();

        counterThread.join();
        counterThread1.join();
        counterThread2.join();
        counterThread3.join();

        System.out.println(counter.getCount());


    }
}
