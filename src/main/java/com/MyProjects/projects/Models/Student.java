package com.MyProjects.projects.Models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
//@Scope("prototype")
public class Student {
    private int rollNo;
    private String Name;
    private int marks;
}
