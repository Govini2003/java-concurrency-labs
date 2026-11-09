package Lec7;

public class OrderProcess implements Runnable{
    private Order order;

    public OrderProcess(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " chef has started preparing the " + order.getOrderId() + "|" + order.getOrderName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " chef has finished the " + order.getOrderId() + "|" + order.getOrderName());
    }
}