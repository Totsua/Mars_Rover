package org.example.service;


public interface ServiceLayer {

    // Create the Plateau
    boolean createPlateau(String input);
    // Create the Rover
    boolean createRover(String input);

    // Rover Instructions
    boolean instructRover(String input);

    // Check if the space on the grid is empty
    // boolean isSpaceEmpty(int[] destination);

    // Check if the rover will go off grid
    boolean isSpaceValid(int[] destination);





}
