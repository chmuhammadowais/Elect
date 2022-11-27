package Test;

import Functionality.CandidateRegistration;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CandidateRegistrationTest extends MainFrame {
    @Test
    void CandidateRegistration(){
        var ob = new CandidateRegistration();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void reg_call(){
        var ob = new CandidateRegistration();
        assertTrue(ob.reg_call("0","test","test"));
    }
    @Test
    void pic_choose_call(){
        var ob = new CandidateRegistration();
        assertTrue(ob.pic_choose_call());
    }
    @Test
    void back_call(){
        var ob = new CandidateRegistration();
        assertTrue(ob.back_call());
    }
}