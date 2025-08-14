package com.MyProjects.projects.Repos;

import com.MyProjects.projects.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo  {


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Student st) {
        String sql = "Insert into Student (name,marks) values (?,?)";

        // Create a KeyHolder to hold the generated key
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Use a Lambda expression for a cleaner PreparedStatementCreator
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, st.getName());
            ps.setInt(2, st.getMarks());
            return ps;
        }, keyHolder);

        // Retrieve the generated rollno and set it in the Student object
        if (keyHolder.getKey() != null) {
            st.setRollNo(keyHolder.getKey().intValue());
        }

        System.out.println(rows + " affected, generated rollno is " + st.getRollNo());
    }



    public List<Student> findAll() {

        String sql = "select * from student";
        RowMapper<Student> rm = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student s = new Student();
                s.setMarks(rs.getInt("marks"));
                s.setName(rs.getString("name"));
                s.setRollNo(rs.getInt("rollno"));
                System.out.println("New Student inserted with name:" + s.getName());

                return s;
                //Note: above query can be reduced to a lambda expression for shortening
            }
        };
      return  jdbcTemplate.query(sql,rm);

    }
}
