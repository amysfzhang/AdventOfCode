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
public class Part2 {
    public static void main (String[] args) {
        String[] lines = Reader.read().split("\n");
        String pattern = lines[0];        
        
        HashMap m = new HashMap(); //map with keys and values
        for (int i = 2; i < lines.length; i++) {
            m.put(lines[i].substring(0,3), lines[i].substring(7,15));
        }

        ArrayList<String> a = new ArrayList<>(); //array with all nodes ending in A
        for (Object lol : m.keySet()) {
            if (String.valueOf(lol).endsWith("A")) {
                a.add(String.valueOf(lol));
            }
        }
        
        //loops through each node to find shortest steps of each one. Slower than incrementing nodes together
        int[] s = new int[a.size()]; //stores shortest number of steps
        for (int i = 0; i < a.size(); i++) {
            int patNum = 0, steps = 0;

            //same code as part 1
            while (!a.get(i).endsWith("Z")) {
                if (pattern.charAt(patNum) == 'L') {
                    a.set(i, String.valueOf(m.get(a.get(i))).substring(0, 3));
                }
                if (pattern.charAt(patNum) == 'R') {
                    a.set(i, String.valueOf(m.get(a.get(i))).substring(5, 8));
                }
                steps++;
                patNum = (patNum + 1) % pattern.length();
            }
            s[i] = steps;
        }
        
        //finds lcm of all items in steps
        long lcm = 1;
        for (int i = 0; i < s.length; i++) {
            lcm = lcm(lcm, s[i], Math.max(lcm, s[i]));
        }        
        System.out.println(lcm);
    }
    
    public static long lcm(long a, long b, long c) {
        long lcm = Math.max(a, b);
        if (lcm % Math.min(a, b) != 0) {
            lcm = lcm(lcm + c, Math.min(a, b), c);
        }
        return lcm;
    }
}
