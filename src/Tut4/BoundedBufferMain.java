package Tut4;

public class BoundedBufferMain {

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer buffer = new BoundedBuffer(5);
        int itemsPerThread = 10;   // 2 producers x 10 = 2 consumers x 10

        // Producer task: adds items to the buffer
        Runnable producer1 = () -> produce(buffer, 100, itemsPerThread);
        Runnable producer2 = () -> produce(buffer, 200, itemsPerThread);

        // Consumer task: removes items from the buffer
        Runnable consumer = () -> consume(buffer, itemsPerThread);

        Thread p1 = new Thread(producer1, "Producer-1");
        Thread p2 = new Thread(producer2, "Producer-2");
        Thread c1 = new Thread(consumer, "Consumer-1");
        Thread c2 = new Thread(consumer, "Consumer-2");

        // Run all four threads concurrently
        p1.start();
        p2.start();
        c1.start();
        c2.start();

        p1.join();
        p2.join();
        c1.join();
        c2.join();

        System.out.println("All producers and consumers finished.");
    }

    private static void produce(BoundedBuffer buffer, int startValue, int count) {
        try {
            for (int i = 0; i < count; i++) {
                buffer.put(startValue + i);
                Thread.sleep(100);           // simulate production time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void consume(BoundedBuffer buffer, int count) {
        try {
            for (int i = 0; i < count; i++) {
                buffer.take();
                Thread.sleep(250);           // simulate consumption time (slower)
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}