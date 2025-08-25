//package com.projects.demo.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor   // ✅ Needed by Hibernate
//@AllArgsConstructor
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int roleId;
//
//    @Column(unique = true, nullable = false)   // ✅ Prevents duplicates at DB level
//    private String roleName;
//
//    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Users> users = new ArrayList<>();
//
//    // Convenience constructor (optional)
//    public Role(String roleName) {
//        this.roleName = roleName;
//    }
//}
