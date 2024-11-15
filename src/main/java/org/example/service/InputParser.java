package org.example.service;

import org.example.model.CompassDirections;
import org.example.model.Instruction;
import org.example.model.PlateauSize;
import org.example.model.Position;

import java.util.ArrayList;

public class InputParser {

    CompassDirections directionParser(String input) {
        switch (input) {
            case ("N"), ("n"):
                return CompassDirections.N;
            case ("E"), ("e"):
                return CompassDirections.E;
            case ("W"), ("w"):
                return CompassDirections.W;
            case ("S"), ("s"):
                return CompassDirections.S;
            case null:
                return null;
            default:
                // maybe throw error?*/
             //   throw new RuntimeException(input + " is not a valid input");
        }

        return null;
    }

    PlateauSize plateauSizeParser(String input) {
        if (input == null || input.trim().split(" ").length != 2) {
            return null;
        } else {
            try {
                String[] splitString = input.split(" ");
                int x = Integer.parseInt(splitString[0]) > 0
                        ? Integer.parseInt(splitString[0]) : -Integer.parseInt(splitString[0]);
                int y = Integer.parseInt(splitString[1]) > 0
                        ? Integer.parseInt(splitString[1]) : -Integer.parseInt(splitString[1]);
                if (x == 0 && y == 0) {
                    return null;
                }

                return new PlateauSize(x, y);
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }

    Position positionParser(String input) {
        if(input == null || input.isBlank()){
            return null;
        }

        String[] inputSplit = input.split(" ");
        try{
            int x = Integer.parseInt(inputSplit[0]);
            int y = Integer.parseInt(inputSplit[1]);
            CompassDirections direction = directionParser(inputSplit[2]);
            if(direction == null){
                return null;
            }
            return new Position(x,y,direction);
        }catch (NumberFormatException e ){
            return null;
        }

    }

     Instruction[] instructionParser(String input) {

        if (input == null || input.isBlank()) {
            return null;
        }
        ArrayList<Instruction> instructions = new ArrayList<>();

        for (Character c : input.toCharArray()) {
            switch (c) {
                case ('L'), ('l'):
                    instructions.add(Instruction.L);
                    break;
                case ('R'), ('r'):
                    instructions.add(Instruction.R);
                    break;
                case ('M'), ('m'):
                    instructions.add(Instruction.M);
                    break;
                default:
                    // maybe throw error
            }
        }

        Instruction[] instructionArray = new Instruction[instructions.size()];
        for (int i = 0; i < instructions.size(); i++) {
            instructionArray[i] = instructions.get(i);
        }


        return instructionArray.length > 0 ? instructionArray : null;
    }
}

