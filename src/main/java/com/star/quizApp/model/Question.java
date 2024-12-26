package com.star.quizApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private  String questionTitle;
//    private String option1;
//    private String option2;
//    private String option3;
//    private String option4;
//    private String correctAnswer;
//    private String difficultyLevel;
//    private String category;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("question_title")
    private String questionTitle;

    @JsonProperty("option1")
    private String option1;

    @JsonProperty("option2")
    private String option2;

    @JsonProperty("option3")
    private String option3;

    @JsonProperty("option4")
    private String option4;

    @JsonProperty("correct_answer")
    private String correctAnswer;

    @JsonProperty("difficulty_level")
    private String difficultyLevel;

    @JsonProperty("category")
    private String category;

}
