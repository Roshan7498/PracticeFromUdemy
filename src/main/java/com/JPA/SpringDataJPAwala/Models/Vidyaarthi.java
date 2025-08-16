package com.JPA.SpringDataJPAwala.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "vidyaarthi", schema = "dbo")
//@Scope("prototype")
public class Vidyaarthi {
    @Id
    private int rollNo;
    private String name;
    private int marks;
}
