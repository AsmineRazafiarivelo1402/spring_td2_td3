package org.hei.spring_td2_td3.Validator;


import org.hei.spring_td2_td3.Entity.StudentEntity;

import org.hei.spring_td2_td3.exception.BadRequestException;
import org.hei.spring_td2_td3.service.StudentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public class StudentValidator {
    private final StudentService studentService;

    public StudentValidator(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentService getStudentRepository() {
        return studentService;
    }

    public void validStudent(List<StudentEntity> newStudents) throws BadRequestException {
        for (StudentEntity newStudent : newStudents) {
            if (newStudent.getReference() == null || newStudent.getReference().isBlank()) {
                throw new BadRequestException("Student reference cannot be null");
            }
            if (newStudent.getFirstName() == null || newStudent.getFirstName().isBlank()) {
                throw new BadRequestException("Student firstName cannot be null");
            }

            if (newStudent.getLastName() == null || newStudent.getLastName().isBlank()) {
                throw new BadRequestException("Student lastName cannot be null");
            }
            if (newStudent.getAge() == null ) {
                throw new BadRequestException("Student lastName cannot be null");
            }
        }

    }

}
