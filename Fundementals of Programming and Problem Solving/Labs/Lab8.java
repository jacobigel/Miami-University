/*
 * Jacob Igel
 * Section: D
 * Oct 2021
 * Lab8.java
 * We are using nested loops to get an int value from the user and then
 * generate an output that prints a square of the users number and 
 * prints a O is the number of the rows is divisible by the number of columns
 * and prints an X where the number of the rows is not divisible by the number
 * of the columns.
 */
import java.util.Scanner;
import java.util.InputMismatchException;


public class Lab8 {
    public static void main(String[] args) throws InputMismatchException {
        Scanner keyboardReader = new Scanner(System.in);
        
        int i;
        int j;
        String askToRepeat = "";
        int userNum = 0;  
        
        do {
            // this will print the row/column X and O's
            
            System.out.print("Enter an int number: ");
            
            boolean invalidInput = false;

            try { 
                userNum = keyboardReader.nextInt();
                
                
                if (userNum <= 0) {
                    throw new IllegalArgumentException();
                }

            
                for (i = 1; i <= userNum; i++) {
         
                    for (j = 1; j <= userNum; j++) {
                        if (i % j == 0) {
                            System.out.print("O");
                        } else {
                            System.out.print("X");
                        }
                    
                    }
                    System.out.print("\n");
                
                }
                
            } catch (InputMismatchException error) {
                System.out.println("Invalid Input!");
                String dummy = keyboardReader.next();
                invalidInput = true;
                // will catch anything that is not an int value
                
            } catch (IllegalArgumentException error) {
                // will throw if the int num is less than zero
                System.out.println("No result with an input less than or " 
                    + "equal to zero!");
                
            
            }
            
            // we have this do while to ask if they want to repeat
            
            askToRepeat = "y";
            
            if (!invalidInput) {
            
                do {
                    System.out.print("Do you want to repeat (y/n)? ");
                    askToRepeat = keyboardReader.next();
                    
                    
                    // if they do not want to repeat, we end the loop
                    if (askToRepeat.equals("n") || askToRepeat.equals("N")) {
                        System.out.print("End\n");
                        break;
                    
                    }             
                // this repeats the loop if they do not enter Y, y, N, or n 
                } while ((!askToRepeat.equals("n") && !askToRepeat.equals("N") 
                    && !askToRepeat.equals("y") && !askToRepeat.equals("Y")));
            }
        
        } while (askToRepeat.equals("y") || askToRepeat.equals("Y"));

       
    }
}

