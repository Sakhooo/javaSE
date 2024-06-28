package org.example.task;

import java.util.Queue;

public class ProducerThread implements Runnable{
    Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        synchronized (list) {
            while (true) {
                if (list.size()< 10) {
                    int random = RandomUtil.getRandom();
                    list.add(RandomUtil.getRandom());
                    System.out.println("producer adds value: " + random + ". Size : " + list.size());
                    list.add(random);
                } else {
                    System.out.println("producer does nothing");
                }
                list.notifyAll();

                try {
                    int randomWaitValue = 20;
                    System.out.println("producer random wait time: " + randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
