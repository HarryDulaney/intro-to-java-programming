public class TestEnumeratedType {
  enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};

  public static void main(String[] args) {
    Day day = Day.TUESDAY;

    switch (day) {
      case MONDAY:
        System.out.println("Play soccer");
        break;
      case TUESDAY:
        System.out.println("Piano lesson");
        break;
      case WEDNESDAY:
        System.out.println("Math team");
        break;
      default:
        System.out.println("Go home");
    }
  }
}
