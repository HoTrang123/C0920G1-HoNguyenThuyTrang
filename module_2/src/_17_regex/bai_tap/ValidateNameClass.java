package _17_regex.bai_tap;

import java.util.regex.Pattern;

public class ValidateNameClass {
    public static boolean isCheckRegexNamwClass(String nameClass){
        final String REGEXNAMECLASS = "^[ACP]\\d{4}[GHIKLM]$";
        boolean check;
        check = Pattern.matches(REGEXNAMECLASS, nameClass);
        return check;
    }

    public static void main(String[] args) {
        System.out.println(isCheckRegexNamwClass("C0920G"));
        System.out.println(isCheckRegexNamwClass("C0318G"));
        System.out.println(isCheckRegexNamwClass("M0318G"));
        System.out.println(isCheckRegexNamwClass("P0323A"));
    }
}
