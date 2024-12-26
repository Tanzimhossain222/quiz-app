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

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategoryIgnoreCase(category);
    }


    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Question added successfully";
    }

    public Question updateQuestion(int id, Question question) {
        Question existingQuestion = questionDao.findById(id).orElse(null);

        if (existingQuestion == null) {
            return null;
        }

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
        Question existingQuestion = questionDao.findById(id).orElse(null);

        if (existingQuestion == null) {
            return "Question not found";
        }

        questionDao.deleteById(id);
        return "Question deleted successfully";
    }
}
