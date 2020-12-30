package repository.employee;

import model.employee.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements PositionRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuytrang201197";

    private static final String SELECT_ALL_POSITION = "select * from positions";


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
    public List<Position> getAllPosition() {
        List<Position> positionList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_POSITION)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("position_id");
                String name = resultSet.getString("position_name");
                positionList.add(new Position(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }
}
