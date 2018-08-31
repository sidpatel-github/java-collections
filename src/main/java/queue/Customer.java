package queue;

public class Customer {
    public static final Customer SID = new Customer("Sid");
    public static final Customer TOM = new Customer("Tom");
    public static final Customer RONALDO = new Customer("Ronaldo");

    private final String name;

    public Customer(final String name) {
        this.name = name;
    }

    public void reply(final String message) {
        System.out.printf("%s: %s\n", name, message);
    }
}
