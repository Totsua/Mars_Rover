package org.example.model;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Rover {
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void rotate(Instruction instruction) {
        if (instruction != null && instruction != Instruction.M) {
            if (instruction == Instruction.L) {
                switch (position.getCompassDirections()) {
                    case N -> position.setFacing(CompassDirections.W);
                    case E -> position.setFacing(CompassDirections.N);
                    case S -> position.setFacing(CompassDirections.E);
                    case W -> position.setFacing(CompassDirections.S);
                }
            } else {
                switch (position.getCompassDirections()) {
                    case N -> position.setFacing(CompassDirections.E);
                    case E -> position.setFacing(CompassDirections.S);
                    case S -> position.setFacing(CompassDirections.W);
                    case W -> position.setFacing(CompassDirections.N);
                }
            }
        }
    }



    // BiPredicate to test if a move on the xAxis goes through
    private BiPredicate<CompassDirections, Integer> xAxisOperation = (facing,xcoordinate) ->{
        boolean direction = facing == CompassDirections.E || facing == CompassDirections.W;
        boolean isBiggerThan0 = xcoordinate > 0;
        return direction && isBiggerThan0;
    };

    // BiPredicate to test if a move on the yAxis goes through
    private BiPredicate<CompassDirections, Integer> yAxisOperation = (facing,ycoordinate) ->{
        boolean direction = facing == CompassDirections.N ||facing == CompassDirections.S;
        boolean isBiggerThan0 = ycoordinate > 0;
        return direction && isBiggerThan0;
    };

    /**
     *
     *
     */

    public void move(){
        CompassDirections roverFacing = position.getCompassDirections();
        int x = position.getX();
        int y = position.getY();


        // Check if the rover is able to move in a given direction
        if(xAxisOperation.test(roverFacing,x)){

            // Move rover in given direction on X
            x = roverFacing == CompassDirections.E ? x+1 : x-1;
            position.setX(x);

        } else if (yAxisOperation.test(roverFacing,y)) {
            // Move rover in given direction on Y
            y = roverFacing == CompassDirections.N ? y+1 : y-1;
            position.setY(y);
        }


    }

}
