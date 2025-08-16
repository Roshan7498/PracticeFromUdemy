package com.JPA.SpringDataJPAwala;
import com.JPA.SpringDataJPAwala.Models.Vidyaarthi;
import com.JPA.SpringDataJPAwala.Repos.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJPAwalaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringDataJPAwalaApplication.class, args);

		StudentRepository studentRepo = context.getBean(StudentRepository.class);

		// Correct way (no getBean for entity)
		Vidyaarthi st = new Vidyaarthi();
//		Vidyaarthi st1 = new Vidyaarthi();
//		Vidyaarthi st2 = new Vidyaarthi();


//		st.setRollNo(101);
//		st.setName("AAdvik");
//		st.setMarks(101);


//		st.setRollNo(105);
//		st.setName("Roshan2");
//		st.setMarks(94);
//
		st.setRollNo(102);
		st.setName("Munna");
		st.setMarks(92);

//		System.out.println(st);

		studentRepo.save(st);

		System.out.println("deleting....");
//		studentRepo.deleteById(102);
		studentRepo.delete(st);


//		studentRepo.save(st1);


//		System.out.println(studentRepo.findAll());
//		System.out.println(studentRepo.findById(102));
////		System.out.println(studentRepo.findAllById(102,105));
//		System.out.println(studentRepo.findById(1029));
//
//		Optional<Vidyaarthi> s= studentRepo.findById(109);
//		System.out.println(s.orElse(new Vidyaarthi()));

//		System.out.println("printing....");
//		System.out.println(studentRepo.findByName("Munna"));
//		System.out.println(studentRepo.findByMarks(91));
//		System.out.println(studentRepo.findByrollNo(105));
//		System.out.println(studentRepo.findByMarksGreaterThan(20));
//		System.out.println(studentRepo.findByMarksLessThan(92));


	}
}







