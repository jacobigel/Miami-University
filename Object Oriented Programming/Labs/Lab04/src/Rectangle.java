
/**
 * @author jacobigel
 */

import java.awt.Polygon;
import java.util.Scanner;

/**
 * A simple rectangle class.
 */
public class Rectangle extends Shape {
    /**
     * Constructor to create a rectangle using information from the supplied
     * scanner. Input is read in the order x, y, width, height, and color.
     * 
     * @param num      Just some number associated with the shape.
     * @param keyboard The scanner from where the information for the shape is
     *                 to bread.
     */
    public Rectangle(int num, Scanner keyboard) {
        super(num, keyboard);
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
