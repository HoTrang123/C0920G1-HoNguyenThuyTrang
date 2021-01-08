package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> productMap;
     static {
         productMap = new HashMap<>();
         productMap.put(1, new Product(1, "Iphone5", 2000, "h1.jpg.jp2", 200));
         productMap.put(2, new Product(2, "Iphone6", 6000, "h2.jpg", 200));
         productMap.put(3, new Product(3, "Iphone7", 7000, "h3.jpg", 200));

     }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
     }

    @Override
    public void save(Product product) {


    }

    @Override
    public void update(int id, Product product) {
         productMap.put(product.getId(), product);

    }

    @Override
    public void remove(int id) {

         productMap.remove(id);
    }
}

//
//@Override
//public List findAll() {
//        return new ArrayList<>(customers.values());
//        }
//
//@Override
//public void save(Customer customer) {
//
//        customers.put(customer.getId(), customer);
//        }
//
//@Override
//public Customer findById(int id) {
//
//        }
//
//@Override
//public void update(int id, Customer customer) {
//        customers.put(id, customer);
//
//        }
//
//@Override
//public void remove(int id) {
//        customers.remove(id);
//        }