import java.util.ArrayList;

public class House extends Building {
    /* List of all the residents in the house */
    private ArrayList<String> residents;
    /* Whether or not the house has a dining room */
    private boolean hasDiningRoom;
    /* Whether or not the house has an elevator */
    private boolean hasElevator;
  
    /**
    * Creates a new default house.
    */
    public House(){
      super("Unknown", "Unknown", 1);
      this.hasDiningRoom = false;
      this.hasElevator = false;
      this.residents = new ArrayList<>();
      System.out.println("You have built a house: 🏠");
    }

    /**
     * Creates a house with an elevator
     * @param name
     * @param address
     * @param nFloors
     * @param hasDiningRoom
     */
    public House (String name, String address, int nFloors, boolean hasDiningRoom){
      super(name, address, nFloors);
      this.hasDiningRoom = hasDiningRoom;
      this.hasElevator = true;
      this.residents = new ArrayList<>();
      System.out.println("You have built a house: 🏠");
    }

    /**
     * Creates a house with exactly 2 floors
     * @param name
     * @param address
     * @param hasDiningRoom
     * @param hasElevator
     */

     public House (String name, String address, boolean hasDiningRoom, boolean hasElevator){
      super(name, address);
      this.hasDiningRoom = hasDiningRoom;
      this.hasElevator = hasElevator;
      this.nFloors = 2;
      this.residents = new ArrayList<>();
      System.out.println("You have built a house: 🏠");
    }

   /**
    * Creates a new house.
    * @param name String
    * @param address String
    * @param nFloors int
    * @param hasDiningRoom boolean
    * @param hasElevator boolean
    */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
     super(name,address,nFloors);
     this.hasDiningRoom = hasDiningRoom;
     this.hasElevator = hasElevator;
     this.residents = new ArrayList<>();
     System.out.println("You have built a house: 🏠");
    }

   /**
    * Indicates whether or not the house has a dining room.
    * @return true if it does or false if it does not 
    */
    public boolean hasDiningRoom(){
      return this.hasDiningRoom;
    }

    /**
    * Indicates whether or not the house has a dining room.
    * @return true if it does or false if it does not 
    */
    public boolean hasElevator(){
      return this.hasElevator;
    }

    /**
     * Indicates the number of residents in the house.
     * @return number of residents
     */
    public int nResidents(){
      return this.residents.size();
    }
    
    /**
     * Adds a new resident to the house
     * @param name String
     */
    public void moveIn(String name){
      if (this.residents.contains(name)){
        throw new RuntimeException (name + " is already a resident of this house. ");
      }
      this.residents.add(name);
      System.out.println(name + " is now a resident of this house.");
    }
    
    /**
     * Removes a resident from the house
     * @param name String
     * @return name of the resident moved out
     */
    public String moveOut(String name){
      if (!this.residents.contains(name)){
        throw new RuntimeException(name + " is not a resident of this house. ");
      }
        this.residents.remove(name);
        System.out.println(name + " is no longer a resident of this house.");
        return name;
    }

    /**
     * Checks whether or not a person is a resident of this house.
     * @param person String
     * @return true if the person is a resident or false if not 
     */
    public boolean isResident(String person){
      return this.residents.contains(person);
    }

    /**
     * Prints all the available options depending on whether or not the house has an elevator
     */
    public void showOptions() {
      if (this.hasElevator) {
              super.showOptions();
      }
      else {
              System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()");
      }
    }

    /** 
     * Allows user to move between floors if the house has an elevator 
     * @param floorNum int
     */
    public void goToFloor(int floorNum){
      if (!this.hasElevator){
        throw new RuntimeException ("This house does not have an elevator.");
      }
      super.goToFloor(floorNum);
    }

    public static void main(String[] args) {
      new House();
    }
    
  }
