package test.quan_ly_san_phan.commons;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    Scanner scanner = new Scanner(System.in);
    public String isCheckProduct (String string){
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

    public String isCheckNum (String string){
        final String REGEX = "[0-9]+";
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
