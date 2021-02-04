package com.mypractice;

import com.mypractice.interfaces.IBoard;

public class Main {

    public static void main(String[] args) {
        //Initializing Board to Play
        IBoard board = new Board(5,5, 20);
        // Other Possible constructors for the board class
        // IBoard board = new Board(5, 5);
        // IBoard board = new Board(5, 5);
        Player player1 = PlayerFactory.getPlayer("Player-1", PlayerFactory.InteractionType.CONSOLE, board);
        Player player2 = PlayerFactory.getPlayer("Player-2", PlayerFactory.InteractionType.CONSOLE, board);
        //Configure Players on the Board to begin play
        board.setPlayers(player1, player2);
        board.beginPlay();
    }
}
