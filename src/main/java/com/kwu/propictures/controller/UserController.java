package com.kwu.propictures.controller;

import com.kwu.propictures.model.User;
import com.kwu.propictures.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins={"http://localhost:8081", "http://localhost:3000"})
@RestController
@RequestMapping("/userapi/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User addNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }
}
