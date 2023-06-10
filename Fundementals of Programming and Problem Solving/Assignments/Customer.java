/**
 * <p> <strong> Defines a simple Customer class that holds some information
 * regarding customers, this information includes: nickname and id 
 * number. </strong> When a Customer object is created the nickname and the 
 * id number can be retrievd by <b>getName()</b> and <b>getId()</b> methods. 
 * For example: </p>
 * <p> Customer cos = new Customer("blue_jet", 11135422); <br>
 * cos.<b>getName()</b>; returns <b> "blue_jet" </b> <br>
 * cos.<b>getId()</b>; returns <b> 11135422 </b> </p>
 * <p> When a Customer object is created, <strong> the nickname and the
 * id number can not be changed. </strong> </p> 
 * <p>Two Customer objects can be compared by using the <b>equals()</b>
 * methods, for example: </p>
 * <p> Customer cos1 = new Customer("blue_jet", 11135422); <br>
 * Customer cos2 = new Customer("blue_jet", 222356478); </p>
 * <p> If <b>either</b> of nicknames or ids are equal, or <b>both</b> are equal 
 * then the result is <b>true</b>. The result of comparison is <b>false</b>
 * only and only when both values in both objects are different. So, the 
 * result of: </p> 
 * <p> cos1<b>.equals</b>(cos2) or cos2<b>.equals</b>(cos1) </p>
 * <p> is <b>true</b>. But, the result of: </p> 
 * cos2 = new Customer("aaaazzz", 222356478);<br>
 * cos1.equals(cos2)  or  cos2.equals(cos1) <br>
 * <p> is <b> false </b>. </p>
 * <p> To <b>print</b> the Customer object, you can costumize the result by
 * getting the nickname and id number separately and print it in your own
 * way, or you can print the object directly. Here are some examples of
 * printing the Customer object: </p>
 * <p> Customer cost01 = new Customer("Meijad", 22204563); <br>
 * System.out.println(cost01); <br>
 * System.out.println("--------"); <br>
 * System.out.printf("{name: %s, id: %d}%n", cost01.getName(), 
 * cost02.getId());</p>
 * <p> The results are as following: </p>
 * <p> "[Meijad, 22204563]"<br>
 * "--------" <br>
 * "{name: Meijad, id: 22204563}"<br></p>
 * <p> To create a deep (actual) <b>copy</b> of the Customer object the method
 * <b> clone() </b> can be used. The general intent is that, for any Customer
 * object c, the expression: <br>
 * c.clone() <b>!=</b> c; <br>
 * showing they are different objects with different references in the memory,
 * but the result of comparing values as below: <br>
 * x.clone().equals(x) <br>
 * is <b> true </b> .</p>
 * <p> Copyright(C) 2020 Customer.java
 * @author amjadm@miamioh.edu
 */
public class Customer {

    /* For holding the nickname. */ 
    private String nickname;
    /* For holding id number. */
    private long id;

    /**
     * This constructor initilizes the object with the
     * given nickname and id number.
     * @param nickname a String type name.
     * @param id a long type number as id.
     */   
    public Customer(String nickname, long id) {
        setNickname(nickname);
        setId(id);
    }
    
    /**
     * Copy Constructor, this constructor initilizes the object with the
     * given Customer object's information.
     * @param co a Customer object to initialize the object with.
     */ 
    public Customer(Customer co) { 
        setNickname(co.getName());
        setId(co.getId());
    }
    
    /**
     * Returns a String value which is the nickname of this object.
     * @return the nickname of this object.
     */
    public String getName() {
        return getNickname();
    }
    
    /**
     * Returns a long type value which is the id number of this object.
     * @return the id number of this object.
     */
    public long getId() {
        return getIdNum();
    }
    
    /** 
     * Returns this Customer object in the String fromat: 
     * "[nikname, id]"
     * @return A String value from the nickname and the id of this object. 
     */
    @Override
    public String toString() {
        return ("[" + getName() + ", " + getId() + "]");
    }
    
    /** 
     * Compares this Customer object to the given Customer object. 
     * <p> If either names or ids are equal the result is true. <br>
     * If both names and ids are equal the result is true. <br>
     * The result is false when both nicknames and ids are different. <p>
     * @param obj Customer object
     * @return A boolean value, the result of comparison.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer co = (Customer) obj;
            return (getName().equals(co.getName())
                || getId() == co.getId());
        }
        
        return false;
    }
    
    /**
     * Creates and returns a deep copy of this Customer object. 
     * The general intent is that, for any Customer x, the expression: <br>
     * x.clone() <b>!= </b> x; <br>
     * but the result of comparing values as below: <br>
     * x.clone().equals(x) <br>
     * is <b> true </b>.
     * @return The deep copy of the Customer object.
     */
    @Override
    public Customer clone() {
        return new Customer(getName(), getId());
    }
    
    // =================== PRIVATE METHODS ===================
    /*
     * Set a new value for nickname.
     * @param nickname a new string type nickname.
     */
    private void setNickname(String name) {
        this.nickname = name;
    }
    
    /*
     * Set a new value for id.
     * @param id a new long type id.
     */
    private void setId(long idNum) {
        this.id = idNum;
    }
    
    /*
     * Returns the name field.
     * @return the current nickname.
     */
    private String getNickname() {
        return this.nickname;
    }
    
    /*
     * Return the id field.
     * @return the current id number.
     */
    private long getIdNum() {
        return this.id;
    }
}
