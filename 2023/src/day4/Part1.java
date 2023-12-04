/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day4;
import utils.Reader;

/**
 *
 * @author amy
 */
public class Part1 {
    public static void main (String[] args) {
        String[] lines = Reader.read().split("\n");
        int total = 0, square = 0;
        
        for (String line : lines) {
            square = 0;
            String[] part = line.split(":");
            
            String[] temp = part[1].split("\\|");
            String[] winNums = temp[0].trim().split("\\s+");
            String[] nums = temp[1].trim().split("\\s+");
            //nums had left winning, right given
            boolean first = true;
            
            for (String num : nums) {
                for (String winNum : winNums) {
                    if (num.equals(winNum)) {
                        if (first) {
                            square = 1;
                            first = false;
                        } else {
                            square *= 2;//two to the power
                        }
                        break;
                    }
                }
            }
            total += square;
        }
        
        System.out.println(total);
    }
}
