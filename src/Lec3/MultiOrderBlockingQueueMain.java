package Lec3;

public class MultiOrderBlockingQueueMain {
    public static void main(String[] args) {
        MultiOrderBlockingQueue multiOrderBlockingQueue = new MultiOrderBlockingQueue(3);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                multiOrderBlockingQueue.placeOrder("Food" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                multiOrderBlockingQueue.takeOrder();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Consumer");
    }
}

