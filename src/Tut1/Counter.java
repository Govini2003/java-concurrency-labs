//question 7
package Tut1;

public class Counter {

    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented counter to: " + count);
    }

    public int getCount() {
        return count;
    }
    public static void main(String[] args) {
        Counter counter = new Counter();
    }
}