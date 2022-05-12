package com.bnp.marstest;

public enum Direction {
    EAST("E"), WEST("W"),
    NORTH("N"),
    SOUTH("S");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public static Direction getDirection(String direction) {
        switch (direction) {
            case "N":
                return NORTH;
            case "S":
                return SOUTH;
            case "W":
                return WEST;
            case "E":
                return EAST;
            default:
                throw new IllegalStateException("SIGNE NON VALIDE!!");
        }
    }

    public Direction goLeft() {
        switch (this.direction) {
            case "E":
                return NORTH;
            case "W":
                return SOUTH;
            case "N":
                return WEST;
            case "S":
                return EAST;
            default:
                throw new IllegalStateException("SIGNE NON VALIDE!!");
        }


    }

    public Direction goRight() {
        switch (this.direction) {
            case "E":
                return SOUTH;
            case "W":
                return NORTH;
            case "N":
                return EAST;
            case "S":
                return WEST;
            default:
                throw new IllegalStateException("SIGNE NON VALIDE!!");
        }


    }

    @Override
    public String toString() {
        return direction;
    }
}
