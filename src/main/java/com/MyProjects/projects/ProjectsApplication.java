package com.MyProjects.projects;

import com.MyProjects.projects.Models.Student;
import com.MyProjects.projects.Services.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProjectsApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(ProjectsApplication.class, args);

		Student st = context.getBean(Student.class);
//		st.setName("Roshan");
//		st.setRollNo(33);
//		st.setMarks(90);


		StudentService stdService = context.getBean(StudentService.class);
		stdService.addStudent(st);

		List<Student> st1= stdService.getStudents();
		System.out.println(st1);
	}


}
