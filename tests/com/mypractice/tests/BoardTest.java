package com.mypractice.tests;

import com.mypractice.Board;
import com.mypractice.BoardLayout;
import com.mypractice.Position;
import com.mypractice.interfaces.IBoard;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class BoardTest {

    IBoard boardSpecific;
    IBoard boardDefault;

    @Before
    public void setUp() {
        boardSpecific = new Board(20, 30);
        boardDefault = new Board();

    }

    @Test
    public void testBoardLayout() {
        BoardLayout layout = boardSpecific.getBoardLayout();
        assertEquals(layout.height, 20);
        assertEquals(layout.width, 30);

        layout = boardDefault.getBoardLayout();
        assertEquals(layout.height, 5);
        assertEquals(layout.width, 5);

    }

    @Test
    public void testBoardPosition() {
        assertTrue(boardSpecific.isValidPosition(new Position(18, 25)));
        assertFalse(boardSpecific.isValidPosition(new Position(21, 25)));
        assertTrue(boardDefault.isValidPosition(new Position(4, 4)));
        assertFalse(boardDefault.isValidPosition(new Position(6, 2)));
    }
}
