package _11_java_collection_frameword.bai_tap.arraylist_linkedlist_quan_ly_san_pham;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
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
