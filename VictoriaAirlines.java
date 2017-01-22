/**
 * The Command Line interface of  Victoria 
 * Airlines. 
 * 
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 2017-01-16
 */
public class VictoriaAirlines
{
    private static int DEFAULT_MAXIMUM_NUMBER_OF_CUSTOMERS = 10000;
    private static int DEFAULT_MAXIMUM_NUMBER_OF_FLIGHTS = 1000;
    private static int DEFAULT_MAXIMUM_NUMBER_OF_PLANES = 10;
    final static String FLIGHT_DATABASE = "flightDatabase.txt";
    final static String PASSENGER_DATABASE = "passengerDatabase.txt";
    final static String PLANE_DATABASE = "planeDatabase.txt";
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
        OperationsOffice.help();

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
            String input = OperationsOffice.getString("> ");

            // Check for sentinel value
            if (input.equals("exit"))
            {
                programShouldContinue = false;
            } // end of 

            //Handle input
            OperationsOffice.handleInput(input, operationsOffice);

        } // end of loop
        while (programShouldContinue);
    } // end of method main(String[] argument)
} // end of class VictoriaAirlines
