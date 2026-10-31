package Lec4;

public class SmartParkingSystem {

    public static void main(String[] args) {

        ParkingBuffer parkingBuffer = new ParkingBuffer();

        // Producer thread: vehicle detection sensor
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String vehicle = "Vehicle-" + i;
                    parkingBuffer.produce(vehicle);

                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread: parking management system
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    parkingBuffer.consume();

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