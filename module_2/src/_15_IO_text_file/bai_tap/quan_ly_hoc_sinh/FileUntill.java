package _15_IO_text_file.bai_tap.quan_ly_hoc_sinh;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntill {
    public static List<String> readFile(String filePath){
        FileReader fileReader = null;
        List<String> list = new ArrayList<>();
        try {
            fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                list.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
     public static void writeFile(String filePath, String line){
         try {
             FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             bufferedWriter.write(line);
             bufferedWriter.newLine();
             bufferedWriter.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
