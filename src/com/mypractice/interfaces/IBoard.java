package com.mypractice.interfaces;

import com.mypractice.BoardLayout;
import com.mypractice.Player;
import com.mypractice.Position;

public interface IBoard {

    //Configure players
    void setPlayers(Player player1, Player player2);

    //Start the game
    void beginPlay();

    //Tell If a particular Grid Position is Valid or Not
    boolean isValidPosition(Position position);

    //Know the board Layout
    BoardLayout getBoardLayout();

}
