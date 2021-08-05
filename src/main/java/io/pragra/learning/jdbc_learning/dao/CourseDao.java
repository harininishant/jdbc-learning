package io.pragra.learning.jdbc_learning.dao;

import io.pragra.learning.jdbc_learning.domain.Course;
import io.pragra.learning.jdbc_learning.domain.Student;
import io.pragra.learning.jdbc_learning.mapper.CourseMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
public class CourseDao {
    private JdbcTemplate template;
    /*
    mapping line by line using rowmapper lambda
    {
        "courseId": 1,
        "courseName": "FullStackJava",
        "courseDescription": null
    },


     */

    RowMapper<Course>rowMapper = (r,i)-> {
        Course course = new Course();
        course.setCourseId(r.getInt("ID"));// mapping only the ID
        course.setCourseName(r.getString("Name"));
        return course;
    };



    public CourseDao(JdbcTemplate template) {
        this.template = template;
    }


    public List<Course> getAllCourses(){// BeanPropertyRowMapper- matches the column name vs property name
        //return template.query("SELECT * FROM COURSE",new BeanPropertyRowMapper<>(Course.class));
        //return template.query("SELECT * FROM COURSE",new CourseMapper());
        return template.query("SELECT * FROM COURSE",rowMapper);

}

}
