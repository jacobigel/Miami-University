import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<Integer>();
        
        lst.add(10);
        lst.add(20);
        lst.add(30);
        lst.add(40);
        
        // Example where we want to remove some elements
        // as we are going through the list
        System.out.println(lst);
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) > 20) {
                lst.remove(i);
            }
        }
        System.out.println(lst);
        
        // ** SOLUTION **
        // USING Iterator
        lst.add(2, 30);
        ListIterator<Integer> i = lst.listIterator();
        // Adds iterator pointer to the list
        //  10 20 30 40
        // ^  ^  ^  ^
        while (i.hasNext()) {
            // getting elemtns
            int value = i.next();
            if (value > 20) {
                // removes the element returned by the last
                // .next() or .previous() call
                
                //  10 20 (30) 
                // ^  ^  ^    ^
          
                //  10 20 (40) 
                // ^  ^  ^    ^
                i.remove();
            }
            
        }
        System.out.println(lst);
        System.out.println(i.previous());
        System.out.println(i.previous());
       

    }

}
