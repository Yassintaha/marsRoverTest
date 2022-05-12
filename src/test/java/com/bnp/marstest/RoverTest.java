package com.bnp.marstest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {
    private Rover rover;
    @Before public void initRover(){
        Point pointMax=new Point(4,4);
        Position position=new Position(1,1,Direction.NORTH);
        rover = new Rover(position,pointMax);
    }
    @Test
    public void shouldMoveForMultipleInstructions(){
        rover.processForMultipleInstructions("MMRM");
        assertEquals(new Position(2,3,Direction.EAST),rover.getPosition());

    }
    @Test
    public void shouldNotMoveForInvalidMove() {
        rover.processForMultipleInstructions("RRMMMMMMMM");
        assertEquals(new Position(1,0,Direction.SOUTH),rover.getPosition());
    }
    @Test
    public void shouldProcessMoveToRight() {
        rover.processMove('R');
        assertEquals(new Position(1,1,Direction.EAST),rover.getPosition());
    }
    @Test
    public void shouldProcessMoveToLeft() {
        rover.processMove('L');
        assertEquals(new Position(1,1,Direction.WEST),rover.getPosition());

    }
}
