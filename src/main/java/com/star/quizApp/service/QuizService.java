package com.star.quizApp.service;

import com.star.quizApp.dao.QuestionDao;
import com.star.quizApp.dao.QuizDao;
import com.star.quizApp.model.Question;
import com.star.quizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
  private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;


    public Quiz createQuiz(String category, int noOfQuestions, String title) {
        try{
            System.out.println(category+ " "  +noOfQuestions + " "  + title);
            List<Question> questions = questionDao.findRandomQuestionsByCategory(category, noOfQuestions);
            System.out.println("Questions: " + questions);

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);

            System.out.println("Quiz: " + quiz);
            quizDao.save(quiz);
            return quiz;
        } catch (Exception e) {
            throw new RuntimeException("Error creating quiz", e);
        }

    }
}
