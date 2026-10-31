package Tut2;

import java.util.LinkedList;
import java.util.Queue;
public class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity; }
    // Producer calls this method
    public synchronized void produce(int item) throws InterruptedException {

// Wait while the buffer is full
        while (buffer.size() == capacity) {
            System.out.println("Buffer is FULL. Producer is waiting...");
            wait(); }

        buffer.add(item);

        System.out.println("Produced: " + item + " | Buffer size: " + buffer.size());
// Notify the consumer thread that an item is available
        notify();
    }
    // Consumer calls this method
    public synchronized int consume() throws InterruptedException {
// Wait while the buffer is empty
        while (buffer.isEmpty()) {
            System.out.println("Buffer is EMPTY. Consumer is waiting...");
            wait();
        }
        int item = buffer.poll();
        System.out.println("Consumed: " + item + " | Buffer size: " + buffer.size());
// Notify the producer thread that space is available
        notify();
        return item;
    }
}