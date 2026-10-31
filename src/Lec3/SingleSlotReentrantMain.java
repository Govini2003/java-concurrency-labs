package Lec3;

public class SingleSlotReentrantMain {
    public static void main(String[] args) {
        SingleSlotReentrant order = new SingleSlotReentrant();
        Thread producer=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                order.placeOrder("food"+i);
            }
        },"Producer");

        Thread consumer=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                order.takeOrder();


            }
        },"Consumer");

        producer.start();
        consumer.start();
    }
}
