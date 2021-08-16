package com.chatbot.Repositories;

import com.chatbot.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

}
