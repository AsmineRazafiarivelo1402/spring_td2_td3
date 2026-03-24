package org.hei.spring_td2_td3.Controller;

import org.hei.spring_td2_td3.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    List<Student> students = new ArrayList<>();
    @PostMapping("/students")
    public ResponseEntity<List<Student>> createStudent(@RequestBody List<Student> studentList){
        students.addAll(studentList);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Content-Type","application/json")
                .body(students);

    }

    @GetMapping("/students")
    public ResponseEntity<Object> getStudents(@RequestHeader(name = "Accept", required = true) String accept){
        //Object => return un objet
        // ? => type inconnu
        if(!accept.equals("text/plan") || !accept.equals("application/json")){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Format Not Supportde");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Content-Type","application/json")
                .body(students);
    }
}
