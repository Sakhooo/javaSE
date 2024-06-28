package org.example.thread;

public class threadDemo {
    public static void main(String[] args) {
        SimpleThread simpleThread = new SimpleThread();
        SimpleRunnable simpleRunnable = new SimpleRunnable();

        new Thread(() -> System.out.println("JAPY90F8dY :: " + Thread.currentThread().getName()));
        simpleThread.start();
        System.out.println("75AFcwZ39S :: " + Thread.currentThread().getName());
    }
}
