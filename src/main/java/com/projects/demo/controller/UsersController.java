package com.projects.demo.controller;
import com.projects.demo.models.*;
import com.projects.demo.services.JWTService;
import com.projects.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")//to allow from other
public class UsersController {
    @Autowired
    public UserService userService;
    @Autowired
    public AuthenticationManager authenticationManager;
    @Autowired
    public JWTService jwtService;

    @PostMapping("/createUsers")

 public List<Users> UserCreation(@RequestBody List<Users> users){
     return  userService.createUsers((users));


    }


    @PostMapping("/createAuser")

    public Users CreateAuser(@RequestBody Users user){
        return  userService.createAuser(user);


    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        try {
            // Attempt to authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            // If no exception is thrown, authentication was successful
            // You would now generate and return a JWT token here
             String token=jwtService.generateToken(user.getUsername());
             return new ResponseEntity<>(token, HttpStatus.OK);
//             new ResponseEntity<>("Success: Authenticated user " + user.getUsername(), HttpStatus.OK);


        } catch (BadCredentialsException ex) {
            // This specific exception is for invalid username or password
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);

        } catch (AuthenticationException ex) {
            // Catch any other authentication exceptions
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);

        }
    }
/*
    @PostMapping("/login")
    public String login(@RequestBody Users user){

        Authentication authentication= authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
//        return  userService.login(user);
    if (authentication.isAuthenticated())
    return "Success";
    else return "" ;

    }*/
    @GetMapping("/getAllUsers")
    public Optional<List<Users>> getAllUsers(){

       return  userService.getAllusers();

    }


}
