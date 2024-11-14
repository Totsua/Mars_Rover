package org.example.model;

import java.util.Arrays;

public class Plateau {
    private PlateauSize plateauSize;


    public Plateau(PlateauSize plateauSize) {

        this.plateauSize = plateauSize;

    }


    public int[][] getSize(){
        return plateauSize.getPlateauGrid();
    }
}
