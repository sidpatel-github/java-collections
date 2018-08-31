package queue.queues;

import queue.Category;
import queue.Customer;
import queue.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;

public class SimpleHelpDesk {
    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(final Customer customer, final Category category) {

        // we can use add() method but it will throw an exception if a queue is full
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processAllEnquiries() {
        Enquiry enquiry;

        while ((enquiry = enquiries.poll()) != null) {
            enquiry.getCustomer().reply("Have you tried turning it off and on again? as most of the issues are solved by doing this.");
        }

       /* using remove() method
       while (!enquiries.isEmpty())
       {
           enquiry = enquiries.remove();
           enquiry.getCustomer().reply("Have you tried turning it off and on again? as most of the issues are solved by doing this.");
       }*/
    }

    public static void main(String[] args) {
        SimpleHelpDesk simpleHelpDesk = new SimpleHelpDesk();

        simpleHelpDesk.enquire(Customer.SID, Category.PHONE);
        simpleHelpDesk.enquire(Customer.TOM, Category.PRINTER);

        simpleHelpDesk.processAllEnquiries();
    }
}
