package com.mypractice;

/*
Represents Ship type P with 1 hit point per grid
 */
public class ShipP extends Ship {

    public static final int HIT_POINTS = 1;

    public ShipP(Position P, int length, int breadth) {
        super(P, length, breadth);
    }

    @Override
    public int getHitPoints() {
        return HIT_POINTS;
    }
}
