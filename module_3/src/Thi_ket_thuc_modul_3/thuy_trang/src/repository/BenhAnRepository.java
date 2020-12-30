package repository;

import model.BenhAn;

import java.sql.SQLException;
import java.util.List;

public interface BenhAnRepository {
    public List<BenhAn> selectAllBenhAn();

    public BenhAn selectBenhAnById(int id);

    public void insertBenhAn(BenhAn benhAn) throws SQLException;

    public boolean deleteBenhAn(int id) throws SQLException;

    public boolean updateBenhAn(BenhAn benhAn) throws SQLException;
}
