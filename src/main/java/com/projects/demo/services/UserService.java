package com.projects.demo.services;

import com.projects.demo.models.Users;
//import com.projects.demo.repositories.RoleRepo;
import com.projects.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    public UserRepo userRepo;
//    @Autowired
//    public RoleRepo roleRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public List<Users> createUsers(List<Users> users) {

//        for (Users thisuser =  users){
//
//            thisuser.setPassword(encoder.encode(thisuser.getPassword()));
//            System.out.println(thisuser.getPassword()+"Password");
////            userRepo.saveAll(users);
//
//        }
       return  userRepo.saveAll(users);

    }


    public Users createAuser(Users user){

        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);

        return user;
    }

    public Optional<List<Users>> getAllusers() {
        return Optional.of(userRepo.findAll());

    }

}
