package com.star.quizApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @RequestMapping("/")
    public String getQuestions(){
        return "What is the capital of Dhaka?";
    }

}
