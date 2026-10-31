package Lec3;

public class MultiOrderMain {
    public static void main(String[] args) {
        MultiOrder multiOrder=new MultiOrder(5);
        Thread producer=new Thread(()->{
            for (int i=0;i<5;i++){
                multiOrder.placeOrder("Food"+" "+i);
            }
        },"Producer");
        Thread consumer=new Thread(()->{
            for (int i=0;i<5;i++){
                multiOrder.takeOrder();
            }

        },"Consumer");
        producer.start();
        consumer.start();
    }
}
