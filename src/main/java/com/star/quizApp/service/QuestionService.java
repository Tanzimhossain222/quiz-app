package com.star.quizApp.service;

import com.star.quizApp.dao.QuestionDao;
import com.star.quizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestion() {
        return questionDao.findAll();
    }

}
