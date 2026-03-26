package org.hei.spring_td2_td3.Controller;

import org.hei.spring_td2_td3.Entity.StudentEntity;

import org.hei.spring_td2_td3.Validator.StudentValidator;
import org.hei.spring_td2_td3.exception.BadRequestException;
import org.hei.spring_td2_td3.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {
  private final StudentValidator studentValidator; // injection par constructeur
  private final StudentService studentService;
    public StudentController(StudentValidator studentValidator,  StudentService studentService) {
        this.studentValidator = studentValidator;
        this.studentService = studentService;

    }
    //@Autowired = injection par attribut
    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody List<StudentEntity> newStudent) {
        try {
            studentValidator.validStudent(newStudent);
            List<StudentEntity> studentsInMemory = studentService.saveInMemory(newStudent);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type","text/plain")
                    .body(studentsInMemory);
        } catch (BadRequestException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "text/plain")
                    .body(e.getMessage());
        }

    }




    }
//
////    S -> Single Responsability => une classe ne doit avoir qu'une seule raison de changer/ une seule responsabilité / un seul but
////    O -> Open Closed
////    L -> Substitution de Liskov
////    I -> InterfaceAddress Segregation
////    D -> DependencyDefinition Inversion
//}
