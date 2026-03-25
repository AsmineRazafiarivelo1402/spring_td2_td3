package org.hei.spring_td2_td3.Controller;

import ch.qos.logback.core.model.processor.DependencyDefinition;
import org.apache.catalina.valves.rewrite.Substitution;
import org.hei.spring_td2_td3.Entity.Student;
import org.hei.spring_td2_td3.Repository.StudentRepository;
import org.hei.spring_td2_td3.Validator.StudentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentController {
  private final StudentValidator studentValidator;
  private final StudentRepository studentRepository;
    public StudentController(StudentValidator studentValidator, StudentRepository studentRepository) {
        this.studentValidator = studentValidator;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody List<Student> studentList){
        try{
            studentValidator.validStudent(studentList);
            studentRepository.addAllStudent(studentList);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body(studentRepository.getStudents());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "text/plain")
                    .body(e.getMessage());
        }




    }

//    S -> Single Responsability => une classe ne doit avoir qu'une seule raison de changer/ une seule responsabilité / un seul but
//    O -> Open Closed
//    L -> Substitution de Liskov
//    I -> InterfaceAddress Segregation
//    D -> DependencyDefinition Inversion
}
