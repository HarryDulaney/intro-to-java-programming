package ch_09.exercise09_08;

/**
 * Write a test program that creates two Fan objects. Assign maximum speed, radius 10, color
 * yellow, and turn it on to the first object. Assign medium speed, radius 5, color
 * blue, and turn it off to the second object. Display the objects by invoking their
 * toString method.
 */
public class Exercise09_08 {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        fan2.setSpeed(Fan.FAST);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);
        System.out.println("Fan 1 toString: " + fan1.toString());
        System.out.println("Fan 2 toString: " + fan2.toString());
    }
}
