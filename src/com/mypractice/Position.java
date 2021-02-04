package com.mypractice;

/*
Represents a grid point on the batte ship board
 */
public class Position {
    public int X;
    public int Y;

    public Position(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Position){
            Position pos = (Position) obj;
            if (this.Y == pos.Y && this.X == pos.X) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return X * 17 + Y * 13;
    }
}
