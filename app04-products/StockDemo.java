/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * Modified by: Matt Hensman
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo {
    // The stock manager.
    private StockManager manager = new StockManager();

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo() {
        manager.addProduct(new Product(0, "Freezer"));
        manager.addProduct(new Product(1, "Fridge"));
        manager.addProduct(new Product(2, "Water Cooler"));
        manager.addProduct(new Product(3, "Cooker"));
        manager.addProduct(new Product(4, "Microwave"));
        manager.addProduct(new Product(5, "Washing Machine"));
        manager.addProduct(new Product(6, "Tumble Dryer"));
        manager.addProduct(new Product(7, "Dishwasher"));
        manager.addProduct(new Product(8, "Air Conditioner"));
        manager.addProduct(new Product(9, "Water Heater"));
    }
    
    /**
     * Demo testing code
     */
    public void demo() {
        manager.printProductDetails();
        manager.delivery(0, 1);
        manager.delivery(1, 6);
        manager.delivery(2, 3);
        manager.delivery(3, 4);
        manager.delivery(4, 3);
        manager.delivery(5, 2);
        manager.delivery(6, 1);
        manager.delivery(7, 2);
        manager.delivery(8, 6);
        manager.delivery(9, -5);
        manager.printProductDetails();
        
        manager.search("water");

        this.sellProduct(0);
        this.sellProduct(2);
        this.sellProduct(9);
        this.sellProduct(9);
        this.sellProduct(9);
        this.sellProduct(8);
        this.sellProduct(6);
        this.sellProduct(6);
        this.sellProduct(10);
        this.sellProduct(255);
        
        manager.printProductDetails();
        manager.printLowStockProductDetails();
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id) {
        Product product = getProduct(id);
        
        if (product != null)  {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id) {
        Product product = getProduct(id);
        
        if (product != null)  {
            this.showDetails(id);
           
            product.decreaseQuantity(1);
            this.showDetails(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id) {
        Product product = manager.findProduct(id);
        
        if (product == null) {
            System.out.printf("Product with ID: %d is not recognised.\n", id);
        }

        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager() {
        return manager;
    }
}
