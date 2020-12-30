package _case_study.controllers;

import _case_study.commons.AgeComparator;
import _case_study.commons.FileUntil;
import _case_study.commons.NameComparator;
import _case_study.commons.ValidateCustomer;
import _case_study.models.Customers;
import _case_study.models.Villa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Customer {
   Scanner scanner =new Scanner(System.in);
   List<Customers> listCustomer = new ArrayList<>();
   public void addNewCustomer(){
       Customers customers = new Customers();
       System.out.println("Enter your name");
       customers.setName(ValidateCustomer.isCheckName(scanner.nextLine()));
       System.out.println("Enter your birthday");
       customers.setBirthDay(ValidateCustomer.isCheckBirthday(scanner.nextLine()));
       System.out.println("Enter your Gen");
       String gen = scanner.nextLine();
       String newGen = gen.substring(0,1).toUpperCase() + gen.substring(1).toLowerCase();
       customers.setGen(ValidateCustomer.isCheckGen(newGen));
       System.out.println("Enter your ID");
       customers.setCMND(ValidateCustomer.isCheckCMND(scanner.nextLine()));
       System.out.println("Enter your phone");
       customers.setPhone(scanner.nextLine());
       System.out.println("Enter your email");
       customers.setEmail(ValidateCustomer.isCheckEmail(scanner.nextLine()));
       System.out.println("Enter kind of customer");
       customers.setKindCustomer(scanner.nextLine());
       System.out.println("Enter address");
       customers.setAddress(scanner.nextLine());
//       System.out.println("service: 1.Villa 2.House 3.Room");
//       System.out.println("Enter number your chose");
//       customers.setServiceObj(scanner.nextLine());
       listCustomer.add(customers);

       FileUntil.writeFile("src/_case_study/data/Customer.csv",customers.getName() + "," + customers.getBirthDay() + "," + customers.getGen() + ","
               + customers.getCMND() + "," + customers.getPhone() + "," + customers.getEmail() + ","
               + customers.getKindCustomer() + "," + customers.getAddress());
   }

   public static List<Customers> readCustomer(){
       List<Customers> customers = new ArrayList<>();
       List<String[]> listStrCus = FileUntil.readFile("src/_case_study/data/Customer.csv");
       for (String[] s: listStrCus){
           Customers customers1 = new Customers(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
           customers.add(customers1);
       }
       return customers;
   }

   public static void showInformationCustomers(){
       List<Customers> customers = new ArrayList<>();
       List<String[]> listStrCus = FileUntil.readFile("src/_case_study/data/Customer.csv");
       for (String[] s: listStrCus){
           Customers customers1 = new Customers(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
           customers.add(customers1);
       }
       if (customers.isEmpty()){
           System.out.println("Danh sách trống");
           new MainController().displayMainMenu();
       } else {
//           Collections.sort(customers, new NameComparator());
//           for (Customers customers2 : customers) {
//               customers2.showInfor();
//           }
           for (int i = 0; i < customers.size(); i++){
               System.out.print(i + "-");
               customers.get(i).showInfor();
           }
       }
   }
}
