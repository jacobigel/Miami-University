import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple top-level class to test the operations of the 3 different shapes. It
 * also displays them using a pretty Graphical User Interface (GUI)
 * 
 * @author raodm
 *
 */
public class GeometricArt {
    /**
     * A simple art for testing. This data would be loaded from a text file.
     * However, the data is simply included here to ease testing and also reduce
     * the number of files in this lab project. Here are shapes to draw
     * "blocky".
     */
    private static final String BLOCKY = "rectangle 150 50 100 100 red\n"
            + "rhombus 165 65 25 25 blue\n"
            + "rhombus 210 65 25 25 blue\n"
            + "triangle 190 90  20 20 green\n"
            + "rectangle 175 135 50  6 yellow\n"
            + "rectangle 135 165 130 150 red\n"
            + "rhombus 192 200 15 15 green\n"
            + "rhombus 192 240 15 15 green\n"
            + "rhombus 192 275 15 15 green\n"
            + "rectangle 270 190 50 10 red\n"
            + "rectangle 80 190 50 10 red\n"
            + "rectangle 165 320 25 10 yellow\n"
            + "rectangle 210 320 25 10 yellow\n";

    /**
     * The main method creates a set of shapes and displays them using an art
     * display.
     * 
     * @param args The command-line arguments are not used.
     */
    public static void main(String[] args) {
        // Create a graphical display
        ArtDisplay art = new ArtDisplay();
        // Create a scanner to ease reading data from a string.
        Scanner sc = new Scanner(BLOCKY);
        // Create shape-by-shape based on supplied data.
        while (sc.hasNext()) {
            final String name = sc.next();
            switch (name) {
            case "triangle":
                Triangle tri1 = new Triangle(1, sc);
                art.add(tri1.getVertices(), tri1.getColor());
                break;
            case "rectangle":
                Rectangle rect1 = new Rectangle(1, sc);
                art.add(rect1.getVertices(), rect1.getColor());
                break;
            case "rhombus":
                Rhombus rho1 = new Rhombus(1, sc);
                art.add(rho1.getVertices(), rho1.getColor());
                break;
            default:
                System.out.println("Unknown shape " + name);
                System.exit(1);
            }
        }

        // Show the art work.
        art.display();

        // Next, work with polymorphism by implementing methods in
        // ShapeAnalyzer
        testShapeAnalyzer();
    }

    /**
     * A simple method to test operations of the ShapeAnalyzer class, once the
     * methods have been implemented.
     */
    private static void testShapeAnalyzer() {
        // First get the helper method to build a list of shapes.
        final ArrayList<Shape> shapeList = ShapeAnalyzer.parseShapes(BLOCKY);
        if (shapeList != null) {
            final double area = ShapeAnalyzer.getTotalArea(shapeList);
            System.out.println("Total area: " + area);
            final Shape big = ShapeAnalyzer.getBiggest(shapeList);
            System.out.println("Largest shape's area: " + big.getArea());
        } else {
            System.out.println("Polymorphic calls not yet implemented.");
        }
    }
}
