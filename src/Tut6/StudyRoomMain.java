package Tut6;

public class StudyRoomMain {
    public static void main(String[] args) {
        StudyRoomKey room = new StudyRoomKey();

        // Producer: Borrowing Service
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    room.borrowKey("Student " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        // Consumer: Return Service
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    room.returnKey();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        producer.start();
        consumer.start();
    }
}