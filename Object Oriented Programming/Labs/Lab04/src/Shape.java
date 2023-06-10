    import java.awt.Polygon;
import java.util.Scanner;

/**
 * @author jacobigel
 */

/**
 * This class is meant to serve as the parent class (aka base class) for the
 * different shapes. The objective is to use inheritance and polymorphism to
 * streamline the code.
 *
 */
public class Shape {
    // Add any instance variables and methods here as you see fit.
    // Instance variable for x-position
    protected int xpos;
    // Instance variable for y-position
    protected int ypos;
    // Instance variable for height
    protected int height;
    // Instance variable for width
    protected int width;
    // String with color -- valid values are:
    protected String color;
    
    public Shape(int num, Scanner keyboard) {
        // Read data for the rectangle
        // from the given scanner object.
        xpos = keyboard.nextInt();
        ypos = keyboard.nextInt();
        width = keyboard.nextInt();
        height = keyboard.nextInt();
        color = keyboard.next();

        keyboard.nextLine();
    }
    
    /**
     * Obtain the area.
     * 
     * @return Return the area
     */
    public double getArea() {
        return width * height;
    }
    
    /**
     * Obtain color for the shape.
     * 
     * @return Return the color set when the shape was created
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Obtain the vertices that can be used to draw this polygon.
     * 
     * @return The vertices associated with this shape.
     */
    public Polygon getVertices() {
        Polygon vertices = new Polygon();
        // Add vertex in clock-wise order.
        vertices.addPoint(xpos, ypos);
        vertices.addPoint(xpos + width, ypos);
        vertices.addPoint(xpos + width, ypos + height);
        vertices.addPoint(xpos, ypos + height);
        // Return the vertices for this shape
        return vertices;
    }
}

    
   