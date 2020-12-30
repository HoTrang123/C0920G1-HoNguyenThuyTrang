package repository.employee;

import model.employee.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuytrang201197";


    private static final String SELECT_ALL_DIVISION = "select * from user";


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
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DIVISION)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("username");
                String passWord = resultSet.getString("password");
                userList.add(new User(name,passWord));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}