package test_module_2.product;

import utilites_regex_exception_read_write_file.check_input_output.CheckInPrimeData;
import utilites_regex_exception_read_write_file.check_input_output.CheckInStringData;
import utilites_regex_exception_read_write_file.reader_writer_utilities.FileUtilities;

import java.io.*;
import java.util.*;

public abstract class Product {
    private int idProduct;
    private String codeProduct;
    private String nameProduct;
    private double priceProduct;
    private int amountProduct;
    private String producer;
    private static int count = 1;
    static List<Product> arrProduct = new ArrayList<>();

    public Product() {
    }

    public Product(int idProduct, String codeProduct, String nameProduct, double priceProduct, int amountProduct, String producer) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.amountProduct = amountProduct;
        this.producer = producer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public static int getCount() {
        return count++;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public static void deleteProduct() {
        System.out.println("Enter code product want to delete: ");
        String codeProduct = CheckInStringData.checkString();
        boolean checkFind = false;
        int d = -1;
        for (int i = 0; i < arrProduct.size(); i++) {
            if (codeProduct.equals(arrProduct.get(i).getCodeProduct())) {
                checkFind = true;
                d = i;
                break;
            }
        }
        if (checkFind) {
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println("Enter your choice: ");
            int choice = CheckInPrimeData.checkIntPositive();
            if (choice == 1) {
                arrProduct.remove(d);
                showProduct();
                try {
                    writeFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                menu();
            } else if (choice == 2) {
                showProduct();
                menu();
            } else {
                System.out.println("Do not choice");
                deleteProduct();
            }
        } else {
            System.out.println("DO NOT find product!");
            deleteProduct();
        }
    }

    public static void searchProduct() {
        System.out.println("Input code product want to search: ");
        String codeProduct = CheckInStringData.checkString();
        boolean checkFind = false;
        for (Product product : arrProduct) {
            if (codeProduct.equals(product.getCodeProduct())) {
                System.out.println(product.toString());
                checkFind = true;
                break;
            }
        }
        if (!checkFind) {
            System.out.println("Do NOT find product!");
        }
    }

    public static void showProduct() {
        for (Product product : arrProduct) {
            System.out.println(product.toString() + '\n');
        }
    }

    public static void readFile() {
        List<String> arrListStr = null;
        try {
            arrListStr = FileUtilities.readFileAsListOfStrings("src/test_module_2/product/products.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert arrListStr != null;
        for (String str : arrListStr) {
            List<String> arrStr = new ArrayList<>();
            arrStr = Arrays.asList(str.split(","));
            if (arrStr.size() == 9) {
                Product importProduct = new ImportProduct(Integer.parseInt(arrStr.get(0)), arrStr.get(1), arrStr.get(2), Double.parseDouble(arrStr.get(3)), Integer.parseInt(arrStr.get(4)), arrStr.get(5), Double.parseDouble(arrStr.get(6)), arrStr.get(7), Double.parseDouble(arrStr.get(8)));
                arrProduct.add(importProduct);

            } else {
                Product exportProduct = new ExportProduct(Integer.parseInt(arrStr.get(0)), arrStr.get(1), arrStr.get(2), Double.parseDouble(arrStr.get(3)), Integer.parseInt(arrStr.get(4)), arrStr.get(5), Double.parseDouble(arrStr.get(6)), arrStr.get(7));
                arrProduct.add(exportProduct);
            }
        }
    }

    public static void writeFile() throws IOException {
        File file = new File("src/test_module_2/product/products.csv");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        for (Product product : arrProduct) {
            out.write(product.toString());
            out.newLine();
        }
        out.close();
    }

    public static void exit() {
        System.out.println("Exit!");
        System.exit(0);
    }

    public static void checkId() {
        if (arrProduct.size() > 1) {
            int maxId = arrProduct.get(0).getIdProduct();
            for (Product product : arrProduct) {
                if (maxId < product.getIdProduct()) {
                    maxId = product.getIdProduct();
                }
            }
            Product.setCount(maxId + 1);
        }
    }

    public static void menu() {
        System.out.println("1. Add product.");
        System.out.println("2. Delete product by CodeProduct.");
        System.out.println("3. Show array product.");
        System.out.println("4. Search product by CodeProduct.");
        System.out.println("5. Exit.");
        System.out.println("Enter your choice: ");
        switch (CheckInPrimeData.checkIntPositive()) {
            case 1:
                System.out.println("1. Add import product.");
                System.out.println("2. Add export product.");
                System.out.println("Enter your choice: ");
                int choice = CheckInPrimeData.checkIntPositive();
                if (choice == 1) {
                    ImportProduct.addProduct();
                    try {
                        writeFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    menu();
                } else if (choice == 2) {
                    ExportProduct.addProduct();
                    try {
                        writeFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    menu();
                } else {
                    System.out.println("Do not choice");
                    menu();
                }
                break;
            case 2:
                try {
                    deleteProduct();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    writeFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                showProduct();
                menu();
                break;
            case 4:
                searchProduct();
                menu();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Do not choice!");
                menu();
        }
    }

    public String toString() {
        return "" + idProduct + ',' + codeProduct + ',' + nameProduct + ',' + priceProduct + ',' + amountProduct + ',' + producer;
    }
}