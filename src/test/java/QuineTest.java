import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.vsapry.*;
import org.vsapry.Model.Quine;

public class QuineTest {

    //given, when, then
    //e.g. givenRadius_whenCalculateArea_thenReturnArea

    @Test
    public void addTermTest() throws ExceptionQuine {

        String str = "0000";
        Quine quine = new Quine();
        quine.addTerm(str);
        assertEquals(str,quine.terms[0].toString());
    }

    @Test
    public void addTermTestThrowsException() throws Exception {
        String str = "0000";
        Quine quine = new Quine();
        quine.count = 0xff;

        ExceptionQuine q = assertThrows(ExceptionQuine.class, () -> {
            quine.addTerm(str);
        });
        assertTrue(q.getMessage().contains("Quine::addTerm()"));

    }


}
