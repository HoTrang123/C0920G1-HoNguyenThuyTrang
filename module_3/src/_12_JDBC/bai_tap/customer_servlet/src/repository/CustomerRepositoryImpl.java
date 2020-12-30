package repository;

import model.Customer;
import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/customers?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuytrang201197";
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    private static final String SELECT_ALL_CUSTOMER = "select * from customer";

    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id =?";

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + "  (customer_type_id, customer_name, " +
            "customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";

    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?, customer_name = ?, " +
            "customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?," +
            " customer_address = ? where customer_id = ?;";

    private static final String SEARCH_CUSTOMER_BY_NAME = "select * from customer where customer_name like ? ";

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
    public List<Customer> selectAllCustomer() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customerList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                CustomerType customerType = customerTypeRepository.selectTypeCustomerById(rs.getInt("customer_type_id"));
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customerList.add(new Customer(id, customerType, name, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerList;
    }



    @Override
    public Customer selectCustomerById(int id) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id1 = rs.getInt("customer_id");
                CustomerType customerType = customerTypeRepository.selectTypeCustomerById(rs.getInt("customer_type_id"));
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customer = new Customer(id1, customerType, name, birthday, gender, idCard, phone, email, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {

            preparedStatement.setInt(1, customer.getCustomerTypeId().getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setString(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {

            preparedStatement.setInt(1, customer.getCustomerTypeId().getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setString(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Customer> searchCustomer(String name) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME)){
            statement.setString(1,"%"+name+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("customer_id");
                CustomerType customerType = customerTypeRepository.selectTypeCustomerById(rs.getInt("customer_type_id"));
                String name1 = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customerList.add(new Customer(id, customerType, name1, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
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
