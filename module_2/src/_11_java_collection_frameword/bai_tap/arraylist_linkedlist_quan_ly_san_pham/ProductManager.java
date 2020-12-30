package _11_java_collection_frameword.bai_tap.arraylist_linkedlist_quan_ly_san_pham;

import java.util.*;

public class ProductManager {
    private static List<Product> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void createProduct() {
        Product product = new Product();
        System.out.println("Enter id:");
        product.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter Name: ");
        product.setName(scanner.nextLine());
        System.out.println("Enter Price: ");
        product.setPrice(scanner.nextInt());
        list.add(product);
    }

    public void displayProduct() {
        for (Product p : list) {
            System.out.print("ID: " + p.getId());
            System.out.print(", Name: " + p.getName());
            System.out.println(", Price: " + p.getPrice());
        }
    }

    public void editProduct() {
        System.out.println("Enter product id to edit: ");
        int idEdit = scanner.nextInt();
        for (Product p : list) {
            if (idEdit == p.getId()) {
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
                System.out.println("Enter new name for " + p.getName() + " : ");
                String setName = scanner.nextLine();
                if (setName.equals("")){
                    p.setName(p.getName());
                }else {
                    p.setName(setName);
                }

                System.out.println("Enter new price for " + p.getPrice() + " : ");
                int setPrice = scanner.nextInt();
                p.setPrice(setPrice);
            }
        }
    }

    public void deleteProduct() {
        System.out.println("Enter product id to delete: ");
        int idDelete = scanner.nextInt();
        for (Product p : list) {
            if (idDelete == p.getId()) {
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
                System.out.println("Do you want to delete?\n1. Yes, 2. No.");
                int choose = scanner.nextInt();
                if (choose == 1) {
                    list.remove(p);
                    System.out.println("Deleted");
                } else {
                    System.out.println("Dont find ");
                    break;
                }
            }
        }
    }

    public void searchProduct() {
        System.out.println("Enter product name to display: ");
        String nameSearch = scanner.nextLine();
        for (Product p : list) {
            if (p.getName().contains(nameSearch)) {
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
            }
        }
    }

    public void sort() {
        PriceComparator priceComparator = new PriceComparator();
        Collections.sort(list, priceComparator);
        Stack<Product> myStack = new Stack<>();
        System.out.println("Do you want to show sorting up or down?\n1. Up, 2. Down");
        int numChose = scanner.nextInt();
        if (numChose == 1) {
            for (Product p : list) {
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
            }
        } else {
            for (Product p : list) {
                myStack.push(p);
            }
            for (int i = 0; i < list.size(); i++) {
                Product p = myStack.pop();
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
            }
        }
    }
}