package com.mypractice.tests;

import com.mypractice.Position;
import com.mypractice.Ship;
import com.mypractice.ShipFactory;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShipTest {

    Ship shipP;
    Ship shipQ;

    @Before
    public void setUp() {
        Position shipPosition = new Position(2, 2);
        shipP = ShipFactory.getShip(shipPosition, 2, 2, "P");
        shipQ = ShipFactory.getShip(shipPosition, 4, 1, "Q");
    }

    @Test
    public void testIsHit() {
        assertTrue(shipP.isHit(new Position(2,3)));
        assertTrue(shipP.isHit(new Position(3,3)));
        assertTrue(shipQ.isHit(new Position(5,2)));
        assertFalse(shipQ.isHit(new Position(6,2)));
    }

    @Test
    public void testIsSunk() {
        shipP.isHit(new Position(2,2));
        shipP.isHit(new Position(2,3));
        shipP.isHit(new Position(3,2));
        assertFalse(shipP.isSunk());
        shipP.isHit(new Position(3,3));
        assertTrue(shipP.isSunk());

        shipQ.isHit(new Position(2,2));
        shipQ.isHit(new Position(3,2));
        shipQ.isHit(new Position(4,2));
        shipQ.isHit(new Position(5,2));
        assertFalse(shipQ.isSunk());

        shipQ.isHit(new Position(2,2));
        shipQ.isHit(new Position(3,2));
        shipQ.isHit(new Position(4,2));
        shipQ.isHit(new Position(5,2));
        assertTrue(shipQ.isSunk());

    }

    @Test
    public void testGetShipPositions() {
        assertEquals(4, shipP.getShipPositions().size());
        assertEquals(4, shipQ.getShipPositions().size());

        List<Position> positions = shipP.getShipPositions();
        List<Position> expectedPositions = new ArrayList<>();
        expectedPositions.add(new Position(2, 2));
        expectedPositions.add(new Position(2, 3));
        expectedPositions.add(new Position(3, 2));
        expectedPositions.add(new Position(3, 3));
        positions.removeAll(expectedPositions);
        assertEquals(0, positions.size());

    }
}