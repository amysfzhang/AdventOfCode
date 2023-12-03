package utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;

/**
 *
 * @author amy
 */
public class Reader {
    public static String read() {
        String line, input = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/utils/input.txt"));

            while ((line = reader.readLine()) != null) {
                input += line + "\n";
            }
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return input;
    }
}
