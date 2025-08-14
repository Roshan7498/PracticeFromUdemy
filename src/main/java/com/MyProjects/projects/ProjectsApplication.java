package com.MyProjects.projects;

import com.MyProjects.projects.Models.Student;
import com.MyProjects.projects.Services.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.sql.*;

@SpringBootApplication
public class ProjectsApplication {

	public static void main(String[] args)  {

		ApplicationContext context =SpringApplication.run(ProjectsApplication.class, args);

		Student st = context.getBean(Student.class);
		st.setName("Roshan");
//		st.setRollNo(33);
		st.setMarks(90);


		StudentService stdService = context.getBean(StudentService.class);
		stdService.addStudent(st);

		List<Student> st1= stdService.getStudents();
		System.out.println(st1);



//        String url="sqlserver://localhost:1433;databaseName=UdemyTest;encrypt=true;trustServerCertificate=true";
//        String user= "Roshan";
//        String password="passw0rd";
//        try(Connection conn = DriverManager.getConnection(url,user,password)){
//            System.out.println("Connection Established");
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }

	}


}
