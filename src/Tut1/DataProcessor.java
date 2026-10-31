//question 7
package Tut1;

public class DataProcessor extends Thread {

    private Counter counter;

    public DataProcessor(Counter counter) {
        super("Data Processor");
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}