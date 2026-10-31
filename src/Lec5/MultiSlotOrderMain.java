package Lec5;

public class MultiSlotOrderMain {
    public static void main(String[] args) {
        MultiSlotOrder order = new MultiSlotOrder();

        Thread producer =new Thread(()->{
            for(int i=0;i<5;i++){
                order.placeOrder("Food"+i);
            }
        },"Producer - ");


        Thread consumer =new Thread(()->{
            for(int i=0;i<5;i++){
                order.takeOrder();
            }

        },"Consumer - ");

        producer.start();
        consumer.start();
    }
}

