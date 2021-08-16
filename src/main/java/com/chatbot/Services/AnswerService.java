package com.chatbot.Services;

import com.chatbot.Models.Answer;
import com.chatbot.Repositories.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    // Get All Answers
    public List<Answer> getAllAnswer(){
        return (List<Answer>) answerRepo.findAll();
    }

    // Add New Answer
    public Answer addNewAnswer(Answer answer){
        Answer newAnswer = null;
        try{
            newAnswer = answerRepo.save(answer);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        return newAnswer;
    }

    /// get single answer by question
    public List getAnswer(String question){
        List answerByQuestion = null;
        try{
            answerByQuestion = answerRepo.getAnswerByQuestion(question);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        return answerByQuestion;
    }
}
