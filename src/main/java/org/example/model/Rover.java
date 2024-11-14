package org.example.model;

import java.util.Arrays;
import java.util.function.Predicate;

public class Rover {
    private int[] position;
    private Character direction;

    private static final Predicate<Character> directionPredicate = s -> s.equals('N')||
            s.equals('E')||
            s.equals('S')||
            s.equals('W');

    private static final Predicate<Integer> positionPredicate = a ->
            a < 0;

    public Rover(int[] position, Character direction) {

        if (position == null) {
            this.position = null;
        }
        else if(position[0] < 0 || position[1] < 0){
            this.position = null;
        }
        else {
            this.position = position;
        }


        if(direction != null && directionPredicate.test(direction)) {
            this.direction = direction;
        } else {
            this.direction = null;
        }
    }

    public int[] getPosition() {
        return position;
    }

    public Character getDirection() {
        return direction;
    }
}
