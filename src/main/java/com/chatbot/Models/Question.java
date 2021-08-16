package com.chatbot.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questions")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "question")
    private String question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uq_fk")
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "question", cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    private Answer answer;
}
