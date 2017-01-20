/**
 * A flying vehicle that is capable of travelling from a point
 * of departure to a destination.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 1.0 2017-01-11
 */
public class Plane
{
    /* class constants */
    private static final int DEFAULT_NUMBER_OF_ROWS = 30;
    private static final int DEFAULT_NUMBER_OF_SEATS_PER_ROW = 10;
    // Number of cargo items should be equivelent to the number of people on this plane, one item per person.
    private static final int DEFAULT_MAXIMUM_NUMBER_OF_CARGO_ITEMS = DEFAULT_NUMBER_OF_ROWS * DEFAULT_NUMBER_OF_SEATS_PER_ROW;
    private static final String DEFAULT_RANGE = "Short";
    private static final String DEFAULT_LOCATION = "Toronto";
    
    /* instance fields */
    private String aircraftType;
    private boolean isScheduled;
    private String location;
    private int maximumNumberOfItemsOfCargo;
    private int maximumNumberOfPassengers;
    private String name;
    private String range;
    private Seat[][] seat;

    /* constructors */
    /**
     * Constructs a plane with specified name,
     * cargo limit, aircraft type, seating plan,
     * schedule status and range.
     *
     */
    public Plane()
    {
        this.name = "";
        this.maximumNumberOfPassengers = DEFAULT_NUMBER_OF_ROWS * DEFAULT_NUMBER_OF_SEATS_PER_ROW;
        this.maximumNumberOfItemsOfCargo = DEFAULT_MAXIMUM_NUMBER_OF_CARGO_ITEMS;
        this.aircraftType = "";
        this. seat = new Seat[DEFAULT_NUMBER_OF_ROWS][DEFAULT_NUMBER_OF_SEATS_PER_ROW];
        this.isScheduled = false;
        this.range = DEFAULT_RANGE;
        this.location = DEFAULT_LOCATION;

        // Set the names of the seats
        this.setSeatNames();
    } // end of constructor Plane(String name, int maximumPassengers...) 
    
    /**
     * Constructs a plane with specified name,
     * cargo limit, aircraft type, seating plan,
     * schedule status and range.
     * 
     * @param name the name of this plane <br><i>pre-condition: </i>
     * name may not be <code>null </code>
     * @param maximumNumberOfItemsOfCargo the cargo limit
     * of this plane <br><i>pre-condition: </i>
     * maximumNumberOfItemsOfCargo must be >= 0 
     * @param aircraftType the aircraft type of this plane
     * <br><i>pre-condition: </i> aircraftType may not be 
     * @param rowsOfSeats the number of rows of seats in this
     * plane <br><i>pre-condition: </i> rowOfSeats may not be <=0
     * @param seatsInRow the number of seats per row in this 
     * plane <br><i>pre-condition: </i> seatsInRow may not be <=0
     * @param isScheduled the schedule status of this plane
     * @param range the range of this plane <br><i>pre-condition: </i> 
     * range may not be <code>null </code>
     */
    public Plane(String name, 
    int maximumNumberOfItemsOfCargo, 
    String aircraftType, 
    int rowsOfSeats,
    int seatsInRow,
    boolean isScheduled, 
    String range, 
    String location)
    {
        // Check validity of parameters.
        if (name == null) return;
        if (maximumNumberOfItemsOfCargo <0) return;
        if (aircraftType == null) return;
        if (rowsOfSeats <= 0) return;
        if (seatsInRow <= 0) return; 
        if (range == null) return;

        this.name = name;
        /*
         * Calculate the maximum number of passengers using the 
         * number of seats available on this plane. 
         */ 
        this.maximumNumberOfPassengers = rowsOfSeats * seatsInRow;
        this.maximumNumberOfItemsOfCargo = maximumNumberOfItemsOfCargo;
        this.aircraftType = aircraftType;
        this. seat = new Seat[rowsOfSeats][seatsInRow];
        this.isScheduled = isScheduled;
        this.range = range;
        this.location = location;

        // Set the names of the seats
        this.setSeatNames();
    } // end of constructor Plane(String name, int maximumPassengers...) 

    /**
     * Returns the name of this plane.
     * 
     * @return the name of this plane
     */
    public String getName()
    {
        return this.name;
    } // end of method getName()

    /**
     * Returns the maximum number of passengers
     * of this plane.
     * 
     * @return the maximum number of passengers of
     * this plane
     */
    public int getMaximumNumberOfPassengers()
    {
        return this.maximumNumberOfPassengers;
    } // end of method getMaximumPassengers()

    /** 
     * Returns the maximum number of cargo of this plane.
     * 
     * @return the maximum number of cargo of this plane
     */
    public int getMaximumNumberOfItemsOfCargo()
    {
        return this.maximumNumberOfItemsOfCargo;
    } // end of method getMaximumNumberOfCargo()

    /**
     * Returns the type of aircraft of this
     * plane.
     * 
     * @return the type of aircraft of this 
     * plane
     */
    public String getAircraftType()
    {
        return aircraftType;
    } // end of method getAircraftType

    /**
     * Returns the seating plan of this plane.
     * 
     * @return the seating plan of this plane
     */
    public Seat[][] getSeat()
    {
        return this.seat;
    } // end of method getSeat() 

    /**
     * Checks if this plane is scheduled.
     * 
     * @return <code>true</code> if this plane is
     * scheduled otherwise <code>false.</code>
     */
    public boolean isScheduled()
    {
        return this.isScheduled;
    } // end of method isScheduled()

    /**
     * Returns the range of this plane.
     * 
     * @return the range of this plane
     */
    public String getRange()
    {
        return this.range;
    } // end of method getRange()

    /**
     * Returns the location of this plane.
     * 
     * @return the location of this plane
     */
    public String getLocation()
    {
        return this.location;
    } // end of getLocation()

    /**
     * Returns a string representation of this plane.
     * 
     * @return a string representaion of this plane
     */
    public String toString()
    {
        return
        getClass().getName()
        + "["
        + "name: " + this.name
        + ", maxPassengers: " + this.maximumNumberOfPassengers
        + ", maxCargo: " + maximumNumberOfItemsOfCargo
        + ", aircraft: " + aircraftType
        + ", isScheduled: " + isScheduled
        + ", range: " + range
        + ", location: " + location
        + "]";
    } // end of method toString()

    /* mutators */
    /**
     * Sets the name of this plane. 
     * 
     * @param name the name to be set.<br><i>pre-condition: </i>
     * name may not be <code>null </code>
     */
    public void setName(String name)
    {
        // Check validity of name.
        if (name == null) return;
        this.name = name;
    } // end of method setName(String name)

    /**
     * Sets the maximum number of passengers
     * of this plane
     * 
     * @param maximumPassengers the maximum
     * number of passengers to be set <br><i>pre-condition: </i>
     * <code>maximumPassengers may not be greater than seats
     * in this plane</code>
     */
    public void setMaximumNumberOfPassengers(int maximumNumberOfPassengers)
    {
        /*
        Check that maximum number of passengers does not
        exceed amount of seats on plane.    
         */
        if (maximumNumberOfPassengers <= 
        this.getSeat().length * this.getSeat()[0].length)
            this.maximumNumberOfPassengers = maximumNumberOfPassengers; 
    } // end of method setMaximumPassengers(int maximumPassengers)

    /**
     * Sets the maximum cargo of this plane
     * 
     * @param maximumNumberOfItemsOfCargo the maximum number of 
     * cargo to be set <br><i>pre-condition: </i>
     * maximumNumberOfItemsOfCargo must be >= 0 
     */
    public void setMaximumNumberOfItemsOfCargo(int maximumNumberOfItemsOfCargo)
    {
        // Check validity of maximumNumberOfItemsOfCargo
        this.maximumNumberOfItemsOfCargo = maximumNumberOfItemsOfCargo; 
    } // end of method setMaximumCargo(int maximumNumberOfItemsOfCargo)

    /**
     * Sets the aircraft type of this plane.
     * 
     * @param aircraftType the aircraft type
     * to be set
     */
    public void setAircraftType(String aircraftType)
    {
        this.aircraftType = aircraftType;
    } // end of method setAircraftType(String aircraftType)

    /**
     * Sets the seating plan of this plane.
     *
     * @param seat the seats of this plane
     */
    public void setSeat(Seat[][] seat)
    {
        this.seat = seat;
    } // end of method setSeat(int rowsOfSeats, int seatsInRow)

    /**
     * Sets the schedule status of this plane.
     * 
     * @param isScheduled <code>true</code> if 
     * this plane is scheduled for flight, otherwise
     * <code> false</code>
     */
    public void setSchedule(boolean isScheduled)
    {
        this.isScheduled = isScheduled;
    } // end of method setSchedule(boolean isScheduled)

    /**
     * Sets the range of this plane.
     * 
     * @param range the range to be set
     */
    public void setRange(String range)
    {
        this.range = range;
    } // end of method setRange(String range)

    /**
     * Sets the location of this plane.
     * 
     * @param location the location of this plane.
     */
    public void setLocation (String location)
    {
        this.location = location;
    } // end of method setLocation(String location)

    public void setSeatNames()
    {
        /* 
        Name each seat according to its row and column in alpha 
        numeric form.
         */
        for (int row = 0; row < this.seat.length; row++)
        {
            for (int column = 0; column < this.seat[row].length; column++)
            {
                String seatName = "";

                // Associate column with its equivalent alpha value, i.e 1=A
                /* 
                 * We know that the first column will be A, so to calculate 
                 * the alpha we will use the ASCII value of A and add the 
                 * column number. i.e column 1(2 in the plane) = 65 + 1 = B, 
                 * so the alpha value of the second seat is B.
                 */ 
                char alphaValue = (char)(65 + column);
                seatName = alphaValue + Integer.toString(row + 1);

                // create the seat in the array
                this.seat[row][column] = new Seat (seatName,"economic",false,
                    null);
            } // end of for (int column = 0; column < this.seat[row].length...)
        } // end of for (int row = 0; row < this.seat.length; row++)
    } // end of method setSeatNames()
} // end of class Plane