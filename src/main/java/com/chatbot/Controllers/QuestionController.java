package com.chatbot.Controllers;

import com.chatbot.Models.Question;
import com.chatbot.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Get All question
    @GetMapping("/getQuestions")
    ResponseEntity<List<Question>> getUsers(){
        List<Question> allQuestions = questionService.getAllQuestions();
        if(allQuestions.size() < 1) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(allQuestions);
        }
    }

    // Add New Question
    @PostMapping("/newQuestion")
    ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question newQuestion = questionService.addNewQuestion(question);
        if(newQuestion == null){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(newQuestion);
        }
    }

}
