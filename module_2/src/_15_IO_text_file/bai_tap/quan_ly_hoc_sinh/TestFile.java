package _15_IO_text_file.bai_tap.quan_ly_hoc_sinh;

import java.util.ArrayList;
import java.util.List;

public class TestFile {
    public static void main(String[] args) {
        List<String> arr = FileUntill.readFile("src/_15_IO_text_file/bai_tap/quan_ly_hoc_sinh/readFile.csv");
        System.out.println(arr);
        for (String stringline : arr){
            FileUntill.writeFile("src/_15_IO_text_file/bai_tap/quan_ly_hoc_sinh/writerFile.csv", stringline);

        }
    }
}
