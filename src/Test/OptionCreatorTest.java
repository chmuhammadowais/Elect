package Test;

import Functionality.MainFrame;
import Functionality.OptionCreator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OptionCreatorTest extends MainFrame {
    @Test
    void OptionCreator(){
        var ob = new OptionCreator("Head");
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void vote_call(){
        var ob = new OptionCreator("Head");
        assertTrue(ob.vote_call());
    }
    @Test
    void notify_admin(){
        var ob = new OptionCreator("Head");
        assertTrue(ob.notify_admin());
    }
    @Test
    void update_admin(){
        var ob = new OptionCreator("Head");
        assertTrue(ob.update_admin());
    }
}