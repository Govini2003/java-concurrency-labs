package Tut1;

//tutorial 1- question 3
public class NumberRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }

    public static void main(String[] args) {

        //Using the Runnable interface (separate class)
        Thread runnableThread = new Thread(new NumberRunnable());
        runnableThread.start();

        //Using a Lambda function
        Thread lambdaThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        });
        lambdaThread.start();

        //Using an Anonymous class
        Thread anonymouseThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                }
            }
        });
        anonymouseThread.start();
    }
}