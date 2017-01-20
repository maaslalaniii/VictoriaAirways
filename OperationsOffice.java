import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
/**
 * The centralized operations office of Victoria Airways.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 2017-01-16
 */
public class OperationsOffice
{
    /* class constants */
    private static int DEFAULT_MAXIMUM_NUMBER_OF_CUSTOMERS = 10000;
    private static int DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS = 1000;
    private static int DEFAULT_MAXIMUM_NUMBER_OF_PLANES = 100;

    private static String[] LIST_OF_COMMANDS = {
            "help",
            "add plane",
            "add flight",
            "add passenger",
            "remove plane",
            "remove flight",
            "remove passenger",
            "exit"
        };

    /* instance fields */
    private Passenger[] customer;
    private Flight[] flight;
    private int numberOfCustomers;
    private int numberOfFlights;
    private int numberOfPlanes;
    private Plane[] plane;

    /**
     * The CLI for Victoria Airlines operations office.
     */
    public static void main(String[] argument)
    {
        // Create the main operations office.
        OperationsOffice operationsOffice = new OperationsOffice(DEFAULT_MAXIMUM_NUMBER_OF_CUSTOMERS,
                DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS,
                DEFAULT_MAXIMUM_NUMBER_OF_PLANES);

        System.out.println("\fWelcome to the Victoria Airlines CLI.");
        System.out.println("Type \"help\" to list all of possible commands.");

        // print the list of commands
        help();

        boolean programShouldContinue = true;

        do
        {
            // Get input from the user.
            String input = getString("> ");

            // Check for sentinal value
            if (input.equals("exit"))
            {
                programShouldContinue = false;
            } // end of 

            // Handle the input.
            handleInput(input);

        } // end of loop
        while (programShouldContinue);
    } // end of method main(String[] argument)

    /**
     * Prints all the possible commands this CLI can handle.
     */
    public static void help()
    {
        System.out.println("Possible commands:");

        int numberOfCommands = LIST_OF_COMMANDS.length;

        // Print all commands except the last one so that the comma can be excluded.
        for (int i = 0; i < numberOfCommands - 1; i++)
        {
            System.out.print(LIST_OF_COMMANDS[i] + ", ");
        } // end of for(String command : LIST_OF_COMMANDS)

        // Print the last command in the list that we skipped.
        // Subtract one from the length of the array to get the index of the last element.
        System.out.println(LIST_OF_COMMANDS[numberOfCommands - 1]);
    } // end of help()

    /**
     * Returns a string obtained from the console, after the user had been given the specified prompt.
     * 
     * @param prompt the information to give the user before asking them for a value
     * 
     * @return the user input, empty string the method could not get input
     */
    public static String getString(String prompt)
    {
        BufferedReader console = null;
        String input = "";

        // Prompt the user.
        System.out.println(prompt);

        // Get Input from the user.
        try
        {
            console = new BufferedReader(new InputStreamReader(System.in));
            input = console.readLine();
        }
        catch (IOException exception)
        {
            System.out.println("Could not read input from command line interface. Please restart the program.");
        } // end of catch (IOException exception) 

        return input;
    } // end of getString(String prompt)

    /**
     * Returns an integer obtained from the console, after the user had been given the specified prompt.
     * 
     * @param prompt the information to give the user before asking them for a value
     * 
     * @return the user integer input
     */
    public static int getInt(String prompt)
    {
        // Get Input from the user.
        return 0;
    } // end of getInt(String prompt)

    /**
     * Returns an integer obtained from the console, after the user had been given the specified prompt.
     * 
     * @param prompt the information to give the user before asking them for a value
     * 
     * @return the user integer input
     */
    public static void handleInput(String input)
    {        
        // Handle the input.
        switch(input)
        {
            case "help":
            help();

            case "add flight":
            String cost = getString("cost?");

            default:
            System.out.println("\n\"" + input + "\" is not a valid command."
                + "\n\"help\" will bring up a list of possible commands.\n");

        } // end of 
    } // end of 

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
     * 
     * @return whether the operation was successful
     */
    public boolean addFlight(Flight flight)
    {
        if (flight == null) return false;
        if (numberOfFlights >= this.flight.length) return false;

        this.flight[numberOfFlights++] = flight;
        return true;
    } // end of method addFlight(Flight flight)

    /**
     * Adds a plane to the record of this operations office.
     *
     * @param plane the plane to be added
     * 
     * @return whether the operation was successful
     */
    public boolean addPlane(Plane plane)
    {
        if (plane == null) return false;
        if (numberOfPlanes >= this.plane.length) return false;

        this.plane[numberOfPlanes++] = plane;
        return true;
    } // end of method addPlane(Plane plane)

    /**
     * Adds a passenger to the customer database 
     * of this operation office.
     * 
     * @param passenger the passenger to be added
     * 
     * @return whether the operation was successful
     */
    public boolean addCustomer(Passenger passenger)
    {
        if (passenger == null) return false;
        if (numberOfCustomers >= this.customer.length) return false;

        this.customer[numberOfCustomers++] = passenger;
        return true;
    } // end of method addCustomer(Passenger passenger) 

    /**
     * Removes a flight to the record of this operations office.
     *
     * @param flight the flight to be removed
     * 
     * @return whether the operation was successful
     */
    public boolean removeFlight(Flight flight)
    {
        if (flight == null) return false;

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
        return true;
    } // end of method removeFlight(Flight flight)

    /**
     * Removes a flight by its index to the record of this operations office.
     *
     * @param indexOfFlight the index of the flight to be removed
     * 
     * @return whether the flight was successful
     */
    public boolean removeFlightByIndex(int indexOfFlight)
    {        
        if (indexOfFlight < 0) return false;
        if (indexOfFlight > numberOfFlights) return false;

        Flight flightToBeRemoved = this.flight[indexOfFlight];
        this.flight[numberOfFlights--] = null;

        // Shift all the flights after the removed flight down one.
        for (int i = indexOfFlight; i < numberOfFlights; i++) {
            this.flight[indexOfFlight] = this.flight[indexOfFlight + 1];
        } // end of for (int i = indexOfFlight; i < numberOfFlights; i++)

        // Set the plane of the removed flight as unscheduled
        flightToBeRemoved.getPlane().setSchedule(false);

        return true;
    } // end of method removeFlightByIndex(int indexOfFlight)

    /**
     * Reads plane data from the specified text file and 
     * creates a plane database for this operation office.
     * 
     * @param textFile the name of the textFile <br><i>textFile 
     * may not be null</i>
     * @return an array of the planes created from data found 
     * in the specified text file
     */
    public Plane [] loadPlaneData(String textFile)
    {
        Plane [] planeData; 
        try
        {
            // Create connection to file
            BufferedReader fileReader = new BufferedReader(new FileReader(textFile));
            String line = fileReader.readLine();

            // Create array to contain plane data
            planeData = new Plane[Integer.parseInt(line)];

            // Set the array as the planes record of this operation office
            this.setPlanes(planeData);

            while((line = fileReader.readLine()) != null)
            {
                String [] parameter = line.split("\t");

                // Extract the plane parameters stored in the file
                String name = parameter[0];
                int maxCargo = Integer.parseInt(parameter[1]); 
                String aircraft = parameter[2];
                int rows = Integer.parseInt(parameter[3]);
                int columns = Integer.parseInt(parameter[4]);
                boolean isScheduled = Boolean.parseBoolean(parameter[5]);
                String range = parameter[6];
                String location = parameter[7];

                // Create the plane using extracted parameters
                Plane planeToBeAdded = new Plane (name,maxCargo,aircraft,rows,columns,isScheduled,range,location);

                // Add the plane to the array
                this.addPlane(planeToBeAdded);
            } // end of while((line = fileReader.readLine()) != null)
        }
        catch (IOException error)
        {
            System.out.println ("Error Reading File");
            return null;
        }
        return planeData;
    } // end of method loadPlaneData(String textFile)

    /**
     * Reads passenger data from the specified text file and 
     * creates a customer database for this operation office.
     * 
     * @param textFile the name of the textFile <br><i>textFile 
     * may not be null</i>
     * @return an array of the passengers created from data found 
     * in the specified text file
     */
    public Passenger [] loadPassengerData(String textFile)
    {
        Passenger [] customerData; 
        try
        {
            // Create connection to file
            BufferedReader fileReader = new BufferedReader(new FileReader(textFile));
            String line = fileReader.readLine();

            // Create array to contain passenger data
            customerData = new Passenger[Integer.parseInt(line)];

            // Set the array as the passenger record of this operation office
            this.setCustomers(customerData);

            while((line = fileReader.readLine()) != null)
            {
                String [] parameter = line.split("\t");

                // Extract the passenger parameters stored in the file
                String name = parameter[0];
                int age = Integer.parseInt(parameter[1]); 
                boolean hasPassport = Boolean.parseBoolean(parameter[2]);
                int points = Integer.parseInt(parameter[3]);

                // Create the passenger using extracted parameters
                Passenger customerToBeAdded = new Passenger (name, age, null, hasPassport, points, null);

                // Add the passenger to the array
                this.addCustomer(customerToBeAdded);
            } // end of while((line = fileReader.readLine()) != null)
        }
        catch (IOException error)
        {
            System.out.println ("Error Reading File");
            return null;
        }
        return customerData;
    } // end of method loadPassengerData(String textFile)

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
    String date,
    String destination,
    String departure)
    {
        // Check validity of parameters
        if (cost < 0) return null; 
        if (date == null) return null; 
        if (destination == null) return null;  
        if (departure == null)return null;

        // Check if the operations office flight database is full
        if(this.numberOfFlights >= this.getFlights().length)return null;

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
    } // end of method scheduleFlight(double cost, String date)

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
     * for the specified passenger and reserves their seat,
     * if such a flight exists in the operation office flight database.
     * 
     * @param passenger the passenger to be booked into a flight
     * <br><i>pre-condition: </i> passenger may not be <code>null</code>
     * @param departure the departure of the passenger's trip <b><i>
     * pre-condition: </i> departure may not <code>null</code>
     * @param destination the destination of the passenger's trip
     * <b><i>pre-condition: </i> destination may not <code>null</code>
     * 
     * @return <code>true</code> if the reservation was made 
     * sucessfully otherwise <code>false</code>
     */
    public boolean addReservation(Passenger passenger, 
    String departure, 
    String destination)
    {
        // Check validity of parameters
        if (passenger == null)return false;
        if(departure == null )return false;
        if (destination == null)return false;

        // Does this passenger have a passport?
        if (passenger.hasPassport() == false)return false;

        Flight ticketFlight = null; 
        String ticketSeat = null;
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
            flight[counter].isFlightFull() != true)
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
                            // Check if the flight has room for the passenger.
                            if(ticketFlight.isFlightFull())return false;

                            // Check if the flight has room for the cargo.
                            if(ticketFlight.isCargoFull())return false;

                            ticketSeat = ticketFlight.getPlane()
                            .getSeat()[row][column]
                            .getSeatName();

                            // Create a ticket and assign it to the passenger.
                            passenger.setTicket(new Ticket(ticketFlight, ticketSeat));

                            // Assign the passenger to the seat
                            ticketFlight.getPlane().getSeat()[row][column]
                            .setPassenger(passenger);
                            ticketFlight.getPlane().getSeat()[row][column]
                            .setAvailability(true);

                            // Add cargo to the flight
                            ticketFlight.addCargo(passenger.
                                getPassengerCargo());

                            // Add the passenger to the flight
                            ticketFlight.addPassenger(passenger);

                            // Once reservation is complete, exit method
                            return true;
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
        // required flight is not found
        return false;
    } // end of method addReservation(Passenger passsenger...)

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
