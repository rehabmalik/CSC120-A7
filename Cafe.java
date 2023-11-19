import java.util.Hashtable;

public class Cafe extends Building{
    /* Number of coffee ounces in stock at the cafe */
    private int nCoffeeOunces; 
    /* Number of sugar packets in stock at the cafe */
    private int nSugarPackets;
    /* Number of creams in stock at the cafe */
    private int nCreams;
    /* Number of cups in stock at the cafe */
    private int nCups;
    /* List of all the employees working at the cafe*/
    private Hashtable<Integer, String> employees;
    
    /**
     * Creates a new cafe.
     * @param name String
     * @param address String
     * @param nFloors int
     * @param nCoffeeOunces int
     * @param nSugarPackets int
     * @param nCreams int
     * @param nCups int
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name,address,nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups= nCups;
        this.employees = new Hashtable<>();
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Creates a new default cafe.
     */
    public Cafe (){
        super("Unknown", "Unknown", 1);
        this.nCoffeeOunces = 0;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups= 0;
        this.employees = new Hashtable<>();
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Creates a new cafe without a set stock of ingredients.
     * @param name String
     * @param address String
     * @param nFloors int
     */
    public Cafe(String name, String address, int nFloors) {
        super(name,address,nFloors);
        this.employees = new Hashtable<>();
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Adds an employee to the cafe's roster
     * @param name String
     * @param employeeID Integer
     */
    public void addEmployee (int employeeID, String name) {
        if (this.employees.containsKey(employeeID)){
            throw new RuntimeException(name + " is already an employee in " + this.name);
        }
        this.employees.put(employeeID, name);
        System.out.println(name + " is now an employee in " + this.name); 
    }
    
    /**
     * Removes an employee from the cafe's roster
     * @param name String
     * @param employeeID Integer
     */
    public void removeEmployee (int employeeID, String name) {
        if (!this.employees.containsKey(employeeID)){
            throw new RuntimeException(name + " is not an employee in " + this.name);
        }
        this.employees.remove(employeeID);
        System.out.println(name + " is no longer an employee in " + this.name); 
    }

    /**
     * Sells a coffee and alters stock based on how much is used.
     * Directs user to restock if enough ingredients for current order are not available and then sells the coffee.
     * @param size int
     * @param nSugarPackets int
     * @param nCreams int
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        try{ 
            if (this.nCups < 1 || this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams){
                throw new RuntimeException("Not enough ingredients. Please restock before making this order.");
            }

            else {
                this.nCoffeeOunces -= size;
                this.nSugarPackets -= nSugarPackets;
                this.nCreams -= nCreams;
                this.nCups -- ;
                System.out.println("Order successful.");
            }
        }

        catch (RuntimeException e){
            restock(size, nSugarPackets, nCreams, nCreams);
            sellCoffee(size, nSugarPackets, nCreams);
        }

    }

    /**
     * Sells a latte and alters stock based on how much is used.
     * Directs user to restock if enough ingredients for current order are  not available.
     * @param size int
     * @param nSugarPackets int
     */
    public void sellCoffee(int size, int nSugarPackets){
        sellCoffee(size, nSugarPackets, 2);
    }

     /**
     * Sells an espresso and alters stock based on how much is used.
     * Directs user to restock if enough ingredients for current order are  not available.
     * @param size int
     * @param nSugarPackets int
     */
    public void sellCoffee(int size){
        sellCoffee(size,0, 0);
    }

    /**
     * Restocks the ingredients in the cafe.
     * @param nCoffeeOunces int
     * @param nSugarPackets int
     * @param nCreams int
     * @param nCups int
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("The ingredients have been restocked.");
    }

    /**
     * Shows the available options
     */
    public void showOptions() {
        super.showOptions();
    }

    /**
     * Allows user to move to another floor only if they are an employee
     * @param floorNum int
     * @param employeeID Integer
     */
    public void goToFloor(int floorNum, Integer employeeID){
        if (!this.employees.containsKey(employeeID)) {
            throw new RuntimeException(employeeID + " is not a valid employee id.");
        }
        super.goToFloor(floorNum);
    }
    public static void main(String[] args) {
       new Cafe();
    }
    
}
