package edu.neu.csye6200;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// item ID, ItemName, ItemPrice,
public class FileUtil {

    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public static void writeFile(String filename, List<Item> str, boolean append, String heading) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, append));
            bw.write(heading);
            bw.newLine();
            for (Item s : str) {
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
