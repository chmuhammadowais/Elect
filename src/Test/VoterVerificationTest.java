package Test;

import Functionality.MainFrame;
import Functionality.VoterVerification;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VoterVerificationTest extends MainFrame {
    @Test
    void VoterVerification(){
        var ob = new VoterVerification();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void login_call(){
        var ob = new VoterVerification();
        assertTrue(ob.login_call("0","test123"));
    }
    @Test
    void back_call(){
        var ob = new VoterVerification();
        assertTrue(ob.back_call());
    }
    @Test
    void show_password_call(){
        var ob = new VoterVerification();
        assertTrue(ob.show_password_call());
    }
}