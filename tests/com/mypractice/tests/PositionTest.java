package com.mypractice.tests;

import com.mypractice.Position;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void testEquals() {
        Position pos1 = new Position(2, 3);
        Position pos2 = new Position(2, 3);
        Position pos3 = new Position(2, 4);

        Assert.assertEquals("Equal Positions did not match", pos1, pos2);
        Assert.assertNotEquals("UnEqual Positions matched", pos1, pos3);
    }

}