package edu.neu.csye6200;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
   public static List<String> readFile(String filename){
       List <String> lines = new ArrayList();
       String line;
       try {
           BufferedReader br = new BufferedReader(new FileReader(filename));
           while (( line= br.readLine())!= null){
               lines.add(line);
           }
       }catch (IOException E){
           E.printStackTrace();
       }
       return lines;
   }
   public static void writeFile( String filename, List <String> lines){
       try{
           BufferedWriter writer=new BufferedWriter(new FileWriter(filename));
           for(String line:lines){
               writer.write(line);
               writer.newLine();
           }
           writer.close();
       } catch (IOException e){
           e.printStackTrace();
       }
   }
}
