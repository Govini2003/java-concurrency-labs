package Tut3;

class KitchenWorker extends Thread {
    @Override
    public void run() {
        System.out.println("Preparing an order");
        try {
            Thread.sleep(2000);//timed waiting
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("Order completed");
    }
}


