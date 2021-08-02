
package ch_10.exercise10_14;

import java.util.GregorianCalendar;

//_________________________UML DIAGRAM______________________________*
/*																	|
 * 			    		      MyDate         			    		|
 *------------------------------------------------------------------|
 *                     	   -day : int	                       		|
 *                         -month : int  							|
 * 							-year:int   					 		|
 *------------------------------------------------------------------|
 *                     +MyDate()            	    				|
 *                     +MyDate(int, int,int)          		    	|
 *                     +MyDate(long)                       	    	|
 * 	 																|
 * 	 			        setDate(long):void 							|
 * 						                                        	|
 * 	 			    	getters and setters 						|
 * 																	|
 *__________________________________________________________________|  */

/**
 * 10.14 (The MyDate class) Design a class named MyDate. The class contains:
 * ■ The data fields year, month, and day that represent a date. month is
 * 0-based, i.e., 0 is for January.
 * ■ A no-arg constructor that creates a MyDate object for the current date.
 * ■ A constructor that constructs a MyDate object with a specified elapsed time
 * since midnight, January 1, 1970, in milliseconds.
 * ■ A constructor that constructs a MyDate object with the specified year,
 * month, and day.
 * ■ Three getter methods for the data fields year, month, and day, respectively.
 * ■ A method named setDate(long elapsedTime) that sets a new date for
 * the object using the elapsed time.
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 */
public class MyDate {
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    private int year;
    private int month;
    private int day;

    public MyDate() {
        this(System.currentTimeMillis());
    }

    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public void setDate(long elapsedTime) {
        gregorianCalendar.setTimeInMillis(elapsedTime);
        this.year = gregorianCalendar.get(GregorianCalendar.YEAR);
        this.month = gregorianCalendar.get(GregorianCalendar.MONTH);
        this.day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public int getYear() {
        return year;
    }

    public MyDate setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public MyDate setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public MyDate setDay(int day) {
        this.day = day;
        return this;
    }
}
