package Lec2;

public class TicketCounterMain {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter();

        Thread thread1= new Thread(()->{
            for (int i=0;i<5;i++) {
                ticketCounter.purchaseTicket();
            }
        });
        Thread thread2= new Thread(()->{
            for (int i=0;i<5;i++) {
                ticketCounter.purchaseTicket();
            }
        });
        thread1.start();
        thread2.start();

    }
}
