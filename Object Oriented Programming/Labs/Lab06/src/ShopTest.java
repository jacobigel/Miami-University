import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ShopTest {

    /*
     * A helper method that creates a Shop object.
     * 
     * @param name String.
     * 
     * @param items Array of strings for items.
     * 
     * @return a new Shop object.
     */
    private Shop createAShop(String name, String... items) {
        Shop newShop = new Shop(name);

        for (String elem : items) {
            newShop.items.add(elem);
        }

        return newShop;
    }

    /**
     * For testing the constructor.
     */
    @Test
    public void testConstructor() {
        Shop newShop = new Shop("MyOrder");
        assertEquals("the name of the order is not correct", newShop.name,
                "MyOrder");
        assertNotEquals("the name of the order is not correct", newShop.name,
                "Meisam");
    }

    /*
     * For testing the Copy Constructor.
     */
    @Test
    public void testCopyConstructor() {
        Shop newShop = createAShop("MyOrder", "milk", "bread");

        assertNotNull("The name is null", newShop.name);
        assertEquals("The name is not MyOrder", newShop.name, "MyOrder");

        assertEquals("The aren't 2 items", newShop.items.size(), 2);
        assertNotEquals("The aren't 2 items", newShop.items.size(), 3);

        assertTrue("The first item is not milk",
                newShop.items.get(0).equals("milk"));
        assertTrue("The second item is not bread",
                newShop.items.get(1).equals("bread"));
    }

    /*
     * For testing the Clone method.
     */
    @Test
    public void testClone() {
        Shop newShop = createAShop("MyOrder", "milk", "bread", "Pen");

        Shop copy = newShop.clone();

        // make sure they don't have the same memory location
        assertNotSame("Two objects are the same", newShop, copy);

        // Making sure elements don't have the same memory locations either
        for (int i = 0; i < copy.items.size(); i++) {
            // make sure they have the same value
            assertEquals("Element is not the same as copy",
                    newShop.items.get(i), copy.items.get(i));
            // make sure they have different memory locations
            assertSame("Two objects are the same", newShop.items.get(i),
                    copy.items.get(i));

        }
    }
    
    /*
     * For testing the compareTo method.
     */
    @Test
    public void testCompareTo() {
        Shop s1 = createAShop("order1", "a", "b", "c");
        Shop s2 = createAShop("order1", "a", "b", "c", "d", "e", "f", "g", "i");
        Shop s3 = createAShop("order1", "a", "b");
        Shop s4 = createAShop("order1", "a", "b", "c", "d", "e", "f", "g", "i");
        
        assertTrue("s1 is not smaller than s2", s1.compareTo(s2) < 0);
        assertTrue("s2 is not greater than s1", s2.compareTo(s1) > 0);
        assertTrue("s2 and s4 aren't equal", s2.compareTo(s4) == 0);
        assertTrue("s3 is not smaller than s4", s3.compareTo(s4) < 0);
    }
    
    /**
     * Tests the .equals method.
     */
    @Test
    public void testEquals() {
        Shop newShop1 = createAShop("MyOrder", "milk", "bread");
        Shop newShop2 = new Shop(newShop1);

        assertEquals("The objects are the same", newShop1, newShop2);
        assertFalse("The objects have the same memory locations",
                newShop1 == newShop2);
        assertTrue("they are not equal", newShop1.equals(newShop2));
    }
    
    /*
     * Tests the add method.
     */
    @Test
    public void testAdd() {
        Shop shop = createAShop("MyOrder", "milk", "bread");
        for (char ch = 'a'; ch < 'f'; ch++) {
            shop.add("" + ch);
        }
        
        char ch = 'a';
        for (int i = 2; i < 7; i++, ch++) {
            assertTrue(shop.items.get(i).equals("" + ch));
        }
    }
    
    /*
     * Testing the getNumItem method from the Order class.
     */
    @Test
    public void testGetNumItems() {
        Shop s4 = createAShop("order1", "a", "b", "c", "d", "e", "f", "g", "i");
        assertEquals(s4.getNumItems(), 8);
    }
    
    /*
     * Testing the isEmpty method from the Order class.
     */
    @Test
    public void testIsEmpty() {
        Shop s = new Shop("Test");
        assertNotNull(s.items);
        assertTrue(s.isEmpty());
        s.add("item1");
        assertFalse(s.isEmpty());
    }

}
