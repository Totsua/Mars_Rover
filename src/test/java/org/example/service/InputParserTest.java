package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void setInputParser() {
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
                () -> assertEquals(expectedResult1, result1),
                () -> assertEquals(expectedResult2, result2),
                () -> assertEquals(expectedResult3, result3),
                () -> assertEquals(expectedResult4, result4)
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
                () -> assertEquals(expectedResult1, result1),
                () -> assertEquals(expectedResult2, result2),
                () -> assertEquals(expectedResult3, result3),
                () -> assertEquals(expectedResult4, result4)
        );

    }

    @Test
    @DisplayName("directionParser throws RuntimeException when given an incorrect/empty input")
    void directionParser_WithIncorrectOrEmptyInputTest() {
        String testInput1 = "North";
        String testInput2 = "";
        String testInput3 = " ";

        RuntimeException thrown1 = assertThrows(RuntimeException.class, () -> inputParser.directionParser(testInput1));
        RuntimeException thrown2 = assertThrows(RuntimeException.class, () -> inputParser.directionParser(testInput2));
        RuntimeException thrown3 = assertThrows(RuntimeException.class, () -> inputParser.directionParser(testInput3));

        assertEquals("'North' is not a valid input", thrown1.getMessage());
        assertEquals("'' is not a valid input", thrown2.getMessage());
        assertEquals("' ' is not a valid input", thrown3.getMessage());

    }


    @Test
    @DisplayName("directionParser throws RuntimeException when given null input")
    void directionParser_NullInputTest() {
        String testInput1 = null;

        RuntimeException thrown1 = assertThrows(RuntimeException.class, () -> inputParser.directionParser(testInput1));

        assertEquals("null cannot be an input. Please contact the developer.", thrown1.getMessage());
    }

    @Test
    @DisplayName("plateauSizeParser returns PlateauSize object given correct inputs")
    void plateauSizeParser_CorrectInputTest() {
        String testInput1 = "10 5";

        PlateauSize expectedResult = new PlateauSize(10, 5);

        PlateauSize result = inputParser.plateauSizeParser(testInput1);

        assertAll(
                () -> assertEquals(expectedResult.getX(), result.getX()),
                () -> assertEquals(expectedResult.getY(), result.getY()),
                () -> assertEquals(expectedResult.getX() + 1, result.getPlateauGrid().length),
                () -> assertEquals(expectedResult.getY() + 1, result.getPlateauGrid()[0].length)

        );

    }

    @Test
    @DisplayName("plateauSizeParser returns PlateauSize with positive inputs given negative")
    void plateauSizeParser_NegativeInputTest() {
        String testInput1 = "-8 -10";

        PlateauSize expectedResult = new PlateauSize(8, 10);

        PlateauSize result = inputParser.plateauSizeParser(testInput1);

        assertAll(
                () -> assertEquals(expectedResult.getX(), result.getX()),
                () -> assertEquals(expectedResult.getY(), result.getY()),
                () -> assertEquals(expectedResult.getX() + 1, result.getPlateauGrid().length),
                () -> assertEquals(expectedResult.getY() + 1, result.getPlateauGrid()[0].length)

        );

    }

    @Test
    @DisplayName("plateauSizeParser throws RuntimeException for given incorrect/empty input")
    void plateauSizeParser_IncorrectOrEmptyInputTest() {
        String testInput1 = "BOB";
        String testInput2 = "";
        String testInput3 = "10 100 1000";

        RuntimeException result1 = assertThrows(RuntimeException.class,() -> inputParser.plateauSizeParser(testInput1));
        RuntimeException result2 = assertThrows(RuntimeException.class,() -> inputParser.plateauSizeParser(testInput2));
        RuntimeException result3 = assertThrows(RuntimeException.class,() -> inputParser.plateauSizeParser(testInput3));

        assertAll(
                () -> assertEquals("'BOB' is not a valid input", result1.getMessage()),
                () -> assertEquals("'' is not a valid input", result2.getMessage()),
                () -> assertEquals("'10 100 1000' is not a valid input", result3.getMessage())
        );

    }

    @Test
    @DisplayName("plateauSizeParser throws a RuntimeException for null input")
    void plateauSizeParser_NullInputTest() {
        String testInput = null;

        RuntimeException result1 = assertThrows(RuntimeException.class, () -> inputParser.plateauSizeParser(testInput));

        assertEquals("null cannot be an input. Please contact the developer.", result1.getMessage());
    }

    @Test
    @DisplayName("positionParser returns a Position with correct Input attributes")
    void positionParser_WithCorrectInputTest() {
        String testInput1 = "1 2 n";
        String testInput2 = "0 0 W";

        var expectedResult1 = new Position(1, 2, CompassDirections.N);
        var expectedResult2 = new Position(0, 0, CompassDirections.W);

        var result1 = inputParser.positionParser(testInput1);
        var result2 = inputParser.positionParser(testInput2);

        assertAll(
                () -> assertEquals(expectedResult1.getX(), result1.getX()),
                () -> assertEquals(expectedResult1.getY(), result1.getY()),
                () -> assertEquals(expectedResult1.getCompassDirections(), result1.getCompassDirections()),
                () -> assertEquals(expectedResult2.getX(), result2.getX()),
                () -> assertEquals(expectedResult2.getY(), result2.getY()),
                () -> assertEquals(expectedResult2.getCompassDirections(), result2.getCompassDirections())
        );
    }


    @Test
    @DisplayName("positionParser throws a RuntimeException with incorrect/empty inputs")
    void positionParser_WithIncorrectOrEmptyInputTest() {
        String testInput1 = "S 10 1";
        String testInput2 = "10 E 4";
        String testInput3 = " ";


        RuntimeException result1 = assertThrows(RuntimeException.class, () ->inputParser.positionParser(testInput1));
        RuntimeException result2 = assertThrows(RuntimeException.class, () ->inputParser.positionParser(testInput2));
        RuntimeException result3 = assertThrows(RuntimeException.class, () ->inputParser.positionParser(testInput3));

        assertAll(
                () -> assertEquals("'S 10 1' is not a valid input",result1.getMessage()),
                () -> assertEquals("'10 E 4' is not a valid input",result2.getMessage()),
                () -> assertEquals("' ' is not a valid input",result3.getMessage())
        );
    }

    @Test
    @DisplayName("positionParser throws RuntimeException with null input")
    void positionParser_WithNullInputTest() {
        String testInput1 = null;

        RuntimeException result1 = assertThrows(RuntimeException.class, () ->inputParser.positionParser(testInput1));

        assertEquals("null cannot be an input. Please contact the developer.",result1.getMessage());
    }

    @Test
    @DisplayName("instructionParser returns the correct Instruction enum array for a correct input")
    void instructionParser_CorrectInputTest() {
        String testInput1 = "LLMLM";
        String testInput2 = "RLMLRMLR"; // l -> to the left // r -> to the right //m -> move

        Instruction[] expectedResult1 = {Instruction.L, Instruction.L, Instruction.M, Instruction.L, Instruction.M};
        Instruction[] expectedResult2 = {Instruction.R, Instruction.L, Instruction.M, Instruction.L, Instruction.R,
                Instruction.M, Instruction.L, Instruction.R};

        Instruction[] result1 = inputParser.instructionParser(testInput1);
        Instruction[] result2 = inputParser.instructionParser(testInput2);

        assertEquals(Arrays.toString(expectedResult1), Arrays.toString(result1));
        assertEquals(Arrays.toString(expectedResult2), Arrays.toString(result2));

    }

    @Test
    @DisplayName("instructionParser throws a RuntimeException for an incorrect or empty input")
    void instructionParser_IncorrectOrEmptyInputTest() {
        String testInput1 = "BAOPESAZ";
        String testInput2 = " ";


        RuntimeException result1 = assertThrows(RuntimeException.class, () -> inputParser.instructionParser(testInput1));
        RuntimeException result2 = assertThrows(RuntimeException.class, () -> inputParser.instructionParser(testInput2));

        assertEquals("'BAOPESAZ' is not a valid input.",result1.getMessage());
        assertEquals("' ' is not a valid input.",result2.getMessage());

    }

    @Test
    @DisplayName("instructionParser throws a RuntimeException for a null input")
    void instructionParser_NullInputTest() {
        String testInput1 = null;

        RuntimeException result1 = assertThrows(RuntimeException.class, () -> inputParser.instructionParser(testInput1));

        assertEquals("null cannot be an input. Please contact the developer.",result1.getMessage());


    }


}