package ch_09.exercise09_06;


//_________________________UML DIAGRAM______________________________*
/*																	|
 * 						   StopWatch								|
 *------------------------------------------------------------------|
 * 	-startTime : long			                                   	|
 * 															 		|
 *  -endTime : long			    									|
 *------------------------------------------------------------------|
 * 	 +StopWatch():                          						|
 * 	 																|
 * 	  start():void	                                                |
 * 						    					    				|
 * 	  stop():void						    						|
 *  																|
 * 	+getEndTime() : long					    					|
 * 																	|
 * 	+getStartTime() : long				`   						|
 * 																	|
 * 	+getElapsedTime() : long										|
 *__________________________________________________________________|  */
/**
 * StopWatch.class
 */
public class StopWatch {

    /* ■ Private data fields startTime and endTime with getter methods. */
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    /**
     * ■ A no-arg constructor that initializes startTime with the current time.
     */
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    /**
     * ■ A method named start() that resets the startTime to the current time.
     */
    void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * ■ A method named stop() that sets the endTime to the current time.
     */
    void stop() {
        endTime = System.currentTimeMillis();
    }

    /**
     * ■ A method named getElapsedTime() that returns the elapsed time for the
     * stopwatch in milliseconds.
     */
    public long getElapsedTime() {
        return (endTime - startTime);
    }


}
