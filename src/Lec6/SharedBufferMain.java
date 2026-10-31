package Lec6;

public class SharedBufferMain {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();

        Thread producer= new Thread(()->{
            for(int i=0;i<5;i++){
                sharedBuffer.add("Food"+i);
            }

        },"Producer");

        Thread consumer= new Thread(()->{
            for(int i=0;i<5;i++){
                sharedBuffer.remove();
            }
        },"Consumer");

        producer.start();
        consumer.start();

    }
}
