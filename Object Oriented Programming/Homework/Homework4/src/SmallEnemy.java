import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * The small enemy class.
 * 
 * @author jacobigel
 *
 */
public class SmallEnemy extends Enemy {

    /**
     * Establishes the constraints for the small enemy.
     * 
     * @param panelWidth  - width of the panel
     * @param panelHeight - height of the panel
     */
    public SmallEnemy(int panelWidth, int panelHeight) {
        super(0, 0, 30, 30, 6);

        int x = (int) (Math.random() * (panelWidth - 31));
        int y = (int) (Math.random() * (panelHeight - 31));

        this.setBounds(x, y, 30, 30);

        setColor();

    }

    /**
     * Sets the color for the enemy.
     */
    @Override
    public void setColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randColor = new Color(r, g, b);
        setEnemyColor(randColor);

    }

    /**
     * Sets up the movement for the small enemy.
     */
    public void move(int width, int height) {

        int newX = this.getX() + (int) this.getEnemySpeed();

        if (newX > width || newX < 0) {
            this.setEnemySpeed(this.getEnemySpeed() * -1);
        }

        this.setBounds(newX, this.getY(), this.getWidth(), this.getHeight());

        if (this.getEnemySpeed() >= 0) {
            this.setEnemySpeed(this.getEnemySpeed() + 0.05);
        } else {
            this.setEnemySpeed(this.getEnemySpeed() - 0.05);
        }
    }

    /**
     * Handles the collision when the turret missile hits the small enemy.
     */
    public void processCollision(ArrayList<Enemy> list, int enemy) {
        if (this.getWidth() - 10 <= 0 || this.getHeight() - 10 <= 0) {
            list.remove(enemy);
        } else {
            this.setBounds(this.getX(), this.getY(), this.getWidth() - 10,
                    this.getHeight() - 10);
        }

    }

}
