package Lec3;

public class OrderBlockingQueueMain {
    public static void main(String[] args) {
        OrderBlockingQueue orderBlockingQueue=new OrderBlockingQueue();

        Thread producer=new Thread(()->{
            for (int i=0;i<5;i++){
                orderBlockingQueue.placeOrder("Food"+i);
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        },"Producer");

        Thread consumer=new Thread(()->{
            for (int i=0;i<5;i++){
                orderBlockingQueue.takeOrder();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        },"Consumer");

        producer.start();
        consumer.start();
    }
}
