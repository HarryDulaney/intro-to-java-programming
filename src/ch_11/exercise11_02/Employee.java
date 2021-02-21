package ch_11.exercise11_02;

import ch_10.exercise10_14.MyDate;

/**
 * An employee has an office, salary, and date hired.
 * Use the MyDate class defined in Programming Exercise 10.14 to create an object for date hired.
 * <p>
 * Override the toString method in each class to display the class name and the person’s
 * name.
 */
public class Employee extends Person {

    private String office;
    private double salary;
    private MyDate dateHired;


    public Employee(String office, double salary, MyDate dateHired) {
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getOffice() {
        return office;
    }

    public Employee setOffice(String office) {
        this.office = office;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public Employee setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
        return this;
    }

    @Override
    public String toString() {
        return "Employee.class: { " +
                "Name= " + this.getName() +
                '}';
    }

}
