/**
 * Write a description of class Plane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane
{
    // instance fields 
    private String name;
    private int maximumPassengers;
    private int maximumNumberOfItemsCargo;
    private String aircraftType;
    private int [][] seat;
    private boolean isScheduled;
    private String range;

    /**
     * Constructs a plane with default characteristics 
     */
    public Plane()
    {
        name = "";
        maximumPassengers = 0;
        maximumNumberOfItemsCargo = 0;
        aircraftType = "";
        seat = new int [0][0];
        isScheduled = false;
        range = "";
    }// end of contructor Plane()

    /**
     * Constructs a plane with specified name, passenger
     * limit, cargo limit, aircraft type, seating plan,
     * schedule status and range.
     * 
     * @param name the name of this plane
     * @param maximumPassengers the passenger limit of 
     * this plane
     * @param maximumNumberOfItemsCargo the cargo limit
     * of this plane
     * @param aircraftType the aircraft type of this plane
     * @param seat the seating plan of this plane
     * @param isScheduled the schedule status of this plane
     * @param range the range of this plane
     */
    public Plane(String name, int maximumPassengers, int maximumNumberOfItemsCargo, 
                    String aircraftType, int [] [] seat, boolean isScheduled, String range)
    {
        this.name = name;
        this.maximumPassengers = maximumPassengers;
        this.maximumNumberOfItemsCargo = maximumNumberOfItemsCargo;
        this.aircraftType = aircraftType;
        this. seat = seat;
        this.isScheduled = isScheduled;
        this.range = range;
    }/* end of constructor Plane(String name, int maximumPassengers, int maximumNumberOfItemsCargo
    String aircraftType, int [] [] seat, boolean isScheduled, String range)
     */

    /**
     * Returns the name of this plane.
     * 
     * @return the name of this plane
     */
    public String getName()
    {
        return this.name;
    }// end of method getName()

    /**
     * Returns the maximum number of passengers
     * of this plane.
     * 
     * @return the maximum number of passengers of
     * this plane
     */
    public int getMaximumPassengers()
    {
        return this.maximumPassengers;
    } // end of method getMaximumPassengers()

    /**
     * Returns the type of aircraft of this
     * plane.
     * 
     * @return the type of aircraft of this 
     * plane
     */
    public String getAircraftType()
    {
        return aircraftType;
    } // end of method getAircraftType

    /**
     * Returns the seating plan of this plane.
     * 
     * @return the seating plan of this plane
     */
    public int[][] getSeat()
    {
        return this.seat;
    } // end of method getSeat() 
    
    /**
     * Checks if this plane is scheduled.
     * 
     * @return <code>true</code> if this plane is
     * scheduled otherwise <code>false.</code>
     */
    public boolean isScheduled()
    {
        return this.isScheduled;
    } // end of method isScheduled()

    /**
     * Returns the range of this plane.
     * 
     * @return the range of this plane
     */
    public String getRange()
    {
        return this.range;
    } // end of method getRange()
    
    /**
     * Sets the name of this plane. 
     * 
     * @param name the name of this plane.
     */
    public void setName(String name)
    {
        this.name = name;
    } // end of method setName(String name)

}

