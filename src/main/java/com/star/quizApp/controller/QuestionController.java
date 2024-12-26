package com.star.quizApp.controller;

import com.star.quizApp.model.Question;
import com.star.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable int id){
        return questionService.getQuestionById(id);
    }


    @PostMapping("/add")
    public  String addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }

    @PutMapping("/update/{id}")
    public  Question updateQuestion (@PathVariable int id, @RequestBody Question question){
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }


}
