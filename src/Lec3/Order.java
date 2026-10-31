package Lec3;

public class Order {
    private boolean orderAvailable =false;
    private String order;
    public synchronized void placeOrder(String food) {
        while (orderAvailable) {
            try {
                System.out.println(Thread.currentThread().getName() + "Waiting...");
                wait();//put the producer thread to wait
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //order is not available - so the producer can produce the order
        this.order = food; // order is placed
        orderAvailable = true;
        System.out.println(Thread.currentThread().getName() + "Order Placed"+ food);
        notifyAll();//when there are more than one producer and consumers
    }
    public synchronized void takeOrder() {
        while (!orderAvailable) {
            try {
                System.out.println(Thread.currentThread().getName() + "Waiting...");
                wait();
            }
                catch (InterruptedException e) {
                throw new RuntimeException(e);
                }
        }
        //order is available
        String currentOrder = order; //consumer has consumed
        orderAvailable = false;
        System.out.println(Thread.currentThread().getName() + "Took the order"+ currentOrder);
        notifyAll();
    }
}
