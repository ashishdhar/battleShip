package com.mypractice;

import com.mypractice.interfaces.IPlayerInteraction;

import java.util.List;

/*
Implements logic for player actions such as ship placement,
taking turn to fire missile, informing of ship hits etc.
 */
public class Player {

    private List<Ship> ships;
    private IPlayerInteraction playerInteraction;

    public Player(IPlayerInteraction playerInteraction) {
        this.playerInteraction = playerInteraction;
    }

    public void initShipPositions() {
        this.ships = playerInteraction.getShipsFromUser();
    }

    public Position playTurn() {
        return playerInteraction.getMissileTarget();
    }

    public boolean isAnyShipHit(Position fire) {
        for(Ship s: ships) {
            if (s.isHit(fire)) {
                if (s.isSunk()) {
                    ships.remove(s);
                }
                return true;
            }
        }
        return false;
    }

    public boolean isAnyShipLeft() {
        if (ships.size() == 0) {
            return false;
        }
        return true;
    }

    public void gameOutcome(Board.Result result) {
        playerInteraction.notifyResult(result);
    }

    public void successfulHit(Position position) {
        playerInteraction.notifySuccessfulHit(position);
    }

}
