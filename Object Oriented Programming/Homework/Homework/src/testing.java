import java.util.Scanner;
import java.io.*;
/**
 * 
 */

/**
 * @author jacobigel
 *
 */
public class testing {
//
//    public static void main(String[] args) {
//
//    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
        mystery(3);
        
    }
    
    
    
    
    public static void mystery(int n) throws Exception {
        if (n < 0) {
            throw new Exception();
            
        } try {
            mystery(n-1);
            System.out.println("*".repeat(n));
        } catch (Exception e) {
            System.out.println("Hello");
        }
        
         
    }

}
   
         
//         public static void mystery(int n) throws Exception{ 
//             if (n < 0) { 
//                 throw new Exception(); 
//             } try {
//                 mystery(n - 1); 
//                 System.out.println("*".repeat(n));
//                 } catch (Exception e) {
//                     System.out.println("Hello"); 
//                     
//                 } 
//             
//         }
