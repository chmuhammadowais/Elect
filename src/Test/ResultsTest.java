package Test;

import Functionality.MainFrame;
import Functionality.Results;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResultsTest extends MainFrame {
    @Test
    void Results(){
        var ob = new Results();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void df_back_call(){
        var ob = new Results();
        assertTrue(ob.df_back_call());
    }
    @Test
    void DetailedResult_call(){
        var ob = new Results();
        assertTrue(ob.DetailedResult_call());
    }
    @Test
    void CompiledResults_call(){
        var ob = new Results();
        assertTrue(ob.CompiledResults_call());
    }
    @Test
    void flush_res(){
        var ob = new Results();
        assertTrue(ob.flush_res());
    }
    @Test
    void confirmation_call(){
        var ob = new Results();
        assertTrue(ob.confirmation_call());
    }
    @Test
    void cancel_call(){
        var ob = new Results();
        assertTrue(ob.cancel_call());
    }
}