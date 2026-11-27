package Lec10;

public class Counter {
    private int count;

    public synchronized int getCount() {
        return count;

    }
    public void increment() {
        count++;
        System.out.println(Thread.currentThread().getName()+": "+count);

    }
}
