package com.codegym.service.impl;

import com.codegym.model.Question;
import com.codegym.repository.QuestionRepository;
import com.codegym.repository.UserRepository;
import com.codegym.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;




    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findById(Integer id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

//    @Override
//    public List<Question> search(String title, Integer questionType) {
//        return questionRepository.search( title , questionType);
//    }


//    @Override
//    public List<GiaoDich> findAllByTenGiaoDichContainingAndKhachHang_TenKhachHang(String tenGiaoDich, String tenKhachHang) {
//        return giaoDichRepository.findAllByTenGiaoDichContainingAndKhachHang_TenKhachHang(tenGiaoDich,tenKhachHang);
//    }
}
