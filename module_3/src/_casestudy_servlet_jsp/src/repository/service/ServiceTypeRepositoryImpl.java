package repository.service;

import model.service.ServiceType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuytrang201197";

    private static final String SELECT_ALL_SERVICE_TYPE = "select * from service_type";

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
    public List<ServiceType> getAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("service_type_id");
                String name = resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
