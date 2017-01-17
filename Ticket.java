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
    private Passenger ticketOwner;
    
    /* constructors */
    /**
     * Constructs a ticket with the specified 
     * characteristics
     * 
     * @param reservedFlight the flight of this ticket
     * <br><i>pre-condition </i>reservedFlight may not 
     * be <code>null</code>
     * @param reservedSeat the seat of this ticket
     * <br><i>pre-condition </i>reservedSeat may not 
     * be <code>null</code>
     * @param ticketOwner the owner of this ticket
     * <br><i>pre-condition </i>ticketOwner may not 
     * be <code>null</code>
     */
    public Ticket(Flight reservedFlight, String reservedSeat, Passenger ticketOwner)
    {
        // Check validity of parameters.
        if (reservedFlight == null) return;
        if (reservedSeat == null) return;
        if (ticketOwner == null) return;
        
        this.reservedFlight = reservedFlight;
        this.reservedSeat = reservedSeat;
        this.ticketOwner = ticketOwner;
    } // end of constructor Ticket(Flight reservedFlight, String reservedSeat...)
    
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
     * Returns the owner of this ticket.
     * 
     * @return the owner of this ticket
     */
    public Passenger getTicketOwner()
    {
        return this.ticketOwner;
    } // end of method getTicketOwner()
    
    /*mutators*/
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
    
    /**
     * Sets the owner of this ticket.
     * 
     * @param ticketOwner the owner to be
     * set to this ticket <br><i>pre-condtion: </i>
     * ticketOwner may not be <code>null</code>
     */
    public void setTicketOwner(Passenger ticketOwner)
    {
        // Check validity of ticketOwner
        if (ticketOwner == null) return;
        this.ticketOwner = ticketOwner; 
    } // end of method setTicketOwner(Passenger ticketOwner)
} // end of class Ticket