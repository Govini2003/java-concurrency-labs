package Lec10;

import java.util.concurrent.Exchanger;

public class OrderDelivery {
    public static void main(String[] args) {
        Exchanger<Order> exchanger = new Exchanger<>();

        Thread worker1 = new Thread(()->{
            try {
                Order order1 = new Order(2, "Order 2", "Kandy", 1000.00);
                System.out.println(Thread.currentThread().getName() + " has order:" + order1.getOrderName());
                Order receive = exchanger.exchange(order1);
                System.out.println(Thread.currentThread().getName() + " received:" + receive.getOrderName());
            }
            catch(InterruptedException e){
                throw new RuntimeException();
            }
        },"Worker 1");

        Thread worker2 = new Thread(()->{
            try {
                Order order2 = new Order(1, "Order 1", "Colombo", 2000.00);
                System.out.println(Thread.currentThread().getName() + " has order:" + order2.getOrderName());
                Order receive = exchanger.exchange(order2);
                System.out.println(Thread.currentThread().getName() + " received:" + receive.getOrderName());
            }
            catch(InterruptedException e){
                throw new RuntimeException();
            }
        },"Worker 2");
        worker1.start();
        worker2.start();
    }
}
