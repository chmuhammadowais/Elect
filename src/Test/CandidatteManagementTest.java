package Test;

import Functionality.CandidatteManagement;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CandidatteManagementTest extends MainFrame {
    @Test
    void CandidatteManagement(){
        var ob = new CandidatteManagement();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void reg_call(){
        var ob = new CandidatteManagement();
        assertTrue(ob.reg_call());
    }
    @Test
    void dereg_call(){
        var ob = new CandidatteManagement();
        assertTrue(ob.dereg_call());
    }
    @Test
    void get_reg_cand_call(){
        var ob = new CandidatteManagement();
        assertTrue(ob.get_reg_cand_call());
    }
    @Test
    void back_call(){
        var ob = new CandidatteManagement();
        assertTrue(ob.back_call());
    }
}