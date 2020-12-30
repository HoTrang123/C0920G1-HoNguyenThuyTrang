package repo;

import connection.GetConnection;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO " +
            "khachhang(id_loai_khach, ho_ten, ngay_sinh,gioi_tinh," +
            "so_cmnd,sdt,email,diachi) " +
            "VALUES(?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_CUSTOMER = "select * from khachhang";
    private static final String SELECT_CUSTOMER = "select * from khachhang where  id_khach_hang = ?";
    private static final String DELETE_CUSTOMER_SQL = "delete from khachhang where id_khach_hang = ?";
    private static final String UPDATE_CUSTOMER_SQL = "update khachhang set id_loai_khach = ?,ho_ten= ?, ngay_sinh = ?," +
            "gioi_tinh = ?,so_cmnd = ?,sdt= ?, email = ?,diachi = ? where id_khach_hang = ?";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from khachhang where ho_ten like ?";

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = GetConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = "KH-" + resultSet.getString("id_khach_hang");
                String typeId = resultSet.getString("id_loai_khach");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String gender = resultSet.getString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phone = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("diachi");
                customerList.add(new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                GetConnection.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public Customer selectCustomer(String id) {
        Customer customer = null;
        try(Connection connection = GetConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER)) {
            statement.setInt(1,Integer.parseInt(id.substring(3)));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String typeID = resultSet.getString("id_loai_khach");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String gender = resultSet.getString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phone = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("diachi");
                customer = new Customer(id,typeID,name,birthday,gender,idCard,phone,email,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        try(Connection connection = GetConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
//            statement.setInt(1,Integer.parseInt(customer.getCustomer_id().substring(3)));
            statement.setInt(1,Integer.parseInt(customer.getCustomer_type_id()));
            statement.setString(2,customer.getCustomer_name());
            statement.setString(3,customer.getCustomer_birthday());
            statement.setInt(4,Integer.parseInt(customer.getCustomer_gender()));
            statement.setString(5,customer.getCustomer_id_card());
            statement.setString(6,customer.getCustomer_phone());
            statement.setString(7,customer.getCustomer_email());
            statement.setString(8,customer.getCustomer_address());
            System.out.println(statement);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        boolean check;
        try(Connection connection = GetConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            statement.setInt(1,Integer.parseInt(id));
            check = statement.executeUpdate() > 0;
        }finally {
            GetConnection.getConnection().close();
        }
        return check;
    }


    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean check;
        try(Connection connection = GetConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            statement.setInt(1,Integer.parseInt(customer.getCustomer_type_id()));
            statement.setString(2,customer.getCustomer_name());
            statement.setString(3,customer.getCustomer_birthday());
            statement.setInt(4,Integer.parseInt(customer.getCustomer_gender()));
            statement.setString(5,customer.getCustomer_id_card());
            statement.setString(6,customer.getCustomer_phone());
            statement.setString(7,customer.getCustomer_email());
            statement.setString(8,customer.getCustomer_address());
            statement.setInt(9,Integer.parseInt(customer.getCustomer_id().substring(3)));
            check = statement.executeUpdate() > 0;
        }
        return check;
    }
    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = GetConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME)){
            statement.setString(1,"%"+name+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = "KH-" + resultSet.getString("id_khach_hang");
                String typeId = resultSet.getString("id_loai_khach");
                String name1 = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String gender = resultSet.getString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phone = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("diachi");
                customerList.add(new Customer(id, typeId, name1, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
