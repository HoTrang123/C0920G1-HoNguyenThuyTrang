package com.codegym.service;

import com.codegym.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface QuestionService {
    List<Question> findAll();
    Page<Question> findAll(Pageable pageable);
    void save(Question question);
    Question findById(Integer id);
    void delete(Integer id);
//    List<Question> search(String title , Integer questionType);
//    List<GiaoDich> findAllByTenGiaoDichContainingAndKhachHang_TenKhachHang(String tenGiaoDich, String tenKhachHang);

}
