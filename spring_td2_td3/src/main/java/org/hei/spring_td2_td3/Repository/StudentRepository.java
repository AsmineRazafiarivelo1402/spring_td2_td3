package org.hei.spring_td2_td3.Repository;

import org.hei.spring_td2_td3.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

      public List<Student> getStudents() {
        return students;
    }

    public void addAllStudent(List<Student> studentList) {
          students.addAll(studentList);
    }
}
