package Lec2;

public class TicketCounter {
    private int ticketCount = 10;

    public void purchaseTicket() {
        if (ticketCount > 0) {
            ticketCount--;
            System.out.println(Thread.currentThread().getName()+ "Purchased ticket");
        }else{
            System.out.println("Available tickets are "+ticketCount);
        }
    }

    public synchronized void returnTicket() {
        if (ticketCount <= 9) {
            ticketCount++;
            System.out.println(Thread.currentThread().getName() + " Returned ticket");
        } else {
            System.out.println("All tickets are available");
            System.out.println("Available tickets are " + ticketCount);
        }
    }

}


