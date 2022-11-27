package Test;

import Functionality.MainFrame;
import Functionality.Positions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionsTest extends MainFrame {
    @Test
    void Positions(){
        var ob = new Positions();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void proceed_call(){
        var ob = new Positions();
        assertTrue(ob.proceed_call());
    }
}