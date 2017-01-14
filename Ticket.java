/**
 * A flight ticket.
 * 
 * @author  Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 1.0 2017-1-12
 */
public class Ticket
{
    // instance fields
    private Flight reservedFlight;
    private String reservedSeat;
    private Passenger ticketOwner;
    
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
     * Returns the seat of this ticket.
     * 
     * @return the seat of this ticket.
     */
} // end of class Ticket
