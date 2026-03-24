package org.hei.spring_td2_td3.Controller;

import org.hei.spring_td2_td3.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WelcomeController {
//    @GetMapping("/welcomeparam")
//    public ResponseEntity<String> welcome(@RequestParam(name = "name", required = false ) String name){
//        if (name == null) {
//            return new ResponseEntity<>("Le parametre n'est pas fourni",HttpStatus.BAD_REQUEST);
//        }
//
//        return ResponseEntity.ok("Welcome " + name);
//    }

    //CORRECTION et ResponseEntity conséillé
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome (@RequestParam(name = "name", required = false) String name){
        if(name == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST) // le status est obligatoire
                    .header("Content-Type")
                    .body("Le parametre n'est pas fourni");


        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type")
                .body("Welcome "+name);

    }

//    private final List<Student> students = new ArrayList<>();
//    @PostMapping("/studentspost")
//    public ResponseEntity<List<Student>> createStudent(@RequestBody List<Student> studentList) {
//        try {
//            students.addAll(studentList);
//            return ResponseEntity.status(HttpStatus.CREATED).body(students);
//        } catch (Exception e) {
//            throw new ResponseStatusException(
//                   HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        }
//    @GetMapping("/students")
//    public ResponseEntity<?> getStudents(@RequestHeader("Accept") String accept) {
//
//        if ("text/plain".equals(accept)) {
//
//            return ResponseEntity.ok()
//                    .header("Content-Type", "text/plain")
//                    .body(students);
//        } else {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_ACCEPTABLE)
//                    .body("Format non supporté.");
//        }
//    }
  }
    // les élèments qui constituent la requette

