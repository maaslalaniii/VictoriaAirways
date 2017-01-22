import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    private static int DEFAULT_MAXIMUM_NUMBER_OF_PLANES = 10;
    final static String FLIGHT_DATABASE = "flightDatabase.txt";
    final static int MEDIUM_RANGE_DISTANCE_KM = 10000;
    final static String PASSENGER_DATABASE = "passengerDatabase.txt";
    final static String PLANE_DATABASE = "planeDatabase.txt";
    final static int SHORT_RANGE_DISTANCE_KM = 5000;

    private static String[] LIST_OF_COMMANDS = {
                                                "help",
                                                "add plane",
                                                "add flight",
                                                "add passenger",
                                                "add points",
                                                "book ticket",
                                                "remove plane",
                                                "remove flight",
                                                "remove passenger",
                                                "view planes",
                                                "view flights",
                                                "view passengers",
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
        /* class constants */

        // Create the main operations office.
        OperationsOffice operationsOffice = new OperationsOffice
               (DEFAULT_MAXIMUM_NUMBER_OF_CUSTOMERS,
                DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS,
                DEFAULT_MAXIMUM_NUMBER_OF_PLANES);

        System.out.println("\fWelcome to the Victoria Airlines CLI.");
        System.out.println("Type \"help\" to list all of possible commands.");

        // print the list of commands
        help();

        boolean programShouldContinue = true;
        do
        {
            // Load the databases
            operationsOffice.loadDatabases(
                                            PASSENGER_DATABASE, 
                                            PLANE_DATABASE, 
                                            FLIGHT_DATABASE
                                            );

            // Get input from the user.
            String input = getString("> ");

            // Check for sentinel value
            if (input.equals("exit"))
            {
                programShouldContinue = false;
            } // end of 

            //Handle input
           handleInput(input, operationsOffice);

        } // end of loop
        while (programShouldContinue);
    } // end of method main(String[] argument)
    /*CLI methods*/
    /**
     * Prints all the possible commands this CLI can handle.
     */
    public static void help()
    {
        System.out.println("Possible commands:");

        int numberOfCommands = LIST_OF_COMMANDS.length;

        // Print all commands except the last one so that the 
        // comma can be excluded.
        for (int i = 0; i < numberOfCommands - 1; i++)
        {
            System.out.print(LIST_OF_COMMANDS[i] + ", ");
        } // end of for(String command : LIST_OF_COMMANDS)

        // Print the last command in the list that we skipped.
        // Subtract one from the length of the array to get the index of the last element.
        System.out.println(LIST_OF_COMMANDS[numberOfCommands - 1]);
    } // end of help()

    /**
     * Returns a string obtained from the console, after the user 
     * had been given the specified prompt.
     * 
     * @param prompt the information to give the user before 
     * asking them for a value
     * 
     * @return the user input, empty string the method could not get input
     */
    public static String getString(String prompt)
    {
        BufferedReader console = null;
        String input = "";

        // Prompt the user.
        System.out.print(prompt);

        // Get Input from the user.
        try
        {
            console = new BufferedReader(new InputStreamReader(System.in));
            input = console.readLine();
        }
        catch (IOException exception)
        {
            System.out.println("Could not read input from command line interface." 
                + " Please restart the program.");
        } // end of catch (IOException exception) 
        return input;
    } // end of getString(String prompt)

    /**
     * Returns an integer obtained from the console, after the 
     * user had been given the specified prompt.
     * 
     * @param prompt the information to give the user 
     * before asking them for a value
     * 
     * @return the user integer input
     */
    public static int getInt(String prompt)
    {
        // Get Input from the user.
        String input = getString(prompt);
        int integer;

        // Try and parse the input into an integer.
        try
        {
            integer = Integer.parseInt(input);
        }
        catch (NumberFormatException exception)
        {
            // The number was not valid. Try again.
            return getInt("Invalid integer. Try again: ");
        } // end of catch ()

        // Parsing was successful.
        return integer;
    } // end of getInt(String prompt)

    /**
     * Returns a double obtained from the console, after the user had 
     * been given the specified prompt.
     * 
     * @param prompt the information to give the user before 
     * asking them for a value
     * 
     * @return the user double input
     */
    public static double getDouble(String prompt)
    {
        // Get Input from the user.
        String input = getString(prompt);
        double number;

        // Try and parse the input into an integer.
        try
        {
            number = Double.parseDouble(input);
        }
        catch (NumberFormatException exception)
        {
            // The number was not valid. Try again.
            return getDouble("Invalid number. Try again: ");
        } // end of catch ()

        // Parsing was successful.
        return number;
    } // end of getInt(String prompt)

    /**
     * Returns a boolean integer obtained from the console, after 
     * the user had been given the specified prompt.
     * 
     * @param prompt the information to give the user before 
     * asking them for a value
     * 
     * @return the user boolean input 
     */
    public static boolean getBoolean(String prompt)
    {
        // Get Input from the user.
        String input = getString(prompt);

        // Is this a valid boolean value?
        while(!input.equalsIgnoreCase("true") 
        && !input.equalsIgnoreCase("false"))
        {
            System.out.println("Invalid entry");
            input = getString(prompt);
        } // end of  while(!input.equalsIgnoreCase("true")...)

        boolean booleanInput = Boolean.parseBoolean(input);

        return booleanInput;
    } // end of getInt(String prompt)

    /**
     * Handles the commands executed based on user input.
     * 
     * @param input the input to handle
     * @param operationsOffice the operations office 
     */
    public static void handleInput(
    String input, 
    OperationsOffice operationsOffice
    )
    {        
        // Handle the input.
        switch(input)
        {
            case "help":
            help();
            break;

            // Add a new plane
            case "add plane":
            // Display the planes before adding the new plane
            operationsOffice.displayPlanes();
            // Gather the needed parameters
            System.out.println("Adding plane... Please provide information.");
            String planeName = getString("Plane Name? ");
            String aircraftType = getString("Aircraft type? ");
            int rowsOfSeats = getInt("How many rows of seats? ");
            int seatsInRow = getInt("How many seats are in a row? ");
            String range = getString("What is the plane's range?" 
                    + " [Short|Medium|Long] ");
            String location = getString("What is its current location? ");

            // Create the new plane
            Plane newPlane = new Plane(
                                       planeName,  
                                       aircraftType, 
                                       rowsOfSeats,
                                       seatsInRow,
                                       false, 
                                       range, 
                                       location
                                       );
            // Check if location of plane is valid                           
            if (!isValidLocation(location))
            {
                // Set the plane as null
                newPlane = null;
            } // end of if (!isValidLocation(location))
            // Check that entered numbers are valid
            if (rowsOfSeats < 0 || seatsInRow < 0)
            {
                // Set the plane as null
                newPlane = null;
            } // end of if (rowsOfSeats < 0 || seatsInRow < 0)
            // Was the plane added successfull?
            boolean planeAdditionWasSuccessful = operationsOffice
                .addPlane(newPlane);
            if (planeAdditionWasSuccessful)
            {
                System.out.println("Plane was successfully added!");
                // Save the changes to the database
                operationsOffice.saveCustomerData(PASSENGER_DATABASE);
                operationsOffice.savePlaneData(PLANE_DATABASE);
                operationsOffice.saveFlightData(FLIGHT_DATABASE);
            } 
            else
            {
                System.out.println("Plane addition was unsuccessful!");            
            } // end of if (planeAdditionWasSuccessful)
            // Display the planes after adding plane
            operationsOffice.displayPlanes();
            break;

            // Schedule a new flight
            case "add flight":
            // Display flights before adding new flight
            operationsOffice.displayFlights();
            // Gather needed data
            System.out.println("Adding flight... Please provide information.");
            String flightName = getString("Flight Name? ");
            double cost = getDouble("Cost? ");
            String date = getString("Date? ");
            String departure = (getString("Departure? "));
            String destination = (getString("Destination? "));
            // Attempt to schedule the flight
            Flight flight = operationsOffice.scheduleFlight(
                                                            flightName, 
                                                            cost, 
                                                            date, 
                                                            destination, 
                                                            departure
                                                            );
            // Check if given destination and departure is valid
            if (!isValidLocation(destination) || !

            isValidLocation(departure))
            {
                flight = null;
            } // if (!isValidLocation(destination)...)
            // Check that entered numbers are valid
            if (cost < 0)
            {
                // Set the plane as null
                flight = null;
            } // end of if (cost < 0)
            // Was the flight added successfully?
            boolean flightAdditionWasSuccessful = operationsOffice
                .addFlight(flight);
            if (flightAdditionWasSuccessful)
            {
                System.out.println("Flight was successfully added!");
                // Save the changes to the databases
                operationsOffice.saveCustomerData(PASSENGER_DATABASE);
                operationsOffice.savePlaneData(PLANE_DATABASE);
                operationsOffice.saveFlightData(FLIGHT_DATABASE);
            } 
            else
            {
                System.out.println("Flight addition was unsuccessful!");
                System.out.println("Enter \"view planes\" to see planes" 
                    + " available for flight scheduling");
            } // end of if (flightAdditionWasSuccessful)
            // Display flights after the addition
            operationsOffice.displayFlights();
            break;

            // Add a new passenger
            case "add passenger":
            // Display the customers before adding the new passenger
            operationsOffice.displayCustomers();
            // Gather needed data
            System.out.println("Adding passenger... Please provide" 
                                + " information.");
            String passengerName = getString("Passenger Name? ");
            int age = getInt("Age? ");
            // The passenger must book to obtain a ticket.
            Ticket ticket = null;
            boolean hasPassport = getBoolean("Does this passenger have a" 
                                            + " passport? [true|false] ");
            // New passengers start off with 0 rewards points
            int rewardPoints = 0;
            String passengerCargo = null;
            // Create the new passenger
            Passenger passenger = new Passenger(passengerName,
                                                age,
                                                ticket,
                                                hasPassport,
                                                rewardPoints,
                                                passengerCargo
                                                );
            // Check if the passenger is already registered
            if (operationsOffice.isRegistered(passenger)) 
            {
                System.out.println ("Passenger is already registered");
                passenger = null;
            } // end of  if (operationsOffice.isRegistered(passenger)) 
            
            // Check that entered numbers are valid
            if (age < 0)
            {
                // Set the plane as null
                passenger = null;
            } // end of if (rowsOfSeats < 0 || seatsInRow < 0)
            // Was the passenger added succesfully?
            boolean passengerAdditionWasSuccessful = operationsOffice
                                                    .addCustomer(passenger);
            if (passengerAdditionWasSuccessful)
            {
                System.out.println("Passenger was added!");
                // Save changes to database
                operationsOffice.saveCustomerData(PASSENGER_DATABASE);
                operationsOffice.savePlaneData(PLANE_DATABASE);
                operationsOffice.saveFlightData(FLIGHT_DATABASE);
            }
            else
            {
                System.out.println("Passenger could not be added!");
            } // end of if (passengerAdditionWasSuccessful) 
            // Display the customers after the addition
            operationsOffice.displayCustomers();
            break;

            // Reward points to a customer
            case "add points":
            // Display the customers before adding the points
            operationsOffice.displayCustomers();
            // Gather needed data
            System.out.println("Adding reward points... Please provide" 
                                + " information.");
            String passengerPointsName = getString("Passenger Name? ");
            int passengerPointsAge = getInt("Age? ");
            // Ticket will be initialized by searching through database
            Ticket pointsTicket = null;
            boolean hasPassportPoints = getBoolean("Does this passenger have a" 
                                                    + " passport? [true|false] ");
            // Points will be set if passenger is found in database
            int points = 0;
            // Cargo will be set if passenger is found in database
            String passengerCargoPoints = null;
            // Create a new passenger, to be used to find them in the database
            Passenger pointsPassenger = new Passenger(passengerPointsName,
                                                      passengerPointsAge,
                                                      pointsTicket,
                                                      hasPassportPoints,
                                                      points,
                                                      passengerCargoPoints
                                                      );
            // Check that entered numbers are valid
            if (passengerPointsAge < 0)
            {
                // Set the plane as null
                pointsPassenger = null;
            } // end of if (rowsOfSeats < 0 || seatsInRow < 0)
            
            int pointsToAdd = -1;
            boolean pointsAdditionWasSuccessful = false;
            // Check if the passenger is already registered
            if (operationsOffice.isRegistered(pointsPassenger)) 
            {
                // Locate passenger in database
                for (int i = 0; i < operationsOffice.customer.length; i++) 
                {
                    // Is this passenger null?
                    if (operationsOffice.customer[i] != null)
                    {   
                        // Check to see if this passenger is the one specified
                        if (operationsOffice.customer[i].getName()
                            .equals(pointsPassenger.getName())
                            && operationsOffice.customer[i].getAge() 
                            == (pointsPassenger.getAge()))
                        {
                            pointsToAdd = operationsOffice.rewardPoints
                            (operationsOffice.customer[i]);
                            pointsAdditionWasSuccessful = operationsOffice
                                                          .customer[i]
                                                          .addPoints
                                                          (pointsToAdd); 
                            // Exit loop
                            i = operationsOffice.customer.length;
                        } // end of if (operationsOffice.customer[i]...)
                    } // end of  if (operationsOffice.customer[i] != null)   
                } // end of for (int i = 0; i < operationsOffice...)
            }
            
            // Was the passenger rewarded points succesfully?
            if (pointsAdditionWasSuccessful)
            {
                System.out.println("Points added successfully!");
                // Save changes to databases
                operationsOffice.saveCustomerData(PASSENGER_DATABASE);
                operationsOffice.savePlaneData(PLANE_DATABASE);
                operationsOffice.saveFlightData(FLIGHT_DATABASE);
            }
            else
            {
                System.out.println("Unable to add points!");
                System.out.println("Ensure passenger is registered and" 
                                    + " has a valid ticket");
            } // end of if (pointsAdditionWasSuccessful)
            // Display the customers after the addition of points
            operationsOffice.displayCustomers();
            break;

            // Reserve a seat on the plane for the passenger and their cargo
            case "book ticket":
            // Display the customers before booking the ticket
            operationsOffice.displayCustomers();
            // Gather needed data
            System.out.println("Booking ticket...Please provide information.");
            String nameTicket = getString("Passenger Name? ");
            int ageTicket = getInt("Age? ");
            // The passenger's ticket will be set based on their 
            // departure and destination
            Ticket ticketToBeBooked = null;
            boolean hasPassportTicket = getBoolean("Does this passenger have a" 
                                                   + " passport? [true|false] ");
            String cargoTicket = (getString("Cargo? "));
            String departureTicket = (getString("Departure? "));
            String destinationTicket = (getString("Destination? "));
            Passenger passengerTicket = new Passenger(nameTicket,
                                                      ageTicket,
                                                      ticketToBeBooked,
                                                      hasPassportTicket,
                                                      0,
                                                      cargoTicket
                                                      );
            // Check that entered numbers are valid
            if (ageTicket < 0)
            {
                // Set the plane as null
                passengerTicket = null;
            } // end of if (rowsOfSeats < 0 || seatsInRow < 0)
            
            boolean ticketBookingWasSuccesful = false;
            // Is the passenger registered in the customer database?
            if (operationsOffice.isRegistered(passengerTicket))
            {
                // Locate passenger in database
                for (int i = 0; i < operationsOffice.customer.length; i++) 
                {
                    if (operationsOffice.customer[i] != null)
                    {
                        // Is this the passenger?
                        if (operationsOffice.customer[i].getName()
                        .equals(passengerTicket.getName())
                        && operationsOffice.customer[i].getAge() 
                        == (passengerTicket.getAge()))
                        {
                            ticketToBeBooked = operationsOffice
                                             .createTicket
                                             (
                                             operationsOffice.customer[i],
                                             departureTicket, 
                                             destinationTicket
                                             );
                            // Was the ticket created properly?
                            if (ticketToBeBooked != null)
                            {
                                // Set the ticket to the passenger
                                operationsOffice.customer[i]
                                .setTicket(ticketToBeBooked);
                                // Set the possession of ticket of the 
                                // passenger 
                                operationsOffice.customer[i]
                                .setPossessionOfTicket(true);
                                // Set the passengers cargo
                                operationsOffice.customer[i]
                                .setPassengerCargo(cargoTicket);
                                // Set ticket booking as successful
                                ticketBookingWasSuccesful = true;
                            } // end of if (ticket1 != null)
                            // Exit loop
                            i = operationsOffice.customer.length;
                        } // end of  if (operationsOffice.customer[i]...)
                    } // end of if (operationsOffice.customer[i] != null)
                } // end of for (int i = 0; i < passengerDatabase.length; i++)
            } 
            else
            {
                ticketToBeBooked = operationsOffice.createTicket
                                                    (passengerTicket,
                                                    departureTicket, 
                                                    destinationTicket
                                                    );
                // Was the ticeket created properly?
                if (ticketToBeBooked != null)
                {
                    // Set the ticket to the passenger
                    passengerTicket.setTicket(ticketToBeBooked);
                    // Add the passenger to the customer database
                    operationsOffice.addCustomer(passengerTicket);
                    // Set the ticket booking as succesful
                    ticketBookingWasSuccesful = true;
                } // end of if (ticket1 != null)
            } // end of if (operationsOffice.isRegistered(passenger1))
            // Was the ticket successfully booked?
            if (ticketBookingWasSuccesful)
            {
                System.out.println("Ticket has been booked!");
                // Save changes to databases
                operationsOffice.saveCustomerData(PASSENGER_DATABASE);
                operationsOffice.savePlaneData(PLANE_DATABASE);
                operationsOffice.saveFlightData(FLIGHT_DATABASE);
            }
            else
            {
                System.out.println("Ticket could not be booked!");
                System.out.println("Enter \"view flights\" to see flights" 
                                    + " available for booking tickets");
            } // end of if (passengerAdditionWasSuccessful)               
            // Display customers after booking ticket
            operationsOffice.displayCustomers();
            break;

            // Remove plane from the data base
            case "remove plane":
            // Display the planes, to aid with selecting index for removal
            operationsOffice.displayPlanes();
            // Gather needed data
            System.out.println("Please specify the index of the" 
                                + " plane to be removed...");
            int indexOfPlaneToRemove = getInt("Index of plane? ");
            // Was the plane successfully removed?
            boolean planeRemovalWasSuccessful = operationsOffice
                                              .removePlaneByIndex
                                              (indexOfPlaneToRemove);
            if (planeRemovalWasSuccessful)
            {
                System.out.println("Plane was removed!");
                // Save changes to database.
                operationsOffice.saveCustomerData(PASSENGER_DATABASE);
                operationsOffice.savePlaneData(PLANE_DATABASE);
                operationsOffice.saveFlightData(FLIGHT_DATABASE);
            }
            else
            {
                System.out.println("Plane was not removed.");
            } // end of if (planeRemovalWasSuccessful)
            // Display the remaining planes 
            operationsOffice.displayPlanes();
            break;

            // Remove a flight
            case "remove flight":
            // Display the flights to aid with choosing index for removal
            operationsOffice.displayFlights();
            // Gather needed data
            System.out.println("Please specify the index of the flight"
                                + " to be removed...");
            int indexOfFlightToRemove = getInt("Index of flight? ");
            // Was the flight removed successfully?
            boolean flightRemovalWasSuccessful = operationsOffice
                                               .removeFlightByIndex
                                               (indexOfFlightToRemove);
            if (flightRemovalWasSuccessful)
            {
                System.out.println("Flight was removed!");
                // Save changes to databases
                operationsOffice.saveCustomerData(PASSENGER_DATABASE);
                operationsOffice.savePlaneData(PLANE_DATABASE);
                operationsOffice.saveFlightData(FLIGHT_DATABASE);
            }
            else
            {
                System.out.println("Flight was not removed.");
            } // end of if (flightRemovalWasSuccessful)
            // Display remaining flights
            operationsOffice.displayFlights();
            break;

            // Removing passenger from the customer database
            case "remove passenger":
            // Display customers to aid with choosing index for removal
            operationsOffice.displayCustomers();
            // Gather needed data
            System.out.println("Please specify the index of the flight" 
                                + " to be removed...");
            int indexOfPassengerToRemove = getInt("Index of passenger? ");
            // Was the flight successfully removed?
            boolean passengerRemovalWasSuccessful = operationsOffice
                                                    .removePassengerByIndex
                                                    (indexOfPassengerToRemove);
            if (passengerRemovalWasSuccessful)
            {
                System.out.println("Passenger was removed!");
                // Save changes to database
                operationsOffice.saveCustomerData(PASSENGER_DATABASE);
                operationsOffice.savePlaneData(PLANE_DATABASE);
                operationsOffice.saveFlightData(FLIGHT_DATABASE);
            }
            else
            {
                System.out.println("Passenger was not removed.");
            } // end of if (passengerRemovalWasSuccessful)
            // Display remaining customers
            operationsOffice.displayCustomers();
            break;

            case "view planes":
            // Display the planes in this operation office database
            operationsOffice.displayPlanes();
            break;

            case "view flights":
            // Display the flight in this operation office database
            operationsOffice.displayFlights();
            break;

            case "view passengers":
            // Display the passengers in this operation office database
            operationsOffice.displayCustomers();
            break;

            // Exit program
            case "exit":
            System.exit(0);
            break;

            // Invalid command
            default:
            System.out.println("\n\"" + input + "\" is not a valid command."
                                + "\nTyping \"help\" will bring up a list" 
                                + " of possible commands.\n");

        } // end of 
        // Input was handled. Save the resulting changes.
    } // end of 

    /* constructors */
    /**
     * Constructs an operations office with the specified information.
     * 
     * @param maximumNumberOfFlights the maximum number of 
     * flights this operations office can store <br><i>pre-condition: </i>
     * maximumNumberOfFlights must be greater than 0
     * @param maximumNumberOfPlanes the maximum number of 
     * planes this operations office can store <br><i>pre-condition: </i>
     * maximumNumberOfPlanes must be greater than 0
     * @param maximumNumberOfCustomers the maximum number of 
     * customers this operations office can store <br><i>pre-condition: </i>
     * maximumNumberOfCustomers must be greater than 0
     */
    public OperationsOffice(int maximumNumberOfCustomers, 
    int maximumNumberOfFlights, 
    int maximumNumberOfPlanes)
    {
        if (maximumNumberOfCustomers < 0) 
            customer = new Passenger[DEFAULT_MAXIMUM_NUMBER_OF_CUSTOMERS];
        if (maximumNumberOfFlights < 0) 
            flight = new Flight[DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS];
        if (maximumNumberOfPlanes < 0) 
            plane = new Plane[DEFAULT_MAXIMUM_NUMBER_OF_PLANES];
        customer = new Passenger[maximumNumberOfCustomers];
        flight = new Flight[maximumNumberOfFlights];
        plane = new Plane[maximumNumberOfPlanes];

        // Set the trackers for each array
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
     * customers of Victoria Airlines <br><i>pre-condition: </i>
     * customer may not be <code>null</code>
     */
    public void setCustomers(Passenger[] customer)
    {
        // Check validity of parameter
        if (customer == null) return;

        this.customer = customer;
    } // end of method set(Passenger[] customer)

    /**
     * Sets the flights record of this operations office.
     *
     * @param flight the array which contains the information for flights 
     * of Victoria Airlines<br><i>pre-condition: </i>
     * flight may not be <code>null</code>
     */
    public void setFlights(Flight[] flight)
    {
        // Check validity of parameter
        if (flight == null) return;

        this.flight = flight;
    } // end of method setFlights(Flight[] flight)

    /**
     * Sets the planes record of this operations office.
     *
     * @param plane the array which contains the information for flights of 
     * Victoria Airlines <br><i>pre-condition: </i>
     * plane may not be <code>null</code>
     */
    public void setPlanes(Plane[] plane)
    {
        // Check validity of parameter
        if (plane == null) return;

        this.plane = plane;
    } // end of method setPlanes(Plane[] plane)

    /**
     * Adds a flight to the record of this operations office
     * if there is space for the flight.
     * 
     * @param flight the flight to be added <br><i>pre-condition: </i>
     * flight may not be <code>null</code>
     * 
     * @return whether the operation was successful
     */
    public boolean addFlight(Flight flight)
    {
        // Check validity of parameter
        if (flight == null) return false;

        // Check if the array is full
        if (numberOfFlights >= this.flight.length) return false;

        this.flight[numberOfFlights++] = flight;
        return true;
    } // end of method addFlight(Flight flight)

    /**
     * Adds a plane to the record of this operations office.
     *
     * @param plane the plane to be added <br><i>pre-condition: </i>
     * plane may not be <code>null</code>
     * 
     * @return whether the operation was successful
     */
    public boolean addPlane(Plane plane)
    {
        // Check validity of parameters
        if (plane == null) return false;

        // Check if array is full
        if (numberOfPlanes >= this.plane.length) return false;

        this.plane[numberOfPlanes++] = plane;
        return true;
    } // end of method addPlane(Plane plane)

    /**
     * Adds a passenger to the customer database 
     * of this operation office, if they aren't 
     * already registerd.
     * 
     * @param passenger the passenger to be added
     * <br><i>pre-condition: </i>
     * passenger may not be <code>null</code>
     * 
     * @return whether the operation was successful
     */
    public boolean addCustomer(Passenger passenger)
    {
        // Check validity of parameters
        if (passenger == null) return false;

        // Check if array is full
        if (numberOfCustomers >= this.customer.length) return false;

        // Check if the passenger is registered
        if (this.isRegistered(passenger)) return false;

        this.customer[numberOfCustomers++] = passenger;
        return true;
    } // end of method addCustomer(Passenger passenger) 

    /**
     * Removes a flight to the record of this operations office.
     * <br><i>pre-condition: </i> flight may not be <code>null</code>
     *
     * @param flight the flight to be removed
     * 
     * @return whether the operation was successful
     */
    public boolean removeFlight(Flight flight)
    {
        // Load customer data
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(PLANE_DATABASE));
        // Load Flight data
        this.setFlights(this.loadFlightData(FLIGHT_DATABASE));
        // Check validity of paramters
        // Check validity of parameter
        if (flight == null) return false;

        int indexOfFlight = -1;

        // Find the index of this flight.
        for (int i = 0; i < numberOfFlights; i++)
        {
            // Is this the flight being searched for?
            if (this.flight[i] == flight)
            {
                indexOfFlight = i;
            } // end of if (this.flight[i] == flight)
        } // end of for (int i = 0; i < numberOfFlights; i++)

        Flight flightToBeRemoved = this.flight[indexOfFlight];

        // Shift all the flights after the removed flight down one.
        for (int i = indexOfFlight; i < numberOfFlights; i++) 
        {
            this.flight[i] = this.flight[i + 1];
        } // end of for (int i = indexOfFlight; i < numberOfFlights; i++)

        // Set the plane of the removed flight as unscheduled
        flightToBeRemoved.getPlane().setSchedule(false);

        // Look through the passenger database and delete any tickets 
        // associated with this flight.
        for (int n = 0; n < this.getCustomers().length; n++)
        {
            // Check if this passenger is null
            if (this.getCustomers()[n] != null)
            {
                // Check if this passeger has a ticket 
                if (this.getCustomers()[n].getTicket() != null)
                {
                    // Check if the ticket is associated with this flight
                    if (this.getCustomers()[n].getTicket().getReservedFlight()
                        .equals(flightToBeRemoved.getFlightName()))
                    {
                        this.getCustomers()[n].setTicket(null);
                        this.getCustomers()[n].setPossessionOfTicket(false);
                    } // end of if (this.getCustomers()[n].getTicket...)
                } // end of if if (this.getCustomers()[n].getTicket() != null
            } // end of  if (this.getCustomers()[n] != null
        } // end of for (int n = 0; n < this.getCustomers()...)

        // Reduce the array tracker
        numberOfFlights--;
        return true;
    } // end of method removeFlight(Flight flight)

    /**
     * Removes a flight by its index to the record of this operations office.
     *
     * @param indexOfFlight the index of the flight to be removed
     * <br><i>pre-condition: </i> indexOfFlight 
     * must be greater than 0 and less than number of flights 
     * 
     * @return whether the flight was successful
     */
    public boolean removeFlightByIndex(int indexOfFlight)
    {        
        // Load customer data
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(PLANE_DATABASE));
        // Load Flight data
        this.setFlights(this.loadFlightData(FLIGHT_DATABASE));
        // Check validity of paramters

        if (indexOfFlight < 0) return false;
        if (indexOfFlight > numberOfFlights) return false;

        Flight flightToBeRemoved = this.flight[indexOfFlight];

        // Shift all the flights after the removed flight down one.
        for (int i = indexOfFlight; i < numberOfFlights; i++) {
            this.flight[i] = this.flight[i + 1];
        } // end of for (int i = indexOfFlight; i < numberOfFlights; i++)

        // Set the plane of the removed flight as unscheduled
        flightToBeRemoved.getPlane().setSchedule(false);

        // Look through the passenger database and delete any tickets 
        // associated with this flight.
        for (int n = 0; n < this.getCustomers().length; n++)
        {
            // Check if this passenger is null
            if (this.getCustomers()[n] != null)
            {
                // Check if this passeger has a ticket 
                if (this.getCustomers()[n].getTicket() != null)
                {
                    // Check if the ticket is associated with this flight
                    if (this.getCustomers()[n].getTicket().getReservedFlight()
                        .equals(flightToBeRemoved.getFlightName()))
                    {
                        this.getCustomers()[n].setTicket(null);
                        this.getCustomers()[n].setPossessionOfTicket(false);
                    } // end of if (this.getCustomers()[n].getTicket...)
                } // end of if if (this.getCustomers()[n].getTicket() != null
            } // end of  if (this.getCustomers()[n] != null
        } // end of for (int n = 0; n < this.getCustomers()...)
        // Reduce the array tracker
        numberOfFlights--;
        return true;
    } // end of method removeFlightByIndex(int indexOfFlight)

    /**
     * Removes a plane from the record of this operations office.
     *
     * @param plane the plane to be removed
     * <br><i>pre-condition: </i> plane may not be <code>null</code>
     * 
     * @return whether the operation was successful
     */
    public boolean removePlane(Plane plane)
    {
        // Load customer data
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(PLANE_DATABASE));
        // Load Flight data
        this.setFlights(this.loadFlightData(FLIGHT_DATABASE));

        // Check validity of parameter
        if (plane == null) return false;

        int indexOfPlane = -1;

        // Find the index of this plane.
        for (int i = 0; i < numberOfPlanes; i++)
        {
            // Is this the plane being searched for?
            if (this.plane[i] == plane)
            {
                indexOfPlane = i;
            } // end of if (this.plane[i] == plane)
        } // end of for (int i = 0; i < numberOfPlanes; i++)

        Plane planeToBeRemoved = this.plane[indexOfPlane];

        // Shift all the planes after the removed plane down one.
        for (int i = indexOfPlane; i < numberOfPlanes; i++) 
        {
            this.plane[i] = this.plane[i + 1];
        } // end of for (int i = indexOfPlane; i < numberOfPlanes; i++) 

        // Find rhe flight associated with this plane, if any are
        for (int n = 0; n < this.getFlights().length; n++)
        {
            // Check if this flight is null
            if (this.getFlights()[n] != null)
            {
                // Check if this plane is associated with the flight 
                // to be removed
                if (this.getFlights()[n].getPlane().getName()
                    .equals(planeToBeRemoved.getName()))
                {
                    Flight flightToBeRemoved = this.getFlights()[n];
                    // Located any passengers of the flight to be removed
                    for (int k = 0; k < this.getCustomers().length; k ++)
                    {
                        // Check if this passenger is null
                        if (this.getCustomers()[k] != null)
                        {
                            // Check if this passenger has a ticket
                            if (this.getCustomers()[k].getTicket() != null)
                            {
                                // Is the passenegers ticket associated with 
                                // the flight to be removed?
                                if (this.getCustomers()[k].getTicket()
                                    .getReservedFlight()
                                    .equals(flightToBeRemoved.getFlightName()))
                                {
                                    // Delete their ticket
                                    this.getCustomers()[k].setTicket(null);
                                    this.getCustomers()[k]
                                    .setPossessionOfTicket(false);
                                } // end of if (this.getCustomers()...)
                            } // end of if if (this.getCustomers()[k]..)
                        } // end of  if (this.getCustomers()[k] != null
                    } // end for (int k = 0; k < this.getCustomers()...)
                } // end of (this.getFlights()[n].getPlane()...)
            } // end of if (this.getFlights()[n] != null)
        } // end of (int n = 0; n < this.getFlights()...)

        // Reduce array tracker
        numberOfPlanes--;
        return true;
    } // end of method removePlane(Plane plane)

    /**
     * Removes a plane by its index to the record of this operations office.
     *
     * @param indexOfPlane the index of the plane to be removed
     * <br><i>pre-condition: </i> indexOfPlane must be greater than
     * 0 and less than number of planes in the record.
     * 
     * @return whether the plane was successfully removed
     */
    public boolean removePlaneByIndex(int indexOfPlane)
    {        
        // Load customer data
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(PLANE_DATABASE));
        // Load Flight data
        this.setFlights(this.loadFlightData(FLIGHT_DATABASE));

        // Check validity of paramters
        if (indexOfPlane < 0) return false;
        if (indexOfPlane > numberOfPlanes) return false;

        Plane planeToBeRemoved = this.plane[indexOfPlane];

        // Shift all the planes after the removed plane down one.
        for (int i = indexOfPlane; i < numberOfPlanes; i++)
        {
            this.plane[i] = this.plane[i + 1];
        } // end of for (int i = indexOfPlane; i < numberOfPlanes; i++) {

        // Find rhe flight associated with this plane, if any are
        for (int n = 0; n < this.getFlights().length; n++)
        {
            // Check if this flight is null
            if (this.getFlights()[n] != null)
            {
                // Check if this plane is associated with the flight 
                // to be removed
                if (this.getFlights()[n].getPlane().getName()
                    .equals(planeToBeRemoved.getName()))
                {
                    Flight flightToBeRemoved = this.getFlights()[n];
                    // Located any passengers of the flight to be removed
                    for (int k = 0; k < this.getCustomers().length; k ++)
                    {
                        // Check if this passenger is null
                        if (this.getCustomers()[k] != null)
                        {
                            // Check if this passenger has a ticket
                            if (this.getCustomers()[k].getTicket() != null)
                            {
                                // Is the passenger ticket associated with the 
                                // flight to be removed?
                                if (this.getCustomers()[k].getTicket()
                                    .getReservedFlight()
                                    .equals(flightToBeRemoved.getFlightName()))
                                {
                                    // Delete their ticket
                                    this.getCustomers()[k].setTicket(null);
                                    this.getCustomers()[k]
                                        .setPossessionOfTicket(false);
                                } // end of if (this.getCustomers()[k]...)
                            } // end of if if (this.getCustomers()[k]...)
                        } // end of  if (this.getCustomers()[k] != null)
                    } // end for (int k = 0; k < this.getCustomers()...)
                } // end of (this.getFlights()[n].getPlane()...)
            } // end of if (this.getFlights()[n] != null)
        } // end of  for (int n = 0; n < this.getFlights()...)

        // Reduce array tracker 
        numberOfPlanes--;
        return true;
    } // end of method removePlaneByIndex(int indexOfPlane)

    /**
     * Removes a passenger to the record of this operations office.
     *
     * @param passenger the passenger to be removed
     * <br><i>pre-condition: </i> passenger may not
     * be <code>null</code>
     * 
     * @return whether the operation was successful
     */
    public boolean removePassenger(Passenger passenger)
    {
        // Load customer data
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(PLANE_DATABASE));
        // Load Flight data
        this.setFlights(this.loadFlightData(FLIGHT_DATABASE));

        // Check validity of parameter
        if (passenger == null) return false;

        int indexOfPassenger= -1;

        // find the index of this passenger.
        for (int i = 0; i < numberOfCustomers; i++)
        {
            // Is this the passenger being searched for?
            if (this.customer[i] == passenger)
            {
                indexOfPassenger = i;
            } // end of if (this.customer[i] == passenger)
        } // end of for (int i = 0; i < numberOfCustomers; i++)

        // Shift all the passengers after the removed passenger down one.
        for (int i = indexOfPassenger; i < numberOfCustomers; i++) 
        {
            this.customer[i] = this.customer[i + 1];
        } // end of for (int i = indexOfPassenger; i < numberOfCustomers; i++) 

        // Reduce array tracker 
        numberOfCustomers--;
        return true;
    } // end of method removePassenger(Passenger passenger)

    /**
     * Removes a passenger by its index from this operations office.
     *
     * @param indexOfPassenger the index of the passenger to be removed
     * <br><i>pre-condition: </i> indexOfPassenger must be greater than 0
     * and less than the number of passengers
     * 
     * @return whether the passenger was successfully removed
     */
    public boolean removePassengerByIndex(int indexOfPassenger)
    {        
        // Load customer data
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(PLANE_DATABASE));
        // Load Flight data
        this.setFlights(this.loadFlightData(FLIGHT_DATABASE));

        // Check validity of paramter
        if (indexOfPassenger < 0) return false;
        if (indexOfPassenger > numberOfCustomers) return false;

        // Shift all the passengers after the removed passenger down one.
        for (int i = indexOfPassenger; i < numberOfCustomers; i++)
        {
            this.customer[i] = this.customer[i + 1];
        } // end of for (int i = indexOfPassenger; i < numberOfCustomers; i++)

        // Reduce array tracker 
        numberOfCustomers--;
        return true;
    } // end of method removePassengerByIndex(int indexOfPassenger)

    /*Load Methods*/
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
        // Check validity of parameter
        if (textFile == null) 
            return new Plane[DEFAULT_MAXIMUM_NUMBER_OF_PLANES];
        Plane [] planeData; 
        try
        {
            // Create connection to file
            BufferedReader fileReader = new BufferedReader
                                    (new FileReader(textFile));
            String line = fileReader.readLine();

            // Create array to contain plane data
            // The first line contains the size of the array
            planeData = new Plane[Integer.parseInt(line)];

            int counter = 0;
            // Read each tokenized line and use it to create a plane
            while((line = fileReader.readLine()) != null)
            {
                String [] parameter = line.split("\t");
                String name = "";
                int maxCargo = 0;
                String aircraft = "";
                int rows = 0;
                int columns = 0;
                boolean isScheduled = false;
                String range = "";
                String location = "";
                try
                {
                    // Extract the plane parameters stored in the file
                    name = parameter[0];
                    maxCargo = Integer.parseInt(parameter[1]); 
                    aircraft = parameter[2];
                    rows = Integer.parseInt(parameter[3]);
                    columns = Integer.parseInt(parameter[4]);
                    isScheduled = Boolean.parseBoolean(parameter[5]);
                    range = parameter[6];
                    location = parameter[7];
                }
                catch (NumberFormatException exception)
                {
                    // Invalid plane data, escape from loading data.
                    // Create a new array as the database.
                    return new Plane[DEFAULT_MAXIMUM_NUMBER_OF_PLANES];
                } // end of catch (NumberFormatException exception)
                catch (ArrayIndexOutOfBoundsException exception)
                {
                    // Invalid plane data, escape from loading data.
                    // Create a new array as the database.
                    return new Plane[DEFAULT_MAXIMUM_NUMBER_OF_PLANES];
                } // end of catch (NumberFormatException exception)

                // Create the plane using extracted parameters
                Plane planeToBeAdded = new Plane(
                                                 name,
                                                 aircraft,
                                                 rows,
                                                 columns,
                                                 isScheduled,
                                                 range,
                                                 location
                                                 );

                // Add plane to the array
                planeData[counter] = planeToBeAdded;
                counter++;
            } // end of while((line = fileReader.readLine()) != null)
            // Set the planes array as the database for this office
            this.numberOfPlanes = counter;
            this.setPlanes(planeData);
        }
        catch (IOException error)
        {
            // Error reading file
            // Create a new array as the database
            return new Plane[DEFAULT_MAXIMUM_NUMBER_OF_PLANES];
        }
        catch (NumberFormatException exception)
        {
            // Invalid plane data, escape from loading data.
            // Create a new array as the database.
            return new Plane[DEFAULT_MAXIMUM_NUMBER_OF_PLANES];
        } // end of catch (NumberFormatException exception)
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
    public Passenger[] loadCustomerData(String textFile)
    {
        // Check validity of parameter
        if (textFile == null) 
            return new Passenger[DEFAULT_MAXIMUM_NUMBER_OF_PLANES];
        Passenger[] customerData;
        try
        {
            // Create connection to file
            BufferedReader fileReader = new BufferedReader
                                       (new FileReader(textFile));
            String line = fileReader.readLine();

            // Create array to contain passenger data
            // Size of database is on the first line
            customerData = new Passenger[Integer.parseInt(line)];

            int counter = 0;
            // Read input from the tokenized lines and create passengers
            while((line = fileReader.readLine()) != null)
            {
                String[] parameter = line.split("\t");
                String name = "";
                int age = 0;
                boolean hasPassport = false;
                int points = 0;
                String flightName = null;
                String flightSeat = null;
                String cargo = null;

                // Extract the passenger parameters stored in the file
                try
                {
                    name = parameter[0];
                    age = Integer.parseInt(parameter[1]); 
                    // Check if parameter for flight name is null
                    if (!parameter[2].equals("null"))flightName = parameter[2];
                    // Check if parameter for flight seat is null
                    if (!parameter[3].equals("null"))flightSeat = parameter[3];
                    hasPassport = Boolean.parseBoolean(parameter[4]);
                    points = Integer.parseInt(parameter[5]);
                    // Check if parameter for cargo is null
                    if (!parameter[6].equals("null"))cargo = parameter[6];

                }
                catch (NumberFormatException exception)
                {
                    // Invalid passenger data, escape from loading data.
                    // Create a new array as the database.
                    return new Passenger[DEFAULT_MAXIMUM_NUMBER_OF_CUSTOMERS];
                } // end of catch (NumberFormatException)
                catch (ArrayIndexOutOfBoundsException exception)
                {
                    // Invalid passenger data, escape from loading data.
                    // Create a new array as the database.
                    return new Passenger[DEFAULT_MAXIMUM_NUMBER_OF_CUSTOMERS];
                } // end of catch (NumberFormatException)
                // Create the passenger using extracted parameters
                Passenger customerToBeAdded = new Passenger(
                                                            name, 
                                                            age,  
                                                            null, 
                                                            hasPassport, 
                                                            points, 
                                                            cargo
                                                            );
                // Create the passenger's ticket,if they have one
                if (flightName == null && flightSeat == null)
                {
                    customerToBeAdded.setTicket(null);
                    customerToBeAdded.setPossessionOfTicket(false);
                }
                else
                {
                    customerToBeAdded.setTicket(new Ticket(flightName, 
                                                           flightSeat));
                } // end of  if (flightName == null && flightSeat == null)
                // Add customer to the array
                customerData[counter] = customerToBeAdded;
                counter++;
            } // end of while((line = fileReader.readLine()) != null)
            // Set the array as the passenger record of this operation office
            this.setCustomers(customerData);
            // set the number of customers in this operation office
            this.numberOfCustomers = counter;
        }
        catch (IOException error)
        {
            // Invalid passenger data, escape from loading data.
            // Create a new array as the database.
            return new Passenger[DEFAULT_MAXIMUM_NUMBER_OF_CUSTOMERS];
        }
        catch (NumberFormatException exception)
        {
            // Invalid passenger data, escape from loading data.
            // Create a new array as the database.
            return new Passenger[DEFAULT_MAXIMUM_NUMBER_OF_CUSTOMERS];
        } // end of catch (NumberFormatException)
        return customerData;
    } // end of method loadCustomerData(String textFile)

    /**
     * Reads flight data from a text file and creates
     * a flight database for this operations office.
     * 
     * @param textFile the file to be read from <br><i>
     * pre-condition: </i> textfile may not be 
     * <code>null</code>
     */
    public Flight[] loadFlightData(String textFile)
    {
        // Check validity of parameter
        if (textFile == null) 
            return new Flight[DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS];
        Flight[] flightData;
        try
        {
            // Create connection to file
            BufferedReader fileReader = new BufferedReader
                                       (new FileReader(textFile));
            String line = fileReader.readLine();

            // Create array to contain flight data
            // Size of array is found on first line of file
            flightData = new Flight[Integer.parseInt(line)];

            int counter = 0; 
            // Read the tokenized lines and input them as 
            // parameters to create the flights
            while ((line = fileReader.readLine()) != null) 
            {
                String[] parameter = line.split("\t");
                String flightName = "";
                double flightCost = 0;
                String takeoff = "";
                String destination = "";
                String departure = "";
                String planeName = "";

                // Extract parameters and use them to create flights
                try
                {
                    // Is this line a blank line?
                    if (parameter.length != 0)
                    {
                        flightName = parameter[0];
                        flightCost = Double.parseDouble(parameter[1]);
                        takeoff = parameter[2];
                        destination = parameter[3];
                        departure = parameter[4];
                        planeName = parameter[5];
                    } // end of if (parameter.length != 0)

                    // Locate flightPlane in database, if it exists
                    int planeCounter = 0;
                    boolean planeFound = false;
                    Plane flightPlane = null; 
                    while (planeFound == false 
                    && planeCounter < this.getPlanes().length)
                    {
                        if (this.getPlanes()[planeCounter] != null)
                        {
                            // Is this the flight's plane?
                            if (this.getPlanes()[planeCounter]
                                .getName().equals(planeName))
                            {
                                planeFound = true;
                                flightPlane = this.getPlanes()[planeCounter];
                                flightPlane.setSchedule(true);
                            } // end of if (this.getPlanes()[planeCounter]...)
                        }// if (this.getPlanes()[planeCounter] != null)
                        // Move on to next plane
                        planeCounter++;
                    } // end of while (planeFound == false && planeCounter...)

                    // Was the plane found?
                    if (planeFound == true)
                    {
                        // Create the new flight and add it to array
                        Flight flightToBeAdded = new Flight(flightName, 
                                                            flightCost, 
                                                            takeoff, 
                                                            new Location
                                                            (destination), 
                                                            new Location
                                                            (departure),
                                                            flightPlane
                                                            );
                        flightData[counter] = flightToBeAdded;
                        counter ++;
                    } // end of  if (planeFound == true)
                }
                catch (NumberFormatException exception)
                {
                    // Invalid flight data, escape from loading data.
                    // Create a new array as the database.
                    return new Flight[DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS];
                } // end of catch (NumberFormatException)
                catch (ArrayIndexOutOfBoundsException exception)
                {
                    // Invalid flight data, escape from loading data.
                    // Create a new array as the database.
                    return new Flight[DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS];
                } // end of catch (NumberFormatException)
            }
            this.numberOfFlights = counter;
        }
        catch (IOException exception)
        {
            // Unable to read file, escape from loading data.
            // Creat a new array as the database.
            return new Flight[DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS];
        }
        catch (NumberFormatException exception)
        {
            // Invalid plane data, escape from loading data.
            // Create a new array as the database.
            return new Flight[DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS];
        } // end of catch (NumberFormatException exception)
        return flightData;
    } // end of method loadFlightData(String textFile)

    /**
     * Adds existing passengers and their cargo in the database
     * to their corresponding flights, to ensure that
     * no two same seats are reserved when booking a flight.
     * 
     */
    public void boardPassengers()
    {
        // Loop through the customers database
        for (int i = 0; i < this.getCustomers().length; i++)
        {
            // Check if this customer is null
            if (this.getCustomers()[i] != null)
            {
                // Check if this customer has a ticket
                if (this.getCustomers()[i].getTicket() != null)
                {
                    // Loop throught the flight database
                    for (int n = 0; n < this.getFlights().length; n++)
                    {
                        // Check if this flight is null
                        if(this.getFlights()[n] != null)
                        {
                            // Locate the flight indicate on the passenger's ticket
                            if (this.getCustomers()[i].getTicket()
                                .getReservedFlight()
                                .equals(this.getFlights()[n].getFlightName()))
                            {
                                // Locate the seat indicated on the ticket
                                for(int j = 0; 
                                    j < this.getFlights()[n]
                                    .getPlane().getSeat().length; 
                                    j++)
                                    {
                                    for(int k = 0; 
                                        k < this.getFlights()[n].getPlane()
                                        .getSeat()[j].length; 
                                        k++)
                                        {
                                        if (this.getFlights()[n].getPlane()
                                            .getSeat()[j][k].getSeatName()
                                            .equals((this.getCustomers()[i].getTicket()
                                            .getReservedSeat())))
                                        {
                                            // Mark the seat as taken;
                                            this.getFlights()[n].getPlane()
                                                .getSeat()[j][k]
                                                .setAvailability(true);
                                            // Set the passenger as the 
                                            // passenger of this seat
                                            this.getFlights()[n].getPlane()
                                                .getSeat()[j][k]
                                                .setPassenger
                                            (this.getCustomers()[i]); 
                                            // Add passenger to flight's 
                                            // passenger list
                                            this.getFlights()[n]
                                                .addPassenger
                                            (this.getCustomers()[i]);
                                            // Add the passenger's cargo 
                                            // to the flight
                                            this.getFlights()[n]
                                                .addCargo(this.getCustomers()[i]
                                                .getPassengerCargo());
                                        } // end of if (this.getFlights()[n]...)
                                    } // end of for(int k = 0; k < this..)
                                } // for(int j = 0; j < this.getFlights()...)
                            } // if (this.getCustomers()[i].getTicket()...)
                        } //  if(this.getFlights()[n] != null)
                    } // end of for (int n = 0; n < this.getFlights...)
                } // end of if (this.getCustomers()[i].getTicket() != null)
            } // end of if (this.getCustomers()[i] != null)
        } // end of for (int i = 0; i < this.getCustomers().length; i++)
    } // end of method boardPassengers()

    /**
     * Reads flight, passenger and plane data from 
     * specified text files and intializes 
     * the databases of this operations office, ensuring
     * that all passengers have been added to their flight.
     * 
     * @param customerFile the text file containing the
     * customer data <br><i>pre-condition: </i> 
     * customerFile may not be <code>null</code>
     * @param planeFile the text file containing the
     * plane data.<br><i>pre-condition: </i> planeFile 
     * may not be <code>null</code>
     * @param flightFile the textfile containing the 
     * flight data<br><i>pre-condition: </i> flightFile 
     * may not be <code>null</code>
     */
    public void loadDatabases(
    String customerFile, 
    String planeFile, 
    String flightFile
    )
    {
        // Check validity of parameters
        if (customerFile == null) return;
        if (planeFile == null) return;
        if (flightFile == null) return;
        // Load customer data
        this.setCustomers(this.loadCustomerData(customerFile));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(planeFile));
        // Load Flight data
        this.setFlights(this.loadFlightData(flightFile));
        // Add passengers to the flights and seats 
        // specified on their tickets
        this.boardPassengers();
    }// end of loadDatabases(String customerFile...)

    /*Save methods*/
    /**
     * Saves the customer data of this operations office
     * to the specified file.
     * 
     * @param textFile the file to which the data will be
     * saved to. <br><i>pre-condition: </i> textFile may
     * not be <code>null</code>
     */
    public void saveCustomerData(String textFile)
    {
        // Check validity of parameter
        if (textFile == null) return;
        try
        {
            // Establish connection to file 
            PrintWriter fileWriter = new PrintWriter(new FileWriter(textFile));

            // Write the size of the array on the first line
            fileWriter.println(this.getCustomers().length);

            for (int i = 0; i < this.getCustomers().length; i++)
            {
                // Is their a plane in this index?
                if (this.getCustomers()[i] != null)
                {
                    // Passenger info
                    String name = this.getCustomers()[i].getName();
                    int age = this.getCustomers()[i].getAge();
                    boolean hasPassport = this.getCustomers()[i].hasPassport();
                    int rewardPoints = this.getCustomers()[i].getRewardPoints();
                    // Does this passenger have cargo?
                    String cargo;
                    if(this.getCustomers()[i].getPassengerCargo() == null) 
                    {
                        // Print the cargo as null
                        cargo = "null";
                    }
                    else
                    {
                        cargo = this.getCustomers()[i].getPassengerCargo();
                    } // end of if(this.getCustomers()[i]...) 
                    // Does this passenger have a ticket?
                    String ticketFlight;
                    String ticketSeat;
                    if (this.getCustomers()[i].getTicket() == null)
                    {
                        // print the ticket info as null
                        ticketFlight = "null";
                        ticketSeat = "null";
                    }
                    else
                    {
                        ticketFlight = this.getCustomers()[i].getTicket()
                        .getReservedFlight();
                        ticketSeat =  this.getCustomers()[i].getTicket()
                        .getReservedSeat();
                    } // end of if (this.getCustomers()[i]...)

                    // Print out parameters of flight
                    fileWriter.println(
                                        name
                                        + "\t" + age
                                        + "\t" + ticketFlight
                                        + "\t" + ticketSeat
                                        + "\t" + hasPassport
                                        + "\t" + rewardPoints
                                        + "\t" + cargo
                                        );
                } //  if (this.getCustomers()[i] != null)
            } // end of for (int i = 0; i < this.getCustomers()...)
            // Close the file.
            fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println ("Error writing to file");
        } // end of catch (IOException e)
    } // end of method saveCustomerData(String textFile)

    /** 
     * Saves the plane data of this operations office 
     * to the specified file.
     * 
     * @param textFile the file to which the data will be
     * saved to. <br><i>pre-condition: </i> textFile may
     * not be <code>null</code>
     */
    public void savePlaneData(String textFile)
    {
        // Check validity of parameter
        if (textFile == null) return;
        try
        {
            // Establish connection to file
            PrintWriter fileWriter = new PrintWriter(new FileWriter(textFile));
            // Write the size of the array on the first line
            fileWriter.println(this.getPlanes().length);
            for (int i = 0; i < this.getPlanes().length; i++)
            {
                // Is their a plane in this index?
                if (this.getPlanes()[i] != null)
                {
                    // Print out parameters of flight
                    fileWriter.println(this.getPlanes()[i].getName()
                                       + "\t" + this.getPlanes()[i]
                                       .getMaximumNumberOfItemsOfCargo()
                                       + "\t" + this.getPlanes()[i].getAircraftType()
                                       + "\t" + this.getPlanes()[i].getSeat().length
                                       + "\t" + this.getPlanes()[i].getSeat()[0].length
                                       + "\t" + this.getPlanes()[i].isScheduled()
                                       + "\t" + this.getPlanes()[i].getRange()
                                       + "\t" + this.getPlanes()[i].getLocation());
                } // end of if (this.getPlanes()[i] != null)
            } // end of  for (int i = 0; i < this.getPlanes().length; i++)
            // Close the file
            fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println ("Error writing to file");
        } // end of (IOException e)
    } // end of mwthod savePlaneData(String textFile)

    /**
     * Saves the flight data of this operations office
     * to the specified file.
     * 
     * @param textFile the file to which the data will be
     * saved to. <br><i>pre-condition: </i> textFile may
     * not be <code>null</code>
     */

    public void saveFlightData(String textFile)
    {
        // Check validity of parameter
        if (textFile == null) return;
        try
        {
            // Establish connect to file
            PrintWriter fileWriter = new PrintWriter(new FileWriter(textFile));
            // Write the size of the array on the first line
            fileWriter.println(this.getFlights().length);
            for (int i = 0; i < this.getFlights().length; i++)
            {
                // Is their a flight in this index?
                if (this.getFlights()[i] != null)
                {
                    // Print out parameters of flight
                    fileWriter.println(this.getFlights()[i].getFlightName()
                        + "\t" + this.getFlights()[i].getCost()
                        + "\t" + this.getFlights()[i].getDate()
                        + "\t" + this.getFlights()[i].getDestination()
                        .getLocationName()
                        + "\t" + this.getFlights()[i].getDeparture()
                        .getLocationName()
                        + "\t" + this.getFlights()[i].getPlane().getName());
                } // end of if (this.getFlights()[i] != null)
           } // end of for (int i = 0; i < this.getFlights().length; i++)
            // Close the file
            fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println ("Error writing to file");
        } // end of catch (IOException e)
    } // end of method saveFlightData (String textFile)

    /*Scheduling flight function*/
    /**
     * Schedules a flight from the specified departure
     * to destination at the specifed date with the 
     * specified cost if an unscheduled plane matching 
     * it's range and departure is found.
     * 
     * @param flightName the name of this flight <br>
     * <i>pre-condition: </i> flightName may not be 
     * <code>null</code>
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
    public Flight scheduleFlight(String flightName,
    double cost, 
    String date,
    String destination,
    String departure)
    {
        // Load customer data
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(PLANE_DATABASE));
        // Load Flight data
        this.setFlights(this.loadFlightData(FLIGHT_DATABASE));

        // Check validity of parameters
        if (flightName == null) return null;
        if (cost < 0) return null; 
        if (date == null) return null; 
        if (destination == null) return null;  
        if (departure == null)return null;

        // Check if the operations office flight database is full
        if(this.numberOfFlights >= this.getFlights().length)return null;

        // Create departure and destination locations
        Location flightDestination = new Location(destination);
        Location flightDeparture = new Location(departure);

        // Calculate distance of flight
        Double flightDistance = calculateDistanceKm(flightDeparture,
                                                    flightDestination);

        // Using the distance of the flight, determine the range of flight
        String flightRange = "";

        if (flightDistance > 0 && flightDistance <= SHORT_RANGE_DISTANCE_KM)
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
        Plane[] plane = this.getPlanes(); 
        int counter = 0;
        boolean planeFound = false;
        Plane flightPlane = null; 
        while (planeFound == false && counter < this.getPlanes().length)
        {
            /*
             * Check if the plane has the required range and is present 
             * at the departure and isn't scheduled
             */
            if (this.getPlanes()[counter] == null) return null;
            // Does this plane have the required parameters?
            if (this.getPlanes()[counter].getRange().equals(flightRange) && 
                this.getPlanes()[counter].getLocation().equals(departure) 
                && this.getPlanes()[counter].isScheduled() == false)
            {
                flightPlane = this.plane[counter];  
                // Exit loop
                planeFound = true;
            }
            //increment counter
            counter++;
        } // end of while (counter > 0 && counter < plane.length)

        // Was a plane meeting the requirements found?
        if (flightPlane != null)
        {
            // Create a new flight
            Flight flight1 = new Flight(flightName, 
                                        cost, 
                                        date, 
                                        flightDestination, 
                                        flightDeparture, 
                                        flightPlane); 
            // Set the plane as scheduled
            flightPlane.setSchedule(true);
            return flight1;
        } // end of if (flightPlane != null)
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

    /*Managing reservations functions*/
    /**
     * Creates a ticket for flight with the specified departure and destination
     * for the specified passenger if such a flight exists in 
     * this operation office flight database.
     * 
     * @param passenger the passenger to make the ticket for
     * <br><i>pre-condition: </i> passenger may not be <code>null</code>
     * @param departure the departure of the passenger's trip <b><i>
     * pre-condition: </i> departure may not <code>null</code>
     * @param destination the destination of the passenger's trip
     * <b><i>pre-condition: </i> destination may not <code>null</code>
     * 
     * @return the ticket made to reserve the passenger's seat
     */
    public Ticket createTicket(Passenger passenger, 
    String departure, 
    String destination)
    {
        // Load customer data
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(PLANE_DATABASE));
        // Load Flight data
        this.setFlights(this.loadFlightData(FLIGHT_DATABASE));
        // Add existing passengers to their flights
        this.boardPassengers();

        // Check validity of parameters
        if (passenger == null) return null;
        if  (departure == null ) return null;
        if (destination == null) return null;

        // Does this passenger have a passport?
        if (passenger.hasPassport() == false) return null;

        Flight ticketFlight = null; 
        String ticketSeat = null;
        int counter = 0;

        /*
         * Locate a flight with the required departure and destination 
         * in the database.
         */ 
        while (ticketFlight == null && counter < numberOfFlights)
        {
            // Does this flight have the same departure and 
            // destination as the passenger?
            // Does this flight have space for the passenger and their cargo?
            if (this.getFlights()[counter].getDeparture().getLocationName()
            .equals(departure) && this.getFlights()[counter].getDestination()
            .getLocationName().equals(destination) && 
            this.getFlights()[counter].isFlightFull() != true
            && this.getFlights()[counter].isCargoFull() != true)
            {
                ticketFlight = this.getFlights()[counter];
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
                            if(ticketFlight.isFlightFull()) return null;

                            // Check if the flight has room for the cargo.
                            if(ticketFlight.isCargoFull()) return null;

                            ticketSeat = ticketFlight
                                        .getPlane()
                                        .getSeat()[row][column]
                                        .getSeatName();

                            // Create a ticket and assign it to the passenger.
                            Ticket ticket = new Ticket(ticketFlight
                                                        .getFlightName(), 
                                                        ticketSeat);

                            // Once ticket is made, exit method
                            return ticket;
                        } // end of if (ticketFlight.getPlane().getSeat...)
                        // Increment column
                        column++;
                    }// end of while (column < ticketFlight.getPlane()...)
                    // Increment row
                    row++;
                }// end of while (row < ticketFlight.getPlane().getSeat()...)
            } //  If (this.flight[i].getDeparture().getLocationName()...)
            // Increment the counter to move onto next flight in the database
            counter ++;
        } // end of for (int i = 0; i < numberOfFlights; i++)
        // Required flight is not found
        return null;
    } // end of method addReservation(Passenger passenger...)

    /**
     * Rewards passengers who are in this operation office's 
     * database with frequent flyer points in accordance to 
     * their flight cost.
     * 
     * @param passenger the passenger to be rewarded points
     * <br><i>pre-condition: </i> passenger may not be 
     * <code>null</code>
     */
    public int rewardPoints(Passenger passenger)
    {
        // Load customer data
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));
        // Load plane data 
        this.setPlanes(this.loadPlaneData(PLANE_DATABASE));
        // Load Flight data
        this.setFlights(this.loadFlightData(FLIGHT_DATABASE));
        this.boardPassengers();

        // Check validity of passenger
        if (passenger == null) return -1 ;
        // Does the passenger have a ticket?
        if (passenger.hasTicket() == false) return -1;

        int pointsToBeAdded = -1;

        Flight passengerFlight = null;
        // Locate the flight indicated on the passenger's ticket
        for (int i = 0; i < this.getFlights().length; i++)
        {
            if (this.getFlights()[i] != null)
            {
                if (this.getFlights()[i].getFlightName()
                    .equals(passenger.getTicket().getReservedFlight()))
                {
                    passengerFlight = this.getFlights()[i];
                    // Exit loop
                    i = this.getFlights().length;
                } // end of  if (this.getFlights()[i].getFlightName()...0
            }// end of if (this.getFlights[i].getName()...)
        } // end of for (int i = 0; i < this.getFlights().length; i++)

        // Was the flight found?
        if (passengerFlight != null)
        {
            pointsToBeAdded = (int) (1.5 * passengerFlight.getCost());
        } // end of if (passengerFlight != null)
        return pointsToBeAdded;
        // end of  if (isRegistered(passenger, this.getCustomers())
    } // end of method rewardPoints(Passenger passenger)

    /*
     * Method to check if a passenger is already in the database
     */
    private boolean isRegistered(Passenger passenger)
    {
        // Load customer database
        this.setCustomers(this.loadCustomerData(PASSENGER_DATABASE));

        for (int i = 0; i < this.getCustomers().length; i++) 
        {
            if (this.getCustomers()[i] != null)
            {
                if (this.getCustomers()[i].getName()
                    .equals(passenger.getName())
                    && this.getCustomers()[i].getAge() 
                    == (passenger.getAge()))
                {
                    return true;
                } // end of if (this.getCustomers()[i]...)
            } // end of if (this.getCustomers()[i] != null)
        } // end of for (int i = 0; i < passengerDatabase.length; i++)
        return false;
    } // end of method isRegistered(Passenger passenger...)

    /*
     * Method to check if the entered location is one
     * Victoria Airlines serves
     */
    private static boolean isValidLocation(String locationName)
    {
        boolean isValid;
        switch(locationName)
        {
            case "Toronto":
            isValid = true;
            break;

            case "Los Angeles":
            isValid = true;
            break;

            case "Chicago":
            isValid = true;
            break;

            case "New York":
            isValid = true;
            break;

            case "Vancouver":
            isValid = true;
            break;

            case "Beijing":
            isValid = true;
            break;

            case "Sydney":
            isValid = true;
            break;

            case "Tokyo":
            isValid = true;
            break;

            case "London":
            isValid = true;
            break;

            case "Dubai":
            isValid = true;
            break;

            case "Delhi":
            isValid = true;
            break; 

            default:
            isValid =  false;
            break;
        } // end of switch(locationName)
        return isValid;
    } // end of method isValidLocation(String locationName)

    /**
     * Displays the flights of this operations
     * office.
     */
    public void displayFlights()
    {
        if (numberOfFlights == 0)
        {
            System.out.println("No Flights Scheduled");
        }
        else
        {
            System.out.println("Flights");
        } //  if (numberOfFlights == 0)
        for (int i = 0; i < this.numberOfFlights; i++)
        {
            System.out.println("[" + i + "]" 
                + " Flight Name:" + flight[i].getFlightName() 
                + ", Cost:" + flight[i].getCost() 
                + ", Takeoff Data:" + flight[i].getDate()
                + ", Departure:" + flight[i].getDeparture().getLocationName() 
                + ", Destination:" + flight[i].getDestination()
                .getLocationName()
                + ", Plane Name:" + flight[i].getPlane().getName()
            );
        } // end of for (int i = 0; i < this.numberOfFlight...)      
    } // end of method displayFlights()

    /**
     * Displays the planes of this operations
     * office.
     */
    public void displayPlanes()
    {
        if (numberOfPlanes == 0)
        {
            System.out.println("No Planes in Database");
        }
        else
        {
            System.out.println("Planes");
        } //  if (numberOfPlanes == 0)
        for (int i = 0; i < this.numberOfPlanes; i++)
        {
            System.out.println("[" + i + "] " 
                + " Plane Name:" + plane[i].getName() 
                + ", Cargo space:" + plane[i].getMaximumNumberOfItemsOfCargo() 
                + ", Aircraft:" + plane[i].getAircraftType()
                + ", Seat Rows:" + plane[i].getSeat().length 
                + ", Seats Per Row:" + plane[i].getSeat()[0].length
                + ", Scheduled:" + plane[i].isScheduled()
                + ", Range:" + plane[i].getRange()
                + ", Current Location:" + plane[i].getLocation()
            );
        } // end of for (int i = 0; i < this.numberOfPlanes..)
    } // end of method displayPlanes()

    /**
     * Displays the customers of this operations
     * office.
     */
    public void displayCustomers()
    {
        if (numberOfCustomers == 0)
        {
            System.out.println("No Registered Customers");
        }
        else
        {
              System.out.println("Customers");
        } // end of if (numberOfCustomers == 0)
        for (int i = 0; i < this.numberOfCustomers; i++)
        {
            System.out.println("[" + i + "] " 
                + " Name:" + customer[i].getName() 
                + ", Age:" + customer[i].getAge() 
                + ", Ticket:" + customer[i].getTicket()
                + ", Possesion of Ticket:" + customer[i].hasTicket()
                + ", Points:" + customer[i].getRewardPoints()
                + ", Cargo:" + customer[i].getPassengerCargo()
            );
        } // end of for (int i = 0; i < this.numberOfCustomers...)
    } // end of method displayCustomers()
} // end of class OperationsOffice