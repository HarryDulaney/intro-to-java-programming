public class HidingDemo {
  public static void main(String[] args) {
    A x = new B();

    // Access instance data field i
    System.out.println("(1) x.i is " + x.i);
    System.out.println("(2) (B)x.i is " + ((B)x).i);

    // Access static data field j
    System.out.println("(3) x.j is " + x.j);
    System.out.println("(4) ((B)x).j is " + ((B)x).j);

    // Invoke static method m1
    System.out.println("(5) x.m1() is " + x.m1());
    System.out.println("(6) ((B)x).m1() is " + ((B)x).m1());

    // Invoke instance method m2
    System.out.println("(7) x.m2() is " + x.m2());
    System.out.println("(8) x.m3() is " + x.m3());
  }
}

class A {
  public int i = 1;
  public static int j = 11;

  public static String m1() {
    return "A's static m1";
  }

  public String m2() {
    return "A's instance m2";
  }

  public String m3() {
    return "A's instance m3";
  }
}

class B extends A {
  public int i = 2;
  public static int j = 12;

  public static String m1() {
    return "B's static m1";
  }

  public String m2() {
    return "B's instance m2";
  }
}
