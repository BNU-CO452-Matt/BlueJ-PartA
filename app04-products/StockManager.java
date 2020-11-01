import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Matt Hensman
 * @version 2020-10-27
 */
public class StockManager {
    // A list of the products.
    private ArrayList<Product> stock = new ArrayList<>();

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item) {
        this.stock.add(item);
    }

    /**
     * Rename a product in the stock list.
     * @param id Product ID.
     * @param name New product name.
     */
    public void renameProduct(int id, String name) {
        Product product = this.findProduct(id);
        if (product != null) {
            product.setName(name);
        }
    }

    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id) {
        Product product = this.findProduct(id);
        if (product != null) {
            product.decreaseQuantity(1);
        }
    }
    
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount) {
        Product product = this.findProduct(id);
        if (product != null) {
            product.increaseQuantity(amount);
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id) {
        for (Product product : this.stock) {
            if (product.getID() == id) {
                return product;
            }
        }
        
        return null;
    }

    /**
     * Search product names for a given search term and return a list.
     * @param term Product name to search for
     */
    public void search(String term) {
        String out = String.format("Search results for \"%s\":\n", term);
        String formattedTerm = term.toLowerCase();

        for (Product product : this.stock) {
            if (product.getName().toLowerCase().contains(formattedTerm)) {
                out += product + "\n";
            }
        }
        
        System.out.println(out + "\n");
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id) {
        Product product = this.findProduct(id);
        if (product != null) {
            return product.getQuantity();
        }
        
        return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails() {
        String out = "Stock list:\n";
        for (Product product : this.stock) {
            out += " - " + product + "\n";
        }

        System.out.println(out + "\n");
    }

    /**
     * Print details of products with low stock.
     */
    public void printLowStockProductDetails() {
        String out = "Low stock list:\n";
        for (Product product : this.stock) {
            if (product.getQuantity() > 3) {
                continue;
            }

            out += " - " + product + "\n";
        }
        
        System.out.println(out + "\n");
    }
}
