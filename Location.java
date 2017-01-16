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
    private int longitude;
    private String locationName;

    /**
     * Constructs a location with the specifed name
     * and assigns it with its corresponding coordinates.
     * 
     * @param locationName the name of this location
     */
    public Location(String locationName)
    {
        this.locationName = locationName;
        switch (locationName)
        {
            case locationName.equalsIgnoreCase("toronto"):
            this.latitude = 43.6532;
            this.longitude = -79.3832;
            break;
            
            case locationName.equalsIgnoreCase("los angeles"):
            this.latitude = 34.0522;
            this.longitude = -118.2437;
            break
            
            case locationName.equalsIgnoreCase("chicago"):
            this.latitude = 41.8781;
            this.longitude = -87.6298;
            break;
            
            case locationName.equalsIgnoreCase("new York"):
            this.latitude = 41.8781;
            this.longitude = -87.6298;
            break;
            
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
