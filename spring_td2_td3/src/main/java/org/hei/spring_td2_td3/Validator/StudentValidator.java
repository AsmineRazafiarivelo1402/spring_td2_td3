package org.hei.spring_td2_td3.Validator;


import org.hei.spring_td2_td3.Entity.Student;
import org.hei.spring_td2_td3.Repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentValidator {
    private final StudentRepository studentRepository;

    public StudentValidator(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void validStudent(List<Student> newStudents) {
        for (Student newStudent : newStudents) {
            if (newStudent.getReference() == null || newStudent.getReference().isBlank()) {
                throw new RuntimeException("Student reference cannot be null");
            }
            if (newStudent.getFirstName() == null || newStudent.getFirstName().isBlank()) {
                throw new RuntimeException("Student firstName cannot be null");
            }

            if (newStudent.getLastName() == null || newStudent.getLastName().isBlank()) {
                throw new RuntimeException("Student lastName cannot be null");
            }
            if (newStudent.getAge() == null ) {
                throw new RuntimeException("Student lastName cannot be null");
            }
        }

    }

}
