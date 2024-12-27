package com.star.quizApp.controller;

import com.star.quizApp.model.Quiz;
import com.star.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<?> getQuiz(@RequestParam String category, @RequestParam int noOfQuestions, @RequestParam String title) {
        try{
            Quiz result = quizService.createQuiz(category, noOfQuestions, title);
            return ResponseEntity.status(201).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating quiz");
        }

    }

}
