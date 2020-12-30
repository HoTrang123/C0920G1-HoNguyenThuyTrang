package repository;

import model.BenhAn;
import model.BenhNhan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepositoryImpl implements BenhAnRepository{
    private String jdbcURL = "jdbc:mysql://localhost:3306/danh_sach_benh_an?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuytrang201197";

    BenhNhanRepository benhNhanRepository = new BenhNhanRepositoryImpl();

    private static final String SELECT_ALL_BENHAN = "select * from benh_an";

    private static final String SELECT_BENHAN_BY_ID = "select * from benh_an where id_benh_an =?";

    private static final String INSERT_BENHAN_SQL = "INSERT INTO benh_an" + "  (id_benh_nhan, " +
            "ngay_nhap_vien, ngay_ra_vien, ly_do_nhap_vien) VALUES " +
            " (?, ?, ?, ?);";

    private static final String DELETE_BENHAN_SQL = "delete from benh_an where id_benh_an = ?;";

    private static final String UPDATE_BENHAN_SQL = "update benh_an set id_benh_nhan = ?, ngay_nhap_vien = ?, " +
            "ngay_ra_vien = ?, ly_do_nhap_vien = ?, " + " where id_benh_an = ?;";

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
    public List<BenhAn> selectAllBenhAn() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<BenhAn> benhAnList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BENHAN);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id_benh_an");
                BenhNhan benhNhan = benhNhanRepository.selectBenhNhanById(rs.getInt("id_benh_nhan"));
                String ngay_nhap_vien = rs.getString("ngay_nhap_vien");
                String ngay_ra_vien = rs.getString("ngay_ra_vien");
                String ly_do_nhap_vien = rs.getString("ly_do_nhap_vien");
                benhAnList.add(new BenhAn(id, benhNhan, ngay_nhap_vien, ngay_ra_vien, ly_do_nhap_vien));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benhAnList;
    }

    @Override
    public BenhAn selectBenhAnById(int id) {
        BenhAn benhAn = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENHAN_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id1 = rs.getInt("id_benh_an");
                BenhNhan benhNhan = benhNhanRepository.selectBenhNhanById(rs.getInt("id_benh_nhan"));
                String ngay_nhap_vien = rs.getString("ngay_nhap_vien");
                String ngay_ra_vien = rs.getString("ngay_ra_vien");
                String ly_do_nhap_vien = rs.getString("ly_do_nhap_vien");
                 benhAn = new BenhAn(id1, benhNhan, ngay_nhap_vien, ngay_ra_vien, ly_do_nhap_vien);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benhAn;
    }

    @Override
    public void insertBenhAn(BenhAn benhAn) throws SQLException {
        System.out.println(INSERT_BENHAN_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BENHAN_SQL)) {

            preparedStatement.setInt(1, benhAn.getBenhNhanId().getId());
            preparedStatement.setString(2, benhAn.getNgayNhapVien());
            preparedStatement.setString(3, benhAn.getNgayRaVien());
            preparedStatement.setString(4, benhAn.getLyDoNhapVien());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean deleteBenhAn(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BENHAN_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBenhAn(BenhAn benhAn) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENHAN_SQL);) {

            preparedStatement.setInt(1, benhAn.getBenhNhanId().getId());
            preparedStatement.setString(2, benhAn.getNgayNhapVien());
            preparedStatement.setString(3, benhAn.getNgayRaVien());
            preparedStatement.setString(4, benhAn.getLyDoNhapVien());
            preparedStatement.setInt(9, benhAn.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
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
