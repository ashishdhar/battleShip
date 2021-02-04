package com.mypractice;

import com.mypractice.interfaces.IBoard;
import com.mypractice.interfaces.IPlayerInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Implements player interaction interface for console
 */
public class ConsolePlayerInteraction implements IPlayerInteraction {

    private Scanner scanner;
    private IBoard board;
    private String displayName;

    public ConsolePlayerInteraction(String displayName, IBoard board) {
        this.scanner = new Scanner(System.in);
        this.board = board;
        this.displayName = displayName;
    }

    public List<Ship> getShipsFromUser() {
        System.out.println("Welcome " + displayName + " to Battle Ship");
        BoardLayout layout = this.board.getBoardLayout();
        System.out.println("Board Details below Height = " + layout.height + " Width = " + layout.width);
        System.out.println("Enter Details of ships in following format <TYPE> <X-POS> <Y-POS> <ShipLength> <ShipBreadth> . Type \"done\" to finish");

        List<Ship> ships = new ArrayList<>();

        String userInput = "";
        while (true) {
            userInput = scanner.nextLine();
            if ("done".equalsIgnoreCase(userInput)) {
                break;
            }
            String [] inputs = userInput.split(" ");
            if (!validateShipInput(inputs)) {
                System.out.println("Incorrect number of user inputs !!! Retry.");
                continue;
            }
            Ship ship = null;
            try {
                ship = transformUserInputToShip(inputs);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            if (!isValidShipPlacement(ship)) {
                System.out.println("Incorrect ship placement !!! Retry.");
                continue;
            }
            ships.add(ship);
        }
        return ships;
    }

    public Position getMissileTarget() {
        System.out.println(displayName + " Enter Missile Target Position");
        String userInput = scanner.nextLine();
        String [] inputs = userInput.split(" ");
        if (!validateMissileInput(inputs)) {
            System.out.println("Incorrect Input for Missile Target. Retry");
            return getMissileTarget();
        }
        Position position = new Position(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        if(!isValidMissileTarget(position)) {
            System.out.println("Incorrect Missile Target Position. Retry.");
            return getMissileTarget();
        }
        return position;
    }

    public void notifyResult(Board.Result result) {
        switch (result) {
            case WIN:
                System.out.println(displayName + " you won the match :)");
                break;
            case LOSS:
                System.out.println(displayName + " you lost the match :(");
                break;
            case DRAW:
                System.out.println("It was a draw !!!");
                break;
        }
    }

    public void notifySuccessfulHit(Position pos) {
        System.out.println(displayName + " scored a successful hit on (" + pos.X + "," + pos.Y + ")");
    }

    private boolean validateShipInput(String [] userInput) {
        if (userInput.length != 5) {
            return false;
        }
        return true;
    }

    private boolean validateMissileInput(String [] userInput) {
        if (userInput.length != 2) {
            return false;
        }
        return true;
    }

    private boolean isValidShipPlacement(Ship ship) {
        List<Position> shipPositions = ship.getShipPositions();
        return !shipPositions.stream().anyMatch(position -> !board.isValidPosition(position));
    }

    private boolean isValidMissileTarget(Position missile) {
        if (board.isValidPosition(missile)){
            return true;
        }
        return false;
    }

    private Ship transformUserInputToShip(String[] inputs) {
        String shipType = inputs[0];
        Position position = new Position(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
        int shipLength = Integer.parseInt(inputs[3]);
        int shipBreadth = Integer.parseInt(inputs[4]);
        return ShipFactory.getShip(position, shipLength, shipBreadth, shipType);
    }

}
