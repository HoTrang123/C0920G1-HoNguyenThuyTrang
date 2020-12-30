package test_module_2.product;

import utilites_regex_exception_read_write_file.check_input_output.CheckInPrimeData;
import utilites_regex_exception_read_write_file.check_input_output.CheckInStringData;

public class ImportProduct extends Product {
    private double priceImportProduct;
    private String cityImport;
    private double taxImport;

    public ImportProduct() {
    }

    public static void addProduct() {
        int id = Product.getCount();
        System.out.println("Enter code product: ");
        String codeProduct = CheckInStringData.checkString();
        System.out.println("Enter name product: ");
        String nameProduct = CheckInStringData.checkString();
        System.out.println("Enter price product: ");
        double priceProduct = CheckInPrimeData.checkDoublePositive();
        System.out.println("Enter amount product: ");
        int amountProduct = CheckInPrimeData.checkIntPositive();
        System.out.println("Enter producer: ");
        String producer = CheckInStringData.checkString();
        System.out.println("Enter price import product: ");
        double priceImportProduct = CheckInPrimeData.checkDoublePositive();
        System.out.println("Enter city import: ");
        String cityImport = CheckInStringData.checkString();
        System.out.println("Enter tax import: ");
        double taxImport = CheckInPrimeData.checkDoublePositive();
        Product product = new ImportProduct(id, codeProduct, nameProduct, priceProduct, amountProduct, producer, priceImportProduct, cityImport, taxImport);
        arrProduct.add(product);
    }

    public ImportProduct(double priceImportProduct, String cityImport, double taxImport) {
        this.priceImportProduct = priceImportProduct;
        this.cityImport = cityImport;
        this.taxImport = taxImport;
    }

    public ImportProduct(int idProduct, String codeProduct, String nameProduct, double priceProduct, int amountProduct, String producer, double priceImportProduct, String cityImport, double taxImport) {
        super(idProduct, codeProduct, nameProduct, priceProduct, amountProduct, producer);
        this.priceImportProduct = priceImportProduct;
        this.cityImport = cityImport;
        this.taxImport = taxImport;
    }

    public double getPriceImportProduct() {
        return priceImportProduct;
    }

    public void setPriceImportProduct(double priceImportProduct) {
        this.priceImportProduct = priceImportProduct;
    }

    public String getCityImport() {
        return cityImport;
    }

    public void setCityImport(String cityImport) {
        this.cityImport = cityImport;
    }

    public double getTaxImport() {
        return taxImport;
    }

    public void setTaxImport(double taxImport) {
        this.taxImport = taxImport;
    }

    @Override
    public String toString() {
        return super.toString() + ',' + priceImportProduct + ',' + cityImport + ',' + taxImport;
    }
}
