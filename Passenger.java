/**
 * A passenger who is capable of boarding a flight.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 1.0 2016-12-23
 */

public class Passenger
{
   /* instance fields */
   private int age;
   private boolean hasTicket;
   private String name;
   
   /* constructors */
   /**
    * Constructs a passenger with the specified characteristics.
    * 
    * @param name the name of the passenger
    * @param age the age of the passenger
    * @param hasTicket <code>true</code> if this passenger has
    * a ticket; <code>false</code> otherwise
    */
   public Passenger(String name, int age, boolean hasTicket)
   {
      name = "";
      hasTicket = false;
      age = 0;
   } // end of constructor Passenger()

   /* accessors */  
   /**
    * Returns the age of the passenger.
    * 
    * @return the age of the passenger
    */
   public int getAge()
   {
       return age;
   } // end of method getAge()
   
   /**
    * Returns the name of the passenger.
    * 
    * @return the name of the passenger
    */
    public String getName()
   {
       return name;
   } // end of method getName()
   
   /**
    * Returns <code>true</code> if the passenger has a ticket; otherwise
    * <code>false</code>.
    * 
    * @return <code>true</code> if the passenger has a ticket; otherwise
    * <code>false</code>
    */
    public boolean hasTicket()
   {
       return hasTicket;
   } // end of method hasTicket()
   
   /* mutators */ 
   /**
    * Sets the age of the passenger.
    * 
    * @param age the age of the passenger
    */
    public void setAge(int age)
   {
       this.age = age;
   } // end of method setAge(int age)
   
   /**
    * Sets the name of the passenger.
    * 
    * @param name the name of the passenger
    */
    public void setName(String name)
   {
       this.name = name;
   } // end of method setName(String name)
   
   /**
    * Sets the passenger's possession of a ticket
    * 
    * @param hasTicket <code>true</code> if this passenger has
    * a ticket; <code>false</code> otherwise
    */
    public void setPossessionOfTicket(boolean hasTicket)
   {
       this.hasTicket = hasTicket;
   } // end of method setPossessionOfTicket(boolean hasTicket)
} // end of class Passenger
