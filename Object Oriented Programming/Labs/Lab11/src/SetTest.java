import java.util.HashSet;
import java.util.Set;

/**
 * A simple Class for demonstrating set.
 * 
 * @author amjadm
 *
 */
public class SetTest {
    // Set is an interface class
    // Set is a concept
    static Set<Integer> mySet;
    
    /**
     * Takes O(1) to add an element.
     * 
     * @param value an int value
     */

    public static void add(int value) {
        if (mySet.add(value)) {
            System.out.printf("The value %d was added successfully!\n", value);
        } else {
            System.out.printf("Error! the value %d is already in the set.\n", value);
        }     
    }
    
    /**
     * Takes O(1) to remove an element.
     * 
     * @param value an int value
     */
    public static void remove(int value) {
        if (mySet.remove(value)) {
            System.out.printf("The value %d was removed successfully!\n", value);
        } else {
            System.out.printf("Error! the value %d does not exist.\n", value);
        }
        
    }
    
    /**
     * Calling contains method from hashSet class.
     * Takes O(1) to find an element.
     * 
     * @param key an int value.
     * @return boolean.
     */
    public static boolean isThere(int key) {
        return mySet.contains(key); 
    }
    
    /**
     * Prints all the elements.
     * It takes O(n) time.
     * 
     */
    public static void displaySet() {
        int i = 0;
        for (int elem : mySet) {
            System.out.printf("The [%d] element is: %d\n", i++, elem);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // HashSet is a data structrure implementing the Set
        // using hash codes.
        mySet = new HashSet<Integer>();
        
        for (int i = 0; i < 5; i++) {
            add(i);
        }
        
        // try to add a duplicate
        // Adding/Checking an element inside the set takes constant time or O(1)
        add(4);
        
        System.out.println(isThere(3));
        System.out.println(isThere(5));
        
        
        displaySet();
        
        // ** No random access to elements like arrays
        // ** Can't be Sorted
        // ** After adding an element, changing the order is guaranteed
        add(-2);
        displaySet();
        
        // Removing an element from a normal list takes 
        // linear time or O(n) 
        // while in sets it takes constant time or O(1)
        remove(12);
        remove(0);
        displaySet();

    }

}
