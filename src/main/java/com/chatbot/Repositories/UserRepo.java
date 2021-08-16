package com.chatbot.Repositories;

import com.chatbot.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsernameAndUserPassword(String username, String password);
}
