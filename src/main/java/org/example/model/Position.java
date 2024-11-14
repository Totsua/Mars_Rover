package org.example.model;

public class Position {
    private int x;
    private int y;
    private CompassDirections facing;

    public Position(int x, int y, CompassDirections facing) {

        this.x = x < 0 ? -x : x;

        this.y = y < 0 ? -y : y;

        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CompassDirections getCompassDirections() {
        return facing;
    }
}
