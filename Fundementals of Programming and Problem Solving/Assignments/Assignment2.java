/*
 * Jacob Igel
 * Section: D
 * Oct 2021
 * Assignment2.java
 * We are getting a name of file from a user, reading that file to only get
 * the words written inside that file and print it to the system. After that
 * we will give the option to print that to a file that the user chooses.
*/
import java.util.Scanner;  // importing Scanner class
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Assignment2 {
    public static void main(String[] args) throws FileNotFoundException {
    
        Scanner keyboardReader = new Scanner(System.in);
        
        // Getting the file name from the user
        System.out.print("Enter an input file name: ");
        String inputFileName = keyboardReader.next();
        Scanner fileInput = new Scanner(new File(inputFileName));
        
        
        while (fileInput.hasNext()) {
            
            //String insideFile = fileInput.next();
            
            if (fileInput.hasNextInt()) {
    
                int fileNumber = fileInput.nextInt();
                
                for (int i = 0; i < fileNumber; i++) {
                    System.out.print(fileInput.next());  

                }
                
                if (fileInput.hasNextInt()) {
                   
                    System.out.print(" ");
                }
                
               
                
            } else { // check to see if there is a pound symbol
                System.out.print("\n");
                fileInput.next();
            }
            
            
        }
        
        System.out.println();

        // This is where we ask the user if they want to print what is in the
        // file into a separate output file
        
        String askToPrint = "";
        
        while (!(askToPrint.equals("y") || askToPrint.equals("n"))) {
            System.out.printf("**Do you want to print in a file (y/n): ");
            
            askToPrint = keyboardReader.next();
            
            if (!(askToPrint.equals("y") || askToPrint.equals("n"))) {
                System.out.println();
            
            }

        }
        
        // if the user puts a "y" then it will print everything that it 
        // did to the system to a file
        
        if (askToPrint.equals("y")) {
            System.out.printf("Enter an output file name: ");
            String outputFileName = keyboardReader.next();
            PrintWriter out = new PrintWriter(new File(outputFileName));
            fileInput = new Scanner(new File(inputFileName));


            while (fileInput.hasNext()) {
            
                if (fileInput.hasNextInt()) {
                    
                    int fileNumber = fileInput.nextInt();
                    
                    for (int i = 0; i < fileNumber; i++) {
                        out.print(fileInput.next());
                        
                   
                    }
                    
                    out.print(" ");
                   
                    
                } else { // check to see if there is a pound symbol
                    out.print("\n");
                    fileInput.next();
                }
                
            }

            out.close();
            System.out.println("Printed inside the " + outputFileName
                + " successfully!"); 
            
        } else {
            System.out.print("");
        
        }


        System.out.print("End!\n");   
        
        fileInput.close();    
    }
}