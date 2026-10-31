package Tut3;

public class ResturantDemo {
    public static void main(String[] args)
            throws InterruptedException {
        OrderCounter counter = new OrderCounter();
        final int totalOrders = 6;

        Thread waiter = new Thread(() -> {
            try {
                for (int i = 1; i <= totalOrders; i++) {
                    counter.placeOrder("Order-" + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Waiter");

        Thread chef = new Thread(() -> {
            try {
                for (int i = 1; i <= totalOrders; i++) {
                    String order = counter.takeOrder();
                    System.out.println("Preparing: " + order);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Chef");

        chef.start();
        waiter.start();
        waiter.join();
        chef.join();
        System.out.println("All orders processed");
    }
}

