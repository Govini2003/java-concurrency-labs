package Lec4;
import java.util.LinkedList;
import java.util.Queue;

class ParkingBuffer {
    private final Queue<String> buffer = new LinkedList<>();
    private final int CAPACITY = 8;

    // Producer inserts a vehicle record
    public synchronized void produce(String vehicle)
            throws InterruptedException {

        while (buffer.size() == CAPACITY) {
            wait(); // Wait if the buffer is full
        }

        buffer.add(vehicle);
        System.out.println("Produced: " + vehicle);

        notifyAll(); // Notify waiting consumer
    }

    // Consumer retrieves a vehicle record
    public synchronized String consume()
            throws InterruptedException {

        while (buffer.isEmpty()) {
            wait(); // Wait if the buffer is empty
        }

        String vehicle = buffer.remove();
        System.out.println("Processed: " + vehicle);

        notifyAll(); // Notify waiting producer

        return vehicle;
    }
}

