package _15_IO_text_file.bai_tap.read_file_csv;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/_15_IO_text_file/bai_tap/read_file_csv/fileText.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String [] elementLine;
            while ((line = bufferedReader.readLine()) != null){
                elementLine = line.split(",");
                System.out.println(elementLine[0] +','+ elementLine[1] +',' +elementLine[2]+ ','
                        + elementLine[3] + ',' + elementLine[4] + ',' + elementLine[5]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
