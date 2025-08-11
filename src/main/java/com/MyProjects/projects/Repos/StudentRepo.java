package com.MyProjects.projects.Repos;

import com.MyProjects.projects.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
@Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Student st) {

        String sql= "Insert into Student (rollNo,name,marks) values (?,?,?)";
      int rows=jdbcTemplate.update(sql,st.getRollNo(),st.getName(),st.getMarks());
        System.out.println(rows + " affected");
    }

    public List<Student> findAll() {

        String sql = "select * from student";
        RowMapper<Student> rm = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student s = new Student();
                s.setMarks(rs.getInt("marks"));
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));

                return s;
                //Note: above query can be reduced to a lambda expression for shortening
            }
        };
      return  jdbcTemplate.query(sql,rm);

    }
}
