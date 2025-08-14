package com.MyProjects.projects.Services;

import com.MyProjects.projects.Models.Student;
import com.MyProjects.projects.Repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
   private StudentRepo studentrepo;


    public void addStudent(Student st) {

      studentrepo.save(st);
    }

    public List<Student> getStudents() {
      return  studentrepo.findAll();

    }
}
