package Tut2;

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(3); // Buffer capacity of 3
// Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedBuffer.produce(i);
                    Thread.sleep(500); // Simulate delay in production
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");
// Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedBuffer.consume();
                    Thread.sleep(1000); // Simulate delay in processing (slower than producer)
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");
        producer.start();
        consumer.start();
    }
}