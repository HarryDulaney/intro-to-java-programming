package ch_01;


public class Exercise01_12 {
    public static void main(String[] args) {
        double hrs = 1;
        double mins = 40;
        double secs = 35;
        double totaldist = 24;
        double kilodist = totaldist * 1.6;
        double converttomin = hrs * 60 + mins + secs / 60;
        double KPH = 60 * kilodist / converttomin;

        System.out.println(KPH);

    }

}
