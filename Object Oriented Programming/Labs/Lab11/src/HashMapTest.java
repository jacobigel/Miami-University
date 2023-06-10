import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        // ADDING <key, value>
        // It's put method, not add method
        map.put("meisam", 12345);
        map.put("meAgain", 27387);
        map.put("andMeAgain", 31223);
        map.put("alsoMe", 39273);
        
        
        // The hashMap class has the toString method 
        // so we can print the object directly
        System.out.println(map);
        
        //GETTING the SIZE
        System.out.println(map.size());
        
        
        // GETTING a VALUE -> O(1)
        int value = map.get("alsoMe");
        System.out.println(value);
        
        
        // CHECKING a KEY -> O(1)
        System.out.println(map.containsKey("meAgain"));
        System.out.println(map.containsKey("MEISAM"));
        
        
        // CHECKING a VALUE -> **O(n)**
        System.out.println(map.containsValue(31223));
        System.out.println(map.containsValue(31333));
        
        
        // REPLCING a VALUE Using put -> O(1)
        map.put("meisam", null);
        System.out.println(map);
        
        
        // Difference between hashMap and HashTable:
        // ** In hashMap we can have null keys and values
        // ** In hashTable we can not have null keys and values
        map.put(null, null);
        System.out.println(map);
        
        
        // REPLCING a VALUE Using replace -> O(1)
        map.replace("meisam", 88888);
        // Difference between replacing by using put and replace
        // ** using put, if the key does not exist, it will add
        //            that key, value to the set
        // ** Using replace, if the key does not exist, it will
        //            do nothing
        
        
        // PUT IF ABSENT -> O(1)
        map.putIfAbsent("meisam", 77777);
        System.out.println(map);
        
        
        // REMOVING a Key, value
        // returns the value if the key exist
        System.out.println(map.remove(null));
        // returns null if the key is not there
        System.out.println(map.remove("ME"));
        System.out.println(map);
        
        
        // GETIING the LIST of VALUES
        // returns Collection
        System.out.println(map.values());
        Integer[] values = map.values().toArray(new Integer[0]);
        for (int v : values) {
            System.out.println(v);
        }
        
        // GETIING the LIST of VALUES
        // ** returns set
        System.out.println(map.keySet());
        Set<String> keys = map.keySet();
        System.out.println(keys);
    }

}
