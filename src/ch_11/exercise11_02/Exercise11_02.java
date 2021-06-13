package ch_11.exercise11_02;

//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 						     Person     							|
 *------------------------------------------------------------------|
 *                      -name: String						        |
 *                      -address: String							|
 *                      -phoneNumber: String		    			|
 *                      -emailAddress: String						|
 *    																|
 *																	|
 *------------------------------------------------------------------|
 * 	                        +Person()								|
 * 	 																|
 *  	            +getters and setters							|
 * 																	|
 * 	                +toString(): String								|
 * 																	|
 * 																	|
 * 																	|
 * 																	|
 * _________________________________________________________________|
 */

//__________________________________________________________________*
/*																	|
 * 						     Person     							|
 *------------------------------------------------------------------|
								^
								^
//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 						     Employee     							|
 *------------------------------------------------------------------|
 *                      -office: String						        |
 *                      -salary: double 							|
 *                      -dateHired: MyDate		    	    		|
 *    																|
 *																	|
 *------------------------------------------------------------------|
 * 	 																|
 *  	            +getters and setters							|
 * 																	|
 * 	                +toString(): String								|
 * 																	|
 * 																	|
 * 																	|
 * 																	|
 * _________________________________________________________________| */


//__________________________________________________________________*
/*																	|
 * 						     Person     							|
 *------------------------------------------------------------------|
								^
								^
//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 						     Student     							|
 *------------------------------------------------------------------|
 *                      +STATUS: String	:                           |
 *		        (freshman, sophomore, junior, or senior)            |
 *																	|
 *------------------------------------------------------------------|
 * 	                                								|
 *  	            +getters and setters							|
 * 																	|
 * 	                +toString(): String								|
 * 																	|
 * 																	|
 * 																	|
 * 																	|
 * _________________________________________________________________| */

//__________________________________________________________________*
/*																	|
 * 						     Employee     							|
 *------------------------------------------------------------------|
								^
								^
//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 						     Faculty     							|
 *------------------------------------------------------------------|
 *                         -rank:int                                |
 *																	|
 *------------------------------------------------------------------|
 * 	                                								|
 *  	            +getters and setters							|
 * 																	|
 * 	                +toString(): String								|
 * 																	|
 * 																	|
 * 																	|
 * 																	|
 * _________________________________________________________________| */

//__________________________________________________________________*
/*																	|
 * 						     Employee     							|
 *------------------------------------------------------------------|
								^
								^
//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 						     Staff       							|
 *------------------------------------------------------------------|
 *                      +title: String                              |
 *																	|
 *------------------------------------------------------------------|
 * 	                                								|
 *  	            +getters and setters							|
 * 																	|
 * 	                +toString(): String								|
 * 																	|
 * 																	|
 * 																	|
 * 																	|
 * _________________________________________________________________| */


import ch_10.exercise10_14.MyDate;

/**
 * 11.2 (The Person, Student, Employee, Faculty, and Staff classes) Design a
 * class named Person and its two subclasses named Student and Employee.
 * Make Faculty and Staff subclasses of Employee.
 * <p>
 * A person has a name, address, phone number, and email address.
 * <p>
 * A student has a class status (freshman, sophomore, junior, or senior). Define the status as a constant.
 * <p>
 * An employee has an office, salary, and date hired.
 * <p>
 * Use the MyDate class defined in Programming Exercise 10.14 to create an object for date hired.
 * <p>
 * A faculty member has office hours and a rank.
 * <p>
 * A staff member has a title. Override the toString method in each class to display the class name and the person’s
 * name.
 * <p>
 * Draw the UML diagram for the classes and implement them.
 * <p>
 * Write a test program that creates a Person, Student, Employee, Faculty, and Staff, and
 * invokes their toString() methods.
 */
public class Exercise11_02 {

	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Garry Barryman");
		Student student = new Student(Student.SENIOR);
		student.setName("Jingle PB&J");
		Employee employee = new Employee("Delray Beach,FL", 45_750.00, new MyDate());
		employee.setName("Sarah Stodenbyer");
		Faculty faculty = new Faculty(new double[]{9.0, 5.0}, 5);
		faculty.setName("Milly Millyman");
		Staff staff = new Staff("Boston,MA", 750_000.00, new MyDate(), "CEO");
		staff.setName("Madonna Firehat");

		System.out.println(person.toString());
		System.out.println(student.toString());
		System.out.println(employee.toString());
		System.out.println(faculty.toString());
		System.out.println(staff.toString());
	}
}
