package Lec3;

public class OrderMain {
    public static void main(String[] args) {
        Order order = new Order();
        Thread producer= new Thread(()->{
            for(int i=0;i<10;i++){
                order.placeOrder("Food"+i);
            }
        },"Producer");

        Thread consumer= new Thread(()->{
            for(int i=0;i<10;i++){
                order.takeOrder();
            }
        },"Consumer");

        producer.start();
        consumer.start();
    }
}
