package repo;

import connection.GetConnection;
import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {

    private static final String SELECT_ALL_CUSTOMERTYPE = "select * from loaikhach";

    @Override
    public List<CustomerType> getAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try(Connection connection = GetConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERTYPE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id_loai_khach");
                String name = resultSet.getString("ten_loai_khach");
                customerTypeList.add(new CustomerType(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }
}
