package _11_java_collection_frameword.bai_tap.product;

public class Comparator implements java.util.Comparator<Product> {
    @Override
    public int compare(Product product, Product product1) {
        if (product.getPrice() > product1.getPrice()){
            return 1;
        } else if (product.getPrice() == product1.getPrice()){
            return 0;
        } else {
            return -1;
        }
    }
}
