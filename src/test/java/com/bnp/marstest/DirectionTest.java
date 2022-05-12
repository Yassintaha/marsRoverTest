package com.bnp.marstest;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DirectionTest {

    @Test
    public void shouldReturnLeft() {
        assertEquals(Direction.EAST, Direction.SOUTH.goLeft());
        assertEquals(Direction.WEST, Direction.NORTH.goLeft());
    }

    @Test
    public void shouldReturnRight() {
        assertEquals(Direction.WEST, Direction.SOUTH.goRight());
        assertEquals(Direction.EAST, Direction.NORTH.goRight());
    }

    @Test
    public void shouldReturnDirectionAlphabet() {
        assertEquals("S", Direction.SOUTH.toString());
        assertEquals("N", Direction.NORTH.toString());
    }
}
