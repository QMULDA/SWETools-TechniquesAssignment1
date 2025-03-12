import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.vsapry.Model.MinTerm;

public class MinTermTest {

    private MinTerm minTermA;
    private MinTerm minTermB;

    @BeforeEach
    void setUp() {
        minTermA = new MinTerm("0");
        minTermB = new MinTerm("1");
    }

    @Test
    void testIntegersToString() {
        assertEquals("0", minTermA.integersToString());
        assertEquals("1", minTermB.integersToString());
    }

    @Test
    void testIsSameTrue() {
        MinTerm anotherA = new MinTerm("0");
        assertTrue(minTermA.isSame(anotherA));
    }

    @Test
    void testIsSameFalse() {
        assertFalse(minTermA.isSame(minTermB));
    }

    @Test
    void testIsSameThrowsExceptionWhenMinTermInvalidLength() {
        MinTerm twoChars = new MinTerm("00");
        assertThrows(IllegalArgumentException.class, () -> {minTermA.isSame(twoChars);});
    }

    @Test
    void testIsSameThrowsExceptionWhenLengthMinTermsMismatched() {
        MinTerm twoChars = new MinTerm("00");
        assertThrows(IllegalArgumentException.class, () -> {minTermA.isSame(twoChars);});
    }

    @Test
    void testNumberOfDifferencesBetweenMinTermsIs1() {
        int numberOfDifferences = minTermA.numberOfDifferencesBetweenMinTerms(minTermB);
        assertEquals(1, numberOfDifferences);
    }

    @Test
    void testNumberOfDifferencesBetweenMinTermsIs3(){
        MinTerm a = new MinTerm("0000");
        MinTerm b = new MinTerm("0111");

        assertEquals(3, a.numberOfDifferencesBetweenMinTerms(b));
    }

    @Test
    void testNumberOfDifferencesBetweenMinTermsThrowsException(){
        MinTerm twoChars = new MinTerm("00");
        assertThrows(IllegalArgumentException.class, () -> {minTermA.numberOfDifferencesBetweenMinTerms(twoChars);});
    }

    @Test
    void testCombine(){
        MinTerm a = new MinTerm("0111");
        MinTerm b = new MinTerm("1111");

        assertEquals("_111", MinTerm.combine(a, b).integersToString());
    }

}
