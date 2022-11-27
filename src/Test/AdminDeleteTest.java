package Test;

import Functionality.AdminDelete;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminDeleteTest extends MainFrame {
    @Test
    void AdminDelete(){
        var ob = new AdminDelete();
        assertNotNull(ob,"Object Failed");
    }

    @Test
    void verify_call(){
        var ob = new AdminDelete();
       assertTrue(ob.verify_call("test","test"));
    }

    @Test
    void delete_call() {
        var ob = new AdminDelete();
        assertTrue(ob.delete_call("test"));
    }

    @Test
    void back_call() {
        var ob = new AdminDelete();
        assertTrue(ob.back_call());
    }

    @Test
    void show_password_call() {
        var ob = new AdminDelete();
        assertTrue(ob.show_password_call());
    }
}