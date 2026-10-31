package Lec1;

class MyThread extends Thread {

    public MyThread() {
        super();
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    @Override
    public void run() {
        // If a Runnable target was provided, run that; otherwise do this thread's own work
        if (Thread.currentThread() instanceof MyThread && this.getClass() == MyThread.class) {
            super.run(); // runs the target Runnable if one was set, otherwise does nothing
        }
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}