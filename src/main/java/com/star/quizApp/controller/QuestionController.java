package com.star.quizApp.controller;

import com.star.quizApp.model.Question;
import com.star.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getQuestions() {
        try {
            List<Question> questions = questionService.getAllQuestion();
            if (questions.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(questions);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        try {
            List<Question> questions = questionService.getQuestionsByCategory(category);
            if (questions.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(questions);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable int id) {
        Question question = questionService.getQuestionById(id);
        if (question == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(question);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        try {
            String result = questionService.addQuestion(question);
            return ResponseEntity.status(201).body(result); // Created
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding question");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable int id, @RequestBody Question question) {
        try {
            Question updatedQuestion = questionService.updateQuestion(id, question);
            if (updatedQuestion == null) {
                return ResponseEntity.status(404).build();
            }
            return ResponseEntity.ok(updatedQuestion);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        try {
            String result = questionService.deleteQuestion(id);
            if ("Question not found".equals(result)) {
                return ResponseEntity.status(404).body(result);
            }
            return ResponseEntity.status(200).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting question");
        }
    }
}
