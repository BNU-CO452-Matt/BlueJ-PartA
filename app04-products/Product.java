/**
 * Model some details of a product sold by a company.
 * 
 * Modified by: Matt Hensman
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Product {
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID() {
        return this.id;
    }

    /**
     * @return The product's name.
     */
    public String getName() {
        return this.name;
    }
    
    public void setName (String name) {
        this.name = name;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * @return The id, name and quantity in stock.
     */
    @Override
    public String toString() {
        return String.format("%s (%d), stock level: %d",
                             this.name, this.id, this.quantity);
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(int count) {
        if (count > 0)  {
            this.quantity += count;
        } else  {
            System.out.println("Attempt to restock " + this.name +
                               " with a non-positive amount: " + count);
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public void decreaseQuantity(int count) {
        if ((this.quantity - count) >= 0)  {
            this.quantity -= count;
        } else {
            System.out.println(
                "Attempt to sell an out of stock item: " + this.name);
        }
    }
}
