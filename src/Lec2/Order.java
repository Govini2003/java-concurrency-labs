package Lec2;

public class Order {
    private String food;
    private boolean orderAvailable = false;

    public synchronized void placeOrder(String food) {
        System.out.println(Thread.currentThread().getName()+"Placing Order");
        while (orderAvailable) {              // wait until the previous order is taken
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.food = food;
        orderAvailable = true;
        System.out.println("Order is placed");
        notifyAll();                          // wake up the waiting taker
    }

    public synchronized String takeOrder() {
        while (!orderAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String currentOrder = food;
        orderAvailable = false;
        notifyAll();
        return currentOrder;
    }
}