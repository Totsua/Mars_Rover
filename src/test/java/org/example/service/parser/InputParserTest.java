package org.example.service.parser;

import org.example.model.*;
import org.example.service.parser.InputParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

  private InputParser inputParser;
    @BeforeEach
    void setInputParser(){
        inputParser = new InputParser();
    }

    @Test
    @DisplayName("directionParser returns a correct CompassDirections Enum given a correct input")
    void directionParser_WithCorrectInputTest() {
        String testInput1 = "N";
        String testInput2 = "E";
        String testInput3 = "S";
        String testInput4 = "W";

        CompassDirections expectedResult1 = CompassDirections.N;
        CompassDirections expectedResult2 = CompassDirections.E;
        CompassDirections expectedResult3 = CompassDirections.S;
        CompassDirections expectedResult4 = CompassDirections.W;


        CompassDirections result1 = inputParser.directionParser(testInput1);
        CompassDirections result2 = inputParser.directionParser(testInput2);
        CompassDirections result3 = inputParser.directionParser(testInput3);
        CompassDirections result4 = inputParser.directionParser(testInput4);

        assertAll(
                () -> assertEquals(expectedResult1,result1),
                () -> assertEquals(expectedResult2,result2),
                () -> assertEquals(expectedResult3,result3),
                () -> assertEquals(expectedResult4,result4)
        );

    }
    @Test
    @DisplayName("directionParser returns a correct CompassDirections Enum given a lowercase correct input")
    void directionParser_WithCorrectLowerCaseInputTest() {
        String testInput1 = "n";
        String testInput2 = "e";
        String testInput3 = "s";
        String testInput4 = "w";

        CompassDirections expectedResult1 = CompassDirections.N;
        CompassDirections expectedResult2 = CompassDirections.E;
        CompassDirections expectedResult3 = CompassDirections.S;
        CompassDirections expectedResult4 = CompassDirections.W;


        CompassDirections result1 = inputParser.directionParser(testInput1);
        CompassDirections result2 = inputParser.directionParser(testInput2);
        CompassDirections result3 = inputParser.directionParser(testInput3);
        CompassDirections result4 = inputParser.directionParser(testInput4);

        assertAll(
                () -> assertEquals(expectedResult1,result1),
                () -> assertEquals(expectedResult2,result2),
                () -> assertEquals(expectedResult3,result3),
                () -> assertEquals(expectedResult4,result4)
        );

    }

    @Test
    @DisplayName("directionParser returns null when given an incorrect/empty input")
    void directionParser_WithIncorrectOrEmptyInputTest() {
        String testInput1 = "North";
        String testInput2 = "";
        String testInput3 = " ";

        var result1 = inputParser.directionParser(testInput1);
        var result2 = inputParser.directionParser(testInput2);
        var result3 = inputParser.directionParser(testInput3);


        assertNull(result1);
        assertNull(result2);
        assertNull(result3);
    }
    @Test
    @DisplayName("directionParser returns null when given null input")
    void directionParser_NullInputTest() {
        String testInput1 = null;

        CompassDirections result1 = inputParser.directionParser(testInput1);

        assertNull(result1);
    }

    @Test
    @DisplayName("plateauSizeParser returns PlateauSize object given correct inputs")
    void plateauSizeParser_CorrectInputTest() {
        String testInput1 = "10 5";

        PlateauSize expectedResult = new PlateauSize(10,5);

        PlateauSize result = inputParser.plateauSizeParser(testInput1);

        assertAll(
                () -> assertEquals(expectedResult.getX(),result.getX()),
                () -> assertEquals(expectedResult.getY(),result.getY()),
                () -> assertEquals(expectedResult.getX() + 1,result.getPlateauGrid().length),
                () -> assertEquals(expectedResult.getY() + 1,result.getPlateauGrid()[0].length)

        );

    }

    @Test
    @DisplayName("plateauSizeParser returns PlateauSize with positive inputs given negative")
    void plateauSizeParser_NegativeInputTest() {
        String testInput1 = "-8 -10";

        PlateauSize expectedResult = new PlateauSize(8,10);

        PlateauSize result = inputParser.plateauSizeParser(testInput1);

        assertAll(
                () -> assertEquals(expectedResult.getX(),result.getX()),
                () -> assertEquals(expectedResult.getY(),result.getY()),
                () -> assertEquals(expectedResult.getX() + 1,result.getPlateauGrid().length),
                () -> assertEquals(expectedResult.getY() + 1,result.getPlateauGrid()[0].length)

        );

    }

    @Test
    @DisplayName("plateauSizeParser returns null for given incorrect/empty input")
    void plateauSizeParser_IncorrectOrEmptyInputTest(){
        String testInput1 = "BOB";
        String testInput2 = "";
        String testInput3 = "10 100 1000";

        PlateauSize result1 = inputParser.plateauSizeParser(testInput1);
        PlateauSize result2 = inputParser.plateauSizeParser(testInput2);
        PlateauSize result3 = inputParser.plateauSizeParser(testInput3);

        assertAll(
                () -> assertNull(result1),
                () -> assertNull(result2),
                () -> assertNull(result3)
        );

    }

    @Test
    @DisplayName("plateauSizeParser returns null for null input")
    void plateauSizeParser_NullInputTest(){
        String testInput = null;

        PlateauSize result = inputParser.plateauSizeParser(testInput);

       assertNull(result);
    }

    @Test
    @DisplayName("positionParser returns a Position with correct Input attributes")
    void positionParser_WithCorrectInputTest(){
        String testInput1 = "1 2 N";
        String testInput2 = "0 0 W";

        var expectedResult1 = new Position(1,2,CompassDirections.N);
        var expectedResult2 = new Position(0,0,CompassDirections.W);

        var result1 = inputParser.positionParser(testInput1);
        var result2 = inputParser.positionParser(testInput2);

        assertAll(
                () -> assertEquals(expectedResult1.getX(),result1.getX()),
                () -> assertEquals(expectedResult1.getY(),result1.getY()),
                () -> assertEquals(expectedResult1.getCompassDirections(),result1.getCompassDirections()),
                () -> assertEquals(expectedResult2.getX(),result2.getX()),
                () -> assertEquals(expectedResult2.getY(),result2.getY()),
                () -> assertEquals(expectedResult2.getCompassDirections(),result2.getCompassDirections())
        );
    }


    @Test
    @DisplayName("positionParser returns null with incorrect/empty inputs")
    void positionParser_WithIncorrectOrEmptyInputTest(){
        String testInput1 = "S 10 1";
        String testInput2 = "10 E 4";
        String testInput3 = " ";


        var result1 = inputParser.positionParser(testInput1);
        var result2 = inputParser.positionParser(testInput2);
        var result3 = inputParser.positionParser(testInput3);

        assertAll(
                () -> assertNull(result1),
                () -> assertNull(result2),
                () -> assertNull(result3)
        );
    }

    @Test
    @DisplayName("positionParser returns null with null input")
    void positionParser_WithNullInputTest(){
        String testInput1 = null;

        var result1 = inputParser.positionParser(testInput1);

        assertNull(result1);
    }

    @Test
    @DisplayName("instructionParser returns the correct Instruction enum array for a correct input")
    void instructionParser_CorrectInputTest() {
        String testInput1 = "LLMLM";
        String testInput2 = "RLMLRMLR"; // l -> to the left // r -> to the right //m -> move

        Instruction[] expectedResult1 = {Instruction.L,Instruction.L,Instruction.M,Instruction.L,Instruction.M};
        Instruction[] expectedResult2 = {Instruction.R,Instruction.L,Instruction.M,Instruction.L,Instruction.R,
                Instruction.M,Instruction.L,Instruction.R};

        Instruction[] result1 = inputParser.instructionParser(testInput1);
        Instruction[] result2 = inputParser.instructionParser(testInput2);

        assertEquals(Arrays.toString(expectedResult1), Arrays.toString(result1));
        assertEquals(Arrays.toString(expectedResult2), Arrays.toString(result2));

    }

    @Test
    @DisplayName("instructionParser returns null for an incorrect or empty input")
    void instructionParser_IncorrectOrEmptyInputTest() {
        String testInput1 = "BAOPESAZ";
        String testInput2 = " ";


        Instruction[] result1 = inputParser.instructionParser(testInput1);
        Instruction[] result2 = inputParser.instructionParser(testInput2);

        assertNull(result1);
        assertNull(result2);

    }
    @Test
    @DisplayName("instructionParser returns null for a null input")
    void instructionParser_NullInputTest() {
        String testInput1 = null;

        Instruction[] result1 = inputParser.instructionParser(testInput1);

        assertNull(result1);
    }


}