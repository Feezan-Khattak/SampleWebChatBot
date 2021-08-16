package com.chatbot.Services;

import com.chatbot.Models.Question;
import com.chatbot.Repositories.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    // Get All Questions
    public List<Question> getAllQuestions(){
        return (List<Question>) questionRepo.findAll();
    }

    // Add new Question
    public Question addNewQuestion(Question question){
        Question newQuestion = null;
        try{
            newQuestion = questionRepo.save(question);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        return newQuestion;
    }

}
