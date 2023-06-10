/*
 * Jacob Igel
 * Lab13.java
 * writing 2 methods, one for linear search and
 * one for binary search and look for different keys 
 * to see which search method can find the keys faster.
 */

import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;

public class Lab13 {
    public static void main(String[] args) throws FileNotFoundException { 
        
        // Counting how many lines are in the text file
        Scanner fileIn = new Scanner(new File("customer_list.txt"));
    
        int count = 0;
        while (fileIn.hasNextLine()) {
            fileIn.nextLine();
            count++;
        }
        //System.out.println("There are " + count + "  lines in the file.");
        
        Customer[] arr = new Customer[count];
        
        fileIn = new Scanner(new File("customer_list.txt"));
        
        // Puts the text file into an array 
        int j = 0;
        while (fileIn.hasNext()) {
            String custName = fileIn.next();
            long custId = fileIn.nextLong();
            arr[j] = new Customer(custName, custId);
            j++;
        }
            
        /*
        System.out.println("[0]: " + arr[0]);
        System.out.println("[10]: " + arr[10]);
        System.out.println("[1000]: " + arr[1000]);
        System.out.println("[1000000]: " + arr[1000000]);
        System.out.println("[last index]: " + arr[count-1]);
        */
           
            
        // Test 1
        System.out.println("The object " + arr[0] + " located at the "
                + "index of: " 
                + linearSearch(arr, new Customer("gwstikg", 100005949L)));
                
        System.out.println();
                
        System.out.println("The object " + arr[0] + " located at the "
                + "index of: " 
                + binarySearch(arr, new Customer("gwstikg", 100005949L))); 
                
        System.out.println();
        
        //Test 2
        System.out.println("The object [mqzhfygjuk, 6001073675] " 
               + "located at the index of: " 
               + linearSearch(arr, new Customer("mqzhfygjuk", 6001073675L)));
                
        System.out.println();
                
        System.out.println("The object [mqzhfygjuk, 6001073675] " 
               + "located at the index of: "  
               + binarySearch(arr, new Customer("mqzhfygjuk", 6001073675L)));
                
        System.out.println();
        
        // Test 3
        System.out.println("The object [gnv, 7412760286] "
                + "located at the index of: " 
                + linearSearch(arr, new Customer("gnv", 7412760286L)));
                
        System.out.println();
                
        System.out.println("The object [gnv, 7412760286] "
                + "located at the index of: "  
                + binarySearch(arr, new Customer("gnv", 7412760286L))); 
                
        System.out.println();
        
        // Test 4
        System.out.println("The object [CSE174, 1111111111] " 
               + "located at the index of: " 
               + linearSearch(arr, new Customer("CSE174", 1111111111L)));
                
        System.out.println();
                
        System.out.println("The object [CSE174, 1111111111] " 
               + "located at the index of: "  
               + binarySearch(arr, new Customer("CSE174", 1111111111L)));
                
        System.out.println();             
    
    }
    // @param Customer[] arr - array of customers with their name and ID  
    // @param Customer key - Customer ID key
    // @return - index of the array
    
    public static int linearSearch(Customer[] arr, Customer key) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            if (arr[i].equals(key)) {
                System.out.println("Linear Search: The key is found "
                    + "after " + counter + " comparison");
                return i;
            }
        }
        
        System.out.println("Linear Search: The key is found "
                + "after " + counter + " comparison");
        return -1;
    }
    
    // @param Customer[] arr - array of customers with their name and ID  
    // @param Customer key - Customer ID key
    // @return - index of the array  
    
    public static int binarySearch(Customer[] arr, Customer key) {
        int compare = 0;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            compare++;
            if (arr[mid].equals(key)) {
                System.out.println("Binary Search: the key is found "
                    + "after " + compare + " comparison");
                return mid;
            } else if (key.getId() > arr[mid].getId()) {
                low = mid + 1;
            } else if (key.getId() < arr[mid].getId()) {
                high = mid - 1;
            }
        }
        
        System.out.println("Binary Search: the key is found "
                + "after " + compare + " comparison");
        return -1;
    }
    
}

