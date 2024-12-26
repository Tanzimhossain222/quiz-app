package com.star.quizApp.service;

import com.star.quizApp.dao.QuestionDao;
import com.star.quizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestion() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategoryIgnoreCase(category);
    }

    public String addQuestion(Question question) {
        try {
            questionDao.save(question);
            return "Question added successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error saving question", e);
        }
    }

    public Question updateQuestion(int id, Question question) {
        Optional<Question> existingQuestionOpt = questionDao.findById(id);

        if (existingQuestionOpt.isEmpty()) {
            return null;
        }

        Question existingQuestion = existingQuestionOpt.get();
        existingQuestion.setQuestionTitle(question.getQuestionTitle());
        existingQuestion.setOption1(question.getOption1());
        existingQuestion.setOption2(question.getOption2());
        existingQuestion.setOption3(question.getOption3());
        existingQuestion.setOption4(question.getOption4());
        existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
        existingQuestion.setCategory(question.getCategory());
        existingQuestion.setDifficultyLevel(question.getDifficultyLevel());

        return questionDao.save(existingQuestion);
    }

    public Question getQuestionById(int id) {
        return questionDao.findById(id).orElse(null);
    }

    public String deleteQuestion(int id) {
        Optional<Question> existingQuestionOpt = questionDao.findById(id);

        if (existingQuestionOpt.isEmpty()) {
            return "Question not found";
        }

        questionDao.deleteById(id);
        return "Question deleted successfully";
    }
}
