package ch_21.exercise21_10;


/**
 * for case catch
 * float goto
 * strictfp
 * byte
 * <p>
 * This is a test file for Exercise21_10.
 * The correct number of Java Keywords count should be: 11
 * <p>
 * Result looks like:
 * WordOccurrence{word='package', count=1}
 * WordOccurrence{word='static', count=1}
 * WordOccurrence{word='void', count=1}
 * WordOccurrence{word='null', count=1}
 * WordOccurrence{word='break', count=1}
 * WordOccurrence{word='for', count=1}
 * WordOccurrence{word='class', count=1}
 * WordOccurrence{word='if', count=1}
 * WordOccurrence{word='int', count=1}
 * WordOccurrence{word='public', count=2}
 */
public class FileToTest {
    public static void main(String[] args) { // public static void
        String KEY_WORDS = "abstract assert boolean break";
        for (int i = 6; i >= 0; i--) {
            System.out.println("args[0]: " + args[0]);
            if (args[i] == null) {
                break;
            }
        }
        System.out.print(KEY_WORDS); /* null null null */
    }

}
