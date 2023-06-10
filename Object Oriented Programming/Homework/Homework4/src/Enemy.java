import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * 
 */

/**
 * The enemy class.
 * 
 * @author jacobigel
 *
 */
public abstract class Enemy extends JComponent {

    private double enemySpeed;
    private Color enemyColor;

    /**
     * This establishes the x and y coordinates, the height and width, and the
     * enemy speed for the enemies.
     * 
     * @param x          - x position of enemy
     * @param y          - y position of enemy
     * @param height     - height of enemy
     * @param width      - width of enemy
     * @param enemySpeed - speed of enemy
     */
    public Enemy(int x, int y, int height, int width, double enemySpeed) {
        this.setBounds(x, y, width, height);
        this.enemySpeed = enemySpeed;

    }

    /**
     * This is for the enemies movement.
     */
    public abstract void move(int width, int height);

    /**
     * Draws a filled circle using the Enemy's color and its bounds.
     * 
     * @param g - graphics of the enemy
     */
    public void paintCompenent(Graphics g) {
        g.setColor(getEnemyColor());
        g.fillOval(this.getX(), this.getY(), this.getWidth(),
                this.getHeight());
    }

    /**
     * Speed of enemy.
     * 
     * @return - the speed of the enemy
     */
    public double getEnemySpeed() {
        return this.enemySpeed;
    }

    /**
     * setter for the enemy speed.
     * 
     * @param s - sets the enemy speed
     */
    public void setEnemySpeed(double s) {
        this.enemySpeed = s;
    }

    /**
     * gets the color of the enemy.
     * 
     * @return - enemy color
     */
    public Color getEnemyColor() {
        return enemyColor;
    }

    /**
     * Sets the enemy color.
     * 
     * @param c - color of enemy
     */
    public void setEnemyColor(Color c) {
        this.enemyColor = c;
    }

    /**
     * Processes the collision of the enemies.
     * 
     * @param list  - list of active enemies
     * @param enemy - enemy
     */
    public abstract void processCollision(ArrayList<Enemy> list, int enemy);

    /**
     * Sets the color of the enemies.
     */
    public abstract void setColor();

}
