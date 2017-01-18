/**
 * A medium range Boeing plane.
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang 
 * @version 1.0 2017-1-11
 */
public class Boeing737Medium extends Plane
    {
        /**
         * Constructs a plane with the characteristics
         * of a Boeing 737 Medium range aircraft.
         * 
         * @param name the name of this Boeing 737
         * Medium plane
         * @param location the location of this Boeing 737
         * Medium plane 
         */
        public Boeing737Medium(String name, String location)
        {
            super(name, 140, "Boeing 737", 20, 6, false, "Medium", location);
        }// end of contructor Boeing737Medium(String name, String location)
    }// end of class BoeingShort