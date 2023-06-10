import java.util.Scanner;

/**
 * A java program to determine if what the user
 * entered is an int, double or string
 * 
 * @author igeljj
 *
 */
public class Numero {
    /**
     * This is a program to determine if the user entered an int,
     * double, or string
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String wordtype = "String";
            System.out.println("Enter a word or a number: ");
            String word = in.next();
            try {
                Integer.parseInt(word);
                wordtype = "int";
            } catch (NumberFormatException nfe) {
            }
            if (!wordtype.equals("int")) {
                try {
                    Double.parseDouble(word);
                    wordtype = "double";
                } catch (NumberFormatException nfe) {

                }
            }
            System.out.println(word + " is a " + wordtype);
        }
    }
}
