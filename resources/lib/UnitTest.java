package resources.lib;

import java.math.BigInteger;

public class UnitTest {

    public static void assertEquals(BigInteger b1, BigInteger b2) {
        if (!b1.equals(b2)) {
            throw new UnitTestException("Failed Unit Test, Expected: " + b1 + ", but got: " + b2);
        }
    }
}
