package com.JPA.SpringDataJPAwala.Repos;

import com.JPA.SpringDataJPAwala.Models.Vidyaarthi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Vidyaarthi,Integer>{


//    @Query("Select vid from Vidyaarthi vid where vid.Name=?1")//1 denotes the first parameter out of many params passed
    List<Vidyaarthi> findByName(String name);
    List<Vidyaarthi> findByMarks(int marks);

    List<Vidyaarthi> findByrollNo(int i);

    List<Vidyaarthi>  findByMarksGreaterThan(int i);

    List<Vidyaarthi>  findByMarksLessThan(int i);
}
