import java.util.ArrayList;

/**
 * A generic Order class with name and items for the student.
 * 
 * @author amjadm
 */
public abstract class Order implements Cloneable, Comparable<Order> {
    /**
     * The name of the order.
     */
    public final String name;
    
    /**
     * The set of items in the order.
     * 
     * @see addScore
     */
    protected ArrayList<String> items;
    
    /**
     * Initializes Order with given name and no items.
     * 
     * @param name The name of the student
     */
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }
    
    /**
     * Add an item to this Order.
     * 
     * @param item The item to be added.
     */
    public void addItem(String item) {
        if (item.isEmpty()) {
            throw new IllegalArgumentException("Invalid item");
        }
        this.items.add(item);
    }
    
    /**
     * Returns the number of items in the Order.
     * 
     * @return The number of item in this Order.
     */
    public int getNumItems() {
        return (this.items.size());
    }
    
    /**
     * Returns true if there is no item in the order, and false otherwise.
     * 
     * @return true if there is no item in this Order.
     */
    public boolean isEmpty() {
        return (getNumItems() == 0);
    }
}
