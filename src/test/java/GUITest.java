import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vsapry.Controller.MinTermListController;
import org.vsapry.Model.MinTermList;
import org.vsapry.View.GUI;
import org.vsapry.View.MenuBar;

public class GUITest {

    MinTermList mintermlist = new MinTermList();
    MinTermListController controller = new MinTermListController(mintermlist);
    GUI gui = new GUI(controller);

    @BeforeEach
    void setUp(){
        MinTermList mintermlist = new MinTermList();
        MinTermListController controller = new MinTermListController(mintermlist);
        GUI gui = new GUI(controller);
    }


    @Test
    void testHasInvalidInputForNumberOfBits_valid() {
        MenuBar.bits = 3;
        assertFalse(gui.hasInvalidInputForNumberOfBits());

        MenuBar.bits = 5;
        assertFalse(gui.hasInvalidInputForNumberOfBits());
    }

    @Test
    void testHasInvalidInputForNumberOfBits_invalid() {
        MenuBar.bits = 2;
        GUI gui = new GUI(controller);
        assertTrue(gui.hasInvalidInputForNumberOfBits());

        MenuBar.bits = 6;
        assertTrue(gui.hasInvalidInputForNumberOfBits());
    }

}

