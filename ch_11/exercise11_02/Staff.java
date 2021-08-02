package ch_11.exercise11_02;

import ch_10.exercise10_14.MyDate;

/**
 * A staff member has a title.
 * <p>
 * Override the toString method in each class to display the class name and the person’s
 * name.
 */
public class Staff extends Employee {

    private String title;

    public Staff(String office, double salary, MyDate dateHired, String title) {
        super(office, salary, dateHired);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Staff setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "Staff.class: { " +
                "Name= " + getName()  +
                '}';
    }
}
