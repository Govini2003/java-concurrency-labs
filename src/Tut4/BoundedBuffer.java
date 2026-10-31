package Tut4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition();  // producers wait here
    private final Condition notEmpty = lock.newCondition();  // consumers wait here

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
    }

    // Called by producers
    public void put(int item) throws InterruptedException {
        lock.lock();
        try {
            // while (not if) guards against spurious wakeups
            while (queue.size() == capacity) {
                System.out.println(Thread.currentThread().getName()
                        + " waiting: buffer FULL");
                notFull.await();
            }
            queue.add(item);
            System.out.println(Thread.currentThread().getName()
                    + " produced " + item + "  | buffer size = " + queue.size());
            notEmpty.signal();   // tell a waiting consumer an item is available
        } finally {
            lock.unlock();
        }
    }

    // Called by consumers
    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName()
                        + " waiting: buffer EMPTY");
                notEmpty.await();
            }
            int item = queue.remove();
            System.out.println(Thread.currentThread().getName()
                    + " consumed " + item + " | buffer size = " + queue.size());
            notFull.signal();    // tell a waiting producer space is available
            return item;
        } finally {
            lock.unlock();
        }
    }
}