package com.bnp.marstest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.ParseException;
import java.util.Arrays;

@Data
@AllArgsConstructor
public class  Rover {
    Position position;
    Point    matrix;

    public void processForMultipleInstructions(String instructions) {
        instructions.chars().mapToObj( c -> (char) c).forEach(this::processMove);
    }

    public void processMove(char instruction){

        switch (instruction) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'M':
                move();
                break;
        }
    }

    private void move() {
       if(position.isValidMove(position.goAhead(),this.matrix)){
           this.setPosition(position.goAhead());
       }
    }

    private void turnLeft() {
       this.setPosition(new Position(this.position.x,this.position.y,this.position.getDirection().goLeft()));
    }

    private void turnRight() {
        this.setPosition(new Position(this.position.x,this.position.y,this.position.getDirection().goRight()));
    }
    public  static Rover initRover(String positions,Point matrix) {
        Position position=Utils.parsePosition(positions);
        return new Rover(position,matrix);
    }

}
