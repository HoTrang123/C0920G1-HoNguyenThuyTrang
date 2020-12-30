package test_module_2.officers;

import utilites_regex_exception_read_write_file.regex.RegexToString;
import utilites_regex_exception_read_write_file.check_input_output.CheckInPrimeData;
import utilites_regex_exception_read_write_file.check_input_output.CheckInStringData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerOfficers {
    private static List<Officers> arrListOfficers = new ArrayList<>();

    public static void managerMenu() {
        System.out.println("Select menu: ");
        System.out.println("1.Add officer.");
        System.out.println("2.Search officer by name.");
        System.out.println("3.Show officer.");
        System.out.println("4.Exit.");
        switch (CheckInPrimeData.checkIntPositive()) {
            case 1:
                addOfficer();
                managerMenu();
                break;
            case 2:
                searchOfficer();
                managerMenu();
                break;
            case 3:
                showOfficer();
                managerMenu();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Enter your select again!");
                managerMenu();
        }
    }

    public static void addOfficer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your select:");
        System.out.println("1. Add Worker.");
        System.out.println("2. Add Engineer.");
        System.out.println("3. Add Employee.");
        switch (CheckInPrimeData.checkIntPositive()) {
            case 1:
                System.out.println("Enter your full name: ");
                String nameWorker = CheckInStringData.checkString();
                System.out.println("Enter your age: ");
                int ageWorker = CheckInPrimeData.checkIntPositive();
                System.out.println("Enter your gender: ");
                String genderWorker = RegexToString.regexGender(input.nextLine());
                System.out.println("Enter your address: ");
                String addressWorker = CheckInStringData.checkString();
                System.out.println("Enter your level: ");
                int level = CheckInPrimeData.checkIntPositive();
                Officers worker = new Worker(nameWorker, ageWorker, genderWorker, addressWorker, level);
                arrListOfficers.add(worker);
                break;
            case 2:
                System.out.println("Enter your full name: ");
                String nameEngineer = CheckInStringData.checkString();
                System.out.println("Enter your age: ");
                int ageEngineer = CheckInPrimeData.checkIntPositive();
                System.out.println("Enter your gender: ");
                String genderEngineer = RegexToString.regexGender(input.nextLine());
                System.out.println("Enter your address: ");
                String addressEngineer = CheckInStringData.checkString();
                System.out.println("Enter your majorEducate: ");
                String majorEducate = CheckInStringData.checkString();
                Officers engineer = new Engineer(nameEngineer, ageEngineer, genderEngineer, addressEngineer, majorEducate);
                arrListOfficers.add(engineer);
                break;
            case 3:
                System.out.println("Enter your full name: ");
                String nameEmployee = CheckInStringData.checkString();
                System.out.println("Enter your age: ");
                int ageEmployee = CheckInPrimeData.checkIntPositive();
                System.out.println("Enter your gender: ");
                String genderEmployee = RegexToString.regexGender(input.nextLine());
                System.out.println("Enter your address: ");
                String addressEmployee = CheckInStringData.checkString();
                System.out.println("Enter your job: ");
                String job = CheckInStringData.checkString();
                Officers employee = new Employee(nameEmployee, ageEmployee, genderEmployee, addressEmployee, job);
                arrListOfficers.add(employee);
                break;
            default:
                System.out.println("Enter your select again");
                addOfficer();
        }
    }

    public static void searchOfficer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input name officer want to search: ");
        String name = input.nextLine();
        boolean checkFind = false;
        for (Officers officers : arrListOfficers) {
            if (name.equals(officers.getName())) {
                System.out.println(officers.toString());
                checkFind = true;
                break;
            }
        }
        if (!checkFind) {
            System.out.println("Do NOT find officer!");
        }
    }

    public static void showOfficer() {
        for (Officers officers : arrListOfficers) {
            System.out.println(officers.toString() + "\n");
        }
    }

    public static void exit() {
        System.out.println("Exit!");
        System.exit(0);
    }
}
