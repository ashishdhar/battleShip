package com.mypractice;

/*
Factory that return ship objects of various types.
 */
public class ShipFactory {
    public static Ship getShip(Position position, int shipLength, int shipBreadth, String shipType) {
        if (shipType.equalsIgnoreCase("P")) {
            return new ShipP(position, shipLength, shipBreadth);
        } else if (shipType.equalsIgnoreCase("Q")) {
            return new ShipQ(position, shipLength, shipBreadth);
        } else {
            throw new IllegalArgumentException("Invalid Ship Type");
        }
    }
}
