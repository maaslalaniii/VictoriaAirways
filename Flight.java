import java.util.Date;

/**
 * A flight
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang
 * @version 1.0
 */
public class Flight
{
    /* instance fields */
    Cargo[] cargo;
    double cost;
    Date date;
    String destination;
    String departure;
    Passenger[] passenger;
    Plane plane;
    
    /**
     * Constructs a flight with the specified characteristics
     * 
     * 
     */
    public Flight(int maximumItemsOfCargo,
                  double cost,
                  Date date,
                  String destination,
                  String departure,
                  int maximumNumberOfPassengers,
                  Plane plane)
    {
        this.cargo = new Cargo[maximumItemsOfCargo];
        this.cost = cost;
        this.date = date;
        this.destination = destination;
        this.departure = departure;
        this.passenger = new Passenger[maximumNumberOfPassengers];
        this.plane = plane;
    } // end of constructor Flight()
} // end of class Flight
