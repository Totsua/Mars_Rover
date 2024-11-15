package org.example.service;

import org.example.model.CompassDirections;
import org.example.model.Instruction;
import org.example.model.PlateauSize;
import org.example.model.Position;

import java.util.ArrayList;

public class InputParser {

    CompassDirections directionParser(String input) {
        return switch (input) {
            case ("N"), ("n") -> CompassDirections.N;
            case ("E"), ("e") -> CompassDirections.E;
            case ("W"), ("w") -> CompassDirections.W;
            case ("S"), ("s") -> CompassDirections.S;
            case null -> throw new RuntimeException("null cannot be an input. Please contact the developer.");
            default -> throw new RuntimeException("'" + input + "'" + " is not a valid input");
        };

    }

    PlateauSize plateauSizeParser(String input) {
        if(input == null){
            throw new RuntimeException("null cannot be an input. Please contact the developer.");
        }
        if (input.trim().split(" ").length != 2) {
            throw new RuntimeException("'" + input + "'" + " is not a valid input");
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
                throw new RuntimeException("'" + input + "'" + " is not a valid input");
            }
        }
    }

    Position positionParser(String input) {
        if(input == null){
           throw new RuntimeException("null cannot be an input. Please contact the developer.");
        }

        String[] inputSplit = input.split(" ");
        try{
            int x = Integer.parseInt(inputSplit[0]);
            int y = Integer.parseInt(inputSplit[1]);
            CompassDirections direction = directionParser(inputSplit[2]);
            if(direction == null){
                throw new RuntimeException();
            }
            return new Position(x,y,direction);
        }catch (  RuntimeException e ){
            throw new RuntimeException("'" + input + "'" + " is not a valid input");
        }

    }

     Instruction[] instructionParser(String input) {

        if (input == null) {
            throw new RuntimeException("null cannot be an input. Please contact the developer.");
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
                   throw new RuntimeException("'" + input + "'" + " is not a valid input.");
            }
        }

        Instruction[] instructionArray = new Instruction[instructions.size()];
        for (int i = 0; i < instructions.size(); i++) {
            instructionArray[i] = instructions.get(i);
        }


        return instructionArray;
    }
}

