package ch_13.exercise13_13;

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
