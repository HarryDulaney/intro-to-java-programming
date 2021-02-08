package ch_10;

import java.util.Arrays;
import java.util.Objects;

/**
 * Write a test program that creates a course, adds three students, removes one,
 * and displays the students in the course.
 */
public class Exercise10_09 {
    public static void main(String[] args) {
        Course statistics = new Course("Statistics 341");
        statistics.addStudent("Jillian Frometorgai");
        statistics.addStudent("Shrezen Maticut");
        statistics.addStudent("Phi Wazi");
        statistics.dropStudent("Jillian Frometorgai");

        System.out.println("Students in the course " + statistics.getCourseName() + " are: ");
        for (String s : statistics.getStudents()) {
            if (Objects.nonNull(s)) {
                System.out.print(s + " ");
            }
        }
    }
}
/**
 * **10.9 (The Course class) Revise the Course class as follows:
 * ■ The array size is fixed in Listing 10.6. Improve it to automatically increase
 * the array size by creating a new larger array and copying the contents of the
 * current array to it.
 * ■ Implement the dropStudent method.
 * ■ Add a new method named clear() that removes all students from the
 * course.
 */
class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (student.length() < (numberOfStudents + 1)) {
            students = Arrays.copyOf(students, students.length * 2);
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
        System.out.println("Added student: " + student + " to the course: " + getCourseName());
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

    /**
     * ■ Implement the dropStudent method.
     *
     * @param student to drop
     */
    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                students[i] = null;
                break;
            }
        }
        System.out.println("Dropped student: " + student + " has been dropped from " + getCourseName());
    }

    /**
     * ■ Add a new method named clear() that removes all students from the
     */
    protected void clear() {
        Arrays.fill(students, null);
    }


}