package _case_study.commons;

import java.sql.CallableStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateCustomer {
    static Scanner scanner = new Scanner(System.in);
    public static String isCheckBirthday(String birthday){
        final String REGEX_BIRTH = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
        while (true) {
            if (Pattern.matches(REGEX_BIRTH, birthday)) {
                long currentTime = System.currentTimeMillis();
                Date date = null;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    date = simpleDateFormat.parse(birthday);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                assert date != null;
                long millisecondsBirth =  date.getTime();
                long millisecondsAge = currentTime - millisecondsBirth;
                long rateMilliToYear = 60*60*24*365;
                long age = millisecondsAge / (rateMilliToYear * 1000);
                if (age >= 18){
                    return birthday;
                }
                else {
                    System.out.println("Nhap khong du 18 tuoi, hay nhap lai");
                    birthday = scanner.nextLine();
                }
            } else {
                System.out.println("Nhap khong dung dinh dang, hay nhap lai");
                birthday = scanner.nextLine();
            }
        }
    }

    public static String isCheckName(String name){
        final String REGEX_NAME = "([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ]" +
                "([a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)[ ])+" +
                "[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ]" +
                "([a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)$";
//        final String REGEX_NAME = "([A-Z][a-z]*[ ])*([A-Z][a-z]*)";
        while (true) {
            if (Pattern.matches(REGEX_NAME, name)) {
                return name;
            } else {
                System.out.println("Nhap khong dung dinh dang, hay nhap lai");
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
                System.out.println("Email phai dung dinh dang abc@abc.abc, hay nhap lai");
                email = scanner.nextLine();
            }
        }
    }

    public static String isCheckGen(String gen){
        final String REGEX_GEN = "(Male)|(Female)|(Unknow)";
        while (true){
            if (Pattern.matches(REGEX_GEN, gen)){
                return gen;
            }
            else {
                System.out.println("Nhap khong dung dinh dang, hay nhap lai");
                gen = scanner.nextLine();
            }
        }
    }

    public static String isCheckCMND(String cmnd){
        final String REGEX_CMND = "(\\d{3}[ ]){2}[\\d]{3}";
        while (true){
            if (Pattern.matches(REGEX_CMND, cmnd)){
                return cmnd;
            }
            else {
                System.out.println("CMND phai co 9 chu so va theo dinh dang XXX XXX XXX, hay nhap lai");
                cmnd = scanner.nextLine();
            }
        }
    }
}
