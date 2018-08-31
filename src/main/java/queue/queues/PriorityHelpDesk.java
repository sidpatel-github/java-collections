package queue.queues;

import queue.Category;
import queue.Customer;
import queue.Enquiry;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Comparator.comparing;


public class PriorityHelpDesk {

    // private static final Comparable<Enquiry> BY_CATEGORY = comparing(Enquiry::getCategory);

    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        public int compare(final Enquiry o1, final Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };
    private Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processAllEnquiries() {
        Enquiry enquiry;

        while ((enquiry = enquiries.poll()) != null) {
            enquiry.getCustomer().reply("Have you tried turning it off and on again? as most of the issues are solved by doing this.");
        }
    }

    public static void main(String[] args) {
        PriorityHelpDesk priorityHelpDesk = new PriorityHelpDesk();

        priorityHelpDesk.enquire(Customer.SID, Category.PHONE);
        priorityHelpDesk.enquire(Customer.TOM, Category.PRINTER);
        priorityHelpDesk.enquire(Customer.RONALDO, Category.COMPUTER);

        priorityHelpDesk.processAllEnquiries();
    }
}
