package multithread.lesson1.vol;

public class VolatileDemo {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!flag) {
                System.out.println("still false");
            }
        });
        thread.start();

        Thread.sleep(5L);
        Thread thread1 = new Thread(() -> {
            flag = true;
            System.out.println("flag is set");
        });
        thread1.start();


    }
}
