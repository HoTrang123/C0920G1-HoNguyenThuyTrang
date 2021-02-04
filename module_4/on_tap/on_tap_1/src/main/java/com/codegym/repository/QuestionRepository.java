package com.codegym.repository;

import com.codegym.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("select c from question c where c.title like %?1% and c.questionType.name like %?2%")
    List<Question> search(String title, String questionType);

}
