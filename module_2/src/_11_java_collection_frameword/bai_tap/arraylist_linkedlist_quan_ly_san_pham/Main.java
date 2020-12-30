package _11_java_collection_frameword.bai_tap.arraylist_linkedlist_quan_ly_san_pham;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        boolean check = true;
        while (check){
            int a;
            System.out.println("1. Create a product.");
            System.out.println("2. Edit a product.");
            System.out.println("3. Delete a product.");
            System.out.println("4. Show product list.");
            System.out.println("5. Find products.");
            System.out.println("6. Reverse product by price.");
            System.out.println("0. Stop");
            System.out.println("Enter a number: ");
            a = scanner.nextInt();

            switch (a){
                case 1: {
                    productManager.createProduct();
                    break;
                }
                case 2: {
                    productManager.editProduct();
                    break;
                }
                case 3: {
                    productManager.deleteProduct();
                    break;
                }
                case 4: {
                    productManager.displayProduct();
                    break;
                }
                case 5: {
                    productManager.searchProduct();
                    break;
                }
                case 6: {
                    productManager.sort();
                    break;
                }
                case 0: check = false;
                    break;
            }

        }
    }
}
