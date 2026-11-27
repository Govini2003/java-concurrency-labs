package Lec10;

public class Order {
    private int orderId;
    private String orderName;
    private String location;
    private double price;

    Order(int orderId, String orderName, String location, Double price) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.location = location;
        this.price = price;
    }
    public String getOrderName() {
        return orderName;
    }
}
