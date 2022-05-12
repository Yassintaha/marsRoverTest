package com.bnp.marstest;

import java.util.Arrays;

public class Utils {
    public static Point parseMatrix(String dimensions) {
        try {
            String[] dimentionsMatrix = Arrays.stream(dimensions.split(" "))
                    .map(String::trim)
                    .toArray(String[]::new);
            return new Point(Integer.parseInt(dimentionsMatrix[0]), Integer.parseInt(dimentionsMatrix[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The coordinates of the plateau are INVALID");
        }

    }

    public static Position parsePosition(String position) {
        try {
            String[] positionElement = Arrays.stream(position.split(" "))
                    .map(String::trim)
                    .toArray(String[]::new);
            int xCoordinate = Integer.parseInt(positionElement[0]);
            int yCoordinate = Integer.parseInt(positionElement[1]);
            Direction direction = Direction.getDirection(positionElement[2]);
            return new Position(xCoordinate, yCoordinate, direction);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The coordinates of Position are  INVALID");
        }

    }

}
