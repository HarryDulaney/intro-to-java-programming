public class EnrollmentEvent extends java.util.EventObject {
  private String studentToEnroll;
  private int enrollmentCap;

  /** Construct a EnrollmentEvent */
  public EnrollmentEvent(Object source, String studentToEnroll,
      int enrollmentCap) {
    super(source);
    this.studentToEnroll = studentToEnroll;
    this.enrollmentCap = enrollmentCap;
  }

  public String getStudentToEnroll() {
    return studentToEnroll;
  }

  public long getEnrollmentCap() {
    return enrollmentCap;
  }
}
