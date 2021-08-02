package ch_10.exercise10_28;


/**
 * **10.28 (Implement the StringBuilder class) The StringBuilder class is provided
 * in the Java library. Provide your own implementation for the following methods
 * (name the new class MyStringBuilder2):a
 * TEST
 * public MyStringBuilder2();
 * public MyStringBuilder2(char[] chars);
 * public MyStringBuilder2(String s);
 * public MyStringBuilder2 insert(int offset, MyStringBuilder2 s);
 * public MyStringBuilder2 reverse();
 * public MyStringBuilder2 substring(int begin);
 * public MyStringBuilder2 toUpperCase();
 */
public class Exercise10_28 {
    public static void main(String[] args) {
        //Test StringBuilder2
        MyStringBuilder2 myStringBuilder2 = new MyStringBuilder2("SuperCalifradolistic");
        System.out.print("Start MyStringBuilder2 values: ");
        System.out.println(myStringBuilder2.toString());
        System.out.print("ToUpperCase: ");
        System.out.println(myStringBuilder2.toUpperCase().toString());
        System.out.print("Insert: ");
        myStringBuilder2.insert(3, new MyStringBuilder2("TESTinsertTEST"));
        System.out.println(myStringBuilder2.toString());
        System.out.print("Reverse: ");
        System.out.println(myStringBuilder2.reverse().toString());
        System.out.println("subString: " + myStringBuilder2.substring(5).toString());
    }

}

