package Tut7.Q2;

public class SupportRequest {
    private String customerName;
    private String description;

    public SupportRequest(String customerName, String description) {
        this.customerName = customerName;
        this.description = description;
    }

    public void processRequest() {
        System.out.println(
                Thread.currentThread().getName()
                        + " processing request from "
                        + customerName
                        + ": " + description
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}