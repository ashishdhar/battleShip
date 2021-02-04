package com.mypractice;

/*
Represents Ship type Q with 2 hit point per grid
 */
public class ShipQ extends Ship {

    public static final int HIT_POINTS = 2;

    public ShipQ(Position P, int length, int breadth) {
        super(P, length, breadth);
    }

    @Override
    public int getHitPoints() {
        return HIT_POINTS;
    }
}
