package com.bnp.marstest;

import org.w3c.dom.ls.LSResourceResolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        List<Rover> rovers = new ArrayList<>();
        Point matrix ;
        if(args.length>0){
            Path path = Paths.get(args[0]);
            try  {
                List<String> lines = Files.readAllLines(path);
                String matrixDimensions = Optional.ofNullable(lines.get(0)).orElseThrow(() -> new IllegalArgumentException("EMPTY FILE"));
                matrix=Utils.parseMatrix(matrixDimensions);
                for (int i = 1;i<lines.size();i=i+2) {
                    Rover rover = Rover.initRover(lines.get(i),matrix);
                    rovers.add(rover);
                    rover.processForMultipleInstructions(lines.get(i+1));
                }
                rovers.forEach(rover -> System.out.println(rover.getPosition()));
            }catch (IOException e) {
                System.out.println("File "+args[0]+" Not Found!!");
                e.printStackTrace();
            }
        }else {
            throw new IllegalArgumentException("ARGUMENT NO VALID");
        }
}

}


