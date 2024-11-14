package org.example.model;

import java.util.Arrays;

public class Grid {
    private int[] upperRightGridCoordinate;
    private int[][] gridSize;


    public Grid(int[] upperRightGridCoordinate) {
        this.upperRightGridCoordinate = upperRightGridCoordinate;
        int x = upperRightGridCoordinate[0] < 0 ? -upperRightGridCoordinate[0] : upperRightGridCoordinate[0];
        int y = upperRightGridCoordinate[1] < 0 ? -upperRightGridCoordinate[1] : upperRightGridCoordinate[1];

        if(Arrays.equals(upperRightGridCoordinate, new int[]{0, 0}) || upperRightGridCoordinate == null){
            gridSize = null;
        }
        else {
            gridSize = new int[x + 1][y + 1];
        }
    }


    public int[][] getSize(){
        return gridSize;
    }
}
