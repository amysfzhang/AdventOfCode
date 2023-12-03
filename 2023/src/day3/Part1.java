/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day3;
import utils.Reader;
import java.util.regex.*;

/**
 *
 * @author amy
 */
public class Part1 {
    public static void main (String[] args) {
        String[] lines = Reader.read().split("\n");
        
        Pattern num = Pattern.compile("\\d+");
        Pattern symbol = Pattern.compile("[^\\w\\d\\.]");
        int sum = 0;
        
        for (int i = 0; i < lines.length; i++) {
            int end = 0;
            Matcher m = num.matcher(lines[i]);
            
            while (m.find(end)) {
                boolean add = false;
                //loops through each number found
                //checks top 
                if (i != 0) {
                    if (symbol.matcher(lines[i-1].substring(m.start(), m.end())).find()) {
                        add = true;
                    }
                    //check if diagonals exist on top
                    if (m.start() != 0 && symbol.matcher(lines[i-1].substring(m.start()-1, m.end())).find()) {
                        add = true;
                    }
                    if (m.end() != lines[i-1].length() && symbol.matcher(lines[i-1].substring(m.start(), m.end()+1)).find()) {
                        add = true;
                    }
                }
                //checks bottom
                if (i != lines.length-1) {
                    if (symbol.matcher(lines[i+1].substring(m.start(), m.end())).find()) {
                        add = true;
                    }
                    //check if diagonals exist
                    if (m.start() != 0 && symbol.matcher(lines[i+1].substring(m.start()-1, m.end())).find()) {
                        add = true;
                    }
                    if (m.end() != lines[i+1].length() && symbol.matcher(lines[i+1].substring(m.start(), m.end()+1)).find()) {
                        add = true;
                    }
                }
                
                //check side
                if (m.start() != 0 && symbol.matcher(lines[i].substring(m.start()-1, m.start())).find()) {
                    add = true;
                }
                if (m.end() != lines[i].length() && symbol.matcher(lines[i].substring(m.end(), m.end()+1)).find()) {
                    add = true;
                }
                
                end = m.end();
                if (add) sum += Integer.parseInt(m.group());
            }
        }
        System.out.println(sum);
    }
}
