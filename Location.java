/**
 * Write a description of class Location here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Location
{
    // instance variables
    private double latitude;
    private double longitude;
    private String locationName;

    /**
     * Constructs a location with the specifed name
     * and assigns it with its corresponding coordinates
     * if it is a location where Victoria Airways provides 
     * service.
     * 
     * @param locationName the name of this location <br>
     * <i>pre-condition: </i> locationName may not be 
     * <code>null</code>
     */
    public Location(String locationName)
    {
       // Check validity of locationName
        if (locationName == null)return;
        /* 
         * Check if entered location is one Victoria Airways provides
         * services too
         */ 
        switch (locationName)
        {
            case "Toronto":
            this.locationName = locationName;
            this.latitude = 43.6532;
            this.longitude = -79.3832;
            break;

            case "Los Angeles":
            this.locationName = locationName;
            this.latitude = 34.0522;
            this.longitude = -118.2437;
            break;

            case "Chicago":
            this.locationName = locationName;
            this.latitude = 41.8781;
            this.longitude = -87.6298;
            break;

            case "New York":
            this.locationName = locationName;
            this.latitude = 40.7128;
            this.longitude = -74.0059;
            break;

            case "Vancouver":
            this.locationName = locationName;
            this.latitude = 49.2827;
            this.longitude = -123.1207;
            break;

            case "Beijing":
            this.locationName = locationName;
            this.latitude = 39.9042;
            this.longitude = 116.4074;
            break;

            case "Sydney":
            this.locationName = locationName;
            this.latitude = -33.8688;
            this.longitude = 151.2093;
            break;

            case "Tokyo":
            this.locationName = locationName;
            this.latitude = 35.6895;
            this.longitude = 139.6917;
            break;

            case "London":
            this.locationName = locationName;
            this.latitude = 51.5074;
            this.longitude = -0.1278;
            break;

            case "Dubai":
            this.locationName = locationName;
            this.latitude = 25.2048;
            this.longitude = 55.2708;
            break;

            case "Delhi":
            this.locationName = locationName;
            this.latitude = 28.7041;
            this.longitude = 77.1025;
            break; 

            default:
            return;
        } // end of switch(locationName)
    } // end of constructor Location (locationName)

    /**
     * Returns the name of this location.
     * 
     * @return the name of this location
     */
    public String getLocationName()
    {
        return this.locationName;
    } // end of method getLocationName()

    /**
     * Returns the latitude of this location.
     * 
     * @return the latitude of this location
     */
    public double getLatitude()
    {
        return this.latitude;
    } // end of method getLatitude()

    /**
     * Returns the longitude of this location.
     * 
     * @return the longitude of this location
     */
    public double getLongitude()
    {
        return this.longitude;
    } // end of method getLongitude()

    /**
     * Sets the name of this location
     * 
     * @param locationName the name of this location
     * <br><i>pre-condition: </i> locationName may 
     * not be <code>null</code>
     */
    public void setLocationName(String locationName)
    {
        // Check validity of locationName
        if (locationName == null)return;
        this.locationName = locationName;
    } // end of method setLocationName(String locationName)
    
    /**
     * Sets the latitude of this location
     * 
     * @param latitude the latitude of this location
     */
    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    } // end of method setLatitude(double latitude)
    
    /**
     * Sets the longitude of this location
     * 
     * @param longitude the longitude of this location
     */
    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    } // end of method setLongitude(double longitude)
} // end of class Location
