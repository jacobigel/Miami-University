import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class that enables a user to play a game involving guessing an English word
 * randomly chosen by the computer. This class does not actually provide any
 * interaction with the user. That task is handled by a different class to be
 * developed by the students as part of this project. The special feature of
 * this class is that its interactions are solely based on exceptions. So it is
 * the responsibility of the calling method(s) to suitably interpret the
 * exceptions thrown by the methods in this class.
 * 
 * @author raodm
 *
 */
public class WordThrow {
    /**
     * This string contains the SECRET word to be guessed by the player by
     * calling different method(s) in this class.
     */
    private final String SECRET;
    
    /**
     * Instance variable to track the number of calls to the guess methods
     * in this class. The number of calls is to be reported by the GameConsole
     * just before it quits.
     */
    private int numCalls = 0;
    
    /**
     * The constructor is intentionally private to ensure that this class is
     * instantiated only from the main method in this class. The constructor
     * initializes the SECRET word from a dictionary of words.
     * 
     * @param word An optional word to be used as the SECRET word. Setting the
     *             word directly helps with testing.
     * @throws FileNotFoundException If the "word_list.txt" could not be read.
     */
    private WordThrow(String word) throws FileNotFoundException {
        if (word == null || word.isEmpty()) {
            // A test word has not been specified. Randomly select a word
            // from an English dictionary.
            final int SKIP = 1 + (int) (Math.random() * 6900);
            try (Scanner dict = new Scanner(new File("word_list.txt"))) {
                for (int i = 0; (i < SKIP); i++) {
                    word = dict.next();
                }
            }
        }
        // Use the randomly chosen word or the supplied word (to ease testing).
        SECRET = word;
    }
    
    /**
     * Interface method to detect if a given word matches the SECRET word
     * to be guessed.
     * 
     * @param word The word that the user is guessing.
     * 
     * @throws WordThrow.WordLengthMismatchException If the user's word does not
     *     match the length of the SECRET word.
     * 
     * @throws WordThrow.CorrectWordException If the user's word is exactly the
     *     same as the SECRET word.
     */
    public void guess(final String word)
            throws WordThrow.WordLengthMismatchException,
            WordThrow.CorrectWordException {
        // Track the number of API calls for reporting later on
        numCalls++;
        // Now check the word and throw suitable exceptions.
        if (word == null || word.length() != SECRET.length()) {
            throw new WordLengthMismatchException();
        } else if (word.equals(SECRET)) {
            throw new CorrectWordException();
        }
    }

    /**
     * Make a guess if a character occurs at a given index position.
     * 
     * @param c     The lower case character being guessed.
     * 
     * @throws WordThrow.MatchAndOccursException Thrown when the character
     *         guessed is correct . THe exception's message also
     *         indicates the next index position where the character
     *         occurs again or the index position is set to -1 if the
     *         character does not occur again.
     * 
     * @throws WordThrow.MismatchException Thrown when the character
     *         guessed at the given index position is incorrect.
     */
    public void guess(char c) throws WordThrow.MatchAndOccursException, 
            WordThrow.MismatchException {
        // Track the number of API calls 
        numCalls++;
        // Find the index positions where the character occurs
        String indexPos = "";
        for (int i = 0; (i < SECRET.length()); i++) {
            if (SECRET.charAt(i) == c) {
                indexPos += " " + i;
            }
        }
        // If the indexPos string isn't empty then the character occurs
        // at least once. Report those positions.
        if (!indexPos.isEmpty()) {
            throw new MatchAndOccursException(indexPos.substring(1));
        } else {
            // The character was not a match. 
            throw new MismatchException(c);
        }
    }
    
    /**
     * The main method that sets up a SECRET word and let's the GameConsole play
     * the game.
     * 
     * @param args The command-line arguments. If an argument is specified, then
     *             this method assumes that is the word to be used as the
     *             SECRET. This is useful for testing and troubleshooting
     *             programs.
     * 
     * @throws Exception This method just exposes exceptions that may be thrown
     *                   by the WordThrow constructor.
     */
    public static void main(String[] args) throws Exception {
        // Create a WordThrow game that loads a SECRET word in the constructor.
        WordThrow wt = new WordThrow(args.length > 0 ? args[0] : null);
        // Let the Game console do its play
        GameConsole.play(wt);
        // Print the number of API calls
        System.out.println("The SECRET word was: " + wt.SECRET);
        System.out.println("Number of API calls: " + wt.numCalls);
    }
    
    /**
     * A simple exception that is thrown by the guess method if the guessed
     * word is of different length than the SECRET word.
     */
    public static class WordLengthMismatchException extends Exception {
        // A dummy serialization ID to keep Eclipse happy.
        private static final long serialVersionUID = 1L;     
    }
    
    /**
     * A simple exception that is thrown by the guess method if the guessed
     * word is exactly the same as the SECRET word.
     */
    public static class CorrectWordException extends Exception {
        // A dummy serialization ID to keep Eclipse happy.
        private static final long serialVersionUID = 1L; 
    }
    
    /**
     * A simple exception that is thrown by the guess method if the guessed
     * let is exactly the same as the SECRET word.
     */
    public static class InvalidLetterException extends Exception {
        // A dummy serialization ID to keep Eclipse happy.
        private static final long serialVersionUID = 1L; 
    }
  
    /**
     * A simple exception that is thrown by the guess method if the guessed
     * character at a given index position is a mismatch.
     */
    public static class MismatchException extends Exception {
        /**
         * Constructor to initialize the next occurring index position.
         * 
         * @param c The character guessed by the user which is not present
         * in the SECRET word.
         */
        public MismatchException(char c) {
            super("The character '" + c + "' is not in the word.");
        }
        // A dummy serialization ID to keep Eclipse happy.
        private static final long serialVersionUID = 1L; 
    }
    
    /**
     * A simple exception that is thrown by the guess method if the guessed
     * character matches at a given index position and it also occurs at another
     * index position.
     */
    public static class MatchAndOccursException extends Exception {
        /**
         * Constructor to initialize the next occurring index position.
         * 
         * @param indexPos The index position(s) where the character occurs.
         *     Each index position is separated by a blank space.
         */
        public MatchAndOccursException(String indexPos) {
            super(indexPos);
        }

        // A dummy serialization ID to keep Eclipse happy.
        private static final long serialVersionUID = 1L; 
    }
}
