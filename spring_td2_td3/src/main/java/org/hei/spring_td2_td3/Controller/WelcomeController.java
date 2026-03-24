package org.hei.spring_td2_td3.Controller;
import org.hei.spring_td2_td3.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(@RequestParam("name") String n) {
        return "Welcome " + n;
    }

    // correction : car c'est pour student, on doit créer une autre controller pour gérer ça
//    private final List<Student> students = new ArrayList<>();
//    @PostMapping("/students")
//    public ResponseEntity<String> createStudent(@RequestBody List<Student> studentList) {
//        students.addAll(studentList);
//        String noms = students.stream()
//                .map(Student::getFirstName)
//                .collect(Collectors.joining(", "));
//
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(noms);
//    }

//    @GetMapping("/students")
//    public ResponseEntity<String> getStudents(@RequestHeader("Accept") String accept) {
//
//        if ("text/plain".equals(accept)) {
//            String noms = students.stream()
//                    .map(Student::getFirstName)
//                    .collect(Collectors.joining(", "));
//            return ResponseEntity.ok()
//                    .header("Content-Type", "text/plain")
//                    .body(noms);
//        } else {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_ACCEPTABLE)
//                    .body("Format non supporté.");
//        }
//    }
}
