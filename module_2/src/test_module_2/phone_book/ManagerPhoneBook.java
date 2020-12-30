package test_module_2.phone_book;

import utilites_regex_exception_read_write_file.check_input_output.CheckInPrimeData;
import utilites_regex_exception_read_write_file.check_input_output.CheckInStringData;
import utilites_regex_exception_read_write_file.reader_writer_utilities.FileUtilities;
import utilites_regex_exception_read_write_file.regex.RegexToString;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManagerPhoneBook {
    static List<PhoneBook> arrListPhoneBook = new ArrayList<>();

    public static void menu() {
        System.out.println("------PROGRAMMING MANAGER PHONE BOOK------");
        System.out.println("Select functions by number (to continue)!");
        System.out.println("1. Watch phone book.");
        System.out.println("2. Add new phone book.");
        System.out.println("3. Update phone book.");
        System.out.println("4. Delete phone book.");
        System.out.println("5. Search phone book.");
        System.out.println("6. Read file phone book.");
        System.out.println("7. Write file phone book.");
        System.out.println("8. Exit.");
        System.out.println("Select function: ");
        switch (CheckInPrimeData.checkIntPositive()) {
            case 1:
                displayPhoneBook();
                menu();
                break;
            case 2:
                addPhoneBook();
                menu();
                break;
            case 3:
                updatePhoneBook();
                menu();
                break;
            case 4:
                deletePhoneBook();
                menu();
                break;
            case 5:
                searchPhoneBook();
                menu();
                break;
            case 6:
                readFilePhoneBook();
                menu();
                break;
            case 7:
                writeFilePhoneBook();
                menu();
                break;
            case 8:
                exit();
                break;
            default:
                System.out.println("Do not have select!");
                menu();
        }
    }

    public static void displayPhoneBook() {
        for (PhoneBook phoneBook : arrListPhoneBook) {
            System.out.println(phoneBook.toString() + "\n");
        }
    }

    public static void addPhoneBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your full name: ");
        String name = CheckInStringData.checkString();
        System.out.println("Enter your phone number: ");
        String phoneNumber = RegexToString.regexPhoneNumber(input.nextLine());
        System.out.println("Enter group phone book: ");
        String group = CheckInStringData.checkString();
        System.out.println("Enter your gender (Male/Female): ");
        String gender = RegexToString.regexGender(input.nextLine());
        System.out.println("Enter your address: ");
        String address = CheckInStringData.checkString();
        System.out.println("Enter your birthday (dd/MM/yyyy): ");
        String birthday = RegexToString.regexDate(input.nextLine());
        System.out.println("Enter your email (abc@abc.abc): ");
        String email = RegexToString.regexEmail(input.nextLine());
        PhoneBook phoneBook = new PhoneBook(name, group, phoneNumber, gender, address, birthday, email);
        arrListPhoneBook.add(phoneBook);
    }

    public static void updatePhoneBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter phone number want to update: ");
        String phoneNumber = RegexToString.regexPhoneNumber(input.nextLine());
        boolean checkFind = false;
        for (PhoneBook phoneBook : arrListPhoneBook) {
            if (phoneNumber.equals(phoneBook.getPhoneNumber())) {
                System.out.println("Enter new group: ");
                String group = CheckInStringData.checkString();
                System.out.println("Enter new full name: ");
                String name = CheckInStringData.checkString();
                System.out.println("Enter your gender (Male/Female): ");
                String gender = RegexToString.regexGender(input.nextLine());
                System.out.println("Enter new address: ");
                String address = CheckInStringData.checkString();
                System.out.println("Enter your birthday (dd/MM/yyyy): ");
                String birthday = RegexToString.regexDate(input.nextLine());
                System.out.println("Enter your email (abc@abc.abc): ");
                String email = RegexToString.regexEmail(input.nextLine());
                phoneBook.setAddress(address);
                phoneBook.setBirthday(birthday);
                phoneBook.setEmail(email);
                phoneBook.setGender(gender);
                phoneBook.setGroup(group);
                phoneBook.setName(name);
                checkFind = true;
                break;
            }
        }
        if (!checkFind) {
            System.out.println("Do NOT find phone number!");
        }
    }

    public static void deletePhoneBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter phone number want to delete: ");
        String phoneNumber = RegexToString.regexPhoneNumber(input.nextLine());
        boolean checkFind = false;
        int d = -1;
        for (int i = 0; i < arrListPhoneBook.size(); i++) {
            if (phoneNumber.equals(arrListPhoneBook.get(i).getPhoneNumber())) {
                checkFind = true;
                d = i;
                break;
            }
        }
        if (checkFind) {
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println("Enter your select: ");
            int choice = CheckInPrimeData.checkIntPositive();
            if (choice == 1) {
                arrListPhoneBook.remove(d);
                menu();
            } else if (choice == 2) {
                menu();
            } else {
                System.out.println("Do not select!");
                deletePhoneBook();
            }
        } else {
            System.out.println("DO NOT find phone number!");
            deletePhoneBook();
        }
    }

    public static void searchPhoneBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input phone number want to search: ");
        String phoneNumber = input.nextLine();
        boolean checkFind = false;
        for (PhoneBook phoneBook : arrListPhoneBook) {
            if (phoneNumber.equals(phoneBook.getPhoneNumber())) {
                System.out.println(phoneBook.toString());
                checkFind = true;
                break;
            }
        }
        if (!checkFind) {
            System.out.println("Do NOT find phone number!");
        }
    }

    public static void readFilePhoneBook() {
        List<String> arrListStr = null;
        try {
            arrListStr = FileUtilities.readFileAsListOfStrings("src/test_module_2/phone_book/phonebook.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert arrListStr != null;
        for (String str : arrListStr) {
            List<String> arrStr = new ArrayList<>();
            arrStr = Arrays.asList(str.split(","));
            PhoneBook phoneBook = new PhoneBook(arrStr.get(0), arrStr.get(1), arrStr.get(2), arrStr.get(3), arrStr.get(4), arrStr.get(5), arrStr.get(6));
            arrListPhoneBook.add(phoneBook);
        }
    }

    public static void writeFilePhoneBook() {
        File file = new File("src/test_module_2/phone_book/phonebook.csv");
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (PhoneBook phoneBook : arrListPhoneBook) {
            try {
                assert out != null;
                out.write(phoneBook.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            assert out != null;
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exit() {
        System.out.println("Exit!");
        System.exit(0);
    }
}
