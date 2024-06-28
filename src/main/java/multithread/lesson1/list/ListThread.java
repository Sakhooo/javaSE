package multithread.lesson1.list;

import java.util.List;

public class ListThread extends Thread{
    private final List<Integer> list;

    public ListThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            list.add(i);
        }
    }
}
