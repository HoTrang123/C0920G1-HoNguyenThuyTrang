package _case_study.controllers;

import _case_study.commons.FileUntil;
import _case_study.models.Customers;

import java.util.*;

public class MuaVe {
    public void showMuaVe() {
        Scanner scanner = new Scanner(System.in);
        Queue<Customers> customersQueue = new LinkedList<>();
        List<Customers> customers = new ArrayList<>();
        List<String[]> listStrCus = FileUntil.readFile("src/_case_study/data/Customer.csv");
        for (String[] s : listStrCus) {
            Customers customers1 = new Customers(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
            customers.add(customers1);
        }
        int countSize = customers.size();
        for (int j = 0; j < countSize; j++) {
            int i = 0;
            for (i = 0; i < customers.size(); i++) {
                System.out.print(i + "-");
                customers.get(i).showInfor();
            }
            System.out.println("Enter your chose customer " + j);
            int c = scanner.nextInt();
            customersQueue.add(customers.get(c));
            customers.remove(c);
        }
        if (customers.size() == 0) {
            System.out.println("Danh sach xuat ve:");
            int countQueue = customersQueue.size();
            for (int i = 0; i < countQueue; i++){
                System.out.println(customersQueue.poll());
            }
        }
    }
}
