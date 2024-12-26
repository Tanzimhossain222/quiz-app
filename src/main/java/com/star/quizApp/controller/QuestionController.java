package com.star.quizApp.controller;

import com.star.quizApp.model.Question;
import com.star.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/allQuestions")
    public List<Question> getQuestions(){
        return questionService.getAllQuestion();
    }

}
