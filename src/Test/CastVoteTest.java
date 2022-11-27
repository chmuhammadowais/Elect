package Test;

import Functionality.CastVote;
import Functionality.MainFrame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CastVoteTest extends MainFrame {
    @Test
    void CastVote(){
        var ob = new CastVote("Timeless");
        assertNotNull(ob,"Object Failed");
    }
    @Test
    void cast_call(){
        var ob = new CastVote("Timeless");
        assertTrue(ob.cast_call());
    }
    @Test
    void end_call(){
        var ob = new CastVote("Timeless");
        assertTrue(ob.end_call());
    }
}