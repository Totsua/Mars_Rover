package org.example.service;

import org.example.model.*;

import java.util.function.Predicate;

public class ServiceLayerImpl implements ServiceLayer{

    InputParser inputParser = new InputParser();
    Plateau plateau;
    Rover rover;

    public Plateau getPlateau() {
        return plateau;
    }

    public Rover getRover() {
        return rover;
    }

    /**
     * @param input
     * @return
     */
    @Override
    public boolean createPlateau(String input) {
        PlateauSize plateauSize = inputParser.plateauSizeParser(input);
        if(plateauSize != null){
            plateau = new Plateau(plateauSize);
            return true;
        }
        return false;
    }

    /**
     * @param input
     * @return
     */
    @Override
    public boolean createRover(String input) {
        Position position = inputParser.positionParser(input);
        if(position == null){
            return false;
        }
        boolean isPositionValidOnGrid = isSpaceValid(new int[]{position.getX(), position.getY()});
        if(isPositionValidOnGrid){
            rover = new Rover(position);
            return true;
        }
        return false;
    }

    /**
     * @param input
     */
    @Override
    public boolean instructRover(String input) {
        Predicate<Instruction> instructionMovePredicate = n -> n == Instruction.M;
        Position initialRoverPosition = rover.getPosition();

        Instruction[] instructions = inputParser.instructionParser(input);

        if (instructions == null) {
            return false;
        } else {

            for (Instruction instruction : instructions) {
                // Check if the instruction is 'M' or it's 'L'/'R'
                if (instructionMovePredicate.test(instruction)) {
                    rover.move();
                } else {
                    rover.rotate(instruction);
                }
            }
        }
        int[] newRoverCoordinates = {rover.getPosition().getX(), initialRoverPosition.getY()};

        if (isSpaceValid(newRoverCoordinates)) {
            return true;
        } else {
            rover.setPosition(initialRoverPosition);
            return false;
        }
    }

    /**
     * @param destination
     * @return
     */
    @Override
    public boolean isSpaceValid(int[] destination) {
        int plateauXRange = plateau.getSize().length -1;
        int plateauYRange = plateau.getSize()[0].length -1;

        return destination[0] <= plateauXRange && destination[1] <= plateauYRange;

    }
}