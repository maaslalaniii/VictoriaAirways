/**
 * A luggage belonging to one of the passengers.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 1.0 2016-12-23
 */

public class Cargo
{
   /* instance fields */
   private boolean hasWheels;
   private double size;
   private double weight;
   
   /* constructors */
   /**
    * Constructs a cargo with the specified characteristics.
    * 
    * @param weight the weight of the cargo in kilograms
    * @param hasWheels <code>true</code> if this cargo has
    * wheels; <code>false</code> otherwise
    * @param size the size of the cargo in centimetres
    */
   public Cargo(double weight, boolean hasWheels, double size)
   {
      this.weight = weight;
      this.hasWheels = hasWheels;
      this.size = size;
   } // end of constructor Cargo(double weight, boolean hasWheels)
   
   /* accessors */  
   /**
    * Returns the weight of the cargo.
    * 
    * @return the weight the weight of the cargo
    */
   public double getWeight()
   {
       return weight;
   } // end of method getWeight()
   
   /**
    * Returns the cargo's possession of wheels.
    * 
    * @return the cargo's possession of wheels
    */
    public boolean getPossessionOfWheels()
   {
       return hasWheels;
   } // end of method getPossessionOfWheels()
   
   /**
    * Returns the size of the cargo in centimetres.
    * 
    * @return the size of the cargo in centimetres
    */
   public double getSize()
   {
       return size;
   } // end of method getSize()
   
   /* mutators */ 
   /**
    * Sets the weight of the cargo.
    * 
    * @param weight the weight of the cargo
    */
    public void setWeight(int weight)
   {
       this.weight = weight;
   } // end of method setWeight(int weight)
   
   /**
    * Sets the cargo's possession of wheels.
    * 
    * @param hasWheels <code>true</code> if this cargo has
    * wheels; <code>false</code> otherwise
    */
    public void setPossessionOfWheels(boolean hasWheels)
   {
       this.hasWheels = hasWheels;
   } // end of method setPossessionOfWheels(boolean hasWheels)
   
    /**
    * Sets the size of the cargo.
    * 
    * @param size the size of the cargo in centimetres
    */
    public void setSize(double size)
   {
       this.size = size;
   } // end of method setSize(double size)
} // end of class Cargo
