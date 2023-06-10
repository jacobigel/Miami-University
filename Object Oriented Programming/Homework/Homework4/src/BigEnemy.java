import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * The big enemy class.
 * 
 * @author jacobigel
 *
 */
public class BigEnemy extends Enemy {

    /**
     * Establishes the constraints for the big enemy.
     * 
     * @param panelWidth  - width of the panel
     * @param panelHeight - height of the panel
     */
    public BigEnemy(int panelWidth, int panelHeight) {
        super(0, 0, 56, 56, 4);

        int x = (int) (Math.random() * (panelWidth - 57));
        int y = (int) (Math.random() * (panelHeight - 57));

        this.setBounds(x, y, 56, 56);

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
     * Sets up the movement for the big enemy.
     */
    public void move(int width, int height) {
        int newX = this.getX() + (int) this.getEnemySpeed();

        if (newX > width || newX < 0) {
            setEnemySpeed(getEnemySpeed() * -1);
        }

        this.setBounds(newX, this.getY(), this.getWidth(), this.getHeight());

    }

    /**
     * Handles the collision when the turret missile hits the big enemy.
     */
    public void processCollision(ArrayList<Enemy> list, int enemy) {
        if (this.getWidth() - 20 <= 0 || this.getHeight() - 20 <= 0) {
            list.remove(enemy);
        } else {
            this.setBounds(this.getX(), this.getY(), this.getWidth() - 20,
                    this.getHeight() - 20);
        }

    }

}
