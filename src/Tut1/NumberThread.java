package Tut1;
//tutorial 1- question 2

public class NumberThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+" - "+i);
        }
    }

    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        numberThread.start();
    }
}