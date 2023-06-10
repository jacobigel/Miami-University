
import java.util.Arrays;

/**
 * A simple tester to test the methods to be developed in the 
 *     SearchSort class.
 */
public class SearchSortTest {
    /**
     * Internal helper method to test operation of the insert method.
     */
    private static void testInsert() {
        // First test
        final int[] list1 = {2, 3, 5, 6};
        final int[] expList1 = {2, 3, 4, 5, 6};
        boolean same = Arrays.equals(expList1, SearchSort.insert(list1, 4));
        System.out.println("1st insert test " + (same ? "passed" : "failed"));
        
        // Second test
        final int[] expList2 = {2, 3, 4, 5, 6, 10};
        same = Arrays.equals(expList2, SearchSort.insert(expList1, 10));
        System.out.println("2nd insert test " + (same ? "passed" : "failed"));
        
        // Third test
        final int[] expList3 = {1, 2, 3, 4, 5, 6, 10};
        same = Arrays.equals(expList3, SearchSort.insert(expList2, 1));
        System.out.println("3rd insert test " + (same ? "passed" : "failed"));
    }
    
    /**
     * Internal helper method to test operation of the countDuplicates method.
     */
    private static void testCountDupes() {
        final int[] list1 = {1, 2, 4, 5};
        final int[] list2 = {2, 3, 5, 6, 7, 8, 11};
        final int[] list3 = {6, 7};

        // The first test (output should be 2)
        System.out.println("1st dupe count test: "
                + SearchSort.countDuplicates(list1, list2));
        // Same list, output should be 7
        System.out.println("2nd dupe count test: "
                + SearchSort.countDuplicates(list2, list2));
        // No items match. Output should be 0
        System.out.println("1st dupe count test: "
                + SearchSort.countDuplicates(list1, list3));
    }
    
    /**
     * Internal helper method to test O(n) operation of the 
     *     countDuplicates method.
     *
     * @param reps Number of times to repeat test.
     */
    private static void testLargeCountDupes(int reps) {
        final int[] bigList = new int[10_000_000];
        // Repeat operation so that the time taken is about 2 seconds.
        for (int i = 0; (i < reps); i++) {
            bigList[i]++;  // Make some difference
            SearchSort.countDuplicates(bigList, bigList);
        }
    }
    
    /** 
     * A simple main method for performing several tests.
     * 
     * @param args Command-line arguments are not used.
     */
    public static void main(String[] args) {
        // First test the insert method
        System.out.println("Testing insert method...");
        testInsert();
        
        // Test functionality of the countDuplicates method
        System.out.println("\nTesting countDuplicates method...");
        testCountDupes();
        
        // Finally do a long duplicate test to check O(n) implementation
        System.out.println("\nTesting countDuplicates for O(n)...");
        // long start = System.currentTimeMillis();
        int reps = (args.length > 0 ? Integer.parseInt(args[0]) : 1000);
        testLargeCountDupes(reps);
        // System.out.println("Elapsed time: " 
        //        + (System.currentTimeMillis() - start));
        System.out.println("Done.");
    }
}
