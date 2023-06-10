/**
 * Jacob Igel
 * Section: D
 * Oct 2021
 * Lab6.java
 * Reads grades from a file and transforms them to their respective 
 * letter grade. It will also print the total number of students and 
 * it will print the average total grade
 */
import java.util.Scanner;  // importing Scanner class
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Lab6 {
    public static void main(String[] args) throws FileNotFoundException {
    
        Scanner keyboardReader = new Scanner(System.in);
    
        // Getting the file name from the user
        System.out.printf("Enter a file name: ");
        String inputFileName = keyboardReader.next();
        Scanner fileInput = new Scanner(new File(inputFileName));
    
        // Entering the output file name
        System.out.printf("Enter an output filename: ");
        String outputFileName = keyboardReader.next();
        PrintWriter out = new PrintWriter(new File(outputFileName));
    
        int numStudents = 0;
        int totalGrade = 0;
    
        
        while (fileInput.hasNextLine()) {
        
            fileInput.next(); // this reads the name from the file
            
            int grade = fileInput.nextInt();
            char letterGrade;
            totalGrade += grade;
            numStudents += 1;
    
            
            // Correlating each number grade with its respective letter grade
            
            if (grade >= 90) {
                letterGrade = 'A';
                
            } else if (grade >= 80) {
                letterGrade = 'B';
        
            } else if (grade >= 70) {
                letterGrade = 'C';
            
            } else if (grade >= 60) {
                letterGrade = 'D';
    
            } else {
                letterGrade = 'F';
            }
            out.println(letterGrade);
            
    
        }
        
        
        // This prints the number of students and the average grade
        double avgGrade = (double) totalGrade / numStudents;
        System.out.printf("Number of students: %d", numStudents);
        out.printf("Number of students: %d", numStudents); // print to file
        System.out.printf("\nClass Average: %.2f", avgGrade);
        out.printf("\nClass Average: %.2f", avgGrade); // print to file
    
    
        
        fileInput.close();
        out.close();
    
    }
}