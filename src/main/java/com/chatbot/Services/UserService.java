package com.chatbot.Services;

import com.chatbot.Models.User;
import com.chatbot.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // Get Single User By Id
    public Optional<User> getSingleUser(int id){
        return userRepo.findById(id);
    }

    // Get All Users
    public List<User> getAllUsers(){
        return (List<User>) userRepo.findAll();
    }

    // Get by username and password
    public User getByUsernameAndPassword(String username, String passwrod){
       return userRepo.findByUsernameAndUserPassword(username, passwrod);
    }

    // add New User
    public User addNewUser(User user){
        User newUser = null;
        try {
            newUser = userRepo.save(user);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        return newUser;
    }

}
