package com.star.quizApp.service;

import com.star.quizApp.dao.QuestionDao;
import com.star.quizApp.dao.QuizDao;
import com.star.quizApp.exception.ResourceNotFoundException;
import com.star.quizApp.model.Question;
import com.star.quizApp.model.QuestionWrapper;
import com.star.quizApp.model.Quiz;
import com.star.quizApp.model.ResponseQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
  private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;


    public Quiz createQuiz(String category, int noOfQuestions, String title) {
        try{

            List<Question> questions = questionDao.findRandomQuestionsByCategory(category, noOfQuestions);

            if (questions.isEmpty()) {
                throw new ResourceNotFoundException("No questions found for the given category.");
            }

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);

            quizDao.save(quiz);
            return quiz;
        } catch (Exception e) {
            throw new RuntimeException("Error creating quiz", e);
        }

    }

    public List<QuestionWrapper> getQuizQuestions(int id) {

        Quiz quiz = quizDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quiz with ID " + id + " not found"));
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        List<Question> questions = quiz.getQuestions();

            for (Question q : questions) {
                QuestionWrapper questionWrapper = new QuestionWrapper(
                        q.getId(),
                        q.getQuestionTitle(),
                        q.getOption1(),
                        q.getOption2(),
                        q.getOption3(),
                        q.getOption4()
                );
                questionWrappers.add(questionWrapper);
            }

            return questionWrappers;

    }

    public int calculateResult(int id, List<ResponseQuiz> response) {
     Quiz quiz = quizDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quiz with ID " + id + " not found"));


        List<Question> questions = quiz.getQuestions();

        Map<Integer, Question> questionMap = questions.stream()
                .collect(Collectors.toMap(Question::getId, question -> question));

        int score = 0;

        for (ResponseQuiz res: response){
            Question question = questionMap.get(res.getId());
            if (question != null && question.getCorrectAnswer().equals(res.getResponse())){
                score++;
            }
        }
        return score;


    }
}
