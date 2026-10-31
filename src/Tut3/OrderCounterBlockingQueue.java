package Tut3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class OrderCounterBlockingQueue {
    private final BlockingQueue<String> orders =
            new ArrayBlockingQueue<>(3);

    public void placeOrder(String order)
            throws InterruptedException {

        // TODO 1: Insert the order, waiting if necessary.
        orders.put(order);

        System.out.println("Added: " + order);
    }

    public String takeOrder() throws InterruptedException {

        // TODO 2: Remove and return an order,
        //         waiting if necessary.
        String order = orders.take();

        System.out.println("Taken: " + order);

        return order;
    }

    public static void main(String[] args) {

        OrderCounterBlockingQueue counter =
                new OrderCounterBlockingQueue();

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