package io.pragra.learning.jdbc_learning.domain;

import lombok.*;

@Data
@NoArgsConstructor // spring uses setter method hence default constructor is needed
public class Course {

private  int courseId;
private  String courseName;
private  String courseDescription;

}
