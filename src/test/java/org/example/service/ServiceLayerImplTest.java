package org.example.service;

import org.example.model.CompassDirections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceLayerImplTest {
    private ServiceLayerImpl serviceLayer;

    @BeforeEach
    void setServiceLayerImpl(){
        serviceLayer = new ServiceLayerImpl();
    }


    @Test
    @DisplayName("createPlateau creates a Plateau with correct inputs given")
    void createPlateau_CorrectInputs() {
        String testInput = "6 5";



        assertTrue(serviceLayer.createPlateau(testInput));
        assertEquals(7,serviceLayer.plateau.getSize().length);
        assertEquals(6,serviceLayer.plateau.getSize()[0].length);

    }

    @Test
    @DisplayName("createRover creates Rover with correct inputs given")
    void createRover_CorrectInputs() {
        String testInput = "6 5";
        serviceLayer.createPlateau(testInput);

        String testInput2 = "1 2 N";

        assertTrue(serviceLayer.createRover(testInput2));

        assertAll(
                () -> assertEquals(1,serviceLayer.getRover().getPosition().getX()),
                () -> assertEquals(2,serviceLayer.getRover().getPosition().getY()),
                () -> assertEquals(CompassDirections.N,serviceLayer.getRover().getPosition().getCompassDirections())
        );

    }

    @Test
    @DisplayName("instructRover moves Rover with correct inputs")
    void instructRover_CorrectInputs() {
        String testInput = "6 5";
        serviceLayer.createPlateau(testInput);
        String testInput2 = "1 2 N";
        serviceLayer.createRover(testInput2);

        String testInput3 ="LMLMLMLMML";

        assertTrue(serviceLayer.instructRover(testInput3));

        assertAll(
                () -> assertEquals(0,serviceLayer.getRover().getPosition().getX()),
                () -> assertEquals(3,serviceLayer.getRover().getPosition().getY()),
                () -> assertEquals(CompassDirections.W,serviceLayer.getRover().getPosition().getCompassDirections())
        );

    }

    @Test
    @DisplayName("isSpaceValid returns true if a given space is on the Plateau")
    void isSpaceValid_CorrectInputs() {
        String testInput = "6 5";
        serviceLayer.createPlateau(testInput);

        int[] testInput2 = {5,5};

        boolean result1 = serviceLayer.isSpaceValid(testInput2);

        assertTrue(result1);

    }
}