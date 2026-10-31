package Lec6;

public class MultiSlotSharedBufferMain {
    public static void main(String[] args) {
        MultiSlotSharedBuffer multiSlotSharedBuffer = new MultiSlotSharedBuffer();

        Thread producer=new Thread(()->{
            for(int i=0;i<5;i++){
                multiSlotSharedBuffer.add("Food "+i);
            }
        },"Producer");


        Thread consumer=new Thread(()->{
            for(int i=0;i<5;i++){
                multiSlotSharedBuffer.remove();
            }
        },"Consumer");

        producer.start();
        consumer.start();

    }
}
