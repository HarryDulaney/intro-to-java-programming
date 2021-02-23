package ch_11.exercise11_05;

import java.util.ArrayList;


//_________________________UML DIAGRAM______________________________*
/*																	|
 * 							  Course  								|
 *------------------------------------------------------------------|
 * 				                                                    |
 * 	                    -courseName: String	                 		|
 *                      -students: ArrayList<String>               	|
 * 	                                                        		|
 *------------------------------------------------------------------|
 * 	                  +Course(courseName: String) 					|
 * 	                  +getCourseName(): String		    			|
 * 	                  +addStudent(student: String): void			|
 * 	 																|
 * 																	|
 *__________________________________________________________________|  */


public class Course {
    private String courseName;
    private ArrayList<String> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students.add(student);
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        students.remove(student);
        System.out.println("Dropped student: " + student);
    }
}