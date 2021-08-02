package ch_10.exercise10_01;


//_________________________UML DIAGRAM______________________________*
/*																	|
 * 							  Time  								|
 *-------------------------------------------------------------------|
 * 	-hour : long		(defaults are current time)					|
 * 															 		|
 *   -minute : long													|
 * 																	|
 * 	-second : long													|
 * 																	|
 * 	-theTime: long													|
 * 																	|
 *-------------------------------------------------------------------|
 * 	 -Time(): (System.currentTime.Millis()) 						|
 * 	 																|
 * 	 -Time(long):   												|
 * 																	|
 * 	 -Time(hour:long,min:long,second:long)							|
 * 																	|
 * 	+setTime():void													|
 *  																	|
 * 	+getHour() : long												|
 * 																	|
 * 	+getSec() : long												|
 * 																	|
 * 	+getMin() : long												|
 * 	 																|
 * 																	|
 *___________________________________________________________________|  */

/**
 * Exercise10.1 (The Time class) Design a class named Time. The class contains:
 * <p>
 * The data fields hour, minute, and second that represent a time.
 * <p>
 * A no-arg constructor that creates a Time object for the current time.
 * (The values of the data fields will represent the current time.)
 * <p>
 * A constructor that constructs a Time object with a specified elapsed time
 * since midnight, January 1, 1970, in milliseconds. (The values of the data
 * fields will represent this time.)
 * <p>
 * A constructor that constructs a Time object with the specified hour, minute, and second.
 * <p>
 * Three getter methods for the data fields hour, minute, and second, respectively.
 * <p>
 * A method named setTime(long elapseTime) that sets a new time for the object using
 * the elapsed time. For example, if the elapsed time is 555550000 milliseconds, the
 * hour is 10, the minute is 19, and the second is 10.
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 * <p>
 * Write a test
 * program that creates three Time objects (using new Time(), new Time(555550000),
 * and new Time(5, 23, 55)) and displays their hour, minute, and second in the format
 * hour:minute:second.
 * <p>
 * (Hint: The first two constructors will extract the hour, minute, and second from
 * the elapsed time. For the no-arg constructor, the current time can be obtained using
 * System.currentTimeMillis(), as shown in Listing 2.7 ShowCurrentTime.java.
 * Assume that the time is in GMT.)
 *
 * @author Harry D.
 */
public class Time {

    private long hour;
    private long min;
    private long second;

    public Time() {

        long theTime = System.currentTimeMillis();

        this.setTime(theTime);
    }

    public Time(long newTime) {

        this.setTime(newTime);

    }

    public Time(long newHour, long newMin, long newSec) {

        second = newSec;

        min = newMin;

        hour = newHour;

    }

    public void setTime(long elapsedTime) {

        hour = (((elapsedTime / 1000) / 60) / 60) % 24;

        second = (elapsedTime / 1000) % 60;

        min = ((elapsedTime / 1000) / 60) % 60;


    }

    public long getHour() {

        return hour;

    }

    public long getMin() {

        return min;
    }

    public long getSec() {

        return second;
    }


}
