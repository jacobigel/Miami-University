/*
 * Jacob Igel
 * Assignment4.java
 * Loading a list, printing the list, using sorting
 * algorithms to then sort and print the list.
*/
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Assignment4 {
    static Scanner in = new Scanner(System.in); // global scanner object
    private static boolean loadedIn = false; 
    // this is a check if data has been loaded in
    private static boolean isSorted = false;
    // this is a check if array list has been sorted
    private static ArrayList<Customer> custList = new ArrayList<Customer>();
    private static ArrayList<Customer> custUnsort = new ArrayList<Customer>();
    
    
    private static void menu() {
        System.out.printf("1. Load from a file\n");
        System.out.printf("2. Print the loaded list\n");
        System.out.printf("3. Sort the list based on the nicknames\n");
        System.out.printf("4. sort the list based on the ids\n");
        System.out.printf("5. Print the sorted list\n");
        System.out.printf("6. Exit\nEnter a number [1-6]: ");
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        int option;
        do {
            menu();  // Displaying the menu
            option = in.nextInt();
            if (option != 1 &&  loadedIn == false) {
                System.out.println("No data has been loaded yet!\n");
            }
            switch (option) {
                case 1: // load from a file
                    loadFile();
                    break;
                case 2: // print the loaded list
                    printList();
                    break;
                case 3: // sort list on nicknames
                    sort1(custList);
                    break;
                case 4: // Sort list on ids
                    sort2(custList);
                    break;
                case 5: // Print sorted list
                    printSort();
                    break;
                case 6: // end
                    System.out.println("End!");
                    break;
                default:
                    break;
            } 
        } while (option != 6);      
    } // main
    
    public static void loadFile() throws FileNotFoundException {
        custList = new ArrayList<Customer>();
        custUnsort = new ArrayList<Customer>();
        
        System.out.println();
        
        System.out.print("Enter the name of the file: ");
        String inputFileName = in.next();
        Scanner fileInput = new Scanner(new File(inputFileName));
        
        while (fileInput.hasNext()) {
            String custName = fileInput.next();
            long custId = fileInput.nextLong();
            custList.add(new Customer(custName, custId));
        }
        
        loadedIn = true;
        isSorted = false;
        System.out.print("Loading from the file is done!\n");
        
        System.out.println();
        
        custUnsort = new ArrayList<Customer>(custList);
    }
    
    public static void printList() { // option 2
        String cont = "";
        if (loadedIn == true) {
            System.out.println();
            System.out.println("**** Printing the list ****");
            int temp = 0;
            int i = 0;
            do {
                for (i = 0; i < 10 && temp + i < custUnsort.size(); i++) {
                    System.out.println((i + temp + 1) 
                         + ". " + custUnsort.get(i + temp));
                }
                temp += 10;
                i = 0;
                
                
                if (temp > custUnsort.size()) {
                    break;
                }
                
                System.out.print("Enter something to "
                    + "continue/enter s to stop: ");
                cont = in.next();
                   
               
            } while (!(cont.equals("s")));
            System.out.println();
        }

        

    }    
        
    // @param ArrayList<Customer> custList 
    // - returns the sorted array list by nickname
    public static void sort1(ArrayList<Customer> custList) { // option 3
        boolean madeSwap;
        if (loadedIn == true) {
            do {
                madeSwap = false;
                for (int i = 0; i < custList.size() - 1; i++) {
                    // compare side by side elements
                    if (custList.get(i).getName()
                        .compareTo(custList.get(i + 1).getName()) > 0) {
                        Customer temp = custList.get(i);
                        custList.set(i, custList.get(i + 1));
                        custList.set(i + 1, temp);
                        madeSwap = true;
                    } 
                }
                
                
            } while (madeSwap); 
            System.out.println("Sorting is done!");
            System.out.println();
            isSorted = true;
            
        } 

    }
    

    // @param ArrayList<Customer> custList 
    // - returns the sorted array list by id
    public static void sort2(ArrayList<Customer> custList) { // option 4
        boolean madeSwap;
        if (loadedIn == true) {
            do {
                madeSwap = false;
                for (int i = 0; i < custList.size() - 1; i++) {
                    // compare side by side elements
                    if (custList.get(i).getId() > custList.get(i + 1).getId()) {
                        Customer temp = custList.get(i);
                        custList.set(i, custList.get(i + 1));
                        custList.set(i + 1, temp);
                        madeSwap = true;
                    } 
                }
                
            } while (madeSwap); 
            System.out.println("Sorting is done!");
            System.out.println();
            isSorted = true;
        
        }

    }
    
    
    public static void printSort() { // option 5
        if (isSorted == true && loadedIn == true) {
            String cont = "";
            System.out.println();
            System.out.println("**** Printing the list ****");
            int temp = 0;
            int i = 0;
            do {
                for (i = 0; i < 10 && temp + i < custList.size(); i++) {
                    System.out.println((i + temp + 1) 
                        + ". " + custList.get(i + temp));
                }
                temp += 10;
                i = 0;
                if (temp > custList.size()) {
                    break;
                }
                System.out.print("Enter something to "
                    + "continue/enter s to stop: ");
                cont = in.next();
                   
               
            } while (!(cont.equals("s")));

            System.out.println();

        
        } else if (isSorted == false && loadedIn == true) {
            System.out.println("Nothing is sorted yet!");
            System.out.println();
        }
        
    }    


}
