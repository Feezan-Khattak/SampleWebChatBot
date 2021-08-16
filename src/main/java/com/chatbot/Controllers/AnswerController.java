package com.chatbot.Controllers;

import com.chatbot.Models.Answer;
import com.chatbot.Services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    // Get All Answers
    @GetMapping("/getAnswers")
    ResponseEntity<List<Answer>> getAnswers(){
        List<Answer> allAnswer = answerService.getAllAnswer();
        if(allAnswer.size() < 1){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(allAnswer);
        }
    }

    // get single answer
    @GetMapping("/getAnswer/{question}")
    public ResponseEntity<List> getNewAnswer(@PathVariable String question){
        List newAnswer = answerService.getAnswer(question);
        if(newAnswer == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(newAnswer);
        }
    }

    // Add new Answer
    @PostMapping("/newAnswer")
    ResponseEntity<Answer> addAnswer(@RequestBody Answer answer){
        Answer newAnswer = answerService.addNewAnswer(answer);
        if(newAnswer == null){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(newAnswer);
        }
    }
}
