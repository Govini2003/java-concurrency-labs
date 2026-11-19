package Lec8;

public class BookingTicket implements Runnable {

    private int id;

    public BookingTicket(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-Customer"+ id +" started booking");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"-Customer"+ id +" finished booking");
    }
}
