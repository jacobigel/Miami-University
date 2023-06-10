import java.util.ArrayList;

/**
 * A simple Shop class.
 * 
 * @author amjadm
 */
public class Shop extends Order{
    
    /**
     * Constructor.
     * 
     * @param name A name for the order.
     */
    public Shop(String name) {
        super(name);
    }
    
    public Shop(Shop other) {
        super(other.name);
        
        this.items = new ArrayList<String>(other.items);
    }

    /**
     * @return Returns a deep copy of this object.
     */
    @Override
    public Shop clone() {
        return new Shop(this);
    }
    
    /**
     * @return it returns -1, 0, and 1. 
     */
    @Override
    public int compareTo(Order o) {
        return (int) Math.signum((double) (this.items.size() - o.items.size()));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != Shop.class) {
            return false;
        }
        
        // down cast to get to name. It is guaranteed to work because
        // we checked the Java-class in the previous if-statement.
        Shop other = (Shop) obj;
        
        return this.name.equals(other.name) && haveSameItems(other);
    }
    
    /*
     * Returns true if items aren't matched.
     * 
     * @param other a Shop object.
     * @return true if they have the same items, and false otherwise.
     */
    private boolean haveSameItems(Shop other) {
        if (this.items.size() != other.items.size()) {
            return false;
        }
        // Checking items
        for (int i = 0; i < this.items.size(); i++) {
            if (!(this.items.get(i).equals(other.items.get(i)))) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Adds an item to the list of items.
     * 
     * @param item a String.
     * @return true if it was successful and false otherwise.
     */
    public boolean add(String item) {
        if (item.isEmpty()) {
            throw new IllegalArgumentException("Invalid item!");
        }
        
        return this.items.add(item);
    }

}
