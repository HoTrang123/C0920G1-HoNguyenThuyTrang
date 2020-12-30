package repository.customer;

import model.customer.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuytrang201197";

    private static final String GET_ALL_CUSTOMER_TYPE = "SELECT * FROM customer_type";
    private static final String GET_CUSTOMER_TYPE_BY_ID = "SELECT * FROM customer_type where customer_type_id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_CUSTOMER_TYPE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }

    @Override
    public CustomerType selectTypeCustomerById(int id) {
        CustomerType customerType = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_TYPE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("customer_type_name");
                customerType = new CustomerType(id, name);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerType;
    }
}
