import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

/**
 * The Missile class.
 * 
 * @author jacobigel
 *
 */

public class Missile extends JComponent {

    private int missileSpeed;
    private Color missileColor;

    /**
     * Sets up the constraints for the missile.
     * 
     * @param x - x position of the missile
     * @param y - y position of the missile.
     */
    public Missile(int x, int y) {
        setBounds(x, y, 15, 15);        
        setMissileSpeed(5);
        setMissileColor();

    }

    /**
     * Sets up the missile color.
     * @return - returning the missile color.
     * 
     */
    public Color setMissileColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randColor = new Color(r, g, b);
        return randColor = missileColor;
    }

    public void paintCompenent(Graphics g) {
        g.setColor(setMissileColor());
        g.fillOval(getX(), getY(), 15, 15);

    }

    /**
     * This is for the movement of the missile.
     * 
     * @param width   - width of the missile.
     * @param height  - height of the missile.
     * @param list    - list of active missiles.
     * @param missile - the actual missile itself.
     */
    public void move(int width, int height, ArrayList<Missile> list,
            int missile) {

        int newY = this.getY() - this.getMissileSpeed();
        if (newY < 0) {
            list.remove(missile);
        }

        this.setBounds(getX(), newY, 15, 15);

    }

    /**
     * This is for setting the speed of the missile.
     * 
     * @param missileSpeed - the speed for the missile.
     */
    public void setMissileSpeed(int missileSpeed) {
        this.missileSpeed = missileSpeed;
    }

    /**
     * This is for getting the missile speed.
     * 
     * @return - returns the speed of the missile.
     */
    public int getMissileSpeed() {
        return missileSpeed;

    }
}
