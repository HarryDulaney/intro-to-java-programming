package ch_10.exercise10_01;

public class Exercise10_01 {
    public static void main(String[] args) {

        Time test1 = new Time();

        Time test2 = new Time(555550000);

        Time test3 = new Time(5, 23, 55);

        System.out.println("The result for the no argument Time object is " + test1.getHour() + ":" + test1.getMin() + ":" +
                test1.getSec() + ".");

        System.out.println("The result for the single argument Time object is " + test2.getHour() + ":" + test2.getMin() + ":" +
                test2.getSec() + ".");

        System.out.println("The result for the three argument Time object is " + test3.getHour() + ":" + test3.getMin() + ":" +
                test3.getSec() + ".");

    }
}
