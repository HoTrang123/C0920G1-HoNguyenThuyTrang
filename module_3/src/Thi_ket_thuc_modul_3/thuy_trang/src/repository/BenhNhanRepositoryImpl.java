package repository;

import model.BenhNhan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepositoryImpl implements BenhNhanRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/danh_sach_benh_an?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuytrang201197";

    private static final String SELECT_ALL_BENHNHAN = "select * from benh_nhan";
    private static final String SELECT_BENHNHAN_BY_ID = "select * from benh_nhan where id_benh_nhan =?";

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
    public List<BenhNhan> selectAllBenhNhan() {
        List<BenhNhan> benhNhanList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BENHNHAN);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id_benh_nhan");
                String name = rs.getString("ten_benh_nhan");
                benhNhanList.add(new BenhNhan(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benhNhanList;
    }

    @Override
    public BenhNhan selectBenhNhanById(int id) {
        BenhNhan benhNhan = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENHNHAN_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ten_benh_nhan");
                benhNhan = new BenhNhan(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benhNhan;
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
