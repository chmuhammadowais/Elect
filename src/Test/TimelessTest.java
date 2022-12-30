package Test;

import Functionality.MainFrame;
import Functionality.Timeless;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimelessTest extends MainFrame {
    @Test
    void Timeless(){
        var ob = new Timeless();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void proceed_call(){
        var ob = new Timeless();
        assertTrue(ob.proceed_call());
    }
    @Test
    void back_call(){
        var ob = new Timeless();
        assertTrue(ob.back_call());
    }
    @Test
    void complete_frame(){
        assertTrue(Timeless.complete_frame());
    }
}