package com.chatbot.Controllers;

import com.chatbot.Models.User;
import com.chatbot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // Get Single user
    @GetMapping("/getUser/{id}")
    ResponseEntity<Optional<User>> getUser(@PathVariable int id){
        Optional<User> singleUser = userService.getSingleUser(id);
        return singleUser
                .map(e -> ResponseEntity.ok(singleUser))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get All users
    @GetMapping("/getUsers")
    ResponseEntity<List<User>> getUsers(){
        List<User> allUsers = userService.getAllUsers();
        if(allUsers.size() < 1){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(allUsers);
        }
    }

    // Get by userName and password
    @GetMapping("/getUser/{username}/{password}")
    ResponseEntity<User> getByUsername(@PathVariable String username, @PathVariable String password){
        User byUsernameAndPassword = userService.getByUsernameAndPassword(username, password);
        if(byUsernameAndPassword == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(byUsernameAndPassword);
        }
    }

    // Add new user
    @PostMapping("/newUser")
    ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addNewUser(user);
        if(newUser == null){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(newUser);
        }
    }

}
