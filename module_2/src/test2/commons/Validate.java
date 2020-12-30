package test2.commons;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    static Scanner scanner = new Scanner(System.in);
    public static String isCheck(String name){
        final String REGEX = "[\\w]+";
        while (true) {
            if (Pattern.matches(REGEX, name)) {
                return name;
            } else {
                System.out.println("Fail, Enter again: ");
                name = scanner.nextLine();
            }
        }
    }

    public static String isCheckEmail(String email){
        final String REGEX_EMAIL = "\\w+@\\w*(.\\w+)+";
        while (true) {
            if (Pattern.matches(REGEX_EMAIL, email)) {
                return email;
            } else {
                System.out.println("Email must have format to be abc@abc.abc, enter again");
                email = scanner.nextLine();
            }
        }
    }

    public static String isCheckPhone(String phone){
        final String REGEX_PHONE = "0[\\d]{9}";
        while (true) {
            if (Pattern.matches(REGEX_PHONE, phone)) {
                return phone;
            } else {
                System.out.println("Phone phai dung dinh dang 0xxxxxxxx, hay nhap lai");
                phone = scanner.nextLine();
            }
        }
    }
}
