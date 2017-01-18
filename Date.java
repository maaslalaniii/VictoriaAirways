/**
 * An object which know its year, month, day
 * of month, hour and time. 
 * 
 * @author Maas Lalani, Jenisha Thomas, Ming Zhao Huang  
 * @version 2017-01-17
 */
public class Date
{
    // class constants
    final static int JANUARY = 1;
    final static int FEBRUARY = 2;
    final static int MARCH = 3;
    final static int APRIL = 4;
    final static int MAY = 5;
    final static int JUNE = 6;
    final static int JULY = 7;
    final static int AUGUST = 8;
    final static int SEPTEMBER = 9;
    final static int OCTOBER = 10; 
    final static int NOVEMBER = 11;
    final static int DECEMBER = 12;

    // instance fields
    private int year;
    private int month; 
    private int dayOfMonth;
    private int hour; 
    private int minute; 
    /**
     * Constructs a date with the specified year,
     * month, day of month, hour and time, ensuring 
     * that the specifed day of month corresponds with 
     * the specified month.
     * 
     * @param year the year of this date <br>
     * <i>pre-condition: </i> year must be greater than 0
     * @param month the month of this date<br><i>pre-condition: </i> 
     * month must be a value ranging from 1-12(inclusive)
     * @param dayOfMonth the day of month of this date <br><i>
     * pre-condition: </i>dayOfMonth may not exceed the maximum 
     * number of days in the specified month
     * @param hour the hour of this date <br><i>pre-condition: </i>
     * hour may not be negative and must be less than 24
     * @param minute the mintue of this date <br><i>pre-condition: </i>
     * minute may not be negative and must be less than 60
     */
    public Date(int year, int month, int dayOfMonth, int hour, int minute)
    {
        // Check validity of parameters
        if (year <= 0) return;
        if (month <= 0 || month >12) return;
        if (dayOfMonth <= 0 )
        {
            return;
        }
        // Check if the specifed day is a valid date of specified month
        else if (month == JANUARY || month == MARCH || month == MAY 
				|| month == JULY || month == AUGUST || month == OCTOBER 
				|| month == DECEMBER)
        {
            if (dayOfMonth > 31)return;
        }
        else if (month == APRIL || month == JUNE || month == SEPTEMBER 
				|| month == NOVEMBER)
        {
            if (dayOfMonth > 30) return;
        }
        else if (month == FEBRUARY)
        {
            // For the month of February check if the year is a leap year
            if (year % 4 == 0)
            {
                if (dayOfMonth > 29) return;
            }
            else 
            {
                if (dayOfMonth > 28) return;
            } // end of if (year % 4 == 0)
        } // end of if (dayOfMonth <= 0 )
        if (hour < 0 || hour > 23) return;
        if (minute < 0 || minute > 59) return;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
        this.minute = minute;
    } // end of constructor Date(int year, int month, int dayOfMonth...)

    /**
     * Returns the year of this date.
     * 
     * @return the year of this date
     */
    public int getYear()
    {
        return this.year;
    } // end of method getYear()

    /**
     * Returns the month of this date.
     * 
     * @return the month of this date
     */
    public int getMonth()
    {
        return this.month;
    } // end of method getMonth()

    /**
     * Returns the day of month of this date. 
     * 
     * @return the day of month of this date
     */
    public int getDayOfMonth()
    {
        return this.dayOfMonth;
    } // end of method getDayOfMonth()

    /**
     * Returns the hour of this date. 
     * 
     * @return the hour of this date
     */
    public int getHour()
    {
        return this.hour;
    } // end of method getHour()

    /**
     * Returns the minute of this date. 
     * 
     * @return the minute of this date
     */
    public int getMinute()
    {
        return this.minute;
    } // end of method getMinute()

    /**
     * Returns a string representation of this date.
     * 
     * @return a string representation of this date
     */
    public String toString()
    {
        return 
        getClass().getName()
        + "[" 
        + "year: " + year
        + ", month: " + month
        + ", day: " + dayOfMonth
        + ", hour: " + hour
        + ", minute: " + minute
        +"]";
    } // end of toString()
   
    /**
     * Sets the year of this date.
     * 
     * @param year the year of this date<i>pre-condition: 
     * </i> year must be greater than 0
     */
    public void setYear(int year)
    {
        // Check validity of year
        if (year <= 0) return;
        this.year = year;
    } // end of method setYear(int year)

    /**
     * Sets the month of this date.
     * 
     * @param month the month of this date<br><i>pre-condition: </i> 
     * month must be a value ranging from 1-12(inclusive)
     */
    public void setMonth(int month)
    {
        if (month <= 0 || month >12) return;
        this.month = month;
    } // end of method setMonth(int month)

    /**
     * Sets the day of month of this date. 
     * 
     * @param dayOfMonth the day of month of this date
     * <br><i>pre-condition: </i>dayOfMonth may not exceed 
     * the maximum number of days in the specified month
     */
    public void setDayOfMonth(int dayOfMonth)
    {
        // Check validity of dayOfMonth
        if (dayOfMonth <= 0 )
        {
            return;
        }
        // Check if the specifed day is a valid date of specified month
        else if (this.month == JANUARY || this.month == MARCH 
				|| this.month == MAY || this.month == JULY 
				|| this.month == AUGUST || this.month == OCTOBER 
				|| this.month == DECEMBER)
        {
            if (dayOfMonth > 31)return;
        }
        else if (this.month == APRIL || this.month == JUNE 
				|| this.month == SEPTEMBER || this.month == NOVEMBER)
        {
            if (dayOfMonth > 30) return;
        }
        else if (this.month == FEBRUARY)
        {
            // For the month of February check if the year is a leap year
            if (this.year % 4 == 0)
            {
                if (dayOfMonth > 29) return;
            }
            else 
            {
                if (dayOfMonth > 28) return;
            } //end of if (this.year % 4 == 0)
        } // end of if (dayOfMonth <= 0 )
        this.dayOfMonth = dayOfMonth;
    } // end of method setDayOfMonth(int dayOfMonth)

    /**
     * Sets the hour of this date. 
     * 
     * @param hour the hour of this date<br><i>pre-condition: </i>
     * hour may not be negative and must be less than 24
     */
    public void setHour(int hour)
    {
        if (hour < 0 || hour > 23) return;
        this.hour = hour;
    } // end of method setHour(int hour)

    /**
     * Sets the minute of this date. 
     * 
     * @param the minute of this date<br><i>pre-condition: </i>
     * minute may not be negative and must be less than 60
     */
    public void setMinute(int minute)
    {
        if (minute < 0 || minute > 59) return;
        this.minute = minute;
    } // end of method setMinute(int minute)
}
