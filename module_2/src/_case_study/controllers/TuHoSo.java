package _case_study.controllers;

import _case_study.models.Employee;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class TuHoSo {
    public static Stack<Employee> employeeStack = new Stack<>();

    static {

        for (Map.Entry<String, Employee> employeeEntry: new MapEmployee().showEmployee().entrySet()){
            employeeStack.push(employeeEntry.getValue());
        }
    }

    public static void find(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter name employee to find");
        String name = scanner.nextLine();
        Employee employee = findHSNV(name);

        if (employee!= null){
            System.out.println("File employee:" + employee.toString());
        } else {
            System.out.println("Dont find");
        }
    }

    public static Employee findHSNV(String name){
        Employee employee = null;

        while (!employeeStack.isEmpty()){
            employee = employeeStack.pop();
            if (employee.getNameEmployee() == name){
                return employee;
            }
        }
        return employee;
    }


}
