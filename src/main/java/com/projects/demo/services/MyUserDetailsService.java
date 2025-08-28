package com.projects.demo.services;

//import com.projects.demo.models.UserDetailsImpl;
import com.projects.demo.models.UserDetailsImpl;
import com.projects.demo.models.Users;
import com.projects.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user= userRepo.findByUsername(username);

       if(user==null){

           System.out.println("User 404");
           throw new UsernameNotFoundException("Username not found");
       }
        return new UserDetailsImpl(user);
    }


}
