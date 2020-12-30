package _03_array_method_in_java.array.thuc_hanh.tim_gtri_trong_mang;

import java.util.Scanner;

public class TimGiaTri {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name student: ");
        String inputName = scanner.nextLine();
        boolean check = false;
        for (int i =0; i<students.length; i++){
            if (students[i].equals(inputName)){
                System.out.print("Position of the students in the list " + inputName + " is: " + (i + 1));
                check = true;
                break;
            }
        }
        while (!check){
            System.out.print("Not found" + inputName + " in the list.");

        }
    }
}
