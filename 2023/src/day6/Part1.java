/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day6;

import java.util.ArrayList;
import utils.Reader;

/**
 *
 * @author amy
 */
public class Part1 {
    public static void main (String[] args) {
        String[] lines = Reader.read().split("\n");
        int total = 1;
        ArrayList<Long> time = new ArrayList<>();
        ArrayList<Long> distance = new ArrayList<>();
        
        for (String i : lines[0].split(":\s+")[1].split("\s+")) {
            time.add(Long.parseLong(i.trim()));
        }
        for (String i : lines[1].split(":\s+")[1].split("\s+")) {
            distance.add(Long.parseLong(i.trim()));
        }
        
        //cycle through time
        for (int i = 0; i < time.size(); i++) {
            int boatSpeed = 0, ways = 0;
            //boat speed * time = distance
            while (boatSpeed < time.get(i)) {
                if (boatSpeed * (time.get(i) - boatSpeed) > distance.get(i)) {
                    ways++;
                }
                boatSpeed++;
            }
            total *= ways;
        }
        
        System.out.println(total);
    }        
}
