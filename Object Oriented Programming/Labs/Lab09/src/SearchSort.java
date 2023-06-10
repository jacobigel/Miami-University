import java.util.Arrays;

/**
 * @author jacob igel
 */

/**
 * Methods to apply some of the concepts of searching and sorting for
 * problem-solving. These problems are commonly asked on Job-interviews and
 * hence also included in exams.
 */
public class SearchSort {
    /**
     * Complete the following insert method that must create a new list that
     * contains all the elements in list and the given item inserted
     * appropriately into the new list. Assume that the original list is
     * initially sorted in descending order (i.e., from largest to smallest).
     * For example insert({2,3,5,6}, 4) should return new list containing the
     * values {2,3,4,5,6}.
     * 
     * @see Arrays.binarySearch
     * @see System.arraycopy
     * 
     * @param list Sorted (in descending order) list of values. Do not modify
     *             this list.
     * @param item The item to be inserted into the newly created list.
     * @return A new sorted list (in descending order) with the item inserted at
     *         the appropriate location.
     */
    public static int[] insert(int[] list, int item) {
        // 1
        int indx = Arrays.binarySearch(list, item);

        // 2
        if (indx >= 0) {
            return list;
        } else {
            // convert index to actual number
            indx = (indx * -1) - 1;

            // 3
            int[] newList = new int[list.length + 1];

            // 4
            System.arraycopy(list, 0, newList, 0, indx);

            // 5
            newList[indx] = item;

            // 6
            System.arraycopy(list, indx, newList, indx + 1, list.length - indx);

            return newList;
        }

    }

    /**
     * Implement this method to counts how many value occur in both list1 and
     * list2. Assume both lists are sorted in ascending order. Also assume that
     * neither list1 nor list2 has any duplicates in itself. For example
     * countDuplicates({1,2,4,5}, {2,3,5,6}) should return 2 (since both lists
     * contain the numbers 2 and 5). You are expected to achieve this task
     * without making multiple passes over either list (your code should only
     * have a single loop)
     * 
     * @note Your implementation must be O(n).
     * 
     * @param list1 The first sorted list. Do not modify.
     * @param list2 The second sorted list. Do not modify.
     * @return The number of values that occur in both lists.
     */
    public static int countDuplicates(int[] list1, int[] list2) {
        int dupCount = 0;
        for (int i = 0, j = 0; i < list1.length && j < list2.length;) {
            if (list1[i] == list2[j]) {
                dupCount++;
                i++;
                j++;
            } else if (list1[i] < list2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return dupCount;
    }

}
