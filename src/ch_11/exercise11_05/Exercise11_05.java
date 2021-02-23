package ch_11.exercise11_05;


/**
 * 11.5 (The Course class) Rewrite the Course class in Listing 10.6. Use an ArrayList
 * to replace an array to store students.
 * <p>
 * Draw the new UML diagram for the class.
 * <p>
 * You should not change the original contract of the Course class
 * (i.e., the definition of the constructors and methods should not be changed, but the private
 * members may be changed.)
 */
public class Exercise11_05 {
    //TEST
    public static void main(String[] args) {
        Course course = new Course("Linear Algebra");
        String studentName = "Bob Bobberton";
        String studentName2 = "Tori Toriton";
        String studentName3 = "Kelly Kellyton";
        String studentName4 = "Tod Todderton";

        course.addStudent(studentName);
        course.addStudent(studentName2);
        course.addStudent(studentName3);
        course.addStudent(studentName4);

        course.dropStudent(studentName);

    }
}
