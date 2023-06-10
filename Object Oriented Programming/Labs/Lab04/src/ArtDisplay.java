import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * <p>
 * This class is part of the Graphical User Interface (GUI) display for this
 * Project. This class essentially draws Polygons of given shape and color. They
 * are added via the add method in this class.
 * </p>
 * 
 * <p>
 * NOTE: Ideally, this class would use polymorphic calls to get information
 * about the shapes to be drawn. However, to get this class working with both
 * the starter and revised code, it is setup a bit differently.
 * </p>
 * 
 * @author raodm
 *
 */
public class ArtDisplay extends JFrame {
    /**
     * Sets up the display to display polygons added to it.
     */
    public ArtDisplay() {
        super("CSE-271 Lab #4: Geometric Art");
        setLayout(new BorderLayout(1, 1));
        setPreferredSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a scroll pane to contain the components.
        JScrollPane jsp = new JScrollPane(new Board());
        add(jsp, BorderLayout.CENTER);
        // Create a JLabel to display mouse coordinates.
        mouseLocation = new JLabel("  Mouse Location: x=  " + ", y=");
        add(mouseLocation, BorderLayout.SOUTH);
        // Pack and show
        pack();
    }

    /**
     * Shows the art on screen (if possible) otherwise prints the list of
     * polygons and their colors.
     */
    void display() {
        // Pack and show
        pack();
        try {
            setVisible(true);
        } catch (HeadlessException exp) {
            // Print all the polygons
            printPolygons();
        }
    }

    /**
     * Adds a polygon with the given color for drawing.
     * 
     * @param poly  The polygon to be drawn.
     * 
     * @param color The color to be used to draw the polygon. Valid colors are
     *              "blue", "green", "yellow", "red"
     */
    public void add(Polygon poly, String color) {
        shapeList.add(poly);
        colorList.add(color);
    }

    /**
     * This method simply prints a list of shapes added with the display. The
     * information is printed to the console.
     */
    public void printPolygons() {
        for (int i = 0; (i < shapeList.size()); i++) {
            Rectangle box = shapeList.get(i).getBounds();
            System.out.println(box + ", Color=" + colorList.get(i));
        }
    }

    /**
     * This array list maintains the list of shapes currently added. New entries
     * are added to this array via the add() method. Finally, the
     * paintComponents() method in the Board inner class uses the list to draw
     * the components on the screen.
     */
    private ArrayList<Polygon> shapeList = new ArrayList<Polygon>();

    /**
     * This array maintains the colors associated with each shape. Ideally we
     * will just use a list of shapes and polymorphic calls.
     */
    private ArrayList<String> colorList = new ArrayList<String>();

    /**
     * An inner class to draw the polygons.
     * 
     * @author raodm
     *
     */
    public class Board extends JComponent {
        /**
         * This method is automatically called whenever the Board containing
         * shapes needs to be repainted. This method iterates through the list
         * of objects in ArrayList, obtains the Polygons corresponding to each
         * and paints them using the specified fill color.
         * 
         * @param g The graphics object that must be used for display.
         */
        public void paintComponent(Graphics g) {
            paintBackground(g);
            for (int i = 0; (i < shapeList.size()); i++) {
                Polygon verticies = shapeList.get(i);
                Color shapeColor = toColor(colorList.get(i));
                g.setColor(new Color(shapeColor.getRed(), shapeColor.getGreen(),
                        shapeColor.getBlue(), 200));
                g.fillPolygon(verticies);
                g.setColor(shapeColor);
                g.drawPolygon(verticies);
            }
        }

        /**
         * This is a simple utility method that used to convert a given color
         * word string (blue, green, yellow, and red) to the corresponding GUI
         * color code.
         * 
         * @param colorWord The color word to be converted.
         * @return The color code correspoding to the given word. If an invalid
         *         color code is specified, then this method returns GRAY as the
         *         default.
         */
        private Color toColor(String colorWord) {
            final Color[] FixedColors = { Color.BLUE, Color.GREEN,
                    Color.YELLOW, Color.RED };
            int colorCode = "blue   green  yellow red"
                    .indexOf(colorWord.toLowerCase()) / 7;
            if ((colorCode >= 0) && (colorCode < FixedColors.length)) {
                return FixedColors[colorCode];
            }
            // For unknown colors we just return gray
            return Color.GRAY;
        }

        /**
         * This method is called whenever the main frame is resized to compute
         * the space required for the Board. This method essentially walks the
         * list of Shapes, locates the one that is displayed at the maximum
         * value and returns it back to the caller.
         * 
         * @return The size the Board needs to be so that all the components can
         *         be drawn on screen properly.
         */
        public Dimension getPreferredSize() {
            Dimension size = new Dimension(0, 0);
            for (int i = 0; (i < shapeList.size()); i++) {
                Polygon shape = shapeList.get(i);
                Rectangle shapeBounds = shape.getBounds();
                size.width = Math.max(size.width, (int) shapeBounds.getMaxX());
                size.height = Math.max(size.height,
                        (int) shapeBounds.getMaxY());
            }
            return size;
        }

        /**
         * This method is invoked from the paintComponent() method. This method
         * is invoked whenever the board component needs to be painted. This
         * method paints the background black and then draws the grid lines on
         * the back to ease validation of results.
         * 
         * @param g The graphics object that must be used for display.
         */
        public void paintBackground(Graphics g) {
            final int Width = getWidth();
            final int Height = getHeight();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            // Draw horizontal lines and print labels with small font.
            g.setFont(g.getFont().deriveFont(g.getFont().getSize() - 2.0f));
            for (int y = 0; (y < Height); y += 50) {
                g.drawLine(0, y, Width, y);
                g.drawString("" + y, 0, y - 2);
                g.drawString("" + y, Width - 25, y - 2);
            }
            // Draw vertical lines and print labels.
            for (int x = 0; (x < Width); x += 50) {
                g.drawLine(x, 0, x, Height);
                g.drawString("" + x, x + 1, 10);
                g.drawString("" + x, x + 1, Height - 1);
            }
        }

        /**
         * Creates a blank board with a mouse listener to display current mouse
         * position.
         */
        public Board() {
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseMoved(MouseEvent me) {
                    mouseLocation.setText("  Mouse Location: x=  "
                            + me.getX() + ", y=" + me.getY());
                }
            });
        }

        /**
         * An automatically generated unique ID to keep Eclipse happy.
         */
        private static final long serialVersionUID = -8416005817077615425L;
    }

    /**
     * A generated serialization unique ID to keep eclispe happy.
     */
    private static final long serialVersionUID = 7403351190228484476L;

    /**
     * A JLabel to display the current location of the mouse to aid debugging.
     */
    private JLabel mouseLocation;
}
