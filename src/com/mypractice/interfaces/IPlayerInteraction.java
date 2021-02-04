package com.mypractice.interfaces;

import com.mypractice.Board;
import com.mypractice.Position;
import com.mypractice.Ship;

import java.util.List;

/**
 * Defines an interface for Interaction with a battle ship player
 * 1) Get the positions of ship placement
 * 2) Targets of missile
 * 3) Inform player of the result of the game
 * 4) Inform player if he scores a successful hit
 */
public interface IPlayerInteraction {

    List<Ship> getShipsFromUser();

    Position getMissileTarget();

    void notifySuccessfulHit(Position pos);

    void notifyResult(Board.Result result);

}
