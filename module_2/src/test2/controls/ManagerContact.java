package test2.controls;

import test2.commons.Validate;
import test2.models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerContact {
static Scanner scanner = new Scanner(System.in);
    static List<Contact> contactList = new ArrayList<>();
    public static void addContact(){
        Contact contact = new Contact();
        System.out.println("Enter phone");
        contact.setPhone(Validate.isCheckPhone(scanner.nextLine()));
        System.out.println("Enter group");
        contact.setGroup(Validate.isCheck(scanner.nextLine()));
        System.out.println("Enter name");
        contact.setName(Validate.isCheck(scanner.nextLine()));
        System.out.println("Enter gender");
        contact.setGender(Validate.isCheck(scanner.nextLine()));
        System.out.println("Enter address");
        contact.setAddress(Validate.isCheck(scanner.nextLine()));
        System.out.println("Enter birthday");
        contact.setBirthday(Validate.isCheck(scanner.nextLine()));
        System.out.println("Enter email");
        contact.setEmail(Validate.isCheckPhone(scanner.nextLine()));

        contactList.add(contact);
    }

    public static void showContact() {
        int count = 1;
        for (int i = 0; i < contactList.size(); i++) {
            if ((i / count / 5) == 1) {
                count++;
                scanner.nextLine();
            }
            System.out.println(contactList.get(i).toString());
        }
    }

    public static void editContact(){
        for (Contact c : contactList){
            System.out.println(c.toString());
        }
        System.out.println("Enter phone contact to edit");
        String phone = scanner.nextLine();
        boolean isHas = false;
        for (Contact c : contactList){
            if (phone.equals(c.getPhone())){
                choseToEdit(c);
                isHas = true;
                break;
            }
        }
        if (!isHas){
            System.out.println("Phone is exist");
            MainController.displayMainMenu();
        }
    }

    private static void choseToEdit(Contact contact){
        System.out.println("1.\tEdit phone\n"+
                "2.\tEdit group\n"+
                "3.\tEdit name\n"+
                "4.\tEdit Gender\n"+
                "5.\tEdit address\n"+
                "6.\tEdit birthday\n"+
                "7.\tEdit email\n"+
                "\tEnter number:\n");
        int c = scanner.nextInt();
        switch (c){
            case 1:
                System.out.println("Enter phone");
                contact.setPhone(Validate.isCheckPhone(scanner.nextLine()));
        }
    }
}
