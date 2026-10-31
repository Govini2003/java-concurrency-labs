package Lec4;

public class MultiSlotReentrantMain {
    public static void main(String[] args) {
        MultiSlotReentrant multiSlotReentrant = new MultiSlotReentrant(5);
        Thread[] producers = new Thread[5];
        Thread[] consumers = new Thread[5];


        for(int i = 0; i < producers.length; i++){
            producers[i]=new Thread(()->{
                for(int j = 0; j < 5; j++)
                {
                    multiSlotReentrant.placeOrder("Food" + j);
                }
            },"Producer"+" "+i);
        }
        for(int i = 0; i < consumers.length; i++){
            consumers[i]=new Thread(()->{
                for(int j = 0; j < 5; j++)
                {
                    multiSlotReentrant.takeOrder();
                }
            },"Consumer"+" "+i);
        }
        for(Thread producer : producers){
            producer.start();
        }
        for(Thread consumer : consumers){
            consumer.start();
        }
    }
}
