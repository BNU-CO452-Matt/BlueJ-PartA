import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Matt Hensman (2020-10-06)
 */
public class TicketMachine
{
    // The amount of money entered by a customer so far.
    private int balance = 0;
    // The total amount of money collected by this machine.
    private int total = 0;

    // Available tickets at this machine
    private final Map<String, Ticket> availableTickets = new HashMap();

    // Ticket constants
    public static final Ticket TICKET_AYLESBURY = new Ticket("Aylesbury", 220);
    public static final Ticket TICKET_AMERSHAM = new Ticket("Amersham", 300);
    public static final Ticket TICKET_HIGH_WYCOMBE = new Ticket("High Wycombe", 330);
    
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        this.addTicket(TicketMachine.TICKET_AYLESBURY
                     , TicketMachine.TICKET_AMERSHAM
                     , TicketMachine.TICKET_HIGH_WYCOMBE);
    }
    
    /**
     * Adds a ticket to this machine.
     */
    private void addTicket(Ticket ...tickets) {
        for (Ticket ticket : tickets) {
            this.availableTickets.put(ticket.getDestination(), ticket);
        }
    }

    /**
     * Format a integer representing pennies to a currency string.
     */
    private String getFormattedPrice(int price) {
        int pennies = price % 100;
        return "£" + price / 100 + "." + (pennies < 10 ? "0" + pennies : pennies);
    }

    /**
     * Prints all available tickets.
     */
    public void printAvailableTickets() {
        for (Ticket ticket : this.availableTickets.values()) {
            System.out.printf("Destination: %s\nPrice: %s\n\n",
                              ticket.getDestination(),
                              this.getFormattedPrice(ticket.getCost()));
        }
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    
    /**
     * Adds the value of a given coin to the balance.
     */
    public void insertCoin(Coin coin) {
        int coinValue = coin.getValue();
        this.balance += coinValue;

        System.out.printf("Entered %s, current balance is %s.\n",
                          this.getFormattedPrice(coinValue),
                          this.getFormattedPrice(this.balance));
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket(String destination)
    {
        if (!this.availableTickets.containsKey(destination)) {
            System.out.println("No such ticket available!");
            return;
        }
        
        Ticket ticket = this.availableTickets.get(destination);
        int ticketCost = ticket.getCost();

        if (this.balance >= ticketCost) {
            // Format date
            String formattedDate = new SimpleDateFormat(
                    "yyyy-MM-dd 'at' HH:mm:ss").format(new Date());

            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# " + ticket.getDestination());
            System.out.println("# " + formattedDate);
            System.out.println("# " + this.getFormattedPrice(ticketCost));
            System.out.println("# ");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            this.total += ticketCost;
            // Reduce the balance by the price.
            this.balance -= ticketCost;
        } else {
            System.out.println("You must insert at least: " +
                               (ticketCost - this.balance) + " more cents.");
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund = this.balance;
        this.balance = 0;
        return amountToRefund;
    }
}
