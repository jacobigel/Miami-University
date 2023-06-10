import java.util.Scanner;

/**
 * A simple program to detect if an input word is an int, double, or 
 * a string.
 * 
 * @author amjadm
 *
 */
public class Numero2 {
    /**
     * Program reads a word, parses it (to int or double), and catches
     * exceptions to detect the word's type. This is a demonstration of
     * how exceptions can be used to develop some "tiral-and-error" type
     * logic in Java programs. 
     * 
     * @param args The command-line arguments are not really used.
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter a word or a number: ");
            String word = in.next();
            // For starters, assume type of word is string.
            String type = "String";
            // To detect if word is an integer, we try to convert
            // it to an integer. If that succeeds (i.e., no exception)
            // then we know it is an integer.
            try {
                Integer.parseInt(word);
                type = "int";
            } catch (NumberFormatException nfe) {
                try {
                    Double.parseDouble(word);
                    type = "double";
                } catch (NumberFormatException err) {
                    // Nothing to be done. word is defenitely a string.
                }
            }

            // Print the word and its deduced type
            System.out.println(word + " is a " + type);
        }
    }
}
