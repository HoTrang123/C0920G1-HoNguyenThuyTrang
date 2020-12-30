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

public class ManagerProductExport {

    static int countId;

    public static void setCountId() {
        List<String[]> lineArr= ReadWriteFileUntil.readFile("src/test/quan_ly_san_phan/datas/ProductFile.csv");
        for (String[] line : lineArr) {
            if (countId < Integer.parseInt(line[0])) {
                countId = Integer.parseInt(line[0]);
            }
        }
    }

    public static void addExportProduct(){
        Scanner scanner = new Scanner(System.in);
        ExportProduct exportProduct = new ExportProduct();
        setCountId();
        countId++;

        exportProduct.setId(String.valueOf(countId));
        System.out.println("Enter ID product:");
        exportProduct.setProductId( new Validate().isCheckProduct(scanner.nextLine()));
        System.out.println("Enter name product:");
        exportProduct.setProductName(new Validate().isCheckProduct(scanner.nextLine()));
        System.out.println("Enter price product:");
        exportProduct.setProductPrice( new Validate().isCheckNum(scanner.nextLine()));
        System.out.println("Enter amount product:");
        exportProduct.setProductNumber(new Validate().isCheckNum(scanner.nextLine()));
        System.out.println("Enter producer:");
        exportProduct.setProducer(new Validate().isCheckProduct(scanner.nextLine()));
        System.out.println("Enter export price product:");
        exportProduct.setExportPrice(new Validate().isCheckNum(scanner.nextLine()));
        System.out.println("Enter import nature product:");
        exportProduct.setExportNature(new Validate().isCheckProduct(scanner.nextLine()));

        String line = exportProduct.getId() + "," + exportProduct.getProductId()+','+ exportProduct.getProductName()
                +',' +exportProduct.getProductPrice()+','+ exportProduct.getProductNumber() + ','+ exportProduct.getProducer()
                +','+ exportProduct.getExportPrice() +','+ exportProduct.getExportNature();
        ReadWriteFileUntil.writeFile("src/test/quan_ly_san_phan/datas/ProductFile.csv", line);
    }

    public static List<ExportProduct> readExportProduct() {
        List<ExportProduct> exportProductList = new ArrayList<>();
        List<String[]> listStr = ReadWriteFileUntil.readFile("src/test/quan_ly_san_phan/datas/ProductFile.csv");

            for (String[] str : listStr) {
                if (str.length == 8) {
                ExportProduct exportProduct = new ExportProduct(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7]);
                exportProductList.add(exportProduct);
            }
        }
        return exportProductList;
    }

    public static void display(List<ExportProduct> exportProductlist) {
        if (exportProductlist.isEmpty()) {
            System.out.println("Product Export is empty");
            MainController.displayMainMenu();
        } else {
            for (ExportProduct p : exportProductlist) {
                p.showIfo();
            }
        }
    }

    public static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        List<ExportProduct> exportProductList = readExportProduct();
        display(exportProductList);
        System.out.println("Enter id product export to delete");
        String idPro = scanner.nextLine();
        boolean isHas = false;
        try {
            for (Product p : exportProductList) {
                if (idPro.equals(p.getProductId())) {
                    exportProductList.remove(p);
                    isYesNo(exportProductList);
                    isHas = true;
                    break;
                }
            }
            if (!isHas) {
                throw new NotFoundProductException("Doesn't exist!");
            }
        } catch (NotFoundProductException e) {
            e.printStackTrace();
            MainController.displayMainMenu();
        }
    }

    public static void isYesNo(List<ExportProduct> exportProductList) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("1.\tYes\n" + "2.\tNo\n" + "Do you want to next?");
        int c = scanner1.nextInt();
        switch (c) {
            case 1:
                String line = "";
                for (ExportProduct p : exportProductList) {
                    line += p.getId() + "," + p.getProductId() + ',' + p.getProductName()
                            + ',' + p.getProductPrice() + ',' + p.getProductNumber() + ',' + p.getProducer()
                            + ',' + p.getExportPrice() + ',' + p.getExportNature();
                }
                List<ImportProduct> importProductList = ManagerProductImport.readImportProduct();
                for (ImportProduct p : importProductList) {
                    line += p.getId() + "," + p.getProductId() + ',' + p.getProductName()
                            + ',' + p.getProductPrice() + ',' + p.getProductNumber() + ',' + p.getProducer()
                            + ',' + p.getImportPrice() + ',' + p.getImportCity() +','+p.getImportTax();
                }
                ReadWriteFileUntil.writeFileInNewFile("src/test/quan_ly_san_phan/datas/ProductFile.csv", line);
                break;
            default:
                MainController.displayMainMenu();
        }
    }

    public static void editExportProduct() {
        Scanner scanner = new Scanner(System.in);
        List<ExportProduct> exportProductList = readExportProduct();
        display(exportProductList);
        System.out.println("Enter id product export to edit");
        String idPro = scanner.nextLine();
        boolean isHas = false;
        try {
            for (ExportProduct p : exportProductList) {
                if (idPro.equals(p.getProductId())) {
                    choseToEdit(p);
                    isYesNo(exportProductList);
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

    private static void choseToEdit(ExportProduct exportProduct){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.\tEdit ID Product\n" +
                "2.\tEdit name product\n" +
                "3.\tEdit price product\n"+
                "4.\tEdit amount product\n"+
                "5.\tEdit producer\n"+
                "6.\tEdit export price\n"+
                "7.\tEdit export nature\n"+
                "\tEnter number");
        int c= scanner.nextInt();
        switch (c){
            case 1:
                scanner.nextLine();
                System.out.println("Enter new id product");
                exportProduct.setProductId(new Validate().isCheckProduct(scanner.nextLine()));
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Enter new name product");
                exportProduct.setProductId(new Validate().isCheckProduct(scanner.nextLine()));
                break;
            case 3:
                scanner.nextLine();
                System.out.println("Enter new price product");
                exportProduct.setProductPrice(new Validate().isCheckNum(scanner.nextLine()));
                break;
            case 4:
                scanner.nextLine();
                System.out.println("Enter new amount product");
                exportProduct.setProductNumber(new Validate().isCheckNum(scanner.nextLine()));
                break;
            case 5:
                scanner.nextLine();
                System.out.println("Enter new producer");
                exportProduct.setProducer(new Validate().isCheckProduct(scanner.nextLine()));
                break;
            case 6:
                scanner.nextLine();
                System.out.println("Enter new import price");
                exportProduct.setExportPrice(new Validate().isCheckNum(scanner.nextLine()));
                break;
            case 7:
                scanner.nextLine();
                System.out.println("Enter new import city");
                exportProduct.setExportNature(new Validate().isCheckProduct(scanner.nextLine()));
                break;
            default:
                choseToEdit(exportProduct);
        }
    }

    private static void isNext(ExportProduct exportProduct){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.\tYes\n"+
                "2.\tNo\n"+
                "you want to edit different anything");
        int c = scanner.nextInt();
        if ( c == 1){
            choseToEdit(exportProduct);
        }
        else {
            MainController.displayMainMenu();
        }
    }
}
