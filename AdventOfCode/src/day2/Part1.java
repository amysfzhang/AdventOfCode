package day2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
import java.io.*;


/**
 *
 * @author amy
 */
public class Part1 {
    public static void main(String[] args) {
        int sum = 0;
        boolean add = true;
        String[] colours = {"red", "green", "blue"};
        
        String file = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
"Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
"Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
"Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
"Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
        
        String[] lines = file.split("\n");
        int gameNum = 1;

        
        for (String line : lines) {
            add = true;
            String[] part = line.split(":");
            String[] bits = part[1].replace(";", ",").split(",");

            for (String bit : bits) {
                for (int j = 0; j < colours.length; j++) {
                    if (bit.endsWith(colours[j])) {
                        switch (j) {
                            case 0:
                                if (Integer.parseInt(bit.trim().substring(0, bit.indexOf(colours[j])-1).trim()) > 12) {
                                    add = false;
                                }
                            case 1:
                                if (Integer.parseInt(bit.trim().substring(0, bit.indexOf(colours[j])-1).trim()) > 13) {
                                    add = false;
                                }
                            case 2:
                                if (Integer.parseInt(bit.substring(0, bit.indexOf(colours[j])-1).trim()) > 14) {
                                    add = false;
                                }
                        }
                                
                    }
                }
            }

            if (add) sum += gameNum;            
            gameNum++;

        }
        
        System.out.println(sum);
    }
}
