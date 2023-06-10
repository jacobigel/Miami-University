import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * A class to test the process of reading the n'th number from
 * a given text file.
 * 
 * @note Each line in the text file is assumed to be exactly 
 *     9 characters long and each line is assumed to contain an integer
 *     (stored as a string).
 * 
 * @author raodm
 *
 */
public class NumberReader {
    /**
     * Each line in the text file is assumed to be exactly 
     * 9 characters long and each line is assumed to contain an integer
     * (stored as a string).
     */
    private static final int LINE_LEN = 9;

    /**
     * Method to use a RandomAccessFile to read a given number. This
     * method operates as follows:
     *    - It uses the seek method to jump to a given offset in the
     *      data file based on the assumption that each line is 
     *      LINE_LEN long.
     *    - Read the line and converts it to an integer
     *    
     * @param fileName The fixed-length file from where lines are to be read.
     * @param n The n'th value to be read.
     * @return The n'th value read from the file.
     * @throws IOException This method throws exceptions on I/O errors.
     */
    public static int getNthIntRandom(String fileName, int n) 
            throws IOException {
        // Use a try-block to automatically close the file.
        try (RandomAccessFile raf = 
                new RandomAccessFile(fileName, "r")) {
            // Jump to the desired offset in the file: O(1)
            raf.seek(n * LINE_LEN);
            // Read a fixed size line: T(9) => O(1)
            String value = raf.readLine().trim();
            // Return the data read: T(9) => O(1)
            return Integer.parseInt(value);
        }
    }
 
    /**
     * Method that uses a Scanner and reads n-1 values to get to the
     * n'th value.
     * 
     * @param fileName he fixed-length file from where lines are to be read.
     * @param n The n'th value to be read.
     * @return The n'th value read from the file.
     * @throws IOException This method throws exceptions on I/O errors.
     */
    public static int getNthIntRegular(String fileName, int n) 
            throws IOException {
        Scanner in = new Scanner(new File("fixed_size_nums.txt"));
        for (int i = 0; (i < n); i++) {
            in.nextInt();
        }
        return in.nextInt();    
    }

    /**
     * The name of the text file (with fixed size lines).
     */
    private static final String FILE_NAME = "fixed_size_nums.txt";
    
    /**
     * The main method that time's the call to the above I/O methods
     * to estimate their runtimes for different inputs.
     * 
     * @param args Command-line arguments are ignored.
     * 
     * @throws Exception The main method does not handle any exceptions
     *     and simply exposes them.
     */
    public static void main(String[] args) throws Exception {
        // Get the n'th number to be read from the user.
        System.out.println("Enter n'th number to read: ");
        int n = 0;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }
        
        // Measure the time taken by the random-access method.
        long startTimeRnd = System.currentTimeMillis();
        int n1 = getNthIntRandom(FILE_NAME, n);
        long rndTime = System.currentTimeMillis() - startTimeRnd;
        
        // Measure the time taken by the sequential-access method.
        long startTimeReg = System.currentTimeMillis();
        int n2 = getNthIntRegular(FILE_NAME, n);
        long regTime = System.currentTimeMillis() - startTimeReg;
        
        // Print the measured times for recording.
        System.out.println("Random read time:  " + rndTime 
                + " milliseconds. Value: " + n1);
        System.out.println("Sequential read time: " + regTime
                + " milliseconds. Value: " + n2);
    }
}
