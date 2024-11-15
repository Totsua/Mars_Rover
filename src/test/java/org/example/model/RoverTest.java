package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {



    @Test
    @DisplayName("Rover correctly changes Position direction depending on instruction given")
    void roverRotateTest(){
        Instruction testInstruction1 = Instruction.L;
        Instruction testInstruction2 = Instruction.R;

        Position testPosition1 = new Position(5,3,CompassDirections.N);
        Position testPosition2 = new Position(5,3,CompassDirections.E);


        Rover testRover1 = new Rover(testPosition1);
        Rover testRover2 = new Rover(testPosition2);

        CompassDirections expectedResult1 = CompassDirections.W;
        CompassDirections expectedResult2 = CompassDirections.S;

        testRover1.rotate(testInstruction1);
        testRover2.rotate(testInstruction2);

        CompassDirections result1 = testRover1.getPosition().getCompassDirections();
        CompassDirections result2 = testRover2.getPosition().getCompassDirections();



        assertAll(
                () -> assertEquals(expectedResult1,result1),
                () -> assertEquals(expectedResult2,result2)
        );

    }

    @Test
    @DisplayName("Rover wont change Position if given 'M' Instruction")
    void roverRotate_MoveInputTest(){
        Instruction testInstruction1 = Instruction.M;

        Position testPosition1 = new Position(5,3,CompassDirections.N);

        Rover testRover1 = new Rover(testPosition1);

        CompassDirections expectedResult1 = CompassDirections.N;

        testRover1.rotate(testInstruction1);

        CompassDirections result1 = testRover1.getPosition().getCompassDirections();

        assertEquals(expectedResult1,result1);

    }

    @Test
    @DisplayName("Rover Position coordinates change correctly for a given direction")
    void roverMoveTest(){


        Position testPosition1 = new Position(5,3,CompassDirections.N);
        Position testPosition2 = new Position(3,4,CompassDirections.E);

        Rover testRover1 = new Rover(testPosition1);
        Rover testRover2 = new Rover(testPosition2);

        int[] expectedResult1 = {5,4};
        int[] expectedResult2 = {4,4};

        testRover1.move();
        testRover2.move();


        int[] result1 = {testRover1.getPosition().getX(), testPosition1.getY()};
        int[] result2 = {testRover2.getPosition().getX(), testPosition2.getY()};


        assertAll(
                () -> assertEquals(expectedResult1[0],result1[0]),
                () -> assertEquals(expectedResult1[1],result1[1]),
                () -> assertEquals(expectedResult2[0],result2[0]),
                () -> assertEquals(expectedResult2[1],result2[1])
        );
    }
    @Test
    @DisplayName("Rover Position won't go into negative coordinates if moving past 0 (x) or 0 (y) Position")
    void roverMove_NegativeTest(){
        Position testPosition1 = new Position(3,0,CompassDirections.S);
        Position testPosition2 = new Position(0,5,CompassDirections.W);

        Rover testRover1 = new Rover(testPosition1);
        Rover testRover2 = new Rover(testPosition2);

        int[] expectedResult1 = {3,0};
        int[] expectedResult2 = {0,5};

        testRover1.move();
        testRover2.move();

        int[] result1 = {testRover1.getPosition().getX(), testPosition1.getY()};
        int[] result2 = {testRover2.getPosition().getX(), testPosition2.getY()};

        assertAll(
                () -> assertEquals(expectedResult1[0],result1[0]),
                () -> assertEquals(expectedResult1[1],result1[1]),
                () -> assertEquals(expectedResult2[0],result2[0]),
                () -> assertEquals(expectedResult2[1],result2[1])
        );

    }


}

