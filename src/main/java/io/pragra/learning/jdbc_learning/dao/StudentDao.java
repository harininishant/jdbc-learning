package io.pragra.learning.jdbc_learning.dao;

import io.pragra.learning.jdbc_learning.domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.List;

/*
this class will provide database CRUD operation for our students table
 */
@Repository // alias for component but it defines the database informationgiven in this class
/*
@Repository is a Spring annotation that indicates that the decorated class is a repository. A repository is
a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.
 */
public class StudentDao {//Dao means database access objects

JdbcTemplate template;// from spring connecting to local host sql database
    /*
    Spring JdbcTemplate is a powerful mechanism to connect to the
    database and execute SQL queries. It internally uses JDBC api,
     but eliminates a lot of problems of JDBC API.
     */

    public StudentDao(JdbcTemplate template) {
        this.template = template;
    }

 public Student createStudent(Student student){
        student.setId(((int) Math.floor(Math.random() * 1000000)));
  String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
template.update(sql,student.getId(),student.getFirstName(),student.getLastName(),student.getCreateDate(),
        student.getUpdateDate(),student.getStatus().toString());
        return student;


 }


           public List<Student> getAllStudent(){// BeanPropertyRowMapper-
        // matches the column name vs property name in the CLASS
        // class that it needs to be mapped has to have noArgConstructor.
       return template.query("SELECT * FROM STUDENT",new BeanPropertyRowMapper<>(Student.class));

 }
     public  Student getStudentById(int id){
        return template.queryForObject("SELECT * FROM STUDENT WHERE ID = ? ",
                new BeanPropertyRowMapper<>(Student.class),id);

}
 public int updateLastName(Student student){ // update returns int.
        // it tells you how many rows are updated thats why it returns an integer value
        String sql = "UPDATE  STUDENT SET LAST_NAME=? WHERE ID = ?";
        return template.update(sql,student.getLastName(),student.getId());
}
public void deleteById(int id){ // not returning anything
        String sql = "DELETE FROM STUDENT WHERE ID = ?";
        template.update(sql, id);
}

}
