package _case_study.controllers;

import _case_study.commons.FileUntil;
import _case_study.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Booking {
    Scanner scanner = new Scanner(System.in);

    public void addNewBooking(Services service) {
        Customer.showInformationCustomers();
        System.out.println("Enter your chose customer:");
        int c = scanner.nextInt();
        boolean checkRun = true;
        while (checkRun) {
            for (int i = 0; i < Customer.readCustomer().size(); i++) {
                if (c == i) {
                    checkRun = false;
//                    Customers customersNew = new Customers(Customer.readCustomer().get(i).getName(),
//                            Customer.readCustomer().get(i).getBirthDay(), Customer.readCustomer().get(i).getGen(),
//                            Customer.readCustomer().get(i).getCMND(), Customer.readCustomer().get(i).getPhone(),
//                            Customer.readCustomer().get(i).getEmail(), Customer.readCustomer().get(i).getKindCustomer(),
//                            Customer.readCustomer().get(i).getAddress(), service);
                    FileUntil.writeFile("src/_case_study/data/Booking.csv", Customer.readCustomer().get(i).getName() +
                            "," + Customer.readCustomer().get(i).getBirthDay() + "," + Customer.readCustomer().get(i).getGen() + ","
                            + Customer.readCustomer().get(i).getCMND() + "," + Customer.readCustomer().get(i).getPhone() + ","
                            + Customer.readCustomer().get(i).getEmail() + "," + Customer.readCustomer().get(i).getKindCustomer()
                            + "," + Customer.readCustomer().get(i).getAddress() + "," + service);
                    new MainController().displayMainMenu();

                    break;
                }
            }
            if (checkRun) {
                System.out.println("Hay nhap lai");
                c = scanner.nextInt();
            }
        }
    }

    public void booking() {
        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        System.out.println("Enter your choose booking");
        int c = scanner.nextInt();
        switch (c) {
            case 1:
                List<Villa> villas = new ArrayList<>();
                List<String[]> listStrVilla = FileUntil.readFile("src/_case_study/data/Villa.csv");
                for (String[] s : listStrVilla) {
                    Villa villa = new Villa(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9]);
                    villas.add(villa);
                }
                List<Integer> list1 = new ArrayList<>();
                if (villas.isEmpty()) {
                    System.out.println("Danh sách trống");
                    new MainController().displayMainMenu();
                } else {
                    for (int i = 0; i < villas.size(); i++) {
                        System.out.print(i + "-");
                        villas.get(i).showInfor();
                        list1.add(i);
                    }
                }
                System.out.println("Enter your choose villa");
                int v = scanner.nextInt();
                boolean ckeckRunV = true;
                while (ckeckRunV) {
                    for (Integer i : list1) {
                        if (v == i) {
                            ckeckRunV = false;
                            addNewBooking(villas.get(v));
                            break;
                        }
                    }
                    if (ckeckRunV) {
                        System.out.println("Hay nhap lai");
                        v = scanner.nextInt();
                    }
                }


            case 2:
                List<House> houses = new ArrayList<>();
                List<String[]> listHouseStr = FileUntil.readFile("src/_case_study/data/House.csv");
                for (String[] s : listHouseStr) {
                    House house = new House(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8]);
                    houses.add(house);
                }
                List<Integer> list2 = new ArrayList<>();
                if (houses.isEmpty()) {
                    System.out.println("Danh sách trống");
                    new MainController().displayMainMenu();
                } else {
                    for (int i = 0; i < houses.size(); i++) {
                        System.out.print(i + "-");
                        houses.get(i).showInfor();
                        list2.add(i);
                    }
                }
                System.out.println("Enter your choose house");
                int h = scanner.nextInt();
                boolean ckeckRunH = true;
                while (ckeckRunH) {
                    for (Integer i : list2) {
                        if (h == i) {
                            ckeckRunH = false;
                            addNewBooking(houses.get(h));
                            break;
                        }
                    }
                    if (ckeckRunH) {
                        System.out.println("Hay nhap lai");
                        h = scanner.nextInt();
                    }
                }
            case 3:
                List<Room> rooms = new ArrayList<>();
                List<String[]> listRoomStr = FileUntil.readFile("src/_case_study/data/Room.csv");
                for (String[] s : listRoomStr) {
                    Room room = new Room(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);
                    rooms.add(room);
                }
                List<Integer> list3 = new ArrayList<>();
                if (rooms.isEmpty()) {
                    System.out.println("Danh sách trống");
                    new MainController().displayMainMenu();
                } else {
                    for (int i = 0; i < rooms.size(); i++) {
                        System.out.print(i + "-");
                        rooms.get(i).showInfor();
                        list3.add(i);
                    }
                }
                System.out.println("Enter your choose room");
                int r = scanner.nextInt();
                boolean ckeckRunR = true;
                while (ckeckRunR) {
                    for (Integer i : list3) {
                        if (r == i) {
                            ckeckRunH = false;
                            addNewBooking(rooms.get(r));
                            break;
                        }
                    }
                    if (ckeckRunR) {
                        System.out.println("Hay nhap lai");
                        r = scanner.nextInt();
                    }
                }
            default:
                System.out.println("Hay nhap lai");
                booking();
        }
    }
}
