package Test;

import Functionality.MainFrame;
import Functionality.Timed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimedTest extends MainFrame {
    @Test
    void Timed(){
        var ob = new Timed();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void setConf_set_time_call(){
        var ob = new Timed();
        assertFalse(ob.setConf_set_time_call());
    }
    @Test
    void back_call(){
        var ob = new Timed();
        assertTrue(ob.back_call());
    }
    @Test
    void set_time_call(){
        var ob = new Timed();
        assertTrue(ob.set_time_call());
    }
    @Test
    void complete_frame(){
        var ob = new Timed();
        assertTrue(ob.complete_frame());
    }
}