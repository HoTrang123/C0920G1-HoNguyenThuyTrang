package com.codegym.repository;

import com.codegym.model.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich, String> {

    @Query("select c from giaoDich c where c.loaiGiaoDich like %?1% and c.khachHang.tenKhachHang like %?2%")
    List<GiaoDich> search(String tenGiaoDich, String tenKhachHang);

}
