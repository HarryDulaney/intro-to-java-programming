package ch_11.exercise11_02;

/**
 * A student has a class status (freshman, sophomore, junior, or senior). Define the status as a constant.
 * <p>
 * Override the toString method in each class to display the class name and the person’s
 * name.
 */
public class Student extends Person {
    protected final String STATUS;

    public static final String FRESHMAN = "freshman";
    public static final String SOPHOMORE = "sophomore";
    public static final String JUNIOR = "junior";
    public static final String SENIOR = "senior";

    public Student(String STATUS) {
        this.STATUS = STATUS;
    }

    public Student(String name, String address, String phoneNumber, String emailAddress, String STATUS) {
        super(name, address, phoneNumber, emailAddress);
        this.STATUS = STATUS;
    }


    @Override
    public String toString() {
        return "Student.class: { " +
                "Name= " + this.getName() +
                '}';
    }
}
