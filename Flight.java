/**
 * A flight which journeys from a point of departure to a destination.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang
 * @version 1.0 2016-12-23
 */
public class Flight
{
    /* instance fields */
    private String [] cargo;
    private double cost;
    private String date;
    private Location departure;
    private Location destination;
    private Passenger[] passenger;
    private Plane plane;
    private int numberOfPassengers;
    private int numberOfCargo;

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
    String date,
    Location destination,
    Location departure,
    Plane plane)
    {
        this.cargo = new String[plane.getMaximumNumberOfItemsOfCargo()];
        this.cost = cost;
        this.date = date;
        this.destination = destination;
        this.departure = departure;
        this.passenger = new Passenger[plane.getMaximumNumberOfPassengers()];
        this.plane = plane;
        this.numberOfPassengers = 0;
        this.numberOfCargo = 0;
    } // end of constructor Flight(double cost...)

    /* accessors */
    /**
     * Returns the cargo of this flight.
     * 
     * @return the cargo of this flight
     */
    public String [] getCargo()
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
    public String getDate()
    {
        return this.date;
    } // end method getDate()

    /**
     * Returns the departure of this flight.
     *
     * @return the departure of this flight
     */
    public Location getDeparture()
    {
        return this.departure;
    } // end method getDeparture()

    /**
     * Returns the destination of this flight.
     *
     * @return the destination of this flight
     */
    public Location getDestination()
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

    /**
     * Returns a string representation of this flight.
     * 
     * @return a string representatino of this flight
     */
    public String toString()
    {
        // Create strings representing the arrays
        String cargoList = "[";
        for (int i = 0; i < cargo.length; i ++)
        {
            cargoList += cargo[i] + " ";
        } // end of for (int i = 0; i < cargo.length; i ++)
        cargoList += "]";

        String passengerList = "[";
        for (int i = 0; i < passenger.length; i ++)
        {
            passengerList += passenger[i] + " ";
        } // end of for (int i = 0; i < cargo.length; i ++)
        passengerList += "]";
        return
        getClass().getName()
        + "["
        + "cargo: " + cargoList
        + ", cost: " + cost
        + ", date: " + date
        + ", departure: " + departure
        + ", destination: " + destination
        + ", passenger: " +  passengerList
        + ", plane: " + plane
        + ", passengerNumber: " + numberOfPassengers
        + ", cargoNumber: " + numberOfCargo   
        + "]";
    } // end of method toString()

    /**
     * Returns <code>true</code> if the flight has
     * reached maximum cargo capicity, otherwise 
     * <code>false.</code>
     * 
     * @return <code>true</code> if the flight has
     * reached maximum cargo capicity, otherwise 
     * <code>false.</code>
     */
    public boolean isCargoFull()
    {
        return this.numberOfCargo >= this.cargo.length;  
    } // end of method isCargoFull()
    
    /**
     * Returns <code>true</code> if the flight has
     * reached maximum passenger capicity, otherwise 
     * <code>false.</code>
     * 
     * @return <code>true</code> if the flight has
     * reached maximum passenger capicity, otherwise 
     * <code>false.</code>
     */
    public boolean isFlightFull()
    {
        return this.numberOfPassengers >= this.passenger.length;  
    } // end of method isCargoFull()
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
        // Set the plane as scheduled
        plane.setSchedule(true);
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
        // Reset passenger counter
        this.numberOfPassengers = 0;
    } // end method setPassengers(Passenger[] passenger)

    /**
     * Sets the cargo of this flight.
     * 
     * @param cargo the new cargo of the flight.
     */
    public void setCargo(String [] cargo)
    {
        if (cargo == null) return;
        if (cargo.length > plane.getMaximumNumberOfItemsOfCargo()) return;
        this.cargo = cargo;
        // Reset cargo counter
        this.numberOfCargo = 0;
    } // end method setCargo(Cargo[] cargo)

    /**
     * Adds an item of cargo to the flight's cargo.
     * 
     * @param cargo the item of cargo to add to this flight's cargo
     * <br><i>pre-condition: </i> cargo may not be <code>null</code>
     */
    public void addCargo(String cargo)
    {
        if (cargo == null) return;
        if (this.isCargoFull()) return;
        this.cargo[this.numberOfCargo] = cargo;
        numberOfCargo++;
    } // end of method addCargo(Cargo cargo)

    /**
     * Adds a passenger to this flight.
     * 
     * @param passenger the passenger to be added to this flight
     */
    public void addPassenger(Passenger passenger)
    {
        if (passenger == null) return;
        // Ensure there is enough space for the passenger.
        if (this.isFlightFull()) return;
        this.passenger[this.numberOfPassengers] = passenger;
        numberOfPassengers++;
    } // end of method addPassenger(Passenger passenger)

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
    public void setDate(String date)
    {
        if (date == null) return;

        this.date = date;
    } // end method setDate(Date date)

    /**
     * Sets the destination of this flight.
     *
     * @param destination the destination of this flight
     */
    public void setDestination(Location destination)
    {
        if (destination == null) return;

        this.destination = destination;
    } // end method setDestination(String destination)

    /**
     * Sets the departure of this flight.
     *
     * @param departure the departure of this flight
     */
    public void setDeparture(Location departure)
    {
        if (departure == null) return;

        this.departure = departure;
    } // end method setDeparture(String departure)
} // end of class Flight