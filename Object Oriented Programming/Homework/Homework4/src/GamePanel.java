import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This class contains the paintable objects such as the enemies, turret, and
 * missile. It also keeps track of the
 * 
 * @author Jacob Igel
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
    /**
     * The list of enemies in the game. Objects are added in the addEnemy
     * method and removed in the detectCollison method.
     */
    private ArrayList<Enemy> enemyList;
    
    /**
     * The list of missiles in the game. Objects are added in the addMissile
     * method and removed in the detectCollison method.
     */
    private ArrayList<Missile> missileList;

    /**
     * The current score in the game. This value is updated in the 
     * detectCollision method.
     */
    private int totalScore = 0;
    
    /**
     * Method detects the collision of the missile and all the enemies. This is
     * done by drawing invisible rectangles around the enemies and missiles, if
     * they intersect, then they collide.
     */
    public void detectCollision() {
        // Uses bounds for enemies and missiles to detect intersection.
        for (int i = 0; i < enemyList.size(); i++) {
            Rectangle enemyRec = enemyList.get(i).getBounds();
            for (int j = 0; j < missileList.size(); j++) {
                Rectangle missileRec = missileList.get(j).getBounds();
                if (missileRec.intersects(enemyRec)) {
                    // Missile has hit an enemy!
                    enemyList.get(i).processCollision(enemyList, i);
                    missileList.remove(j);
                    if (enemyList.get(i) instanceof BigEnemy) {
                        totalScore += 100;
                    } else {
                        totalScore += 150;
                    }
                }
            }
        }
    }
}
