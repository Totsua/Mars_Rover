package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {
    @Test
    @DisplayName("Plateau calculates it's maximum size correctly")
    void plateauSizeTest_Happy(){
        int[] testUpperRightCoordinate = {2, 5};

        int[] expectedResult = {3,6};

        int[][] result = new Plateau(testUpperRightCoordinate).getSize();
        int[] resultLengthWidth = {result.length,result[0].length};

        assertAll(
                () -> assertEquals(expectedResult[0],resultLengthWidth[0]),
                () -> assertEquals(expectedResult[1],resultLengthWidth[1])
        );
    }

    @Test
    @DisplayName("plateauSize correctly returns null if given a (0,0) or null coordinate")
    void plateauSizeTest_WithNoSize(){
        int[] testUpperRightCoordinate = {0,0};
        int[] testUpperRightCoordinate2 = null;

        int[][] result = new Plateau(testUpperRightCoordinate).getSize();
        int[][] result2 = new Plateau(testUpperRightCoordinate2).getSize();

        assertNull(result);
        assertNull(result2);

    }

    @Test
    @DisplayName("Plateau turns negative coordinate inputs to positive inputs")
    void plateauTest_WithNegativeInputs(){
        int[] testUpperRightCoordinate = {-10,-5};

        int[] expectedResult = {11,6};

        int[][] result = new Plateau(testUpperRightCoordinate).getSize();

        int[] resultLengthWidth = {result.length,result[0].length};

        assertAll(
                () -> assertEquals(expectedResult[0],resultLengthWidth[0]),
                () -> assertEquals(expectedResult[1],resultLengthWidth[1])
        );
    }

}
