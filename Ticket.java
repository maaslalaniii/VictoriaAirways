/**
 * A document that a passenger must possess
 * in order to be allowed to board a flight.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 1.0 2017-01-12
 */
public class Ticket
{
    /* instance fields */
    private Flight reservedFlight;
    private String reservedSeat;

    /* constructors */
    /**
     * Constructs a ticket with the specified characteristics.
     * 
     * @param reservedFlight the flight of this ticket
     * <br><i>pre-condition </i>reservedFlight may not 
     * be <code>null</code>
     * @param reservedSeat the seat of this ticket
     * <br><i>pre-condition </i>reservedSeat may not 
     * be <code>null</code>
     */
    public Ticket(Flight reservedFlight, 
				  String reservedSeat)
    {
        // Check validity of parameters.
        if (reservedFlight == null) return;
        if (reservedSeat == null) return;

        this.reservedFlight = reservedFlight;
        this.reservedSeat = reservedSeat;

    } // end of constructor Ticket(Flight reservedFlight...)

    /* accessors */
    /**
     * Returns the flight of this ticket.
     * 
     * @return the flight of this ticket
     */
    public Flight getReservedFlight()
    {
        return this.reservedFlight;
    } // end of method getReservedFlight()

    /**
     * Returns the seat belonging to this ticket.
     * 
     * @return the seat belonging to this ticket
     */
    public String getReservedSeat()
    {
        return this.reservedSeat;
    } // end of method getReservedSeat()


    /**
     * Returns a string representation of this ticket.
     * 
     * @returns a string representation of this ticket
     */
    public String toString()
    {
        return
        getClass().getName()
        + "["
        + "flight: " + reservedFlight
        + ", seat: " + reservedSeat
        + "]";
    } // end of method toString()
    
    /* mutators */
    /**
     * Sets the flight of this ticket.
     * 
     * @param reservedFlight the flight to be set
     * to this ticket <br><i>pre-condition: </i>
     * reservedFlight may not be <code>null</code>
     */
    public void setReservedFlight(Flight reservedFlight)
    {
        // Check validity of reservedFlight
        if (reservedFlight == null) return;
        this.reservedFlight = reservedFlight;
    } // end of method setReservedFlight(Flight reservedFlight)

    /**
     * Sets the seat of this ticket.
     * 
     * @param reservedSeat the seat to be set
     * to this ticket <br><i>pre-condition: </i>
     * reservedSeat may not be <code>null</code>
     */
    public void setReservedSeat(String reservedSeat)
    {
        // Check validity of reservedSeat
        if (reservedSeat == null) return;
        this.reservedSeat = reservedSeat;
    } // end of method setReservedSeat(Seat reservedSeat)
} // end of class Ticket
