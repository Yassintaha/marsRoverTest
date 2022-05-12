package com.bnp.marstest;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Position extends  Point {
    private Direction direction;

    public Position(int x, int y,Direction direction) {
        super(x, y);
        this.direction=direction;
    }

    public Position goAhead() {
        switch (direction.toString()) {
            case "E":
                return new Position(x+1, y, direction);
            case "W":
                return new Position(x-1, y, direction);
            case "N":
                return new Position(x, y+1, direction);
            case "S":
                return new Position(x, y-1, direction);
            default:
                throw new IllegalStateException("Direction Invalide");
        }
    }
    public boolean isValidMove(Position position,Point matrix) {
        return isPositionIn(position,matrix)&& position.getX()>=0 && position.getY()>=0;
    }
    public boolean isPositionIn(Position position,Point pointMax) {
        return position.getX()<=pointMax.getX()
                && position.getY() <=pointMax.getY();
    }

    public boolean isPostionOut(Position position,Point matrix) {
        return position.getX()>matrix.getX()
                && position.getY() >matrix.getY();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && direction == position.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}
