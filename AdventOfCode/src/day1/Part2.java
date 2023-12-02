/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day1;

import java.util.*;
import java.io.*;

/**
 *
 * @author amy
 */
public class Part2 {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        String[] nums = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String file = "two1nine\n" +
"eightwothree\n" +
"abcone2threexyz\n" +
"xtwone3four\n" +
"4nineeightseven2\n" +
"zoneight234\n" +
"7pqrstsixteen";
        
        String[] lines = file.split("\n");
            
        for (String line : lines) {
        String digits = "";
            
            who:
            for (int i = 0; i < line.length(); i++) {
                try {
                    for (int l = 0; l < nums.length; l++) {
                        if (line.substring(i).startsWith(nums[l])){
                            digits = String.valueOf(l + 1);
                            break who;
                        }
                    }
                    digits = String.valueOf(Integer.parseInt(line.substring(i, i+1)));
                    break;
                } catch (NumberFormatException e) {}
            }
            
            how:
            for (int i = line.length() - 1; i >= 0; i--) {
                try {
                    for (int l = 0; l < nums.length; l++) {
                        if (line.substring(i).startsWith(nums[l])){
                            digits += String.valueOf(l + 1);
                            break how;
                        }
                    }
                    digits += String.valueOf(Integer.parseInt(line.substring(i, i+1)));
                    break;
                } catch (NumberFormatException e) {}
            }
            
            try {
                sum += Integer.parseInt(digits);
            } catch (NumberFormatException e) {}
        }
        System.out.println(sum);
    }
}
