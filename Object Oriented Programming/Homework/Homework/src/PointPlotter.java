
/**
 * A program that displays a set of points on the screen
 * and permits the user to perform some operations with
 * the points.
 * 
 * @author DJ Rao
 * @version 0.1
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class PointPlotter {
    /**
     * A simple string that contains the prompt for the menu used in this
     * program.
     */
    private static final String Menu = "\nWhat to do next:\n"
            + "1. Show all points\n"
            + "2. Find point with given distance from (0,0)\n" + "3. Quit\n"
            + "Enter choice: ";

    /**
     * A simple prompt to obtain distance input from the user.
     */
    private static final String DistPrompt = "Find a point with what "
            + "distance from origin? ";

    /**
     * A helper method to display a menu, obtain input from the user, and
     * perform the appropriate operation by calling helper methods in the
     * PointProcessor.java class.
     * 
     * @param ptList The list of points to be used by this method.
     */
    private static void menu(final ArrayList<Point> ptList, Scanner in) {
        for (int menu = 0; menu != 3;) {
            System.out.print(Menu);
            menu = in.nextInt();
            switch (menu) {
            case 1:
                PointProcessor.showAllPoints(ptList);
                break;

            case 2:
                System.out.print(DistPrompt);
                final int dist = in.nextInt();
                ArrayList<Point> distList = PointProcessor.findAll(ptList,
                        dist);
                PointProcessor.showAllPoints(distList);
                break;
            default:
                // Do nothing
            }
        }

    }

    /**
     * The main method that runs the point plotter program to permit the user to
     * process points from a text file.
     * 
     * @param args The command-line arguments are not really used.
     * 
     * @throws Exception This method just exposes exceptions that could be
     *                   thrown by helper methods.
     */
    public static void main(String[] args) throws Exception {
        // First load the list of points from a given data file.
        System.out.print("Enter points text file name: ");
        String fileName; // file name read from user
        try (Scanner in = new Scanner(System.in)) {
            fileName = in.next();
            
           
            // Use helper method to load points.
            final ArrayList<Point> ptList = PointProcessor
                    .readPointsFromFile(fileName);
            // Print the information loaded for now.
            System.out.printf("Loaded %d points from %s\n", ptList.size(),
                    fileName);
            // Next run the menu loop to let the user perform different
            // operations
            menu(ptList, in);
            
        }
    }
}
