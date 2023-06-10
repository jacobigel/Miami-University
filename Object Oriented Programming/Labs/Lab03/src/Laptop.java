
import java.util.ArrayList;

public class Laptop {
    /*
     * Holding the brand of the laptop
     */
    private String brand;

    /*
     * Holding the year of the laptop.
     */
    private int year;

    /*
     * Holding more details such as CPU, RAM and etc.
     */
    private ArrayList<String> details;

    /**
     * Default constructor.
     */
    public Laptop() {
        this.brand = "";
        this.year = 0;
        this.details = new ArrayList<String>();
    }

    /**
     * Constructor.
     * 
     * @param brand   String value.
     * @param year    int value.
     * @param details ArrayList of String.
     */
    public Laptop(String brand, int year, ArrayList<String> details) {
        this.brand = brand;
        this.year = year;
        this.details = details;
    }

    /**
     * Copy Constructor.
     * 
     * @param lpt Laptop Class.
     */
    public Laptop(Laptop lpt) {
        this.brand = lpt.brand;
        this.year = lpt.year;
        this.details = lpt.details;
    }

    /**
     * Constructor.
     * 
     * @param brand String value.
     */
    public Laptop(String brand) {
        this.brand = brand;
        this.year = 2022;
        this.details = new ArrayList<String>();
    }

    /**
     * Returns the value of the instance variable year.
     * 
     * @return an int value.
     */
    public int getYear() {
        return this.year;
    }
    
    /**
     * Returns the brand of the laptop;
     * 
     * @return a String value.
     */
    public String getBrand() {
        return this.brand;
    }
    
    /**
     * Returns details about the laptop.
     * 
     * @return an ArrayList of Strings.
     */
    public ArrayList<String> getDetails() {
        return this.details;
    }
    
    /**
     * Sets a new value for the brand of laptop.
     * 
     * @param brand a String value.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    /**
     * Returns whether or not the laptop is old.
     * 
     * @return a boolean value.
     */
    public boolean isOld() {
        return isOldHelper();
    }
    
    /*
     * A helper method for isOld method.
     * 
     * @return a boolean value;
     */
    private boolean isOldHelper() {
        return (this.year <= 2015) ? true : false;
    }
    
    /**
     * Returns true if the laptop has GPU, and false otherwise.
     * 
     * @return a boolean value.
     */
    public boolean isHighPerformance() {
        return isHighPerformHelper();     
    }
    
    /*
     * A Helper method for isHighPerformance.
     * 
     * @return A boolean value.
     */
    private boolean isHighPerformHelper() {
        for (String elem : this.details) {
            if (elem.toLowerCase().contains("gpu")) {
                return true;
            }
        }
        
        return false;
    }
    
}
