package repository;

import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/customers?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuytrang201197";

    private static final String SELECT_ALL_TYPE_CUSTOMER = "select * from customer_type";
    private static final String SELECT_TYPE_CUSTOMER_BY_ID = "select * from customer_type where customer_type_id =?";

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
    public List<CustomerType> selectAllTypeCustomer() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE_CUSTOMER);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("customer_type_id");
                String name = rs.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerTypeList;
    }


    @Override
    public CustomerType selectTypeCustomerById(int id) {
        CustomerType customerType = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TYPE_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("customer_type_name");
                customerType = new CustomerType(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerType;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
