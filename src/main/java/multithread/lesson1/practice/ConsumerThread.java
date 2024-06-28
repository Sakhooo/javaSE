package multithread.lesson1.practice;

import java.util.Queue;

public class ConsumerThread implements Runnable {
    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            if (!list.isEmpty()) {
                Integer removeValue = list.remove();

                System.out.println("consumer get value: " + removeValue + " size: " + list.size());
            } else {
                System.out.println("list is empty ");
            }
            try {
                int random = RandomUtil.getRandom();
                System.out.println("consumer wait: " + random + "sec");
                list.notifyAll();
                list.wait(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
