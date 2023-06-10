
/**
 * @author jacobigel
 */
import java.awt.Polygon;
import java.util.Scanner;

/**
 * A simple rhombus class.
 */
public class Rhombus extends Rectangle {

    /**
     * Constructor to create a rhombus using information from the supplied
     * scanner. Input is read in the order x, y, width, height, and color.
     * 
     * @param num      Just some number associated with the shape.
     * @param keyboard The scanner from where the information for the shape is
     *                 to bread.
     */
    public Rhombus(int num, Scanner keyboard) {
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
        vertices.addPoint(xpos + width / 2, ypos);
        vertices.addPoint(xpos + width, ypos + height / 2);
        vertices.addPoint(xpos + width / 2, ypos + height);
        vertices.addPoint(xpos, ypos + height / 2);
        // Return the vertices for this shape
        return vertices;
    }
}
