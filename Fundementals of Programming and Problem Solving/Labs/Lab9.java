/**
 * Jacob Igel
 * Lab9.java
 * Practicing writing methods.
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab9 {
    // main method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        int option;
        
        do {
            menu();  // Displaying the menu
            try {
                option = in.nextInt();
            } catch (InputMismatchException err) {
                in.next();  // clearing the input
                option = 0; // picking zero as a value for the option
            }
            switch (option) {
                case 1:
                    System.out.printf("Enter a single binary code: ");
                    char letter = getLetter(in.next());
                    System.out.printf("The letter is: %s\n", letter);
                    break;
                case 2:
                    System.out.printf("Enter binary codes: ");
                    String word = getWord(in.next());
                    System.out.printf("The word is: %s\n", word);
                    break;
                case 3:
                    System.out.printf("End!\n");
                    break;
                default:
                    System.out.printf("Invalid Input!\n");
            }
        } while (option != 3);
    }
    
    /*
     * Prints a menu with options on the display.
     */
    private static void menu() {
        System.out.printf("\n**Binary Code Translator v 1.0**\n");
        System.out.printf("1. Translate a binary code into a letter\n");
        System.out.printf("2. Translate binary codes into a word\n");
        System.out.printf("3. Exit\nEnter a number [1-3]: ");
    }
    
    // TODO
    // ADD getLetter and getWord methods here 
    
    // getLetter
    public static char getLetter(String letter) {
    
        //initialize sum so we can turn that number into ASCII
        int sum = 0; 
         
        for (int i = 7, j = 0; i >= 0; i--, j++) {
        
            if (letter.charAt(j) == '1') {
                sum += Math.pow(2, i); 
            } 
            
        } 
        return (char) sum; // Cast int sum to a Char for ASCII  
    }

    //getWord
    public static String getWord(String word) {
    
        int sum = 0;
        String result = "";
        
        for (int i = 0; i < word.length(); i += 8) {
            char letter = getLetter(word.substring(i, i + 8));
            result += letter; // Add each letter to result in a word
            
        }
        return result;
    }

}