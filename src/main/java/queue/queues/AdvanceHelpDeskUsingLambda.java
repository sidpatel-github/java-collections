package queue.queues;

import queue.Category;
import queue.Customer;
import queue.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class AdvanceHelpDeskUsingLambda {


    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processPrinterEnquiry() {
  /*      Predicate<Enquiry> predicate = enquiry -> enquiry.getCategory() == Category.PRINTER;
        String message = "Is it out of paper?";
        processEnquiry(predicate, message);
*/
        processEnquiry(
                enquiry -> enquiry.getCategory() == Category.PRINTER, "Is it out of paper?");

    }

    public void processGeneralEnquiry() {
     /*   Predicate<Enquiry> predicate = enquiry -> enquiry.getCategory() != Category.PRINTER;
        final String message = "Have you tried turning it off and on again? as most of the issues are solved by doing this.";
        processEnquiry(predicate, message);
       */
     processEnquiry(
                enquiry -> enquiry.getCategory() != Category.PRINTER, "Have you tried turning it off and on again? as most of the issues are solved by doing this.");

    }

    private void processEnquiry(final Predicate<Enquiry> enquiryPredicate, final String message) {

        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && enquiryPredicate.test(enquiry)) {
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        } else {
            System.out.println("No Work to do, it's time to relex!");
        }
    }

    public static void main(String[] args) {
        AdvanceHelpDeskUsingLambda advanceHelpDeskUsingLambda = new AdvanceHelpDeskUsingLambda();

        advanceHelpDeskUsingLambda.enquire(Customer.SID, Category.PHONE);
        advanceHelpDeskUsingLambda.enquire(Customer.TOM, Category.PRINTER);

        advanceHelpDeskUsingLambda.processPrinterEnquiry();
        advanceHelpDeskUsingLambda.processGeneralEnquiry();
        advanceHelpDeskUsingLambda.processPrinterEnquiry();
    }
}
