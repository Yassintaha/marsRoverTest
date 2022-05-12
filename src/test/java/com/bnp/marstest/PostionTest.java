package  com.bnp.marstest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PostionTest {
    private  Position     positionW;
    private  Position     positionE;
    @Before
    public void initPositions() {
            positionW = new Position(1,2, Direction.WEST);
            positionE = new Position(3,4, Direction.EAST);
    }
    @Test
    public void shouldGoHead(){
        assertEquals(new Position(0,2,Direction.WEST),positionW.goAhead());
        assertEquals(new Position(4,4,Direction.EAST),positionE.goAhead());
    }
}
