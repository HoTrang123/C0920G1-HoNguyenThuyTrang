package test.quan_ly_san_phan.models;

public class ExportProduct extends Product {
    private String exportPrice;
    private String exportNature;

    public ExportProduct() {
    }

    public ExportProduct(String exportPrice, String exportNature) {
        this.exportPrice = exportPrice;
        this.exportNature = exportNature;
    }

    public ExportProduct(String id, String productId, String productName, String productPrice, String productNumber, String producer, String exportPrice, String exportNature) {
        super(id, productId, productName, productPrice, productNumber, producer);
        this.exportPrice = exportPrice;
        this.exportNature = exportNature;
    }

    public String getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(String exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getExportNature() {
        return exportNature;
    }

    public void setExportNature(String exportNature) {
        this.exportNature = exportNature;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ExportProduct{" +
                "exportPrice='" + exportPrice + '\'' +
                ", exportNature='" + exportNature + '\'' +
                '}';
    }

    @Override
    public void showIfo() {
        System.out.println(this.toString());
    }
}
