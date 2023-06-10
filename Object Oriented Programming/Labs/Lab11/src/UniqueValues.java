import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;

/**
 * Program to demonstrate different approaches to create a unique list of values
 * using ArrayList, HashSet, and HashMap.
 *
 */
public class UniqueValues {
    /**
     * Returns a list of unique numbers from a given list. This method does
     * *not* guarantees that returned numbers will be in the same order as they
     * occur in the given list.
     * 
     * @note The following method provides a O(n^2) implementation.
     * 
     * @param list The list of values from where unique numbers are to be
     *             returned.
     * 
     * @return The list of uniq numbers. The order of values is *not* guaranteed
     *         to be in the same order.
     */
    public static ArrayList<Integer> 
        makeUnique_ArrayList(ArrayList<Integer> list) {
        // The following array list contains unique values
        ArrayList<Integer> uniq = new ArrayList<>();
        for (Integer str : list) {
            if (!uniq.contains(str)) {
                // Found a new value that is not in the uniq list.
                uniq.add(str);
            }
        }
        return uniq;
    }

    /**
     * Returns a list of unique numbers from a given list. This method does not
     * guarantee that unique numbers will be in the same order as they occur in
     * the given list.
     * 
     * @note This method internally uses a HashSet to create the unique list
     *       thereby providing a O(n) implementation.
     * 
     * @note **IMPORTANT** Ideally this method should not have any loops.
     *       You should be able to implement the whole method only in 3 lines.
     * 
     * @see HashSet.addAll
     * 
     * @param list The list of values from where unique numbers are to be
     *             returned.
     * 
     * @return The list of uniqe numbers. The order of numbers is not guaranteed.
     */
    public static ArrayList<Integer> makeUnique_Set(ArrayList<Integer> list) {
        // line 1: creating a HashSet object
        Set<Integer> mySet = new HashSet<Integer>();
        // line 2: adding the given list to the HashSet using .addAll() method
        mySet.addAll(list);
        // line 3: Creating a new ArrayList and passing the HashSet object to the
        //         constructor to create a new arrayList and initializing it with 
        //         the HashSet values. And returning that ArrayList all in one line.
        return new ArrayList<Integer> (mySet); 
        
        
    }

    /**
     * Returns a list of unique numbers from a given list. This method does not
     * guarantee that unique numbers will be in the same order as they occur in
     * the given list.
     * 
     * @note This method internally uses a HashMap to create the unique list
     *       thereby providing a O(n) implementation.
     * 
     * @note You will need a loop to add entries to the HashMap. For the key you can use the 
     *       elements inside the given list, and for the values you can use the boolean value
     *       true for all elements -> <Integer, Boolean>
     * 
     * @note You should only return the keys as an arrayList. Check out the keySet method.
     *       \see HashMap.keySet()
     * 
     * @param list The list of values from where unique numbers are to be
     *             returned.
     * 
     * @return The list of uniq numbers. The order of numbers is not guaranteed.
     */
    public static ArrayList<Integer> makeUnique_Map(ArrayList<Integer> list) {
        // line 1: creating a HashMap object
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        // line 2, 3, 4: Using a foreach loop, go through the given list and
        //               add the elements to the HashMap object. 
        //               You can use each element as a key, and the boolean value true as the value:
        //               <key, value> == <Integer, Boolean> == < an element of the list, true>
        
        for(int elem: list) {
            map.put(elem, true);
        }
        // line 5: Creating a new ArrayList and passing only the keys from the HashMap object 
        //         (check out the keySet() method) to the constructor to create a new arrayList 
        //         from the keys. And returning that ArrayList all in one line.
        return new ArrayList<Integer> (map.keySet());
    }
    
    /**
     * Using ListIterator, go through the list and add them up elements
     * and return the sum.
     * 
     * @note You can check out the code provided during the lectures on canvas
     *       as an example to see how to use ListIterator.
     *       
     * @param list The list of values from where unique numbers are to be
     *             returned.
     * @return The sum of all elements inside the list.
     */
    public static long sum(ArrayList<Integer> list) {
        // line 1: creating a ListIterator object.
        ListIterator<Integer> lst = list.listIterator();
;        // line 2: creating a sum variable.
        long sum = 0;
        // line 3, 4, 5: using a while loop to go through the elements using the Iterator object
        //               and adding each elements to the sum variable.
        while(lst.hasNext()) {
            int value = lst.next();
            sum += value;
        }
        // line 6: returning the sum.
        return sum;
    }

    /**
     * This is just a helper method that is used to run a given method and print
     * the elapsed time.
     * 
     * @param approach The approach to be used to create unique values. Valid
     *                 approaches are: "ArrayList", "Set", and "Map".
     * 
     * @param list     The list of values to be processed.
     */
    public static void timeApproach(String approach,
            final ArrayList<Integer> list) {
        // Measure runtime for each approach using System.currTimeMillis()
        int count = 0;
        long sum = 0;
        ArrayList<Integer> lst = null;
        final long startTime = System.currentTimeMillis();

        // Based on the approach run different methods to make
        // a unique list of values.
        switch (approach) {
        case "ArrayList":
            lst = makeUnique_ArrayList(list);
            count = lst.size();
            sum = sum(lst);
            break;
        case "Set":
            lst = makeUnique_Set(list);
            count = lst.size();
            sum = sum(lst);
            break;
        case "Map":
            lst = makeUnique_Map(list);
            count = lst.size();
            sum = sum(lst);
            break;
        default:
            System.out.println("Invalid approach " + approach);
        }

        // Measure the elapsed time and print the values.
        final long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("--------------------------");
        System.out.printf("Number of unique values for (%s): %d\n", approach, count);
        System.out.printf("The sum: %d\n", sum);
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
    }

    /**
     * Helper method to generate 'n' random numbers.
     * 
     * @param n The number of random numbers to be generated.
     * 
     * @return A list of random numbers for testing.
     */
    public static ArrayList<Integer> generateRandomList(int n) {
        final ArrayList<Integer> list = new ArrayList<>(n);
        final int maxVal = Math.max(n / 10, 2);
        for (int i = 0; (i < n); i++) {
            list.add((int) (Math.random() * maxVal));
        }
        return list;
    }

    /**
     * The main function uses a given number of values to measure the time taken
     * to generate unique values to assess the runtime complexity of the
     * different approaches.
     * 
     * @param args The command-line arguments are not used.
     */
    public static void main(String[] args) {
        // Obtain the number of values to be used for testing.
        System.out.print("Enter number of values to use (n): ");
        int n = 0;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }
        // Generate 'n' random numbers for testing
        final ArrayList<Integer> list = generateRandomList(n);
        // Measure time for generating unique numbers using the 3
        // approaches in this method.
        timeApproach("ArrayList", list);
        timeApproach("Map", list);
        timeApproach("Set", list);
        
    }
}
