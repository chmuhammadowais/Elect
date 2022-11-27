package Test;

import Functionality.AdminSignup;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdminSignupTest extends MainFrame {
    @Test
    void AdminSignup(){
        var ob = new AdminSignup();
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void signup_call(){
        var ob = new AdminSignup();
        assertTrue(ob.signup_call("test", "test"));
    }
    @Test
    void back_call(){
        var ob = new AdminSignup();
        assertTrue(ob.back_call());
    }
    @Test
    void show_password_call(){
        var ob = new AdminSignup();
        assertTrue(ob.show_password_call());
    }
}