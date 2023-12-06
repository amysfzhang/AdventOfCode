/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day5;

import utils.Reader;
import java.util.*;

/**
 *
 * @author amy
 */
public class Part1and2 {
    public static void main (String[] args) {
        String[] lines = Reader.read().split("\n");

        String[] temp = lines[0].split(":");
        int[] seeds = Arrays.stream(temp[1].split(" "))
                .mapToInt(Integer::parseInt).toArray();
        
        for (int seed : seeds) {
            System.out.println(seed);
        }
    }
}
