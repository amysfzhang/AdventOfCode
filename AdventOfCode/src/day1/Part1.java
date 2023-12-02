/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day1;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author amy
 */
public class Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int sum = 0;
        
        String file = "1abc2\n"
                + "pqr3stu8vwx\n"
                + "a1b2c3d4e5f\n"
                + "treb7uchet\n";
        
        String[] lines = file.split("\n");
            
        for (String line : lines) {
        String digits = "";
            
            for (int i = 0; i < line.length(); i++) {
                try {
                    digits = String.valueOf(Integer.parseInt(line.substring(i, i+1)));
                    break;
                } catch (NumberFormatException e) {}
            }
            
            for (int i = line.length() - 1; i >= 0; i--) {
                try {
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
