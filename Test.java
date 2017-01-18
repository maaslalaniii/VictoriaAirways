/**
 * A class which tests the Victoria_Airways package
 * against the test data specified throughout the class.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang
 * @version 1.0 2016-01-17
 */
public class Test
{
    /**
     * Tests the functions of the Victoria_Airways package.
     * 
     * @param argument not used
     */
    public static void main(String [] argument)
    {
        // Create operation office
        OperationsOffice victoriaAirways = new OperationsOffice(5, 5, 10);

        // Create multiple planes to add operation office
        Boeing737Short plane1 = new Boeing737Short("Plane1", "Toronto");
        Boeing737Medium plane2 = new Boeing737Medium("Plane2", "Tokyo");
        AirbusA340 plane3 = new AirbusA340("Plane3", "Dubai");
        Boeing737Short plane4 = new Boeing737Short("Plane4", "Los Angeles");
        Boeing737Medium plane5 = new Boeing737Medium("Plane5", "Vancouver");
        AirbusA340 plane6 = new AirbusA340("Plane6", "Beijing");
        Boeing737Short plane7 = new Boeing737Short("Plane7", "Delhi");
        Boeing737Medium plane8 = new Boeing737Medium("Plane8", "Sydney");
        AirbusA340 plane9 = new AirbusA340("Plane9", "Toronto");
        Boeing737Short plane10 = new Boeing737Short("Plane10", "Los Angeles");

        // Add the planes to the office database
        victoriaAirways.addPlane(plane1);
        victoriaAirways.addPlane(plane2);
        victoriaAirways.addPlane(plane3);
        victoriaAirways.addPlane(plane4);
        victoriaAirways.addPlane(plane5);
        victoriaAirways.addPlane(plane6);
        victoriaAirways.addPlane(plane7);
        victoriaAirways.addPlane(plane8);
        victoriaAirways.addPlane(plane9);
        victoriaAirways.addPlane(plane10);

        /*
         * Ensure that the planes have been added to the plane database 
         * properly
         */
        System.out.println ("Test 1: Check if all 10 planes have been"
            + " added to plane database");
        for (int i = 0; i < victoriaAirways.getPlanes().length; i++)
        {
            System.out.println (i + ": " + victoriaAirways.getPlanes()[i]);
        } // end of for (int i = 0; i < victoriaAirways.getPlanes().length...)

        // Try adding another plane, while database is full
        System.out.println ("\nTest 2: Attempt to add a plane \"extra\"" 
            + "into the database when full");
        AirbusA340 extra = new AirbusA340("extra", "Toronto");
        victoriaAirways.addPlane(plane10); 
        for (int i = 0; i < victoriaAirways.getPlanes().length; i++)
        {
            System.out.println (i + ": " + victoriaAirways.getPlanes()[i]);
        } // end of for (int i = 0; i < victoriaAirways.getPlanes().length...)

        // Create multiple passengers to add to the customers database
        Passenger passenger1 = new Passenger("Jenisha", 16, null, true, 100, 
                new Cargo(15, false, 100));
        Passenger passenger2 = new Passenger("Maas", 17, null, true, 200, 
                new Cargo(20, true, 200));
        Passenger passenger3 = new Passenger("Ming Zhao", 16, null, true, 150, 
                new Cargo(34, false, 170));
        Passenger passenger4 = new Passenger("Bob", 35, null, true, 100, 
                new Cargo(35, true, 100));
        Passenger passenger5 = new Passenger("Maddy", 20, null, true, 50, 
                new Cargo(65, true, 190));

        // Add the passengers to the customer database
        victoriaAirways.addCustomer(passenger1);
        victoriaAirways.addCustomer(passenger2);
        victoriaAirways.addCustomer(passenger3);
        victoriaAirways.addCustomer(passenger4);
        victoriaAirways.addCustomer(passenger5);

        /* Ensure the passengers have been added to the customer 
         * database properly 
         */
        System.out.println ("\nTest 3: Check if all 5 passengers have" 
            + " been added to customer database");
        for (int i = 0; i < victoriaAirways.getCustomers().length; i++)
        {
            System.out.println (i + ": " + victoriaAirways.getCustomers()[i]);
        } // end of for (int i = 0; i < victoriaAirways.getCustomers(); i++)

        // Try adding another passenger, while customer database is full
        System.out.println ("\nTest 4: Attempt to add a passenger" 
            + "\"extraPerson\" into the database when full");
        Passenger extraPerson = new Passenger("extraPerson", 16, null, true, 
                100, new Cargo(15, false, 100));
        victoriaAirways.addCustomer(extraPerson);
        for (int i = 0; i < victoriaAirways.getCustomers().length; i++)
        {
            System.out.println (i + ": " + victoriaAirways.getCustomers()[i]);
        } // end of for (int i = 0; i < victoriaAirways.getCustomers(); i++)

        // Schedule a flight with the required plane present in the database
        System.out.println ("\nTest 5: Schedule a flight, with the required" 
            + " plane present in the database");
        victoriaAirways.scheduleFlight(100, new Date(2017, 1, 29, 7, 30), 
            "Los Angeles", "Toronto"); 
        for (int i = 0; i < victoriaAirways.getFlights().length; i++)
        {
            System.out.println (i + ": " + victoriaAirways.getFlights()[i]);
        } // end of for (int i = 0; i < victoriaAirways.getFlights(); i++)

        /*
         * Attempt to schedule a flight, where required plane isn't
         * present in database
         */
        System.out.println ("\nTest 6: Attempt to schedule a flight," 
            + " where required plane isn't in the database");
        victoriaAirways.scheduleFlight(100, new Date(2017, 1, 29, 7, 30),
            "Dubai", "London");
        for (int i = 0; i < victoriaAirways.getFlights().length; i++)
        {
            System.out.println (i + ": " + victoriaAirways.getFlights()[i]);
        } // end of for (int i = 0; i < victoriaAirways.getFlights().length...)

        // Schedule more flights
        System.out.println ("\nTest 7: Schedule mulitple flights");
        System.out.println("Just created flight: " 
            + victoriaAirways.scheduleFlight(150, 
                new Date(2017, 5, 29, 8, 30), 
                "Vancouver", "Los Angeles"));
        System.out.println("Just created flight: " 
            + victoriaAirways.scheduleFlight(250,
                new Date(2017, 3, 30, 9, 12), "Delhi", "Tokyo"));
        System.out.println("Just created flight: " 
            + victoriaAirways.scheduleFlight(250, 
                new Date(2017, 7, 24, 13, 52), 
                "Sydney", "Toronto"));
        System.out.println("Just created flight: " 
            + victoriaAirways.scheduleFlight(250, 
                new Date(2017, 2, 10, 20, 32), 
                "Beijing", "Sydney"));
        System.out.println("");
        for (int i = 0; i < victoriaAirways.getFlights().length; i++)
        {
            System.out.println (i + ": " + victoriaAirways.getFlights()[i]);
        } // end of for (int i = 0; i < victoriaAirways.getFlights().length...)

        // Attempt to schedule a flight while flight database is full
        System.out.println ("\nTest 8: Attempt to schedule a "
            + "flight while database is full");
        System.out.println("Just created flight: " 
            + victoriaAirways.scheduleFlight(250, 
                new Date(2017, 2, 10, 7, 02), 
                "Toronto", "Beijing"));
        for (int i = 0; i < victoriaAirways.getFlights().length; i++)
        {
            System.out.println (i + ": " + victoriaAirways.getFlights()[i]);
        } // end of for (int i = 0; i < victoriaAirways.getFlights().length...)

        // Create a ticket for a flight present in the database
        System.out.println ("\nTest 9: Create a ticket for a flight" 
            + " present in the database");
        victoriaAirways.createTicket(passenger1, "Los Angeles", "Vancouver");
        System.out.println ("Just created ticket for "
            + "passengr1: " + passenger1.getTicket());

        /* 
         * Create another ticket for the same flight, ensuring the assigned 
         * seats are not the same
         */
        System.out.println ("\nTest 10: Create another ticket for the same" 
            + " flight present, ensuring seats are" 
            + " assigned properly");
        victoriaAirways.createTicket(passenger2, "Los Angeles", "Vancouver");
        System.out.println ("Just created ticket for "
            + "passenger2: " + passenger2.getTicket());

        //Compare the two seats 
        System.out.println("passenger1's seat: " 
            + passenger1.getTicket().getReservedSeat()); 
        System.out.println("passenger2's seat: " 
            + passenger2.getTicket().getReservedSeat()); 

        // Attempt to create a ticket for a flight which is full
        System.out.println ("\nTest 11: Attempt to create a "
            + "ticket for a flight which is full");
        // Set all the seats of the flight's plane as taken
        for (int row = 0; row < victoriaAirways.getFlights()[0]
        .getPlane().getSeat().length; row++)
        {
            for (int column = 0; column < victoriaAirways.getFlights()[0]
            .getPlane().getSeat()[row].length; column++)
            {
                victoriaAirways.getFlights()[0].getPlane()
                .getSeat()[row][column].setAvailability(true);
            } // end of for (int column = 0; column < this.seat[row].length...)
        } // end of for (int row = 0; row < this.seat.length; row++)

        //Display the seats of the plane
        for (int row = 0; row < victoriaAirways.getFlights()[0]
        .getPlane().getSeat().length; row++)
        {
            for (int column = 0; column < victoriaAirways.getFlights()[0]
            .getPlane().getSeat()[row].length; column++)
            {
                System.out.print(" " + victoriaAirways.getFlights()[0]
                    .getPlane().getSeat()[row][column]);
            } // end of for (int column = 0; column...)
            System.out.println ("");
        } // end of for (int row = 0; row < this.seat.length; row++)

        // Try and create the ticket
        victoriaAirways.createTicket(passenger3, "Toronto", "Los Angeles");
        System.out.println ("Just created ticket for passenger3: " 
            + passenger3.getTicket());

        /*
        Add passenger with reservation(ticket) and their 
        cargo to the plane specified 
         */
        System.out.println ("\nTest 12: Add passenger and "
            + "cargo reservation to flight");
        victoriaAirways.reservation(passenger1);

        // display the flight
        System.out.println("passenger1 added to flight: " 
            + passenger1.getTicket().getReservedFlight());
        // display the seats of the flight
        for (int row = 0; row < passenger1.getTicket().getReservedFlight()
        .getPlane().getSeat().length; row++)
        {
            for (int column = 0; column < passenger1.getTicket()
            .getReservedFlight().getPlane().getSeat()[row].length; column++)
            {
                System.out.print(" " + passenger1.getTicket()
                    .getReservedFlight().getPlane()
                    .getSeat()[row][column]);
            } // end of for (int column = 0; column < this.seat[row].length...)
            System.out.println ("");
        } // end of for (int row = 0; row < this.seat.length; row++)

        // Add another passenger to the same flight
        System.out.println ("\nTest 13: Add another passenger and "
            + "cargo reservation to the same flight");
        victoriaAirways.reservation(passenger2);

        // display the flight
        System.out.println("passenger2 added to flight: " 
            + passenger2.getTicket().getReservedFlight());
        // display the seats of the flight
        for (int row = 0; row < passenger2.getTicket().getReservedFlight()
        .getPlane().getSeat().length; row++)
        {
            for (int column = 0; column < passenger2.getTicket().getReservedFlight()
            .getPlane().getSeat()[row].length; column++)
            {
                System.out.print(" " + passenger2.getTicket().getReservedFlight()
                    .getPlane().getSeat()[row][column]);
            } // end of for (int column = 0; column < this.seat[row].length...)
            System.out.println ("");
        } // end of for (int row = 0; row < this.seat.length; row++)

        // Attempt to add a reservation for a passenger without a ticket
        System.out.println ("\nTest 14: Attempt to add a "
            + "reservation for a passenger without a ticket");
        victoriaAirways.reservation(passenger4);
        // Flights will remain unaltered
        for (int i = 0; i < victoriaAirways.getFlights().length; i++)
        {
            System.out.println (i + ": " + victoriaAirways.getFlights()[i]);
        } // end of for (int i = 0; i < victoriaAirways.getFlights().length...)

        // Reward passenger who is in the customer database with flier points 
        System.out.println ("\nTest 15: Reward passenger who is in the" 
            + " customer database with flier points ");
        System.out.println (passenger1);
        System.out.println ("points for passenger1 before reward: " 
            + passenger1.getRewardPoints()); 
        victoriaAirways.rewardPoints(passenger1);
        System.out.println ("points for passenger1 after reward: " 
            + passenger1.getRewardPoints());

        // Attempt to reward passenger in customer database, without a ticket
        System.out.println ("\nTest 16: Attempt to reward passenger" 
            + " in customer database, without a ticket");
        System.out.println (passenger3);
        System.out.println ("points for passenger3 before reward: " 
            + passenger3.getRewardPoints()); 
        victoriaAirways.rewardPoints(passenger3);
        System.out.println ("points for passenger3 after reward: " 
            + passenger3.getRewardPoints());

        // Attempt to reward a passenger who isn't in the customer database
        System.out.println ("\nTest 17: Attempt to reward a "
            + " passenger who isn't in the customer database");
        Passenger passenger6 = new Passenger("Bill", 20, null, true, 0, 
                new Cargo(65, true, 190));
        System.out.println (passenger6);
        System.out.println ("points for passenger6 before reward: " 
            + passenger6.getRewardPoints()); 
        victoriaAirways.rewardPoints(passenger6);
        System.out.println ("points for passenger6 after reward: " 
            + passenger6.getRewardPoints());
    } // end of method main(String[] argument)
} // end of class Test
