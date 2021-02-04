package com.mypractice;

import com.mypractice.interfaces.IBoard;

public class Board implements IBoard {

    private static final int DEFAULT_HEIGHT = 5;
    private static final int DEFAULT_WIDTH = 5;


    @Override
    public boolean isValidPosition(Position position) {
        if (position.X > height || position.Y > width || position.X < 1 || position.Y < 1) {
            return false;
        }
        return true;
    }

    @Override
    public BoardLayout getBoardLayout() {
        return new BoardLayout(height, width);
    }

    public enum Result {
        WIN,
        LOSS,
        DRAW
    }

    private int height;
    private int width;
    private Player player1;
    private Player player2;
    private int noOfTurns = 10; //Default number of turns

    public Board(int height, int width, int noOfTurns) {
        this.height = height;
        this.width = width;
        this.noOfTurns = noOfTurns;
    }

    //overloaded constructor with default number of turns
    public Board(int height, int width) {
        this.height = height;
        this.width = width;
    }

    //overloaded constructor with default number of turns, height and width
    public Board() {
        this.height = DEFAULT_HEIGHT;
        this.width = DEFAULT_WIDTH;
    }

    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public void beginPlay() throws IllegalStateException{

        if (player1 == null || player2 == null) {
            throw new IllegalStateException("Players not configured on the board.");
        }

        player1.initShipPositions();
        player2.initShipPositions();

        while(noOfTurns > 0) {
            Position pos1 = player1.playTurn();
            while (player2.isAnyShipHit(pos1)) {
                //notify result of hit
                player1.successfulHit(pos1);
                if (!player2.isAnyShipLeft()) {
                    // declare player 1 winner
                    player1.gameOutcome(Result.WIN);
                    player2.gameOutcome(Result.LOSS);
                    return;
                }
                pos1 = player1.playTurn();
            }

            Position pos2 = player2.playTurn();
            while (player1.isAnyShipHit(pos2)) {
                //notify result of hit
                player2.successfulHit(pos2);
                if (!player1.isAnyShipLeft()) {
                    // declare player 2 winner
                    player2.gameOutcome(Result.WIN);
                    player1.gameOutcome(Result.LOSS);
                    return;
                }
                pos2 = player2.playTurn();
            }

            //count turn
            noOfTurns--;
        }

        //exit game with draw
        player1.gameOutcome(Result.DRAW);
        player2.gameOutcome(Result.DRAW);

    }

}
