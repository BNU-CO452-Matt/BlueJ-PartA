/**
 * Represents a ticket to a destination with a cost in pennies.
 *
 * @author Matt Hensman
 * @version 2020-10-06
 */
public class Ticket
{
    // Ticket destination
    private String destination;
    // Ticket cost
    private int cost;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String destination, int cost)
    {
        this.destination = destination;
        this.cost = cost;
    }

    /**
     * Gets the ticket destination.
     */    
    public String getDestination() {
        return this.destination;
    }
    
    /**
     * Gets the ticket cost.
     */
    public int getCost() {
        return this.cost;
    }
}
