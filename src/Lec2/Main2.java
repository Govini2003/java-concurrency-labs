package Lec2;

public class Main2 {
    public static void main(String[] args) {
        Order order = new Order();   // one shared object

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                String food = "Food " + i;
                order.placeOrder(food);
                System.out.println(Thread.currentThread().getName() + " placed: " + food);
            }
        }, "Producer ");

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                String food = order.takeOrder();
                System.out.println(Thread.currentThread().getName() + " took: " + food);
            }
        }, "Consumer ");

        producer.start();
        consumer.start();
    }
}