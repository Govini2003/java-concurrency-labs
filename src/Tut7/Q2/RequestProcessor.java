package Tut7.Q2;

public class RequestProcessor implements Runnable{
    private SupportRequest supportRequest;

    public RequestProcessor(SupportRequest supportRequest) {
        this.supportRequest = supportRequest;
    }

    @Override
    public void run() {
        supportRequest.processRequest();
    }
}
