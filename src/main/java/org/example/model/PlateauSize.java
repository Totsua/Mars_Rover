package org.example.model;

import java.util.Arrays;

public class PlateauSize {

    private int x;
    private int y;
    private int[][] plateauGrid;

    public PlateauSize(int x, int y) {

        int[] upperRightGridCoordinate = {x,y};
        if(upperRightGridCoordinate == null || Arrays.equals(upperRightGridCoordinate, new int[]{0, 0})){
            plateauGrid = null;
        }else {
            this.x = x > 0 ? x : -x;
            this.y = y > 0 ? y : -y;
            plateauGrid = new int[this.x+1][this.y+1];
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getPlateauGrid() {
        return plateauGrid;
    }
}
