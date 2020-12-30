package thi_ket_thuc_modul_2.commons;


import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    Scanner scanner = new Scanner(System.in);
    public String isCheck (String string){
        final String REGEX = "[ \\w\\s\\n\\f]+";
        while (true) {
            if (Pattern.matches(REGEX, string)) {
                return string;
            }
            else {
                System.out.println("Nhap khong dung dinh dang, hay nhap lai");
                string = scanner.nextLine();
            }
        }

    }
}
