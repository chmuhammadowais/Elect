package Test;

import Functionality.AdminSignupDelete;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdminSignupDeleteTest extends MainFrame {
    @Test
    void AdminSignupDelete(){
        var ob = new AdminSignupDelete();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void signup_call(){
        var ob = new AdminSignupDelete();
        assertTrue(ob.signup_call());
    }
    @Test
    void delete_call(){
        var ob = new AdminSignupDelete();
        assertTrue(ob.delete_call());
    }
    @Test
    void back_call(){
        var ob = new AdminSignupDelete();
        assertTrue(ob.back_call());
    }
}