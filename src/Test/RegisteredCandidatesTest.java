package Test;

import Functionality.MainFrame;
import Functionality.RegisteredCandidates;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegisteredCandidatesTest extends MainFrame {
    @Test
    void RegisteredCandidates(){
        var ob = new RegisteredCandidates();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void back_call(){
        var ob = new RegisteredCandidates();
        assertTrue(ob.back_call());
    }
}