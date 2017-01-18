/**
 * A long range AirbusA340 plane.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 1.0 2017-1-11
 */
public class AirbusA340 extends Plane
    {
        /**
         * Constructs a plane with the characteristics
         * of an Airbus A340 Long range aircraft.
         * 
         * @param name the name of this Airbus A340 Long 
         * range plane
         * @param location the location of this Airbus A340 
         * Long range plane 
         */
        public AirbusA340(String name, String location)
        {
            super(name, 200, "Airbus A340", 30, 6, false, "Long", location);
        }// end of contructor AirbusA340(String name, String location)
    }// end of class AirbusA340