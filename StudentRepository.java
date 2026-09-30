package com.example.student;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addStudent(Student student) {
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getEmail());
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email")
            )
        );
    }

    public int deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
