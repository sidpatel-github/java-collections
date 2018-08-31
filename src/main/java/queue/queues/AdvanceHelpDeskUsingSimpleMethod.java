package queue.queues;

import queue.Category;
import queue.Customer;
import queue.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;

public class AdvanceHelpDeskUsingSimpleMethod {


    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processPrinterEnquiry() {
        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && enquiry.getCategory() == Category.PRINTER) {
            enquiries.remove();
            enquiry.getCustomer().reply("Is it out of paper?");
        } else {
            System.out.println("No Work to do, it's time to relex!");
        }
    }

    public void processGeneralEnquiry() {
        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && enquiry.getCategory() != Category.PRINTER) {
            enquiries.remove();
            enquiry.getCustomer().reply("Have you tried turning it off and on again? as most of the issues are solved by doing this.");
        } else {
            System.out.println("No Work to do, it's time to relex!");
        }
    }

    public static void main(String[] args) {
        AdvanceHelpDeskUsingSimpleMethod advanceHelpDeskUsingSimpleMethod = new AdvanceHelpDeskUsingSimpleMethod();

        advanceHelpDeskUsingSimpleMethod.enquire(Customer.SID, Category.PHONE);
        advanceHelpDeskUsingSimpleMethod.enquire(Customer.TOM, Category.PRINTER);

        advanceHelpDeskUsingSimpleMethod.processPrinterEnquiry();
        advanceHelpDeskUsingSimpleMethod.processGeneralEnquiry();
        advanceHelpDeskUsingSimpleMethod.processPrinterEnquiry();
    }
}
