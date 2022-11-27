package Test;

import Functionality.MainFrame;
import Functionality.Timed;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TimedTest extends MainFrame {
    @Test
    void Timed(){
        var ob = new Timed();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void setConf_set_time_call(){
        var ob = new Timed();
        assertTrue(ob.setConf_set_time_call());
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
}