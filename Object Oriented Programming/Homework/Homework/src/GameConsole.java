
/**
 * @author jacobigel
 */

import java.io.File;
import java.util.Scanner;

/**
 * A class that interacts with the user to enable guessing the secret word.
 *
 */
public class GameConsole {

    /**
     * A simple string to generate initial word with a bunch of stars. This
     * string is setup on the assumption on the longest possible word.
     */
    private static final String STARS = "******************************";

    /**
     * The prompt string used to prompt the user for input. The prompt string
     * can be used as: System.out.printf(InputPrompt, currWord);
     */
    private static final String INPUT_PROMPT = "Word so far: %s%n"
            + "Enter a word or a letter [*: quit, +: AI, ?: hint]: ";

    /**
     * A simple message that is printed whenever the user guesses a character
     * correctly. This string is used as: System.out.printf(MatchMessage, c,
     * e.getMessage());
     */
    private static final String MATCH_MESSAGE = "You guessed a character "
            + "correctly!%nThe character '%c' occurs at index position(s) %s%n";
    /**
     * A private static variable that is used to track the characters that have
     * been guessed by the user so far. This word is initialized to a bunch of
     * stars and as the user guesses characters, the corresponding characters
     * are filled-in until the whole word is guessed.
     */
    private static String currWord;

    /**
     * The top-level method that is invoked by WordThrow class to enable the
     * user to use different operations to guess the secret word. This method is
     * expected to prompt the user for input and perform the necessary
     * operations based on user-input. This method essentially uses a set of
     * helper methods to accomplish the necessary functionality.
     * 
     * @param wt The word throw object to be used by this method.
     */

    /**
     * Reader in from the system.
     */
    private static Scanner in = new Scanner(System.in);

    /**
     * To get the 'congrats' message out.
     */
    private static final String CONGRATS = ("You guessed the word!"
            + " Congratulations!\n");

    /**
     * The entire alphabet.
     */
    private static String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Transforms the secret word to the same length as the stars.
     * 
     * @param c    - gets the character from the user
     * @param info - gets the point information
     */
    public static void toStar(char c, String info) {
        Scanner in = new Scanner(info);
        while (in.hasNext()) {
            int indexPoint = in.nextInt();
            String newWord = "";
            for (int i = 0; i < currWord.length(); i++) {
                if (i == indexPoint) {
                    newWord += c;
                } else {
                    newWord += currWord.charAt(i);

                }
            }
            currWord = newWord;
        }
        in.close();
    }

    /**
     * Gets the length of the word from the file.
     * 
     * @param wt - from Word Throw
     * @throws WordThrow.WordLengthMismatchException - sees if the length is the
     *                                               same
     * @throws WordThrow.CorrectWordException        - sees if its the correct
     *                                               word
     */
    public static void getLength(WordThrow wt)
            throws WordThrow.WordLengthMismatchException,
            WordThrow.CorrectWordException {
        String starLen = "";
        for (int i = 0; i <= STARS.length(); i++) {
            starLen += "*";
            try {
                wt.guess(starLen);
                currWord = starLen;
                break;
            } catch (WordThrow.WordLengthMismatchException wlMismatch) {
                continue;
            } catch (WordThrow.CorrectWordException c) {
                continue;
            }
        }
        System.out.println("Guess the " + currWord.length()
                + " character word.");
    }

    /**
     * This method will show the input prompt and then will read what the user
     * enters.
     * 
     * @return - returns a string of what the user entered
     */
    private static String getInput() {
        System.out.printf(INPUT_PROMPT, currWord);
        return in.next();

    }

    /**
     * This method is to see if there is a match, if there is then there will be
     * a message that will be displayed.
     * 
     * @param input - the user input
     * @param match - checking if there is a match
     */
    private static void phase1(char input,
            WordThrow.MatchAndOccursException match) {
        System.out.printf(MATCH_MESSAGE, input,
                match.getMessage());
        toStar(input, match.getMessage());
    }

    /**
     * This will print the alphabet after the user enters a question mark. This
     * will show all of the guesses split by hyphens.
     */
    private static void hint() {
        System.out.println("Letters left to guess: " + alpha);
    }

    /**
     * This method gives us the ability to process an entire word guess instead
     * of just a letter.
     * 
     * @param word - word entered from user
     * @param wt   - from the word throw java class
     */
    private static boolean processWord(String word, WordThrow wt) {
        try {
            wt.guess(word);
            System.out.println("Good try, but you "
                    + "guessed wrong.");
        } catch (WordThrow.WordLengthMismatchException mismatch) {
            System.out.println("Your "
                    + "guessed word did not have same length.");
        } catch (WordThrow.CorrectWordException correct) {
            System.out.println("You guessed "
                    + "the word! Congratulations!");
            return true;
        }
        return false;
    }

    /**
     * This will return a correct character for the user.
     * 
     * @param wt - from the word throw java class
     */
    private static void ai(WordThrow wt) {
        while (currWord.contains("*")) {
            for (int j = 0; j < alpha.length(); j++) {
                if (alpha.charAt(j) != '-') {
                    if (processChar(alpha.charAt(j), wt)) {
                        return;
                    }

                }
            }

        }
    }

    /**
     * This method will process characters inputed by the user.
     * 
     * @param c  - character entered by user
     * @param wt - from the word throw java class
     * @return - will return T/F to know when the play method should quit
     */

    private static boolean processChar(char c, WordThrow wt) {
        if (c == '?') {
            hint();
        } else if (c == '+') {
            ai(wt);
            return true;
        } else if (c == '*') {
            return true;
        } else {
            try {
                wt.guess(c);
            } catch (WordThrow.MatchAndOccursException match) {
                phase1(c, match);
                if (!currWord.contains("*")) {
                    System.out.print(CONGRATS);
                    return true;
                }
            } catch (WordThrow.MismatchException mismatch) {
                System.out.println(mismatch.getMessage());
            } finally {
                alpha = alpha.replace(c, '-'); // for hint method
            }
        }
        return false;
    }

    /**
     * Plays the game and goes through how it works. The "main" method of this
     * class.
     * 
     * @param wt - from Word Throw
     * @throws WordThrow.WordLengthMismatchException - sees if the length is the
     *                                               same
     * @throws WordThrow.CorrectWordException        - sees if its the correct
     *                                               word
     */
    public static void play(WordThrow wt)
            throws WordThrow.WordLengthMismatchException,
            WordThrow.CorrectWordException {
        getLength(wt);
        String input;
        boolean quit = false;
        while (!quit) {
            input = getInput();
            if (input.length() > 1) {
                if (processWord(input, wt)) {
                    quit = true;
                }
            } else {
                quit = processChar(input.charAt(0), wt);
            }

        }
    }
}
