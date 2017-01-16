
/**
 * The Victoria Airlines centralized operations office.
 * 
 * @author Maas, Ming Zhao, Jenisha
 * @version 2017-01-16
 */
public class OperationsOffice
{   
    /* instance fields */
    private Passenger[] customer;
    private Flight[] flight;
    private Plane[] plane;
    private int numberOfCustomers;
    private int numberOfFlights;
    private int numberOfPlanes;

    /**
     * Constructs an operations office with the specified information.
     * 
     * @param maximumNumberOfFlights the maximum number of flights this operations office can store
     * @param maximumNumberOfPlanes the maximum number of planes this operations office can store
     * @param maximumNumberOfCustomers the maximum number of customers this operations office can store
     * 
     */
    public OperationsOffice(int maximumNumberOfCustomers, int maximumNumberOfFlights, int maximumNumberOfPlanes)
    {
        customer = new Passenger[maximumNumberOfCustomers];
        flight = new Flight[maximumNumberOfFlights];
        plane = new Plane[maximumNumberOfPlanes];

        numberOfCustomers = 0;
        numberOfFlights = 0;
        numberOfPlanes = 0;
    } // end of constructor OperationsOffice(int maximumNumberOfCustomers, int maximumNumberOfFlights, int maximumNumberOfPlanes)

    /* accessors */
    /**
     * Returns the record of all customers in this operations office.
     *
     * @return the record of all customers in this operations office
     */
    public Passenger[] getCustomers()
    {
        return customer;
    } // end of method getCustomers()

    /**
     * Returns the record of all flights in this operations office.
     *
     * @return the record of all flights in this operations office
     */
    public Flight[] getFlights()
    {
        return flight;
    } // end of method getFlights()

    /**
     * Returns the record of all planes in this operations office.
     *
     * @return the record of all planes in this operations office
     */
    public Plane[] getPlanes()
    {
        return plane;
    } // end of method getPlanes()

    /* mutators */
    /**
     * Sets the customers record of this operations office.
     *
     * @param customer the array which contains the information for customers of Victoria Airlines
     */
    public void setCustomers(Passenger[] customer)
    {
        if (customer == null) return;

        this.customer = customer;
    } // end of method set(Passenger[] customer)

    /**
     * Sets the flights record of this operations office.
     *
     * @param flight the array which contains the information for flights of Victoria Airlines
     */
    public void setFlights(Flight[] flight)
    {
        if (flight == null) return;

        this.flight = flight;
    } // end of method setFlights(Flight[] flight)

    /**
     * Sets the planes record of this operations office.
     *
     * @param plane the array which contains the information for flights of Victoria Airlines
     */
    public void setPlanes(Plane[] plane)
    {
        if (plane == null) return;

        this.plane = plane;
    } // end of method setPlanes(Plane[] plane)

    /* utility mutators */
    /**
     * Adds a flight to the record of this operations office.
     *
     * @param flight the flight to be added
     */
    public void addFlight(Flight flight)
    {
        if (flight == null) return;

        this.flight[numberOfFlights++] = flight;
    } // end of method addFlight(Flight flight)

    /**
     * Removes a flight to the record of this operations office.
     *
     * @param flight the flight to be removed
     */
    public void removeFlight(Flight flight)
    {
        if (flight == null) return;
        
        // find the index of this flight.
        

        // Shift all the flights after the removed flight down one.
        for (int i = indexOfFlight; i < numberOfFlights; i++) {
            this.flight[indexOfFlight] = this.flight[indexOfFlight + 1];
        } // end of for (int i = indexOfFlight; i < numberOfFlights; i++)
    } // end of method removeFlight(Flight flight)

    /**
     * Removes a flight by its index to the record of this operations office.
     *
     * @param indexOfFlight the index of the flight to be removed
     * 
     * @return the flight that was removed, <code>null</code> if the removal was unsuccessful
     */
    public Flight removeFlightByIndex(int indexOfFlight)
    {        
        if (indexOfFlight < 0) return null;
        if (indexOfFlight > numberOfFlights) return null;

        Flight flightToBeRemoved = this.flight[indexOfFlight];
        this.flight[numberOfFlights--] = null;

        // Shift all the flights after the removed flight down one.
        for (int i = indexOfFlight; i < numberOfFlights; i++) {
            this.flight[indexOfFlight] = this.flight[indexOfFlight + 1];
        } // end of for (int i = indexOfFlight; i < numberOfFlights; i++)

        return flightToBeRemoved;
    } // end of method removeFlightByIndex(int indexOfFlight)

} // end of class OperationsOffice
