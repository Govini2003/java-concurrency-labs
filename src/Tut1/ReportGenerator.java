//question 7
package Tut1;
public class ReportGenerator extends Thread {

    private Counter counter;

    public ReportGenerator(Counter counter) {
        super("Report Generator");
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