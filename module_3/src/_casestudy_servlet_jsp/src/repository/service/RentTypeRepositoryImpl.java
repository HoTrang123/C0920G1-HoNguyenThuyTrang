package repository.service;

import model.service.RentType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements RentTypeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuytrang201197";

    private static final String SELECT_ALL_RENT_TYPE = "select * from rent_type";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<RentType> getAll() {
        List<RentType> serviceTypeList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_RENT_TYPE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                String cost = resultSet.getString("rent_type_cost");
                serviceTypeList.add(new RentType(id,name,cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
