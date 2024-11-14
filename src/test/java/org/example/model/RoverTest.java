package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("Rover only takes directions 'N','E','S' or 'W'")
    void roverDirection_CorrectInputTest(){
        int[] testPosition = {0,0};

        char testDirection1 = 'N';
        char testDirection2 = 'E';
        char testDirection3 = 'S';
        char testDirection4 = 'W';

        Rover testRover1 = new Rover(testPosition,testDirection1);
        Rover testRover2 = new Rover(testPosition,testDirection2);
        Rover testRover3 = new Rover(testPosition,testDirection3);
        Rover testRover4 = new Rover(testPosition,testDirection4);

        char expectedDirection1 = 'N';
        char expectedDirection2 = 'E';
        char expectedDirection3 = 'S';
        char expectedDirection4 = 'W';

        char resultDirection1 = testRover1.getDirection();
        char resultDirection2 = testRover2.getDirection();
        char resultDirection3 = testRover3.getDirection();
        char resultDirection4 = testRover4.getDirection();


        assertAll(
                () -> assertEquals(expectedDirection1,resultDirection1),
                () -> assertEquals(expectedDirection2,resultDirection2),
                () -> assertEquals(expectedDirection3,resultDirection3),
                () -> assertEquals(expectedDirection4,resultDirection4)
        );
    }

    @Test
    @DisplayName("Rover direction is null if incorrect or empty direction input is given")
    void roverDirection_WrongInputTest(){
        int[] testPosition = {0,0};

        char testDirection1 = 'V';
        char testDirection2 = ' ';


        Rover testRover1 = new Rover(testPosition,testDirection1);
        Rover testRover2 = new Rover(testPosition,testDirection2);

        Character resultDirection1 = testRover1.getDirection();
        Character resultDirection2 = testRover2.getDirection();

        assertAll(
                () -> assertNull(resultDirection1),
                () -> assertNull(resultDirection2)
        );
    }


    @Test
    @DisplayName("Rover direction is null if direction input is null")
    void roverDirection_NullInputTest(){
        int[] testPosition = {0,0};

        Character testDirection1 = null;

        Rover testRover1 = new Rover(testPosition,testDirection1);

        Character resultDirection1 = testRover1.getDirection();

        assertNull(resultDirection1);
    }

    @Test
    @DisplayName("Rover position returns null if given a negative or null coordinates")
    void roverPosition_NegativeInput(){
        int[] testPosition1 = {-8,5};
        int[] testPosition2 = {10,-14};
        int[] testPosition3 = null;

        char testDirection = 'N';

        Rover testRover1 = new Rover(testPosition1,testDirection);
        Rover testRover2 = new Rover(testPosition2,testDirection);
        Rover testRover3 = new Rover(testPosition3,testDirection);

        int[] resultPosition1 = testRover1.getPosition();
        int[] resultPosition2 = testRover2.getPosition();
        int[] resultPosition3= testRover3.getPosition();


               assertNull(resultPosition1);
               assertNull(resultPosition2);
               assertNull(resultPosition3);
    }



}
