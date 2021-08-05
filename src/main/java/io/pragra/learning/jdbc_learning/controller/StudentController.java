package io.pragra.learning.jdbc_learning.controller;

import io.pragra.learning.jdbc_learning.dao.CourseDao;
import io.pragra.learning.jdbc_learning.dao.StudentDao;
import io.pragra.learning.jdbc_learning.domain.Course;
import io.pragra.learning.jdbc_learning.domain.Student;
import io.pragra.learning.jdbc_learning.domain.StudentStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
/*
@RestController is a convenience annotation for creating Restful controllers.
It is a specialization of @Component and is autodetected through classpath scanning.
t adds the @Controller and @ResponseBody annotations. It converts the response to JSON or XML.
 */

@RestController // defines controller class acts as a reresentation for URL based classes
public class StudentController {

    private StudentDao studentDao;// injecting the dao class
    private CourseDao courseDao;

    public StudentController(StudentDao studentDao, CourseDao courseDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
    }


    @GetMapping("/student") //localhost:8080/student is the api to call the created table api.
    public Student createStudent() {
        Student student1 = Student.builder().firstName("harini").lastName("Nishant")
                .createDate(new Date()).updateDate(new Date()).status(StudentStatus.ACTIVE).build();
        return studentDao.createStudent(student1);

    }


    @GetMapping("/student/all") //localhost:8080/student is the api to call the created table api.
    public List<Student> getALL() {
        return studentDao.getAllStudent();

    }

    @GetMapping("/student/all/{id}") //localhost:8080/student is the api to call the created table api.
    public Student getAll(@PathVariable int id) {
        return studentDao.getStudentById(id);
    }

    @DeleteMapping("/student/all/{id}") //localhost:8080/student is the api to call the created table api.
    public void Delete(@PathVariable int id) {
        studentDao.deleteById(id);
    }

    @PutMapping("/student/update") //localhost:8080/student is the api to call the created table api.
    public int update(@RequestBody Student student) {
        return studentDao.updateLastName(student);
    }

    @GetMapping("/course")
    public List<Course> getAllCourse() {
        return courseDao.getAllCourses();

    }
}
