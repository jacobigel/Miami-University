// Jacob Igel
// CSE 174, Section D
// Date: 08/27/2021
// Description : Practice with writing, saving,
//               and compiling code. Plays a game of 
//               "Guess my number" with the user.

import java.util.Scanner; //Needed for user input

public class FirstProgram { 

   public static void main(String[] args) {
      // Declare local vairables
      String first, last;
      int correctNumber, guess, guessCount;
      int triangleSize;
      Scanner keyboardReader = new Scanner(System.in);
      
      // Get user's first and last name
      System.out.print("What is your first and last name? ");
      first = keyboardReader.next();
      last = keyboardReader.next();
      
      // Display border and greeting
      drawBorder(50);
      welcome(first + " " + last);
      drawBorder(50);
      
      // Explain the rules
      gameRules(first);
      
      // Start the game with a random number
      correctNumber = (int)(1 + 100 * Math.random());
      guessCount = 0;
      
      // Get first guess
      guessCount++;
      System.out.print("Enter guess #" + guessCount + ": ");
      guess = keyboardReader.nextInt();
      
      // Loop until guess is correct
      while (guess != correctNumber) {
         
         // Higher or lower?
         if (guess < correctNumber) {
            System.out.println("Guess higher.");
         }
         else {
            System.out.println("Guess lower.");
         }
         
         // Get next guess
         guessCount++;
         System.out.print("Enter guess #" + guessCount + ": ");
         guess = keyboardReader.nextInt();
      } // end loop
      
      // By the time we get here, the user has guess the correct
      //number. Print the results
      System.out.println("Congratulations, " + first + ".");
      System.out.println("You got it in " + guessCount + " guesses.");
      
      if (guessCount <=10) {
         System.out.println("You are an excellent guesser. :)");
      }
      else {
         System.out.println("Try harder next time. :(");
      }
      
      //Display some art
      System.out.println();
      System.out.println("And now, some stars to make you happy!");
      System.out.print("How many stars do you want? ");
      triangleSize = keyboardReader.nextInt(); 
      
      
      
      //triangleSize = 7;
      for (int length = triangleSize; length >= 1; length --) {
         drawBorder(length);
      }
      
      System.out.println("Goodbye!");
      
   }  // end main
      
   // Prints a personalized welcome message to the user
   public static void welcome(String name) {
      System.out.println("Welcome, " + name + ".");
      System.out.println("This is my first CSE 174 programming assignment.");
      System.out.println("Let's play \"Guess My Number\"");
   } // end welcome
   
   // Explains the rules of the game
   public static void gameRules(String name) {
      System.out.println("Are you ready to play a game, " + name + "?");
      System.out.println("I will think of a  number between 1 and 100.");
      System.out.println("Try to guess it in 10 or fewer tries.");
   } // end gameRules
   
   // Draws a border made of asterisks
   public static void drawBorder(int length) {
      for (int i = 0; i < length; i++) {
         System.out.print("*");
      }
      System.out.println(); // moves to the next line
   } // end drawBorder
   
} // end class

