package Test;

import Functionality.MainFrame;
import Functionality.Server;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest extends MainFrame {

    @Test
    void server_call() throws IOException {
    assertTrue(Server.server_call(0));
    }
}