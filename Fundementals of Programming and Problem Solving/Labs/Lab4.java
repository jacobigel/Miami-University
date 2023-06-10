// Jacob Igel
// CSE 174, Section D
// Date: 09/17/2021
// Description: In this lab we are getting inputted data from the user
//              then we are reading data in from a file, and then lastly
//              we are putting all of that data in a brand new file.

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class Lab4 {
    public static void main(String[] args) throws FileNotFoundException {
    
        Scanner keyboardReader = new Scanner(System.in);
    
        // First, we need to gather some information from the user
        // We are asking for first and last name, hours of sleep,
        // and number of classes
        System.out.printf("Enter your first and last name: ");
        String firstName = keyboardReader.next();
        String lastName = keyboardReader.next();
        String fullName = firstName + " " + lastName;
        
        System.out.printf("Enter your time spent sleeping each night"
            + " (in hours): ");
        double hoursOfSleep = keyboardReader.nextDouble();
        
        System.out.printf("Enter your number of classes: ");
        int numClasses = keyboardReader.nextInt();
        
        double freeTime = (double) 
            (120 - (hoursOfSleep * 5 + numClasses * 8.72));
        
        // Now we are going to take the values that were inputted
        // and we will put it in a neat display
        System.out.printf(" %s", "_".repeat(44));
        
        System.out.printf("\n|%-20s|%-12s|%-10s|",
             "Name", "Num Classes", "Free Time");
        System.out.printf("\n|............................................|");
        System.out.printf("\n|%-20s|%-12d|%-10.1f|\n",
             fullName, numClasses, freeTime);
        
        System.out.printf(" %s", "-".repeat(44));
        
        // Now we want the user to enter a filename
        // so we can retrieve values from it
        System.out.printf("\nEnter an input filename: ");
        String inputFileName = keyboardReader.next();
        Scanner fileInput = new Scanner(new File(inputFileName));
        
        // This will give us the variables from inside of the file
        // hence hoursOfSleepFile, etc.
        String firstNameFile = fileInput.next();
        String lastNameFile = fileInput.next();
        String fullNameFile = firstNameFile + " " + lastNameFile;
        
        double hoursOfSleepFile = fileInput.nextDouble();
        
        int numClassesFile = fileInput.nextInt();
        
        double freeTimeFile = (double) (120 - (hoursOfSleepFile * 5 
            + numClassesFile * 8.72));
        
        System.out.printf(" %s", "_".repeat(44));
        
        System.out.printf("\n|%-20s|%-12s|%-10s|",
             "Name", "Num Classes", "Free Time");
        System.out.printf("\n|............................................|");
        System.out.printf("\n|%-20s|%-12d|%-10.1f|\n",
             fullNameFile, numClassesFile, freeTimeFile);
        
        System.out.printf(" %s", "-".repeat(44));
        fileInput.close();
        
        // Now we will put all of this information in a new file that
        // the user will name
        
        System.out.printf("\nEnter an output filename: ");
        String outputFileName = keyboardReader.next();
        PrintWriter out = new PrintWriter(new File(outputFileName));
        
        out.printf(" %s", "_".repeat(44));
        
        out.printf("\n|%-20s|%-12s|%-10s|",
             "Name", "Num Classes", "Free Time");
        out.printf("\n|............................................|");

        out.printf("\n|%-20s|%-12d|%-10.1f|",
             fullName, numClasses, freeTime);
        out.printf("\n|............................................|");
        
        out.printf("\n|%-20s|%-12d|%-10.1f|\n",
             fullNameFile, numClassesFile, freeTimeFile);
        
        out.printf(" %s", "-".repeat(44));
        out.close();
 
 
    }
}
