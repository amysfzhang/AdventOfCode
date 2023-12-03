/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day3;

import java.util.regex.*;
import utils.Reader;
import java.util.*;
/**
 *
 * @author amy
 */
public class Part2 {
    public static void main (String[] args) {
        String[] lines = Reader.read().split("\n");

        Pattern num = Pattern.compile("\\d+");
        Pattern symbol = Pattern.compile("\\*");
        int sum = 0;
        ArrayList<int[]> pos = new ArrayList<>(); 
        //x, y, num
        
        //look at each line
        for (int i = 0; i < lines.length; i++) {
            int end = 0;
            Matcher m = num.matcher(lines[i]);

            //each num in a line
            while (m.find(end)) {
                if (i != 0) {
                    if (symbol.matcher(lines[i-1].substring(m.start(), m.end())).find()) {
                        //jot down * position, y = row = i.. m = number, x = 
                        Matcher s = symbol.matcher(lines[i-1].substring(m.start(), m.end()));                            
                        s.find();
                        int[] l = {s.start() + m.start(), i-1, Integer.parseInt(m.group())};
                        pos.add(l);
                    }
                    //check if diagonals exist on top
                    if (m.start() != 0 && symbol.matcher(lines[i-1].substring(m.start()-1, m.start())).find()) {
                        Matcher s = symbol.matcher(lines[i-1].substring(m.start()-1, m.start()));
                        s.find();
                        int[] l = {s.start() + m.start()-1, i-1, Integer.parseInt(m.group())};
                        pos.add(l);
                    }
                    if (m.end() != lines[i-1].length() && symbol.matcher(lines[i-1].substring(m.end(), m.end()+1)).find()) {
                        Matcher s = symbol.matcher(lines[i-1].substring(m.end(), m.end()+1));
                        s.find();
                        int[] l = {s.start() + m.end(), i-1, Integer.parseInt(m.group())};
                        pos.add(l);
                    }
                }
                //checks bottom
                if (i != lines.length-1) {
                    if (symbol.matcher(lines[i+1].substring(m.start(), m.end())).find()) {
                        //jot down * position, y = row = i.. m = number, x = 
                        Matcher s = symbol.matcher(lines[i+1].substring(m.start(), m.end()));                            
                        s.find();
                        int[] l = {s.start() + m.start(), i+1, Integer.parseInt(m.group())};
                        pos.add(l);
                    }
                    //check if diagonals exist 
                    if (m.start() != 0 && symbol.matcher(lines[i+1].substring(m.start()-1, m.start())).find()) {
                        Matcher s = symbol.matcher(lines[i+1].substring(m.start()-1, m.start()));
                        s.find();
                        int[] l = {s.start() + m.start()-1, i+1, Integer.parseInt(m.group())};
                        pos.add(l);
                    }
                    if (m.end() != lines[i+1].length() && symbol.matcher(lines[i+1].substring(m.end(), m.end()+1)).find()) {
                        Matcher s = symbol.matcher(lines[i+1].substring(m.end(), m.end()+1));
                        s.find();
                        int[] l = {s.start() + m.end(), i+1, Integer.parseInt(m.group())};
                        pos.add(l);
                    }
                }
                
                //check side
                if (m.start() != 0 && symbol.matcher(lines[i].substring(m.start()-1, m.start())).find()) {
                    Matcher s = symbol.matcher(lines[i].substring(m.start()-1, m.start()));
                    s.find();
                    int[] l = {s.start() + m.start()-1, i, Integer.parseInt(m.group())};
                    pos.add(l);
                }
                if (m.end() != lines[i].length() && symbol.matcher(lines[i].substring(m.end(), m.end()+1)).find()) {
                    Matcher s = symbol.matcher(lines[i].substring(m.end(), m.end()+1));
                    s.find();
                    int[] l = {s.start() + m.end(), i, Integer.parseInt(m.group())};
                    pos.add(l);
                }
                end = m.end();
            }
        }
        
        //find two that are the same, 
        for (int k = 0; k < pos.size(); k++) {
            System.out.println(pos.get(k)[0] + ", " + pos.get(k)[1] + ":  " + pos.get(k)[2]);
            for (int p = k; p < pos.size(); p++) {
                if (pos.get(k)[0] == pos.get(p)[0] && pos.get(k)[1] == pos.get(p)[1] && pos.get(k)[2] != pos.get(p)[2]) {
                    sum += pos.get(k)[2] * pos.get(p)[2];
                }
            }
        }
        System.out.println(sum);
    }
}
