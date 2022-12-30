package Test;

import Functionality.HelpDesk;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HelpDeskTest extends MainFrame {

    @Test
    void connection_call() throws IOException {
        var ob = new HelpDesk();
        assertTrue(ob.connection_call("Test"));
    }
}