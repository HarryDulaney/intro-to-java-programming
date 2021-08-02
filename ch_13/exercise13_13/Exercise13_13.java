package ch_13.exercise13_13;

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

