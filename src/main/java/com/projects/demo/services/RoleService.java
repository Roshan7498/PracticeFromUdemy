//package com.projects.demo.services;
//
//import com.projects.demo.models.Role;
//import com.projects.demo.models.Users;
//import com.projects.demo.repositories.RoleRepo;
//import com.projects.demo.repositories.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class RoleService {
//@Autowired
//public RoleRepo roleRepo;
//
//@Autowired
//public UserRepo userRepo;
//
//    public Users createUser(Users user, List<String> roleNames) {
//        List<Role> roles = roleNames.stream()
//                .map(roleName -> roleRepo.findByRoleName(roleName)
//                        .orElseGet(() -> roleRepo.save(new Role(roleName))))
//                .collect(Collectors.toList());
//
//        user.setRoles(roles);
//        return userRepo.save(user);
//    }
//}
