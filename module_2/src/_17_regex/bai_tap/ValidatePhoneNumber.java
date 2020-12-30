package _17_regex.bai_tap;

import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    public static boolean isCheckRegexPhone(String phoneNumber){
//        final String REGEX = "^[(][8][4][)][-][(][0]\\d{9}[)]$";
        final String REGEX = "^\\(\\d{2}\\)\\-\\(0\\d{9}\\)$";
        boolean check = Pattern.matches(REGEX, phoneNumber);
        return check;
    }

    public static void main(String[] args) {
        System.out.println(isCheckRegexPhone("(84)-(0123456789)"));
        System.out.println(isCheckRegexPhone("(84)-456789)"));
        System.out.println(isCheckRegexPhone("(84)-(01234569)"));
        System.out.println(isCheckRegexPhone("(84)-(0123456789)"));
    }
}
