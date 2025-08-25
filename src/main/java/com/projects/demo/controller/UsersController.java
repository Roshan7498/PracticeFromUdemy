package com.projects.demo.controller;
import com.projects.demo.models.*;
import com.projects.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")//to allow from other
public class UsersController {
    @Autowired
    public UserService userService;

    @PostMapping("/createUsers")

 public List<Users> UserCreation(@RequestBody List<Users> users){
     return  userService.createUsers((users));


    }


    @PostMapping("/createAuser")

    public Users CreateAuser(@RequestBody Users user){
        return  userService.createAuser(user);


    }
    @GetMapping("/getAllUsers")
    public Optional<List<Users>> getAllUsers(){

       return  userService.getAllusers();

    }


}
