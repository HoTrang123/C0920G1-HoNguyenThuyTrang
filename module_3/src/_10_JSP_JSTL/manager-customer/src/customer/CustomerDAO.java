package customer;

import customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private static List<Customer> list ;
    static {
        list = new ArrayList<>();
        list.add(new Customer("A", "1/1/1991", "123", "customer/anh_1.jpeg"));
        list.add(new Customer("B", "2/1/1991", "123", ""));
        list.add(new Customer("C", "1/3/1991", "123", ""));
    }
    public static List<Customer> getCustomerList(){
        return list;
    }
}
