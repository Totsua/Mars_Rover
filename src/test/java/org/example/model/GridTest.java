package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    @DisplayName("Grid calculates it's maximum size correctly")
    void gridSizeTest_Happy(){
        int[] testUpperRightCoordinate = {2, 5};

        int[] expectedResult = {3,6};

        int[][] result = new Grid(testUpperRightCoordinate).getSize();
        int[] resultLengthWidth = {result.length,result[0].length};

        assertAll(
                () -> assertEquals(expectedResult[0],resultLengthWidth[0]),
                () -> assertEquals(expectedResult[1],resultLengthWidth[1])
        );
    }

    @Test
    @DisplayName("Grid correctly returns null if given a (0,0) or null coordinate")
    void gridSizeTest_WithNoSize(){
        int[] testUpperRightCoordinate = {0,0};

        int[][] result = new Grid(testUpperRightCoordinate).getSize();

        assertNull(result);

    }

    @Test
    @DisplayName("Grid turns negative inputs to positive inputs")
    void gridSizeTest_WithNegativeInputs(){
        int[] testUpperRightCoordinate = {-10,-5};

        int[] expectedResult = {11,6};

        int[][] result = new Grid(testUpperRightCoordinate).getSize();

        int[] resultLengthWidth = {result.length,result[0].length};

        assertAll(
                () -> assertEquals(expectedResult[0],resultLengthWidth[0]),
                () -> assertEquals(expectedResult[1],resultLengthWidth[1])
        );
    }

}
