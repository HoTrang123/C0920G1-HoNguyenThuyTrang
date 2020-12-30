package _case_study.commons;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateService {
    static Scanner scanner = new Scanner(System.in);
    public static String isCheckNameService(String nameService){
        final String REGEX_NAME_SERVICE = "^[A-Z][a-z]+$";
        while (true) {
            if (Pattern.matches(REGEX_NAME_SERVICE, nameService)) {
                return nameService;
            }
            else {
                System.out.println("Nhap khong dung dinh dang, hay nhap lai");
                nameService = scanner.nextLine();
            }
        }

    }

    public static String isCheckAreaService(String area){
        final String REGEX_AREA_SERVICE = "^([3-9][0-9]|[1-9][0-9][0-9]+)([.][0-9]+)?$";
        while (true){
            if (Pattern.matches(REGEX_AREA_SERVICE, area)){
                return area;
            } else {
                System.out.println("Nhap khong dung dinh dang, hay nhap lai");
                area = scanner.nextLine();
            }
        }
    }

    public static String isCheckPrice(String price){
        final String REGEX_PRICE = "^[0-9]+$";
        while (true) {
            if (Pattern.matches(REGEX_PRICE, price)) {
                return price;
            } else {
                System.out.println("Nhap khong dung dinh dang, hay nhap lai");
                price = scanner.nextLine();
            }
        }
    }

    public static String isCheckMaxPerson(String maxPerson){
        final String REGEX_MAX_PERSON = "^[1-9]|(1[0-9])$";
        while (true){
            if (Pattern.matches(REGEX_MAX_PERSON, maxPerson)){
                return maxPerson;
            } else {
                System.out.println("Nhap khong dung dinh dang, hay nhap lai");
                maxPerson = scanner.nextLine();
            }
        }

    }

    public static String isCheckDifferentService(String differentService){
        final String REGEX_DIFFERENT_SERVICE = "(massage)|(karaoke)|(food)|(drink)|(car)";
        while (true){
            if (Pattern.matches(REGEX_DIFFERENT_SERVICE, differentService)){
                return differentService;
            }
            else {
                System.out.println("Nhap khong dung dinh dang, hay nhap lai");
                differentService = scanner.nextLine();
            }
        }
    }
}
