import java.util.ArrayList;
import java.util.Collections;

/**
    A Pizza class that allows for specifying the pizza size,
    crust type, and adding and removing toppings.
    Allows for duplicate toppings (even though some pizza shops
    do not allow for that)
    October 24, 2020
    @author Norm Krumpe
    @version 1.0
*/
public class Pizza {
    
    private static String[] availableSizes = {"small", "medium", "large"};
    private static String[] availableCrusts = {"thin", "thick", "stuffed"};
    private static String[] availableToppings = {
        "pepperoni", "mushrooms", "sausage", "bacon", "pineapple",
        "onions", "peppers", "steak", "ham", "chicken", "tomatoes",
        "anchovies", "spinach", "broccoli", "olives"
    };
      
    private String size;
    private String crust;
    private ArrayList<String> toppings;
    private boolean delivery;
    
    /**
    Constructs a zero-topping, pizza with a specified size and crust type,
    for carry-out.
    @param size the size of this pizza
    @param crust the crust-type of this pizza
    @throws IllegalArgumentException if the size or crust type is not valid
    */
    public Pizza(String size, String crust) {
        setSize(size);
        setCrust(crust);
        this.toppings = new ArrayList<>();
        setDelivery(false);
    }
    
    /**
        Constructs a random topping pizza with 0 to 5 random toppings, 
        based on a lucky integer. 
        The size and crust types will be random, and 
        random (possibly duplicated) toppings will be added. 
        Delivery or carry-out will be randomly selected.
        Every time the same lucky number is entered, 
        the same pizza will result.
        @param luckyNumber a lucky number
    */
    public Pizza(int luckyNumber) {
        java.util.Random rnd = new java.util.Random(luckyNumber);        
        size = availableSizes[rnd.nextInt(availableSizes.length)];
        crust = availableCrusts[rnd.nextInt(availableCrusts.length)];
        int toppingCount = rnd.nextInt(6);
        this.toppings = new ArrayList<>();
        
        for (int i = 0; i < toppingCount; i++) {
            int randomIndex = rnd.nextInt(availableToppings.length); 
            addTopping(availableToppings[randomIndex]);
        }
        setDelivery(rnd.nextBoolean());
    }
    
    // Sets the size of the pizza to the specified size, throwing an
    // exception if the size is not valid.
    private void setSize(String size) {
        for (String s : availableSizes) {
            if (s.equals(size)) {
                this.size = size;
                return;
            }
        }
        throw new IllegalArgumentException("Illegal size: " + size);
    }
    
    // Sets the crust of the pizza to the specified type, throwing an
    // exception if the size is not valid.
    private void setCrust(String crust) {
        for (String s : availableCrusts) {
            if (s.equals(crust)) {
                this.crust = crust;
                return;
            }
        }
        throw new IllegalArgumentException("Illegal crust type: " + crust);
    }
    
    /** 
        Returns the size of this pizza.
        @return the size of this pizza
    */
    public String getSize() {
        return size;
    }
    
    /** 
        Returns the crust type of this pizza.
        @return the crust type of this pizza
    */
    public String getCrust() {
        return crust;
    }
    
    /**
        Sets whether this pizza is to be delivered
        @param delivery true if this pizza is to be delivered, and false for carry-out
    */
    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }
    
    /**
        Returns whether this pizza is to be delivered
        @return true if this pizza is to be delivered, and false for carry-out
    */
    public boolean getDelivery() {
        return delivery;
    }
    
    /**
        Returns whether this pizza contains the specified topping.
        @param topping the topping to be checked
        @return true if this pizza contains the specified topping,
        and false otherwise
    */
    public boolean hasTopping(String topping) {
        return toppings.contains(topping);
    }
    
    /**
        Adds the specified topping to this pizza if the topping
        is valid.
        @param topping the topping to be added
        @return true if the topping was successfully added, or
        false otherwise (if the topping is not on the list of
        available toppings)
    */
    public boolean addTopping(String topping) {
        boolean valid = false;
        for (String t : availableToppings) {
            if (t.equals(topping)) {
                valid = true;
                break;
            }
        }
        
        if (!valid) {
            return false;
        }
        
        toppings.add(topping);
        Collections.sort(toppings);
        return true;
    }
    
    /**
        Gets the number of toppings on this pizza
        @return the count of the number of toppings on this pizza
    */
    public int toppingCount() {
        return toppings.size();
    }
    
    /**
        Returns a space-delimited list of the toppings on this
        pizza
        @return a string containing a space-delimited list of
        the toppings on this pizza
    */
    public String getToppings() {
        String result = "[";
        for (String s : toppings) {
            result += s + " ";
        }
        result = result.trim() + "]";
        return result;
    }
    
    /**
        Returns a string representation of this pizza.
        @return a string containining all pertinent information
        about this pizza
    */
    public String toString() {
        String result = "";
        
        result += getDelivery() ? "DELIVERY ORDER: " : "CARRY-OUT ORDER: ";
         
        result += getSize() + ", " + getCrust() + "\n";
        result += "toppings: " + getToppings();            
        return result;
    }
}
