package _case_study.controllers;

import _case_study.models.House;
import _case_study.models.Room;
import _case_study.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {

    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        Customer customer = new Customer();
        Booking booking = new Booking();
        boolean check = true;
        while (check){
            System.out.println("1.\tAdd New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tBooking movie tickets\n"+
                    "8.\tFind employee records\n"+
                    "9.\tExit\n");
            System.out.println("Enter a number:");
            int a = scanner.nextInt();
            switch (a){
                case 1:
                    service.addNewServices();
                    break;
                case 2:
                    service.showServices();
                    break;
                case 3:
                    customer.addNewCustomer();
                    break;
                case 4:
                    customer.showInformationCustomers();
                    break;
                case 5:
                    new Booking().booking();
                    break;
                case 6:
                    new MapEmployee().display();
                    break;
                case 7:
                    new MuaVe().showMuaVe();
                    break;
                case 8:
                    new TuHoSo().find();
                    break;
                case 9:
                    check = false;
            }
        }
    }
}
