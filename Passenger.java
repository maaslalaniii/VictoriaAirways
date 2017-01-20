/**
 * A passenger who is capable of boarding a flight.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 1.0 2016-12-23
 */
public class Passenger
{
    /* instance fields */
    private int age;
    private boolean hasPassport;
    private boolean hasTicket;
    private String name;
    private String passengerCargo;
    private int rewardPoints;
    private Ticket ticket;

    /* constructors */
    /**
     * Constructs a passenger with the specified characteristics.
     * 
     * @param name the name of this passenger
     * @param age the age of this passenger
     * @param ticket the ticket of this passenger
     * @param hasPassport <code>true</code> if this passenger has
     * a passport; <code>false</code> otherwise
     * @param rewardPoints the reward points of this passenger
     * @param passengerCargo the cargo of this passenger
     */
    public Passenger(String name, 
    int age,
    Ticket ticket, 
    boolean hasPassport, 
    int rewardPoints,
    String passengerCargo              
    )
    {
        this.name = name;
        // Does the passenger have a valid ticket.
        this.hasTicket = ticket != null;
        this.ticket = ticket;
        this.age = age;
        if (age < 0) this.age = 0;
        this.hasPassport = hasPassport;
        this.rewardPoints = rewardPoints;
        if (rewardPoints < 0) this.rewardPoints = 0;
        this.passengerCargo = passengerCargo;
    } // end of constructor Passenger(String name, int age...)

    /* accessors */  
    /**
     * Returns the age of this passenger.
     * 
     * @return the age of this passenger
     */
    public int getAge()
    {
        return age;
    } // end of method getAge()

    /**
     * Returns the name of this passenger.
     * 
     * @return the name of this passenger
     */
    public String getName()
    {
        return name;
    } // end of method getName()

    /**
     * Returns the reward points of this passenger.
     * 
     * @return the reward points of this passenger
     */
    public int getRewardPoints()
    {
        return this.rewardPoints;
    } // end of method getRewardPoints()

    /**
     * Returns <code>true</code> if this passenger has a ticket; otherwise
     * <code>false</code>.
     * 
     * @return <code>true</code> if this passenger has a ticket; otherwise
     * <code>false</code>
     */
    public boolean hasTicket()
    {
        return hasTicket;
    } // end of method hasTicket()

    /**
     * Returns the ticket of this passenger, if they have one.
     * 
     * @return the ticket of this passenger if they have one, 
     * otherwise <code>null</code>
     */
    public Ticket getTicket()
    {
        return this.ticket;
    } // end of method getTicket()

    /**
     * Returns <code>true</code> if this passenger has a passport; otherwise
     * <code>false</code>.
     * 
     * @return <code>true</code> if this passenger has a passport; otherwise
     * <code>false</code>
     */
    public boolean hasPassport()
    {
        return this.hasPassport;
    } // end of method hasPassport()

    /**
     * Returns the cargo of this passenger.
     * 
     * @return the cargo of this passenger
     */
    public String getPassengerCargo()
    {
        return this.passengerCargo;
    } // end of method getPassengerCargo()

    /**
     * Returns a string representation of this passenger.
     * 
     * @return a string representation of this passenger
     */
    public String toString()
    {
        // ticket field has been excluded in order to prevent stack overflow
        return
        getClass().getName()
        + "["
        + "name: " + name
        + ", age: " + age
        + ", hasPassport: " + hasPassport 
        + ", hasTicket: " + hasTicket
        + ", points: " + rewardPoints
        + ", cargo: " + passengerCargo 
        + "]";	
    } // end of method toString()
    
    /* mutators */ 
    /**
     * Sets the age of the passenger.
     * 
     * @param age the age of the passenger
     */
    public void setAge(int age)
    {
        this.age = age;
        if (age < 0) this.age = 0;
    } // end of method setAge(int age)

    /**
     * Sets the name of this passenger.
     * 
     * @param name the name of this passenger
     */
    public void setName(String name)
    {
        this.name = name;
    } // end of method setName(String name)

    /**
     * Sets this passenger's possession of a ticket.
     * 
     * @param hasTicket <code>true</code> if this passenger has
     * a ticket; <code>false</code> otherwise
     */
    public void setPossessionOfTicket(boolean hasTicket)
    {
        this.hasTicket = hasTicket;
    } // end of method setPossessionOfTicket(boolean hasTicket)

    /**
     * Sets the ticket of this passenger.
     * 
     * @param ticket the ticket to be set to
     * this passenger
     */
    public void setTicket(Ticket ticket)
    {
        this.ticket = ticket;

        // Indicate that this passenger has a ticket
        this.setPossessionOfTicket(true);
    } // end of method setTicket(Ticket ticket)

    /**
     * Sets the passenger's possession of a passport.
     * 
     * @param hasPassport <code>true</code> if this passenger has
     * a passport; <code>false</code> otherwise
     */
    public void setPossessionOfPassport(boolean hasPassport)
    {
        this.hasPassport = hasPassport;
    } // end of method setPossessionOfPassport(boolean hasPassport)

    /**
     * Sets the cargo of this passenger.
     * 
     * @param the passengerCargo to be set to this passenger
     */
    public void setPassengerCargo(String passengerCargo)
    {
        this.passengerCargo = passengerCargo;
    } // end of method setPassengerCargo(String passengerCargo)

    /**
     * Sets the amount of frequent-flyer reward points of this passenger.
     * 
     * @param rewardPoints the amount of frequent-flyer reward 
	 * points of this passenger
     */
    public void setRewardPoints(int rewardPoints)
    {
        this.rewardPoints = rewardPoints;
        if (rewardPoints < 0) this.rewardPoints = 0;
    } // end of method setRewardPoints(int rewardPoints)

    /**
     * Add the specifed amount of frequent-flyer reward 
     * points to this passenger.
     * 
     * @param rewardPointsToBeAdded the amount of frequent-flyer points to 
	 * be added
     */
    public void addPoints(int rewardPointsToBeAdded)
    {
        this.rewardPoints += rewardPointsToBeAdded;
    } // end of method addPoints(int rewardPointsToBeAdded)
} // end of class Passenger
