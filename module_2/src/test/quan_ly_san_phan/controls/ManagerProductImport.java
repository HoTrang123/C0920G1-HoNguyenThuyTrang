package test.quan_ly_san_phan.controls;

import test.quan_ly_san_phan.commons.NotFoundProductException;
import test.quan_ly_san_phan.commons.ReadWriteFileUntil;
import test.quan_ly_san_phan.commons.Validate;
import test.quan_ly_san_phan.models.ExportProduct;
import test.quan_ly_san_phan.models.ImportProduct;
import test.quan_ly_san_phan.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProductImport {

    static int countId;

    public static void setCountId() {
        List<String[]> lineArr = ReadWriteFileUntil.readFile("src/test/quan_ly_san_phan/datas/ProductFile.csv");
        for (String[] line : lineArr) {
            if (countId < Integer.parseInt(line[0])) {
                countId = Integer.parseInt(line[0]);
            }
        }
    }

    public static void addImportProduct() {
        Scanner scanner = new Scanner(System.in);
        ImportProduct importProduct = new ImportProduct();
        setCountId();
        countId++;
        importProduct.setId(String.valueOf(countId));
        System.out.println("Enter ID product:");
        importProduct.setProductId(new Validate().isCheckProduct(scanner.nextLine()));
        System.out.println("Enter name product:");
        importProduct.setProductName(new Validate().isCheckProduct(scanner.nextLine()));
        System.out.println("Enter price product:");
        importProduct.setProductPrice(new Validate().isCheckNum(scanner.nextLine()));
        System.out.println("Enter amount product:");
        importProduct.setProductNumber(new Validate().isCheckNum(scanner.nextLine()));
        System.out.println("Enter producer:");
        importProduct.setProducer(new Validate().isCheckProduct(scanner.nextLine()));
        System.out.println("Enter import price product:");
        importProduct.setImportPrice(new Validate().isCheckNum(scanner.nextLine()));
        System.out.println("Enter import city product:");
        importProduct.setImportCity(new Validate().isCheckProduct(scanner.nextLine()));
        System.out.println("Enter import tax product:");
        importProduct.setImportTax(new Validate().isCheckNum(scanner.nextLine()));
        String line = importProduct.getId() + "," + importProduct.getProductId() + ',' + importProduct.getProductName()
                + ',' + importProduct.getProductPrice() + ',' + importProduct.getProductNumber() + ',' + importProduct.getProducer()
                + ',' + importProduct.getImportPrice() + ',' + importProduct.getImportCity() + ',' + importProduct.getImportTax();
        ReadWriteFileUntil.writeFile("src/test/quan_ly_san_phan/datas/ProductFile.csv", line);
    }

    public static List<ImportProduct> readImportProduct() {
        List<ImportProduct> importProductList = new ArrayList<>();
        List<String[]> listStr = ReadWriteFileUntil.readFile("src/test/quan_ly_san_phan/datas/ProductFile.csv");
            for (String[] str : listStr) {
                if (str.length == 9){
                ImportProduct importProduct = new ImportProduct(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], str[8]);
                importProductList.add(importProduct);
            }
        }
        return importProductList;
    }

    public static void display(List<ImportProduct> importProductList) {
        if (importProductList.isEmpty()) {
            System.out.println("Product Import is Empty");
            MainController.displayMainMenu();
        } else {
            for (ImportProduct p : importProductList) {
                p.showIfo();
            }
        }
    }

    public static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        List<ImportProduct> importProductList = readImportProduct();
        display(importProductList);
        System.out.println("Enter id product import to delete");
        String idPro = scanner.nextLine();
        boolean isHas = false;
        try {
            for (Product p : importProductList) {
                if (idPro.equals(p.getProductId())) {
                    importProductList.remove(p);
                    isYesNo(importProductList);
                    isHas = true;
                    break;
                }
            }
            if (!isHas) {
                throw new NotFoundProductException("Doesn't exist");
            }
        } catch (NotFoundProductException e) {
            e.printStackTrace();
            MainController.displayMainMenu();
        }
    }

    public static void isYesNo(List<ImportProduct> importProductList) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("1.\tYes\n" + "2.\tNo\n" + "Do you want to next?");
        int c = scanner1.nextInt();
        switch (c) {
            case 1:
                String line = "";
                for (ImportProduct p : importProductList) {
                    line += p.getId() + "," + p.getProductId() + ',' + p.getProductName()
                            + ',' + p.getProductPrice() + ',' + p.getProductNumber() + ',' + p.getProducer()
                            + ',' + p.getImportPrice() + ',' + p.getImportCity() + ',' + p.getImportTax() + '\n';
                }
                List<ExportProduct> exportProductList = ManagerProductExport.readExportProduct();
                for (ExportProduct p : exportProductList) {
                    line += p.getId() + "," + p.getProductId() + ',' + p.getProductName()
                            + ',' + p.getProductPrice() + ',' + p.getProductNumber() + ',' + p.getProducer()
                            + ',' + p.getExportPrice() + ',' + p.getExportNature() + '\n';
                }
                ReadWriteFileUntil.writeFileInNewFile("src/test/quan_ly_san_phan/datas/ProductFile.csv", line);
                break;
            default:
                MainController.displayMainMenu();
        }
    }

    public static void editImportProduct() {
        Scanner scanner = new Scanner(System.in);
        List<ImportProduct> importProductList = readImportProduct();
        display(importProductList);
        System.out.println("Enter id product import to edit");
        String idPro = scanner.nextLine();
        boolean isHas = false;
        try {
            for (ImportProduct p : importProductList) {
                if (idPro.equals(p.getProductId())) {
                    choseToEdit(p);
                    isYesNo(importProductList);
                    isNext(p);
                    isHas = true;
                    break;
                }
            }
            if (!isHas) {
                throw new NotFoundProductException("Doesn't exist");
            }
        } catch (NotFoundProductException e) {
            e.printStackTrace();
            MainController.displayMainMenu();
        }
    }
//    String productId, String productName, String productPrice, String productNumber,
//    String producer, String importPrice, String importCity, String importTax

    private static void choseToEdit(ImportProduct importProduct){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.\tEdit ID Product\n" +
                "2.\tEdit name product\n" +
                "3.\tEdit price product\n"+
                "4.\tEdit amount product\n"+
                "5.\tEdit producer\n"+
                "6.\tEdit import price\n"+
                "7.\tEdit import city\n"+
                "8.\tEdit import tax\n"+
                "\tEnter number");
        int c= scanner.nextInt();
        switch (c){
            case 1:
                scanner.nextLine();
                System.out.println("Enter new id product");
                importProduct.setProductId(new Validate().isCheckProduct(scanner.nextLine()));
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Enter new name product");
                importProduct.setProductId(new Validate().isCheckProduct(scanner.nextLine()));
                break;
            case 3:
                scanner.nextLine();
                System.out.println("Enter new price product");
                importProduct.setProductPrice(new Validate().isCheckNum(scanner.nextLine()));
                break;
            case 4:
                scanner.nextLine();
                System.out.println("Enter new amount product");
                importProduct.setProductNumber(new Validate().isCheckNum(scanner.nextLine()));
                break;
            case 5:
                scanner.nextLine();
                System.out.println("Enter new producer");
                importProduct.setProducer(new Validate().isCheckProduct(scanner.nextLine()));
                break;
            case 6:
                scanner.nextLine();
                System.out.println("Enter new import price");
                importProduct.setImportPrice(new Validate().isCheckNum(scanner.nextLine()));
                break;
            case 7:
                scanner.nextLine();
                System.out.println("Enter new import city");
                importProduct.setImportCity(new Validate().isCheckProduct(scanner.nextLine()));
                break;

            case 8:
                scanner.nextLine();
                System.out.println("Enter new import tax");
                importProduct.setImportTax(new Validate().isCheckNum(scanner.nextLine()));
                break;
            default:
                choseToEdit(importProduct);
        }
    }

    private static void isNext(ImportProduct importProduct){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.\tYes\n"+
                "2.\tNo\n"+
                "you want to edit different anything");
        int c = scanner.nextInt();
        if ( c == 1){
            choseToEdit(importProduct);
        }
        else {
            MainController.displayMainMenu();
        }
    }
}
