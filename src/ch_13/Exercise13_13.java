package ch_13;

import java.util.Arrays;

/**
 * 13.13 (Enable the Course class cloneable) Rewrite the Course class in Listing 10.6
 * to add a clone method to perform a deep copy on the students field.
 */
public class Exercise13_13 {
    public static void main(String[] args) {
        Course course = new Course("Linear Algebra");
        course.addStudent("Simon");
        course.addStudent("Valerie");
        course.addStudent("Terrance");
        course.addStudent("Shiva");
        course.addStudent("Rajesh");
        course.addStudent("Mollie");
        System.out.print("Cloning the Course object where course name = " + course.getCourseName());
        System.out.println(" . And students is cloned as a deep copy.");
        try {
            Course courseCopy = (Course) course.clone();
            System.out.println("Result of courseCopy.getStudents() == course.getStudents() is " + (course.getStudents() == courseCopy.getStudents()));
        } catch (CloneNotSupportedException cnse) {
            System.out.println("Clone not supported....");
        }
    }

}

class Course implements Cloneable {
    /**
     * @return Course object with deep copy of students array
     * @throws CloneNotSupportedException for unsupported clone type
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Course course = (Course) super.clone();
        course.students = this.students;
        return course;
    }

    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }
}