package ch_10.exercise10_24;

/**
 * 10.24 TEST
 */
public class Exercise10_24 {
    static MyCharacter[] myCharacters = new MyCharacter[10];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            myCharacters[i] = MyCharacter.valueOf(((int) (1 + Math.random() * 123)));
        }
        System.out.println("MyCharacter.valueOf(myCharacters[0].charValue()): " + MyCharacter.valueOf(myCharacters[0].charValue()));
        System.out.println("MyCharacter.valueOf(myCharacters[4].charValue()): " + MyCharacter.valueOf(myCharacters[4].charValue()));
        System.out.println("myCharacters[1] = " + myCharacters[1].charValue() + " , myCharacters[7] = " + myCharacters[7].charValue() + " | " +
                "myCharacters[1].compareTo" +
                "(myCharacters[7]) " +
                ":" +
                " " + myCharacters[1].compareTo(myCharacters[7]));
        System.out.println(myCharacters[5].equals(myCharacters[7]));
        System.out.println("myCharacters[6].charValue() = " + myCharacters[6].charValue() + " | MyCharacter.isDigit" +
                "(myCharacters[6].charValue()): " +
                ")" +
                ":  " + MyCharacter.isDigit(myCharacters[6].charValue()));
        System.out.println(MyCharacter.isLetter(myCharacters[5].charValue()));
        System.out.println("myCharacters[9] = " + myCharacters[9].charValue() + " | (MyCharacter.isLowerCase" +
                ", (myCharacters[9].charValue()) :" + MyCharacter.isLowerCase(myCharacters[9].charValue()));
        System.out.println("myCharacters[3] = " + myCharacters[3].charValue() + " | MyCharacter.isUpperCase" +
                "(myCharacters[3]" +
                ".charValue()" +
                ")): " + MyCharacter.isUpperCase(myCharacters[3].charValue()));
        System.out.println("myCharacters[3] = " + myCharacters[3].charValue() + ", myCharacters[4] = " + myCharacters[4].charValue()
                + " | myCharacters[3].compareTo(myCharacters[4])): " + myCharacters[3].compareTo(myCharacters[4]));
        System.out.println("myCharacters[2] = " + myCharacters[2].charValue() + " , myCharacters[8] = " + myCharacters[8].charValue() + " | myCharacters[2].compareTo(myCharacters[8])): "
                + myCharacters[2].compareTo(myCharacters[8]));

    }
}
