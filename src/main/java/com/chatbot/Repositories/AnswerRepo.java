package com.chatbot.Repositories;

import com.chatbot.Models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer, Integer> {

    @Query(value = "SELECT answers.id, answers.answer, answers.question_question_id FROM answers JOIN questions ON answers.question_question_id = questions.question_id WHERE questions.question = :givenQuestion", nativeQuery = true)
    List getAnswerByQuestion(@Param("givenQuestion") String givenQuestion);
}
