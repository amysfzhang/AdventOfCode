/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day11;

import utils.Reader;
import java.util.*;

/**
 *
 * @author amy
 */
public class Part1 {
    public static void main (String[] args) {
        String[] lines = Reader.read().split("\n");
        ArrayList<Integer[]> gCoords = new ArrayList<Integer[]>();
        ArrayList<Integer> eColomns = new ArrayList<Integer>();
        ArrayList<Integer> eRows = new ArrayList<Integer>();
        
        //find coords of all stars
        for (int i = 0; i < lines.length; i++) {
            String t = lines[i];
            
            while (t.indexOf("#") != -1) {
                gCoords.add(new Integer[] {t.indexOf("#"), i});
                t = t.replaceFirst("#", ".");
            }
        }
        
        //array the colomns that are all .
        for (int i = 0; i < lines[0].length(); i++) {
            for (int j = 0; j < lines.length; j++) {
                if (lines[j].charAt(i) != '.') {
                    break;
                }
                if (j == lines.length - 1) {
                    eColomns.add(i);
                }
            }
        }
        
        //array the rows that are all .
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].indexOf("#") == -1) {
                eRows.add(i);
            }
        }
        
        int total = 0;
        for (int i = 0; i < gCoords.size(); i++) {
          for (int j = i + 1; j < gCoords.size(); j++) {  
              
            int xCount = Math.abs(gCoords.get(i)[0] - gCoords.get(j)[0]);
            //if two star x coords incldue array, add # 
            for (int x = 0; x < eColomns.size(); x++) {
                if ((gCoords.get(i)[0] < eColomns.get(x) && gCoords.get(j)[0] > eColomns.get(x)) 
                    || (gCoords.get(i)[0] > eColomns.get(x) && gCoords.get(j)[0] < eColomns.get(x))) {
                    xCount++;
                }
            }
            
            int yCount = Math.abs(gCoords.get(i)[1] - gCoords.get(j)[1]);
            //if two star y coords incldue array, add # 
            for (int y = 0; y < eRows.size(); y++) {
                if ((gCoords.get(i)[1] < eRows.get(y) && gCoords.get(j)[1] > eRows.get(y)) 
                    || (gCoords.get(i)[1] > eRows.get(y) && gCoords.get(j)[1] < eRows.get(y))) {
                    yCount++;
                }
            } 
            
            //shortest path is the x and y distance added together
            total += xCount + yCount;
          }
        }
        
        System.out.println(total);
    }
}
