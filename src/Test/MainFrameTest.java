package Test;

import Functionality.MainFrame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainFrameTest extends MainFrame {
    @Test
    void MainFrame(){
        var ob = new MainFrame();
        assertNotNull(ob,"Object Failed");
    }

    @Test
    void Cand_mgmt_call() {
        var ob = new MainFrame();
        assertTrue(ob.cand_mgmt_call());
    }

    @Test
    void Elec_start_call() {
        var ob = new MainFrame();
        assertTrue(ob.elec_start_call());
    }

    @Test
    void Res_call() {
        var ob = new MainFrame();
        assertTrue(ob.res_call());
    }

    @Test
    void Adm_signupdelete_call() {
        var ob = new MainFrame();
        assertTrue(ob.adm_signupdelete_call());
    }

    @Test
    void Logout_call() {
        var ob = new MainFrame();
        assertTrue(ob.logout_call());
    }
}