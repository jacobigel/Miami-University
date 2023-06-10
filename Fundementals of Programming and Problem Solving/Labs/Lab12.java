/**
 * Jacob Igel
 * Lab12.java
 * Practicing writing 6 static methods that help practice with Arrays.
*/

public class Lab12 {
    public static void main(String[] args) {
    
        // 1) getNumRows
        int [][] arr1 = new int[][] {{0, -1}, {1, 2}, {10, 2}};
        System.out.println(getNumRows(arr1));
        
        // 2) getRowLength
        int [][] arr2 = new int [][]{{0, -1}, {1, 2}, {10, 2, 5}, {3}};
        System.out.println(getRowLength(arr2, 2));
        
        // 3) changeElem
        int [][] arr3 = new int [][] {{0, -1}, {1, 2}, {10, 2, 5}, {3}};
        System.out.println(changeElem(arr3, 2, 0, 300));
        
        // 4) display
        int [][] arr4 = new int [][] {{0, -1}, {1, 2}, {10, 2, 5}, {3}};
        display(arr4);
        
        // 5)isMagicRows 
        int [][] arr5 = new int [][] {{1, 2, 3, 4}, {2, 3, 1, 4},
            {3, 1, 5, 1}, {4, 4, 1, 1}};
        System.out.println(isMagicRows(arr5));
        
        // 6) isMagicColumns
        int [][] arr6 = new int [][] {{1, 2, 3, 4}, {2, 3, 1, 4},
            {3, 1, 5, 1}, {4, 4, 1, 1}};
        System.out.println(isMagicRows(arr6));
        
    }
    

    
    // 1) getNumRows
    // @param arr - taking in an array
    // @ eturn - the number of the rows in the array
    public static int getNumRows(int[][] arr) {
        return arr.length;
    }
    

    // 2) getRowLength
    // @param arr - taking in an array
    // @return - the length of the rows in the array
    public static int getRowLength(int[][] arr, int row) {
        return (row < 0 || row >= arr.length) ? 0 : arr[row].length;
    }
   
    // 3) changeElem
    // @param arr - taking in an array
    // @param row - the row number
    // @param col - the column number
    // @param newVal - the new value we want in the array
    // @return - the new value that is inside the array
    public static int changeElem(int[][] arr, int row, int col, int newVal) {
        if (row >= 0 && col >= 0 && row < arr.length && col < arr[row].length) {
            arr[row][col] = newVal;
        }
        return newVal;
    }
    
    // 4) display
    // @param arr - taking in an array
    // @return - a display of the different elements of the array
    public static void display(int[][] arr) {
        for (int[] elem : arr) {
            for (int test : elem) {
                System.out.printf("%d ", test);
            }
            System.out.println();
        } 
    }
    
    // 5)isMagicRows 
    // @param arr - taking in an array
    // @return - whether or not the sum of all rows are equal
    public static boolean isMagicRows(int[][] arr) {
        int[] sum = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j : arr[i]) {
                sum[i] += j;
            }
        }
        
        int test = sum[0];
        for (int i : sum) {
            if (test != i) {
                return false; 
            }
        }
        return true;
    }
    
    // 6)isMagicColumns
    // @param arr - taking in an array
    // @return - whether or not the sum of all columns are equal
    public static boolean isMagicColumns(int[][] arr) {
        int[] sum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum[i] += arr[i][j];
            }
        }
        
        int test = sum[0];
        for (int i : sum) {
            if (test != i) {
                return false; 
            }
        }
        return true;
    }
    
}
