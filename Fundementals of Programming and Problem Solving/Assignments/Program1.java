/**
 * Jacob Igel
 * Section: D
 * Sep 2021
 * Program1.java
 * This program decodes the digits.
 */
import java.util.Scanner;  // importing Scanner class

public class Program1 {
    public static void main(String[] args) {
        // Defining a Scanner object
        Scanner in = new Scanner(System.in);
        
        // Prompting the user with a message
        System.out.print("Enter a 10 digit phone number (e.g. 5131234567): ");
        
        // Saving the given number inside a constant variable
        final long PHONE_NUM = in.nextLong();
        
        // This splits up the users inserted phone number
        int areaCode = (int) (PHONE_NUM / 10000000);
        int centralCode = (int) (PHONE_NUM / 10000 % 1000);
        int stationNumber = (int) (PHONE_NUM % 10000);
        
        // This outputs a cleaner version of the users phone number
        System.out.println("(" + areaCode + ")" + " " + centralCode + " " + "-" 
            + " " + stationNumber);
        
        // This converts the pairs of station numbers into their ASCII code
        char stationNumber1 =  (char) ((stationNumber / 100) + 33);
        char stationNumber2 =  (char) ((stationNumber % 100) + 33);

        
        // This prints the phone number but replaces the station number
        // with the pairs respective ASCII codes
        System.out.println("(" + areaCode + ")" + " " + centralCode + " " + "-" 
            + " " + stationNumber2 + stationNumber1);
            
        // This gets the max possible value in java with combining
        // the area and central codes   
        int combinedCodes = Integer.MAX_VALUE - ((areaCode * 1000)
             + centralCode);
        System.out.println(combinedCodes); 
        
        
        // This outputs the new max value with the ASCII codes
        // from the station code surrounding it
        System.out.println("" + stationNumber2 + combinedCodes 
            + stationNumber1);

    }
}
