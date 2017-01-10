/**
 * A short range Boeing plane.
 */
public class BoeingShort extends Plane
    {
        /**
         * Constructs a plane with default characteristics 
         */
        public BoeingShort(String name)
        {
            super(name, 100, 20, "Boeing", new int [20][5], false, "Short");
        }// end of contructor BoeingShort()
    }// end of class BoeingShort