package adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JunitTest {
    PBImplementer pbTokenizer;

    @BeforeEach
    void setUp() {
        pbTokenizer = new PBImplementer("This string is for testing");
    }

    @Test
    @RepeatedTest(5)
    @DisplayName("Check to make sure next token works")
    void testNextToken() {
        String str1 = pbTokenizer.nextToken();
        String str2 = pbTokenizer.arryLStr.nextToken().strip();
        System.out.println(str1 + " " + str2);
        assertTrue(str1.equals(str2));
        //assertTrue(pbTokenizer.nextToken() == pbTokenizer.arryLStr.nextToken());
    }


    @DisplayName("Checks to see if there are more tokens")
    void testHasMoreTokens() {
        assertTrue(pbTokenizer.hasMoreTokens() == pbTokenizer.arryLStr.hasMoreTokens());

    }

    @DisplayName("Check if pushback works, both strings should be the same")
    void testPushback(){
        String str1 = pbTokenizer.nextToken();
        pbTokenizer.pushback();
        String str2 = pbTokenizer.nextToken();
        //assertTrue(str1 == str2);
        assertEquals(str1, str2);

    }

}
