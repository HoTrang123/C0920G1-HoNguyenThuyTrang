package _11_java_collection_frameword.bai_tap.product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager= new ProductManager();
        Scanner scanner = new Scanner(System.in);

        boolean check = true;
        while (check){
            System.out.println("1. Add a product.");
            System.out.println("2. Edit a product.");
            System.out.println("3. Delete a product.");
            System.out.println("4. Display product list.");
            System.out.println("5. Find products.");
            System.out.println("6. Sort product by price.");
            System.out.println("0. Stop");
            System.out.println("Enter a number: ");
            int a = scanner.nextInt();
            switch (a){
                case 1:
                    productManager.add();
                    break;
                case 2:
                    productManager.edit();
                    break;
                case 3:
                    productManager.delete();
                    break;
                case 4:
                    productManager.display();
                    break;
                case 5:
                    productManager.find();
                    break;
                case 6:
                    productManager.sort();
                    break;
                case 0:
                    check= false;
            }
        }
    }
}
