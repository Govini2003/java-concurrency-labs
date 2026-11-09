package Tut7.Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupportRequestMain {
    public static void main(String[] args) {
        SupportRequest supportRequest1 = new SupportRequest("Customer1", "Support Request 1");
        SupportRequest supportRequest2 = new SupportRequest("Customer2", "Support Request 2");
        SupportRequest supportRequest3 = new SupportRequest("Customer3", "Support Request 3");
        SupportRequest supportRequest4 = new SupportRequest("Customer4", "Support Request 4");
        SupportRequest supportRequest5 = new SupportRequest("Customer5", "Support Request 5");

        ArrayList<SupportRequest> supportRequests = new ArrayList<>(List.of(supportRequest1, supportRequest2, supportRequest3, supportRequest4, supportRequest5));

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (SupportRequest request : supportRequests) {
            executorService.submit(new RequestProcessor(request));
        }

        executorService.shutdown();
    }
}
