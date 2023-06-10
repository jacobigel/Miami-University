import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Rectangle;
import java.util.ArrayList;
import org.junit.Test;

public class Phase1Test {
    /**
     * The width of the display panel used for testing.
     */
    private static final int WIDTH = 400;

    /**
     * The height of the display panel used for testing.
     */
    private static final int HEIGHT = 200;

    /**
     * A constant used for comparing doubles.
     */
    private static final double epsilon = 0.000001d;

    /**
     * Bounds representing the display panel to be used for testing.
     */
    private static final Rectangle PanelBounds = new Rectangle(0, 0, WIDTH,
            HEIGHT);

    /**
     * Internal helper method to determine number of steps enemy has to move
     * before its direction changes.
     * 
     * @param startX The starting X coordinate
     * @param endX   The ending x-coordinate
     * @param speed  The speed with which enemy moves in each step
     * @return The number of steps.
     */
    private int getSteps(int startX, int endX, int speed) {
        return (Math.abs(startX - endX) / Math.abs(speed)) + 1;
    }

    @Test
    public void testBigEnemyConstructor() {
        final BigEnemy be = new BigEnemy(WIDTH, HEIGHT);
        final Rectangle bounds = be.getBounds();
        assertTrue(bounds.width == 56 && bounds.height == 56);
        assertTrue(be.getEnemySpeed() == 4.0);
        assertTrue(be.getEnemyColor() != null);
        // Ensure enemy is within bounds
        assertTrue(PanelBounds.contains(be.getBounds()));
    }

    @Test
    public void testBigEnemyOneMove() {
        final BigEnemy be = new BigEnemy(WIDTH - 56, HEIGHT);
        final Rectangle bounds = be.getBounds();
        // Move the enemy
        be.move(WIDTH, HEIGHT);
        // Ensure enemy has moved by its pre-specified speed
        assertTrue(be.getX() - bounds.x == be.getEnemySpeed());
        // BigEnemy's speed should not change.
        assertTrue(Math.abs(be.getEnemySpeed()) == 4.0);
    }
    

    @Test
    public void testBigEnemyManyMoves() {
        final BigEnemy be = new BigEnemy(WIDTH - 56, HEIGHT);
        Rectangle initPos = be.getBounds();
        // Determine number of moves after which enemy should change direction
        int steps = getSteps(initPos.x, WIDTH, (int) be.getEnemySpeed());
        for (int i = 0; (i < steps); i++) {
            be.move(WIDTH, HEIGHT);
        }
        // Ensure enemy has changed direction.
        assertTrue(be.getEnemySpeed() < 0);
        assertTrue(be.getX() >= initPos.x);

        // Move the enemy again and check for direction reversal
        initPos = be.getBounds();
        steps = getSteps(be.getX(), 0, (int) be.getEnemySpeed());
        for (int i = 0; (i < steps); i++) {
            be.move(WIDTH, HEIGHT);
        }
        // Ensure enemy has changed direction.
        assertTrue(be.getEnemySpeed() > 0);
        assertTrue(be.getX() <= initPos.x);
    }

    @Test
    public void testSmallEnemyConstructor() {
        final SmallEnemy se = new SmallEnemy(WIDTH, HEIGHT);
        final Rectangle bounds = se.getBounds();
        assertTrue(bounds.width == 30 && bounds.height == 30);
        assertTrue(se.getEnemySpeed() == 6.0);
        assertTrue(se.getEnemyColor() != null);
        // Ensure enemy is within bounds
        assertTrue(PanelBounds.contains(se.getBounds()));
    }

    @Test
    public void testSmallEnemyOneMove() {
        final SmallEnemy se = new SmallEnemy(WIDTH - 30, HEIGHT);
        final Rectangle bounds = se.getBounds();
        final double prevSpeed = se.getEnemySpeed();
        // Move the enemy
        se.move(WIDTH, HEIGHT);
        // Ensure enemy has moved by its pre-specified speed
        assertTrue(se.getX() - bounds.x < se.getEnemySpeed());
        // BigEnemy's speed should not change.
        final double acceleration = Math.abs(se.getEnemySpeed() - prevSpeed);
        assertEquals(acceleration, 0.05, epsilon);
    }

    @Test
    public void testSmallEnemyManyMoves() {
        final SmallEnemy se = new SmallEnemy(WIDTH - 30, HEIGHT);
        Rectangle initPos = se.getBounds();
        // Determine number of moves after which enemy should change direction
        int steps = getSteps(initPos.x, WIDTH, (int) se.getEnemySpeed());
        for (int i = 0; (i < steps); i++) {
            se.move(WIDTH, HEIGHT);
        }
        // Ensure enemy has changed direction.
        assertTrue(se.getEnemySpeed() < 0);
        assertTrue(se.getX() >= initPos.x);

        // Move the enemy again and check for direction reversal
        initPos = se.getBounds();
        steps = getSteps(se.getX(), 0, (int) se.getEnemySpeed());
        for (int i = 0; (i < steps); i++) {
            se.move(WIDTH, HEIGHT);
        }
        // Ensure enemy has changed direction.
        assertTrue(se.getEnemySpeed() > 0);
        assertTrue(se.getX() <= initPos.x);
    }

    @Test
    public void testMissileConstructor() {
        Missile m = new Missile(WIDTH / 2, HEIGHT / 2);
        assertEquals(m.getX(), WIDTH / 2);
        assertEquals(m.getY(), HEIGHT / 2);
        assertEquals(m.getWidth(), 15);
        assertEquals(m.getHeight(), 15);
        assertEquals(m.getMissileSpeed(), 5);
    }

    @Test
    public void testMissileOneMove() {
        Missile m = new Missile(WIDTH / 2, HEIGHT / 2);
        final Rectangle startPos = m.getBounds();
        ArrayList<Missile> list = new ArrayList<>();
        list.add(m);
        m.move(WIDTH, HEIGHT, list, 0);
        assertEquals(startPos.y - m.getY(), m.getMissileSpeed());
    }

    @Test
    public void testMissileManyMovies() {
        Missile m = new Missile(WIDTH / 2, 15);
        ArrayList<Missile> list = new ArrayList<>();
        list.add(m);
        m.move(WIDTH, HEIGHT, list, 0);
        m.move(WIDTH, HEIGHT, list, 0);
        m.move(WIDTH, HEIGHT, list, 0);
        m.move(WIDTH, HEIGHT, list, 0);

        assertTrue(m.getY() <= 0);
        assertTrue(list.isEmpty());
    }

    ArrayList<Missile> createMissiles(BigEnemy be, SmallEnemy se) {
        Missile m1 = new Missile(be.getX() + (int) be.getEnemySpeed() * 3,
                be.getY() + 5 * 3);
        Missile m2 = new Missile(se.getX() + (int) se.getEnemySpeed() * 3,
                se.getY() + 5 * 3);

        Missile m3 = new Missile(be.getX() + (int) be.getEnemySpeed() * 5,
                be.getY() + 5 * 5);
        Missile m4 = new Missile(se.getX() + (int) se.getEnemySpeed() * 5,
                se.getY() + 5 * 5);

        Missile m5 = new Missile(be.getX() + (int) be.getEnemySpeed() * 7,
                be.getY() + 5 * 7);
        Missile m6 = new Missile(se.getX() + (int) se.getEnemySpeed() * 7,
                se.getY() + 5 * 7);

        ArrayList<Missile> missileList = new ArrayList<>();
        missileList.add(m1);
        missileList.add(m2);
        missileList.add(m3);
        missileList.add(m4);
        missileList.add(m5);
        missileList.add(m6);
        return missileList;
    }

    @Test
    public void testGamePlay() {
        BigEnemy be = new BigEnemy(WIDTH / 2, HEIGHT);
        SmallEnemy se = new SmallEnemy(WIDTH / 2, HEIGHT);
        ArrayList<Enemy> enemyList = new ArrayList<>();
        enemyList.add(be);
        enemyList.add(se);

        ArrayList<Missile> missileList = createMissiles(be, se);

        for (int i = 0; (i < 6); i++) {
            be.move(WIDTH, HEIGHT);
            se.move(WIDTH, HEIGHT);
            for (int j = 0; (j < missileList.size()); j++) {
                missileList.get(j).move(WIDTH, HEIGHT, missileList, j);
            }
            detectCollision(enemyList, missileList);
        }

        assertTrue(enemyList.isEmpty());
        assertTrue(missileList.isEmpty());
    }

    /**
     * Internal helper method to detect and process collisions.
     * 
     * @param enemyList   The list of enemies being used for testing.
     * @param missileList The list of missiles used for testing.
     */
    private void detectCollision(ArrayList<Enemy> enemyList,
            ArrayList<Missile> missileList) {
        // Uses bounds for enemies and missiles to detect intersection.
        for (int i = 0; i < enemyList.size(); i++) {
            Rectangle enemyRec = enemyList.get(i).getBounds();
            for (int j = 0; j < missileList.size(); j++) {
                Rectangle missileRec = missileList.get(j).getBounds();
                if (missileRec.intersects(enemyRec)) {
                    // Missile has hit an enemy!
                    // System.out.println(missileRec + " -- " + enemyRec);
                    enemyList.get(i).processCollision(enemyList, i);
                    missileList.remove(j);
                }
            }
        }
    }
}
