package Test;

import Functionality.AdminLogin;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdminLoginTest extends MainFrame {
    @Test
    void AdminLogin(){
        var ob = new AdminLogin("test");
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void login_call(){
        var ob = new AdminLogin("test");
            assertTrue(ob.login_call("test","test"));
    }
    @Test
    void back_call(){
        var ob = new AdminLogin("test");
        assertTrue(ob.back_call());
    }
    @Test
    void show_password(){
        var ob = new AdminLogin("test");
        assertTrue(ob.show_password_call());
    }
}