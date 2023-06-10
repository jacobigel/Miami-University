/**
 * @author Jacob Igel
 * igeljj@miamioh.edu
 * CSE 271 - D
 */

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is an helper class that is used to perform different operations
 * using a list of points.
 *
 */

public class PointProcessor {

    /** 
     * This method reads the points from a file and separates them into x and
     * y respectively. This method then puts those points into an point object,
     * and then subsequentially an array .
     * @param fileName - file with the points.
     * @return - array with all of the points inside of it.
     * @throws FileNotFoundException - will throw error if file is not found
     */
    public static ArrayList<Point> readPointsFromFile(final String fileName)
            throws FileNotFoundException {
        ArrayList<Point> arr = new ArrayList<Point>();
        try {
            // create a file reader
            Scanner fileReader = new Scanner(new File(fileName));
            while (fileReader.hasNext()) {
                // creating the x & y coordinates for the point object
                int x = fileReader.nextInt();
                int y = fileReader.nextInt();
                Point list = new Point(x, y);
                arr.add(list);               
            }
            //close the file reader
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return arr;

    } 

    /**
     * This method gets the method between two points and finds
     * the distance between them.
     * @param pt - an x and y coordinate
     * @return - the absolute value of the point in the array
     */
    public static int cabDistance(final Point pt) {
        return Math.abs(pt.y) + Math.abs(pt.x);
    }

    /**
     *  This method shows the point with the cabDistance separated
     *  by a tab character.
     * @param pt - the x and y coordinate.
     */
    public static void showPoint(final Point pt) {
        System.out.printf("(%d, %d)\t%d\n",pt.x,pt.y,cabDistance(pt));
    }

    /**
     * This method takes the previous method and instead of
     * only showing one point shows all of the points in the array.
     * @param ptList - the entire list of points in the array.
     */
    public static void showAllPoints(final ArrayList<Point> ptList) {
        if (ptList.size() == 0) {
            System.out.print("Empty list\n");
        } else {
            for (int i = 0; i < ptList.size(); i++) {
                System.out.printf("[%d] ",i);
                showPoint(ptList.get(i));   
            }
        }

    }
    /**
     *  This method finds all of the points which distance 
     *  matches the user entered distance.
     * @param ptList - the entire list of points in the array.
     * @param dist - the distance between two points.
     * @return - the array of points that match the user entered distance.
     */
    
    public static ArrayList<Point> findAll(final ArrayList<Point> ptList, 
            int dist) {
        ArrayList<Point> arr = new ArrayList<Point>();
        for (int i = 0; i < ptList.size(); i++) {
            if (dist == cabDistance(ptList.get(i))) {
                arr.add(ptList.get(i));
            }  
        }
        return arr;   // skeleton. Remove this line
    }
}
