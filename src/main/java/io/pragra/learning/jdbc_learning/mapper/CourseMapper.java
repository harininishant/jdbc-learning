package io.pragra.learning.jdbc_learning.mapper;

import io.pragra.learning.jdbc_learning.domain.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course> {// RowMapper is an functional interface
// course mapper is created as column name and created table are not matching.
    @Override
    public Course mapRow(ResultSet resultSet, int i) throws SQLException {
//        Course course =  new Course();
//        course.setCourseId(resultSet.getInt(1));
//        course.setCourseName(resultSet.getString(2));
//        course.setCourseDescription(resultSet.getString(3));
//        return course; // indexing in sql starts from 1
   // }

        Course course =  new Course();
        course.setCourseId(resultSet.getInt("ID"));
        course.setCourseName(resultSet.getString("NAME"));
        course.setCourseDescription(resultSet.getString("DESCRIPTION"));
        return course; // indexing in sql starts from 1
    }
/*
mapping is required only when someone is trying to read it or write it.otherise we can directly call
 from data.sql like course_fees column as its not written its a hidden column
 */

}
