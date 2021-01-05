package com.trang.repositories.implement;

import com.trang.repositories.ICustomerRepository;
import com.trang.repositories.models.CustomerEDM;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository extends DBConnection implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer_manager;";
    @Override
    public List<CustomerEDM> getListCustomer() {
        List<CustomerEDM> customerEDMList = new ArrayList<>();
        Connection connection = this.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                CustomerEDM customerEDM = new CustomerEDM(id, name, age, email);
                customerEDMList.add(customerEDM);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            this.close();
        }
        return customerEDMList;
    }
}
