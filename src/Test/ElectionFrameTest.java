package Test;

import Functionality.ElectionFrame;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElectionFrameTest extends MainFrame {
    @Test
    void ElectionFrame(){
        var ob = new ElectionFrame();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void timed_call(){
        var ob = new ElectionFrame();
        assertTrue(ob.timed_call());
    }
    @Test
    void timeless_call(){
        var ob = new ElectionFrame();
        assertTrue(ob.timeless_call());
    }
    @Test
    void back_call(){
        var ob = new ElectionFrame();
        assertTrue(ob.back_call());
    }
}