package test_module_2.product;

import utilites_regex_exception_read_write_file.check_input_output.CheckInPrimeData;
import utilites_regex_exception_read_write_file.check_input_output.CheckInStringData;

public class ExportProduct extends Product {
    private double priceExportProduct;
    private String cityExport;

    public ExportProduct() {
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
        System.out.println("Enter price export product: ");
        double priceExportProduct = CheckInPrimeData.checkDoublePositive();
        System.out.println("Enter city export: ");
        String cityExport = CheckInStringData.checkString();
        Product product = new ExportProduct(id, codeProduct, nameProduct, priceProduct, amountProduct, producer, priceExportProduct, cityExport);
        arrProduct.add(product);
    }

    public ExportProduct(double priceExportProduct, String cityExport) {
        this.priceExportProduct = priceExportProduct;
        this.cityExport = cityExport;
    }

    public ExportProduct(int idProduct, String codeProduct, String nameProduct, double priceProduct, int amountProduct, String producer, double priceExportProduct, String cityExport) {
        super(idProduct, codeProduct, nameProduct, priceProduct, amountProduct, producer);
        this.priceExportProduct = priceExportProduct;
        this.cityExport = cityExport;
    }

    public double getPriceExportProduct() {
        return priceExportProduct;
    }

    public void setPriceExportProduct(double priceExportProduct) {
        this.priceExportProduct = priceExportProduct;
    }

    public String getCityExport() {
        return cityExport;
    }

    public void setCityExport(String cityExport) {
        this.cityExport = cityExport;
    }

    @Override
    public String toString() {
        return super.toString() + ',' + priceExportProduct + ',' + cityExport;

    }
}
