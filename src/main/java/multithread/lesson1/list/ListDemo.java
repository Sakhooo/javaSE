package multithread.lesson1.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());

        ListThread listThread = new ListThread(integers);
        ListThread listThread1 = new ListThread(integers);
        ListThread listThread2 = new ListThread(integers);
        ListThread listThread3 = new ListThread(integers);
        ListThread listThread4 = new ListThread(integers);
        ListThread listThread5 = new ListThread(integers);

        listThread.start();
        listThread1.start();
        listThread2.start();
        listThread3.start();
        listThread4.start();
        listThread5.start();


        listThread.join();
        listThread1.join();
        listThread2.join();
        listThread3.join();
        listThread4.join();
        listThread5.join();
        System.out.println(integers);


    }
}
