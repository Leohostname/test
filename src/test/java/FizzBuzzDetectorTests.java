package test.java;

import main.FizzBuzzDetector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FizzBuzzDetectorTests
{
    private static FizzBuzzDetector detector;

    @BeforeAll
    static void initialize()
    {
        detector = new FizzBuzzDetector();
    }

    @Test
    void testShortString()
    {
        String input = "123456";
        Assertions.assertNull(detector.getOverlappings(input));
    }

    @Test
    void testLongString()
    {
        String input = "1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1";
        Assertions.assertNull(detector.getOverlappings(input));
    }

    @Test
    void testStrangeString()
    {
        String input = "測試線來回跑測試線來回跑";
        String output = String.valueOf(detector.getOverlappings(input));
        String comparable = "output string:\n" +
                            "測試線來回跑測試線來回跑 \n" +
                            "\n" +
                            "count: 0";
        Assertions.assertEquals(comparable, output);
    }

    @Test
    void testNullString()
    {
        String input = null;

        Assertions.assertThrows(NullPointerException.class, () -> detector.getOverlappings(input));
    }

    @Test
    void testOnlySignsString()
    {
        String input = ",,.,???,,.,.,.,.,???????";
        String output = String.valueOf(detector.getOverlappings(input));
        String comparable = "output string:\n" +
                            ",,.,???,,.,.,.,.,??????? \n" +
                            "\n" +
                            "count: 0";
        Assertions.assertEquals(comparable, output);

    }
}
