package Test;

import Functionality.CandidateDeregistration;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CandidateDeregistrationTest extends MainFrame {
    @Test
    void CandidateDeregistration(){
        var ob = new CandidateDeregistration();
        assertNotNull(ob,"Object Failed");
    }
   @Test
    void dereg_call(){
       var ob = new CandidateDeregistration();
       assertTrue(ob.dereg_call("0"));
   }
   @Test
    void cancel_call(){

       var ob = new CandidateDeregistration();
       assertTrue(ob.cancel_call());
   }
   @Test
    void dereg_conf_call(){
       var ob = new CandidateDeregistration();
       assertTrue(ob.dereg_conf_call("0"));
   }
}