
/**
 * @author jacobigel
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class uses polymorphism to perform different types of analysis on a
 * given set of geometric polygons that are subclasses of Shape.
 *
 */
public class ShapeAnalyzer {
    /**
     * Returns a list of shapes read from the data in the supplied string. The
     * string is assumed to contain information in the format: "name x y width
     * height color\n". For example: "rectangle 150 50 100 100 red\n" + "rhombus
     * 165 65 25 25 blue\n" + "rhombus 210 65 25 25 blue\n"
     *
     * @param shapeData A string containing information on shapes to be created
     *                  by this method.
     * 
     * @return The list of shapes extracted from the supplied string.
     */
    public static ArrayList<Shape> parseShapes(final String shapeData) {
        // Use the code from GeometricArt that parses the shape here.
        // Instead of adding the shape to the art display, simply add the
        // shape to an array list and return it.
        ArrayList<Shape> lst = new ArrayList<Shape>();

        Scanner sc = new Scanner(shapeData);
        // Create shape-by-shape based on supplied data.
        while (sc.hasNext()) {
            final String name = sc.next();

            switch (name) {
            case "triangle":
                Triangle tri1 = new Triangle(1, sc);
                lst.add(tri1);
                break;
            case "rectangle":
                Rectangle rect1 = new Rectangle(1, sc);
                lst.add(rect1);
                break;
            case "rhombus":
                Rhombus rho1 = new Rhombus(1, sc);
                lst.add(rho1);
                break;
            default:
                System.out.println("Unknown shape " + name);
                System.exit(1);
            }
        }

        return lst;
    }

    /**
     * Computes the sum of areas of all the shapes in the given list of shapes.
     * 
     * @param shapeList The list of shapes whose total area is to be computed.
     * @return The sum of the area of all the shapes.
     */
    public static double getTotalArea(final ArrayList<Shape> shapeList) {
        int sum = 0;
        for (int i = 0; i < shapeList.size(); i++) {
            Shape element = shapeList.get(i);
            sum += element.getArea();
        }
        return sum;
    }

    /**
     * Determines the largest shape (based on area) in the given list of shapes
     * and returns it.
     * 
     * @param shapeList The shapes to be processed by this method.
     * @return The shape with the maximum area.
     */
    public static Shape getBiggest(final ArrayList<Shape> shapeList) {
        Shape max = shapeList.get(0);
        for (int i = 1; i < shapeList.size(); i++) {
            Shape element = shapeList.get(i);
            if (element.getArea() > max.getArea()) {
                max = element;
            }

        }
        return max;
    }
}