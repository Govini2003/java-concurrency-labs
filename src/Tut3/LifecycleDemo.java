package Tut3;

public class LifecycleDemo {
    public static void main(String[] args)
            throws InterruptedException {
        KitchenWorker worker = new KitchenWorker();

        // TODO 1: Print the worker state before starting.
        System.out.println("Worker state:"+worker.getState());

        // TODO 2: Start the worker.
        worker.start();
        System.out.println("Worker state:"+worker.getState());

        // TODO 3: Print the worker state immediately.
        Thread.sleep(500);
        System.out.println("Worker state:"+worker.getState());

        // TODO 4: Print the worker state again.
        worker.join();
        System.out.println("Worker state:"+worker.getState());

        // TODO 5: Wait for the worker to finish.
        System.out.println("Worker state:"+worker.getState());

        // TODO 6: Print the final worker state.
        System.out.println("Worker state:"+worker.getState());
    }
}