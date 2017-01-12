/**
 * A seat in a plane.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 1.0 2017-1-11
 */
public class Seat
{
    // instace fields
    private String seatName;
    private String seatType;
    private boolean isTaken;

    /**
     * Constructs a seat with the specified charateristics.
     * 
     * @param seatName the name to be set for this seat
     * @param seatType the type of class to be set for this seat
     * @param isTaken <code>true</code> if this seat is taken, 
     * otherwise <code>false</code>
     */
    public Seat(String seatName, String seatType, boolean isTaken)
    {
        this.seatName = seatName;
        this.seatType = seatType;
        this.isTaken = isTaken;
    } // end of constructor Seat(String seatName, String seatClass, boolean isTaken)

    /**
     * Returns the name of this seat.
     * 
     * @return the name of this seat
     */
    public String getSeatName()
    {
        return this.seatName;
    } // end of method getSeatName()

    /**
     * Returns the seat type of this seat.
     * 
     * @return the seat type of this seat
     */
    public String getSeatType()
    {
        return this.seatType;
    } // end of method getSeatType()

    /**
     * Returns <code>true</code> if this seat 
     * is taken, otherwise <code>false</code>
     * 
     * @return <code>true</code> if this seat 
     * is taken, otherwise <code>false</code>
     */
    public boolean isTaken()
    {
        return this.isTaken;
    } // end of method isTaken()

    /**
     * Sets the name of this seat.
     * 
     * @param seatName the name of this seat
     * <br><i>pre-condition: </i> seatName may
     * not be <code>null</code>
     */
    public void setSeatName(String seatName)
    {
        this.seatName = seatName;
    } // end of method setSeatName(String seatName)

    /**
     * Sets the seat type of this seat.
     * 
     * @param seatType the seat type of this seat
     * <br><i>pre-condition: </i> seatType may
     * not be <code>null</code>
     */
    public void setSeatType(String seatType)
    {
        this.seatType = seatType;
    } // end of method setSeatType(String seatType)

    /**
     * Sets the availability of this seat
     * 
     * @param isTaken <code> true</code> if
     * the seat is taken, otherwise <code>false</code>
     */
    public void setAvailability(boolean isTaken)
    {
        this.isTaken = isTaken;
    } // end of method setAvailability(boolean isTaken)
} // end of class Seat
