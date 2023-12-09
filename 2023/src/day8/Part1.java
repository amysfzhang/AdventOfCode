/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day8;

import utils.Reader;
import java.util.*;

/**
 *
 * @author amy
 */
public class Part1 {
    public static void main (String[] args) {
        String[] lines = Reader.read().split("\n");
        
        String pattern = lines[0];
        
        HashMap m = new HashMap();
        
        for (int i = 2; i < lines.length; i++) {
            m.put(lines[i].substring(0,3), lines[i].substring(7,15));
        }
        
        String o = "AAA";
        int num = 0, count = 0;
        
        while (!o.equals("ZZZ")) {
            if (pattern.charAt(num) == 'L') {
                o = String.valueOf(m.get(o)).substring(0, 3);
            }
            if (pattern.charAt(num) == 'R') {
                o = String.valueOf(m.get(o)).substring(5, 8);
            }
            
            count++;
            num++;
            if (num == pattern.length()) num = 0;
        }
        
        System.out.println(count);
        //follows pattern until it hits ZZZ
    }
}
