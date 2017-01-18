import java.util.Date;

/**
 * The centralized operations office of Victoria Airways.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang
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

    /* constructors */
    /**
     * Constructs an operations office with the specified information.
     * 
     * @param maximumNumberOfFlights the maximum number of 
     * flights this operations office can store
     * @param maximumNumberOfPlanes the maximum number of 
     * planes this operations office can store
     * @param maximumNumberOfCustomers the maximum number of 
     * customers this operations office can store
     * 
     */
    public OperationsOffice(int maximumNumberOfCustomers, 
    int maximumNumberOfFlights, int maximumNumberOfPlanes)
    {
        customer = new Passenger[maximumNumberOfCustomers];
        flight = new Flight[maximumNumberOfFlights];
        plane = new Plane[maximumNumberOfPlanes];

        numberOfCustomers = 0;
        numberOfFlights = 0;
        numberOfPlanes = 0;
    } // end of constructor OperationsOffice(int maximumNumberOfCustomers...)

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
     * @param customer the array which contains the information 
     * for customers of Victoria Airlines
     */
    public void setCustomers(Passenger[] customer)
    {
        if (customer == null) return;

        this.customer = customer;
    } // end of method set(Passenger[] customer)

    /**
     * Sets the flights record of this operations office.
     *
     * @param flight the array which contains the information 
     * for flights of Victoria Airlines
     */
    public void setFlights(Flight[] flight)
    {
        if (flight == null) return;

        this.flight = flight;
    } // end of method setFlights(Flight[] flight)

    /**
     * Sets the planes record of this operations office.
     *
     * @param plane the array which contains the information
     * for flights of Victoria Airlines
     */
    public void setPlanes(Plane[] plane)
    {
        if (plane == null) return;

        this.plane = plane;
    } // end of method setPlanes(Plane[] plane)

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
     * Adds a plane to the record of this operations office.
     *
     * @param plane the plane to be added
     */
    public void addPlane(Plane plane)
    {
        if (flight == null) return;

        this.plane[numberOfPlanes++] = plane;
    } // end of method addPlane(Plane plane)

    /**
     * Removes a flight to the record of this operations office.
     *
     * @param flight the flight to be removed
     */
    public void removeFlight(Flight flight)
    {
        if (flight == null) return;

        // Find the index of this flight
        int indexOfFlight = 0;
        for (int i = indexOfFlight; i < numberOfFlights; i++)
        {
            if (this.flight[indexOfFlight].equals(flight))
            {
                // Shift all the flights after the removed flight down one
                this.flight[indexOfFlight] = this.flight[indexOfFlight + 1];
            } // end of if (this.flight[indexOfFlight].equals(flight))
        } // end of for (int i = indexOfFlight; i < numberOfFlights; i++)
    } // end of method removeFlight(Flight flight)

    /**
     * Removes a flight by its index to the record of this operations office.
     *
     * @param indexOfFlight the index of the flight to be removed
     * 
     * @return the flight that was removed, <code>null</code>
     * if the removal was unsuccessful
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

    /**
     * Schedules a flight from the specified departure
     * to destination at the specifed date with the 
     * specified cost.
     * 
     * @param cost the cost of this flight
     * @param year the year of the takeoff of 
     * this flight 
     * @param month the month of the takeoff of 
     * this flight
     * @param day the day of the takeoff of this
     * flight
     * @param hour the hour of the takeoff of this
     * flight
     * @param minute the minute of the takeoff of
     * this flight
     * @param destination the destination of this flight
     * <br><i>pre-condition: </i> destination may not be 
     * <code>null</code>
     * @param departure the departure of this flight
     * <br><i>pre-condition: </i> departure may not be 
     * <code>null</code>
     * 
     */
    public void scheduleFlight(double cost, int year, int month, int day,
    int hour, int minute, String destination, String departure)
    {
        final int SHORT_RANGE_DISTANCE_KM = 5000;
        final int MEDIUM_RANGE_DISTANCE_KM = 10000;
        // Create takeoff date
        Date takeoff = new Date(year, month, day, hour, minute);

        // Create departure and destinatino locations
        Location flightDestination = new Location(destination);
        Location flightDeparture = new Location(departure);

        // Calculate distance of flight
        Double flightDistance = calculateDistanceKm(flightDeparture, 
                flightDestination);

        // Using the distance of the flight, determine the range of flight
        String flightRange = "";
        if (flightDistance <= SHORT_RANGE_DISTANCE_KM)
        {
            flightRange = "Short"; 
        }
        else if (flightDistance > SHORT_RANGE_DISTANCE_KM
        && flightDistance <= MEDIUM_RANGE_DISTANCE_KM)
        {
            flightRange = "Medium";
        }
        else 
        {
            flightRange = "Long";
        } // end of if (flightDistance <= SHORT_RANGE_DISTANCE_KM)

        /* Locate a plane at the departure with the flight's range
         * in the operations office database
         */    
        Plane [] plane = this.getPlanes(); 
        int counter = 0;

        Plane flightPlane = null; 
        while (counter >= 0 && counter < plane.length)
        {
            /* Check if the plane has the required range
             * and is present at the departure
             */
            if (plane[counter].getRange().equals(flightRange) 
            && plane[counter].getLocation().equals(departure))
            {
                System.out.println(plane[counter].getName());
                flightPlane = plane[counter]; 
                // set counter to -1 so the loop is exited
                counter = -1;
            }
            else
            {
                //increment counter
                counter++;
            }// end of if (plane[counter].getRange() == flightRange...)
        } // end of while (counter > 0 && counter < plane.length)

        // Was a plane meeting the requirements found?
        if (flightPlane != null)
        {
            // Create a new flight
            Flight flight1 = new Flight(cost, takeoff, 
            flightDestination.toString(), flightDeparture.toString(), flightPlane); 

            // Add flight to the flight database
            this.addFlight(flight1);
        }
        // No plane found, 
        System.out.println ("No planes are available for this flight");
    } // end of method scheduleFlight(double cost, int year...)

    private static double calculateDistanceKm(Location departure, 
    Location destination)
    {
        final int EARTH_RADIUS = 6371;
        double latitude1 = Math.toRadians(departure.getLatitude());
        double latitude2 = Math.toRadians(destination.getLatitude());
        double longitude1 = Math.toRadians(departure.getLongitude());
        double longitude2 = Math.toRadians(destination.getLongitude());
        double latitudeDifference = latitude2 - latitude1;
        double longitudeDifference = longitude2 - longitude1;

        /*
         * Calulate distance between departure and destination by 
         * implementing the Haversine formula.
         */
        double a = Math.sin(latitudeDifference/2) 
            * Math.sin(latitudeDifference/2)
            + Math.cos(latitude1) * Math.cos(latitude2) 
            * Math.sin(longitudeDifference/2) * Math.sin(longitudeDifference/2); 

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = EARTH_RADIUS * c;
        return distance;
    } // end of method calculateDistanceKm(Location departure...)
} // end of class OperationsOffice
