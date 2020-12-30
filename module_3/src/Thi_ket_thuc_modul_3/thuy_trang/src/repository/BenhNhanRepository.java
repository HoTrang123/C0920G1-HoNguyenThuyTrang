package repository;

import model.BenhNhan;

import java.util.List;

public interface BenhNhanRepository {
    public List<BenhNhan> selectAllBenhNhan();
    public BenhNhan selectBenhNhanById(int id);
}
