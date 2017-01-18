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
    private int numberOfCustomers;
    private int numberOfFlights;
    private int numberOfPlanes;
    private Plane[] plane;

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
     */
    public OperationsOffice(int maximumNumberOfCustomers, 
                            int maximumNumberOfFlights, 
                            int maximumNumberOfPlanes)
    {
        customer = new Passenger[maximumNumberOfCustomers];
        flight = new Flight[maximumNumberOfFlights];
        plane = new Plane[maximumNumberOfPlanes];

        numberOfCustomers = 0;
        numberOfFlights = 0;
        numberOfPlanes = 0;
    } // end of constructor OperationsOffice(int maximumNumberOfCustomers..)
    
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
     * @param customer the array which contains the information for 
     * customers of Victoria Airlines
     */
    public void setCustomers(Passenger[] customer)
    {
        if (customer == null) return;

        this.customer = customer;
    } // end of method set(Passenger[] customer)

    /**
     * Sets the flights record of this operations office.
     *
     * @param flight the array which contains the information for flights 
     * of Victoria Airlines
     */
    public void setFlights(Flight[] flight)
    {
        if (flight == null) return;

        this.flight = flight;
    } // end of method setFlights(Flight[] flight)

    /**
     * Sets the planes record of this operations office.
     *
     * @param plane the array which contains the information for flights of 
     * Victoria Airlines
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
        if (numberOfFlights >= this.flight.length) return;
        this.flight[numberOfFlights++] = flight;
    } // end of method addFlight(Flight flight)

    /**
     * Adds a plane to the record of this operations office.
     *
     * @param plane the plane to be added
     */
    public void addPlane(Plane plane)
    {
        if (plane == null) return;
        if (numberOfPlanes >= this.plane.length) return;
        this.plane[numberOfPlanes++] = plane;
    } // end of method addPlane(Plane plane)

    /**
     * Adds a passenger to the customer database 
     * of this operation office.
     * 
     * @param passenger the passenger to be added
     */
    public void addCustomer(Passenger passenger)
    {
        if (passenger == null) return;
        if (numberOfCustomers >= this.customer.length) return;
        this.customer[numberOfCustomers++] = passenger;
    } // end of method addCustomer(Passenger passenger) 

    /**
     * Removes a flight to the record of this operations office.
     *
     * @param flight the flight to be removed
     */
    public void removeFlight(Flight flight)
    {
        if (flight == null) return;

        int indexOfFlight = -1;
        // find the index of this flight.
        for (int i = 0; i < numberOfFlights; i++)
        {
            if (this.flight[i] == flight)
            {
                indexOfFlight = i;
            } // end of if (this.flight[i] == flight)
        } // end of for (int i = 0; i < numberOfFlights; i++)

        // Shift all the flights after the removed flight down one.
        for (int i = indexOfFlight; i < numberOfFlights; i++) 
        {
            this.flight[indexOfFlight] = this.flight[indexOfFlight + 1];
        } // end of for (int i = indexOfFlight; i < numberOfFlights; i++)

        // Set the plane of the removed flight as unscheduled
        flight.getPlane().setSchedule(false);
    } // end of method removeFlight(Flight flight)

    /**
     * Removes a flight by its index to the record of this operations office.
     *
     * @param indexOfFlight the index of the flight to be removed
     * 
     * @return the flight that was removed, <code>null</code> if the 
     * removal was unsuccessful
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
        // Set the plane of the removed flight as unscheduled
        flightToBeRemoved.getPlane().setSchedule(false);

        return flightToBeRemoved;
    } // end of method removeFlightByIndex(int indexOfFlight)

    /**
     * Schedules a flight from the specified departure
     * to destination at the specifed date with the 
     * specified cost.
     * 
     * @param cost the cost of this flight <br><i>
     * pre-condition</i> cost cannot be negative
     * @param date the takeoff date of this flight
     * <br><i>pre-condition: </i> date may not be 
     * <code>null</code>
     * @param destination the destination of this flight
     * <br><i>pre-condition: </i> destination may not be 
     * <code>null</code>
     * @param departure the departure of this flight
     * <br><i>pre-condition: </i> departure may not be 
     * <code>null</code>
     * @return the scheduled flight, if required plane is 
     * present otherwise <code>null</code>
     * 
     */
    public Flight scheduleFlight(double cost, 
    Date date,
    String destination,
    String departure)
    {
        if (cost >= 0 && date != null && destination != null && 
        departure != null && 
        this.numberOfFlights < this.getFlights().length)
        {
            final int SHORT_RANGE_DISTANCE_KM = 5000;
            final int MEDIUM_RANGE_DISTANCE_KM = 10000;

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
            else if (flightDistance > SHORT_RANGE_DISTANCE_KM && 
            flightDistance <= MEDIUM_RANGE_DISTANCE_KM)
            {
                flightRange = "Medium";
            }
            else 
            {
                flightRange = "Long";
            } // end of if (flightDistance <= SHORT_RANGE_DISTANCE_KM)

            /*
            Locate a plane at the departure with the flight's range in the 
            operations office database
             */
            Plane [] plane = this.getPlanes(); 
            int counter = 0;

            Plane flightPlane = null; 
            while (counter >= 0 && counter < plane.length)
            {
                /* Check if the plane has the required range and is present 
                 *at the departure and isn't scheduled
                 */
                if (plane[counter].getRange().equals(flightRange) && 
                plane[counter].getLocation().equals(departure) 
                && plane[counter].isScheduled() == false)
                {
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
                Flight flight1 = new Flight(cost, date, flightDestination, 
                        flightDeparture, flightPlane); 
                // Set the plane as scheduled
                flightPlane.setSchedule(true);
                // Add flight to the flight database
                this.addFlight(flight1);
                return flight1;
            }
            // No plane found, 
            return null;
        }// end of if (cost >= 0 && date != null && destination...)
        return null;
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
        double a = Math.sin(latitudeDifference/2) * 
            Math.sin(latitudeDifference/2) + Math.cos(latitude1) * 
            Math.cos(latitude2) * Math.sin(longitudeDifference/2) * 
            Math.sin(longitudeDifference/2); 
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = EARTH_RADIUS * c;
        return distance;
    } // end of method calculateDistanceKm(Location departure...)

    /**
     * Creates a ticket for flight with the specified departure and destination
     * for the specified passenger if such a flight exists in the operation 
     * office flight database.
     * 
     * @param passenger the passenger to be booked into a flight
     * <br><i>pre-condition: </i> passenger may not be <code>null</code>
     * @param departure the departure of the passenger's trip <b><i>
     * pre-condition: </i> departure may not <code>null</code>
     * @param destination the destination of the passenger's trip
     * <b><i>pre-condition: </i> destination may not <code>null</code>
     */
    public void createTicket(Passenger passenger, 
    String departure, 
    String destination)
    {
        // Check validity of parameters
        if (passenger == null)return;
        if(departure == null )return;
        if (destination == null)return;

        // Does this passenger have a passport?
        if (passenger.hasPassport() == false)return;

        Flight ticketFlight = null; 
        String ticketSeatName = null;
        int counter = 0;

        /*
         * Locate a flight with the required departure and destination 
         * in the database.
         */ 
        while (ticketFlight == null && counter < numberOfFlights)
        {
            if (this.flight[counter].getDeparture().getLocationName()
            .equals(departure) && this.flight[counter].getDestination()
            .getLocationName().equals(destination) && 
            flight[counter].isFull() != true)
            {
                ticketFlight = flight[counter];
                /*
                 * Go through the seats of the flight and allocate the first 
                 * empty seat found to the passenger's ticket
                 */
                int row = 0; 
                int column = 0;
                boolean seatFound = false;

                while (row < ticketFlight.getPlane().getSeat().length && 
                seatFound == false)
                {
                    while (column < ticketFlight.getPlane()
                    .getSeat()[row].length && seatFound == false)
                    {
                        // Is the seat occupied?
                        if (ticketFlight.getPlane().getSeat()[row][column]
                        .isTaken() == false)
                        {
                            ticketSeatName = ticketFlight.getPlane()
                            .getSeat()[row][column]
                            .getSeatName();
                            /*
                             * Set seat as taken in order to prevent multiple 
                             * bookings of the same seat.
                             */
                            this.flight[counter].getPlane()
                            .getSeat()[row][column].setAvailability(true);
                            // Set seat as found and exit loop.
                            seatFound = true;
                        } // end of if (ticketFlight.getPlane().getSeat...)
                        // increment column
                        column++;
                    }// end of while (column < ticketFlight.getPlane()...)
                    // increment row
                    row++;
                }// end of while (row < ticketFlight.getPlane().getSeat().length)

            } //  if (this.flight[i].getDeparture().getLocationName().equals...)
            // increment the counter to move onto next flight in the database
            counter ++;
        } // end of for (int i = 0; i < numberOfFlights; i++)

        // Create a new ticket with the located flight and seat, if found
        if (ticketFlight == null || ticketSeatName == null)return;   
        Ticket bookedTicket = new Ticket(ticketFlight, ticketSeatName, 
                passenger);
    } // end of method bookTicket(Passenger passsenger...)

    /**
     * Reserves a seat on the flight specified on the ticket
     * for the specifed passenger and adds their cargo to 
     * to the flight.
     * 
     * @param passenger the passenger to be added to the flight
     * <br><i>pre-conditon: </i>passenger may not be <code>null</code>
     */
    public void reservation(Passenger passenger)
    {
        // Check validity of passenger
        if (passenger == null) return;

        // Find the ticket of passenger
        if (passenger.getTicket() == null) return;
        Ticket passengerTicket = passenger.getTicket();
        Flight passengerFlight = passengerTicket.getReservedFlight();

        /* Find the flight specified on the ticket, in the operations 
         * office flight database 
         */
        for (int i = 0; i < this.flight.length; i++)
        {
            // Is this the flight specified in the ticket?
            if (flight[i] == passengerFlight)
            {
                // Locate the seat specified on the ticket
                for (int row = 0; row < flight[i].getPlane().getSeat().length;
                row++)
                {
                    for (int column = 0; column < flight[i].getPlane()
                    .getSeat()[row].length; column++)
                    {
                        // Is this seat the seat on the passenger's ticket?
                        if (flight[i].getPlane().getSeat()[row][column]
                        .getSeatName()
                        .equals(passengerTicket.getReservedSeat()))
                        {
                            // Check if the seat is available
                            if (flight[i].getPlane().getSeat()[row][column]
                            .getPassenger() == null)
                            {
                                // Assign the passenger to the seat
                                flight[i].getPlane().getSeat()[row][column]
                                .setPassenger(passenger);
                                flight[i].getPlane().getSeat()[row][column]
                                .setAvailability(true);

                                // Add cargo to the flight
                                flight[i].addCargo(passenger.
                                    getPassengerCargo());

                                // Add the passenger to the flight
                                flight[i].addPassenger(passenger);
                            } // end of if (flight[i].getPlane().getSeat()...)
                        } // end of if (flight[i].getPlane().getSeat()...)
                    } // end of for (int column = 0; column < passengerPlane..)
                } // end of for (int row = 0; row < passengerPlane...)
            } // end of if (flight[i] == passengerFlight)
        } // end of for (int i = 0; i < this.flight.length; i++)
    } // end of method reserveSeat(Passenger passenger)

    /**
     * Rewards passengers who are in this operation office's 
     * database with frequent flyer points in accordance to 
     * their flight cost.
     * 
     * @param passenger the passenger to be rewarded points
     * <br><i>pre-condition: </i> passenger may not be 
     * <code>null</code>
     */
    public void rewardPoints(Passenger passenger)
    {
        // Check validity of passenger
        if (passenger == null) return;

        // Does the passenger have a ticket?
        if (passenger.hasTicket() == false)return;

        //Is the passenger in the operations office database?
        if (isRegistered(passenger, this.getCustomers()))
        {
            /* 
            Find the cost of the passenger's flight and add the 
            corresponding points to their points balance
             */
            int pointsToBeAdded = (int)(1.5 * passenger.getTicket()
                    .getReservedFlight().getCost());
            passenger.addPoints(pointsToBeAdded);
        } // end of  if (isRegistered(passenger, this.getCustomers())
    } // end of method rewardPoints(Passenger passenger)

    private static boolean isRegistered(Passenger passenger, 
    Passenger[] passengerDatabase)
    {
        for (int i = 0; i < passengerDatabase.length; i++) 
        {
            if (passengerDatabase[i] == passenger)
            {
                return true;
            } // if (passengerDatabase[i] == passenger)
        } // end of for (int i = 0; i < passengerDatabase.length; i++)
        return false;
    } // end of method isRegistered(Passenger passenger...)
} // end of class OperationsOffice
