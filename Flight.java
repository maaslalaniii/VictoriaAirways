import java.util.Date;

/**
 * A flight which journeys from a point of departure to a destination.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang
 * @version 1.0 2016-12-23
 */
public class Flight
{
    /* instance fields */
    private Cargo[] cargo;
    private double cost;
    private Date date;
    private String departure;
    private String destination;
    private Passenger[] passenger;
    private Plane plane;

    /* constructors */
    /**
     * Constructs a flight with the specified characteristics.
     * 
     * @param cost the cost of a single ticket in this flight
     * @param date the time of the departure of this flight
     * @param destination the destination of this flight
     * @param departure the departure of this flight
     * @param plane the plane in which this flight will take place
     *  
     */
    public Flight(double cost,
    		  Date date,
    		  String destination,
    		  String departure,
    		  Plane plane)
    {
        this.cargo = new Cargo[plane.getMaximumNumberOfItemsOfCargo()];
        this.cost = cost;
        this.date = date;
        this.destination = destination;
        this.departure = departure;
        this.passenger = new Passenger[plane.getMaximumNumberOfPassengers()];
        this.plane = plane;
    } // end of constructor Flight(double cost..)
    
    /* accessors */
    /**
     * Returns the cargo of this flight.
     * 
     * @return the cargo of this flight
     */
    public Cargo[] getCargo()
    {
        return this.cargo;
    } // end of method getCargo()

    /**
     * Returns the cost of a single ticket of this flight.
     * 
     * @return the cost of a single ticket of this flight
     */
    public double getCost()
    { 
        return this.cost;
    } // end method getCost()
    
    /**
     * Returns the date of this flight.
     *
     * @return the date of this flight
     */
    public Date getDate()
    {
        return this.date;
    } // end method getDate()

    /**
     * Returns the departure of this flight.
     *
     * @return the departure of this flight
     */
    public String getDeparture()
    {
        return this.departure;
    } // end method getDeparture()

    /**
     * Returns the destination of this flight.
     *
     * @return the destination of this flight
     */
    public String getDestination()
    {
        return this.destination;
    } // end method getDestination()
    
    /**
     * Returns the plane of this flight.
     *
     * @return the plane of this flight
     */
    public Plane getPlane()
    {
        return this.plane;
    } // end method getPlane()
    
    /**
     * Returns the passengers of this flight.
     *
     * @return the passengers of this flight
     */
    public Passenger[] getPassengers()
    {
        return this.passenger;
    } // end method getPassengers()
    
    /* mutators */
    /**
     * Sets the plane of this flight.
     *
     * @param plane the plane of this flight
     */
    public void setPlane(Plane plane)
    {
        if (plane == null) return;

        this.plane = plane;
    } // end method setPlane(Plane plane)
    
    /**
     * Sets the passengers of this flight.
     *
     * @param passenger the passengers of this flight
     */
    public void setPassengers(Passenger[] passenger)
    {
        if (passenger == null) return;
        if (this.passenger.length 
			> plane.getMaximumNumberOfPassengers()) return;

        this.passenger = passenger;
    } // end method setPassengers(Passenger[] passenger)

    /**
     * Sets the cargo of this flight.
     * 
     * @param cargo the new cargo of the flight.
     */
    public void setCargo(Cargo[] cargo)
    {
        if (cargo == null) return;
        if (cargo.length > plane.getMaximumNumberOfItemsOfCargo()) return;

        this.cargo = cargo;
    } // end method setCargo(Cargo[] cargo)
    
    /**
     * Adds an item of cargo to the flight's cargo.
     * 
     * @param cargo the item of cargo to add to this flight's cargo
     */
    public void addCargo(Cargo cargo)
    {
        if (cargo == null) return;

        // Ensure there is enough space for the cargo item.
        if (this.cargo.length
			>= this.plane.getMaximumNumberOfItemsOfCargo()) return;

        this.cargo[this.cargo.length] = cargo;
    } // end of method addCargo(Cargo cargo)
    
    /**
     * Sets the cost of a single ticket of this flight.
     *
     * @param cost the cost for a single ticket of this flight
     */
    public void setCost(double cost)
    {
        if (cost < 0) return;

        this.cost = cost;
    } // end method setCost(double cost)
    
    /**
     * Sets the date of this flight.
     *
     * @param date the date of this flight
     */
    public void setDate(Date date)
    {
        if (date == null) return;

        this.date = date;
    } // end method setDate(Date date)
    
    /**
     * Sets the destination of this flight.
     *
     * @param destination the destination of this flight
     */
    public void setDestination(String destination)
    {
        if (destination == null) return;

        this.destination = destination;
    } // end method setDestination(String destination)
    
     /**
     * Sets the departure of this flight.
     *
     * @param departure the departure of this flight
     */
    public void setDeparture(String departure)
    {
        if (departure == null) return;

        this.departure = departure;
    } // end method setDeparture(String departure)
} // end of class Flight
