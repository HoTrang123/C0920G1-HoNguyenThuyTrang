package _case_study.controllers;

import _case_study.models.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class MapEmployee {
    public Map<String, Employee> showEmployee(){
        Map<String, Employee> mapEm = new TreeMap<>();


        try {
            // Đọc file theo đường dẫn
            File file = new File("src/_case_study/data/Employee.csv");

            // Đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(",");
                mapEm.put(list[0], new Employee(list[1], list[2], list[3]));
            }
            br.close();
        } catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return mapEm;
    }
    public void display(){
        Map map = new MapEmployee().showEmployee();
        Set<String> set = map.keySet();
        for (String key: set){
            System.out.println(key + '-' + map.get(key).toString());
        }
    }
}
