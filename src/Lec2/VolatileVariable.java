package Lec2;

public class VolatileVariable {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (running) {
                System.out.println("Running");
            }
            System.out.println("Stopped");
        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        running = false;
        System.out.println("Stopped");
    }
}