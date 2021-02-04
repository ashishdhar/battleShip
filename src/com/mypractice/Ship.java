package com.mypractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Represents a ship on the board with the grid positions it occupies.
Keeps track of hits and eventually if the ship is sunk or not.
 */
public abstract class Ship {

    private Map<Position,Integer> shipPositionMap;

    public Ship(Position P, int length, int breadth) {
        shipPositionMap = new HashMap<>();
        for(int i = P.X; i < P.X + length; i++) {
            for(int j = P.Y; j < P.Y + breadth; j++) {
                shipPositionMap.put(new Position(i,j), getHitPoints());
            }
        }
    }

    public boolean isHit(Position missile) {
        if (shipPositionMap.containsKey(missile)) {
            if (shipPositionMap.computeIfPresent(missile, ((position, hits) -> hits-1))==0) {
                shipPositionMap.remove(missile);
            }
            return true;
        }
        return false;
    }

    public boolean isSunk() {
        if (shipPositionMap.size() == 0){
            return true;
        }
        return false;
    }

    public List<Position> getShipPositions() {
        return  new ArrayList<>(shipPositionMap.keySet());
    }

    public abstract int getHitPoints();
}
