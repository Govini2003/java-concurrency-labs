package Tut3;

import java.util.LinkedList;
import java.util.Queue;

class OrderCounter {
    private final Queue<String> orders = new LinkedList<>();
    private static final int CAPACITY = 3;

    public synchronized void placeOrder(String order)
            throws InterruptedException {

        // TODO 1: Wait while the queue is full.
        while (orders.size() == CAPACITY) {
            wait();
        }

        // TODO 2: Add the order to the queue.
        orders.add(order);
        System.out.println("Added: " + order);

        // TODO 3: Notify all waiting threads.
        notifyAll();
    }

    public synchronized String takeOrder()
            throws InterruptedException {

        // TODO 4: Wait while the queue is empty.
        while (orders.isEmpty()) {
            wait();
        }

        // TODO 5: Remove and store the next order.
        String order = orders.remove();

        System.out.println("Taken: " + order);

        // TODO 6: Notify all waiting threads.
        notifyAll();

        // TODO 7: Return the removed order.
        return order;
    }

    public static void main(String[] args) {

        OrderCounter counter = new OrderCounter();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    counter.placeOrder("Order " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    counter.takeOrder();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}