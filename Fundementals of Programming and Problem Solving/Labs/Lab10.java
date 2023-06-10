/**
 * Jacob Igel
 * Lab10.java
 * Practicing writing methods that will help format names.
 */

// import the scanner class to get the user information 
import java.util.Scanner;

public class Lab10 {
    static Scanner in = new Scanner(System.in); // global variable 
    
    // first only
    public static String formatName(String fname) {
        return String.format("%-8s", fname);
    }
    
    // first and last
    public static String formatName(String fname, String lname) {
        return String.format("%-8s %-8s", fname, lname);
    }
    
    // first, middle initial, last
    public static String formatName(String fname, char mint, String lname) {
        return String.format("%-8s %-8s %-8s", fname, mint + ".", lname);
    }
    
    // first, middle, last
    public static String formatName(String fname, String mname, String lname) {
        return String.format("%-8s %-8s %-8s", fname, mname, lname);
    }
    
    // a menu for our main method
    public static void menu() {

        System.out.printf("Select an Option!\n");
        System.out.printf("1. Only First Name\n");
        System.out.printf("2. First Name, and Last Name\n");
        System.out.printf("3. First Name, Middle Initial, and Last Name\n");
        System.out.printf("4. First Name, Middle Name, and Last Name\n");
        System.out.printf("5. Exit\n");
    }
    
    // main method can only have 35 lines total
    public static void main(String[] args) {
        int option;
        System.out.printf("Welcome to the Name Formatter\n");
        do {
            menu();  // Displaying the menu
            option = in.nextInt();
            if (option != 5) {
                System.out.printf("Please enter the " 
                    + "name parts separated by a space: ");
            }
            switch (option) {
                case 1: // first only
                    System.out.println(formatName(in.next()));
                    break;
                case 2: // first and last
                    System.out.println(formatName(in.next(), in.next()));
                    break;
                case 3: // first, middle initial, last
                    System.out.println(formatName(in.next(),
                         in.next().charAt(0), in.next()));
                    break;
                case 4: // first, middle, last
                    System.out.println(formatName(in.next(),
                         in.next(), in.next()));
                    break;
                case 5: // end
                    System.out.printf("Thank You for using the " 
                        + "Name Formatter!\n");
                    break;
                default:
                    break;
            } 
        } while (option != 5);
            
    }
   
}
