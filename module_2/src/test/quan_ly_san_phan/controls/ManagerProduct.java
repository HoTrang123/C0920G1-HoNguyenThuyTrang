package test.quan_ly_san_phan.controls;

import test.quan_ly_san_phan.commons.NotFoundProductException;
import test.quan_ly_san_phan.commons.ReadWriteFileUntil;
import test.quan_ly_san_phan.models.ExportProduct;
import test.quan_ly_san_phan.models.ImportProduct;
import test.quan_ly_san_phan.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {

    public static List<Product> readProduct() {
        List<Product> productList = new ArrayList<>();
        List<String[]> listStr = ReadWriteFileUntil.readFile("src/test/quan_ly_san_phan/datas/ProductFile.csv");
        for (String[] str : listStr) {
            if (str.length == 9) {
                ImportProduct importProduct = new ImportProduct(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], str[8]);
                productList.add(importProduct);
            } else {
                ExportProduct exportProduct = new ExportProduct(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7]);
                productList.add(exportProduct);
            }
        }
        return productList;
    }

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun) {
            System.out.println("1.\t Add Import Product\n" +
                    "2.\tAdd Export Product\n" +
                    "3.\tShow main menu\n" +
                    "4.\tExit\n");
            System.out.println("Enter a number:");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    ManagerProductImport.addImportProduct();
                    break;
                case 2:
                    ManagerProductExport.addExportProduct();
                    break;
                case 3:
                    MainController.displayMainMenu();
                case 4:
                    checkRun = false;
                    break;
                default:
                    System.out.println("Enter again");
                    addProduct();
            }
        }
    }

    public static void displayProduct() {
        List<Product> productList = readProduct();
        if (productList.isEmpty()) {
            System.out.println("Product is empty");
            MainController.displayMainMenu();
        } else {
            for (Product p : productList) {
                p.showIfo();
            }
        }
    }

    public static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun) {
            System.out.println("1.\t Delete Import Product\n" +
                    "2.\tDelete Export Product\n" +
                    "3.\tShow main menu\n" +
                    "4.\tExit\n");
            System.out.println("Enter a number:");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    ManagerProductImport.deleteProduct();
                    break;
                case 2:
                    ManagerProductExport.deleteProduct();
                    break;
                case 3:
                    MainController.displayMainMenu();
                case 4:
                    checkRun = false;
                    break;
                default:
                    System.out.println("Enter again");
                    addProduct();
            }

        }
    }

    public static void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name product to find");
        String name = scanner.nextLine();
        boolean isHas = false;
        List<Product> productList = readProduct();
        for (Product p : productList) {
            if (name.equals(p.getProductName())) {
                p.showIfo();
                isHas = true;
            }
        }
        if (!isHas) {
            System.out.println("Dont find");
            MainController.displayMainMenu();
        }

    }

    public static void editProduct() {
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun) {
            System.out.println("1.\t Edit Import Product\n" +
                    "2.\tEdit Export Product\n" +
                    "3.\tShow main menu\n" +
                    "4.\tExit\n");
            System.out.println("Enter a number:");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    ManagerProductImport.editImportProduct();
                    break;
                case 2:
                    ManagerProductExport.editExportProduct();
                    break;
                case 3:
                    MainController.displayMainMenu();
                case 4:
                    checkRun = false;
                    break;
                default:
                    System.out.println("Enter again");
                    editProduct();
            }

        }
    }
}