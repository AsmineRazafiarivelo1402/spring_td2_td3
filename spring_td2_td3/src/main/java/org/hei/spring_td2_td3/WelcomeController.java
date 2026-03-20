package org.hei.spring_td2_td3;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(@RequestParam("name") String name) {
        return "Welcome " + name;
    }

    private final List<Student> students = new ArrayList<>();
    @PostMapping("/students")
    public ResponseEntity<String> createStudent(@RequestBody List<Student> studentList) {
        students.addAll(studentList);
        String noms = students.stream()
                .map(Student::getFirstName)
                .collect(Collectors.joining(", "));


        return ResponseEntity.status(HttpStatus.CREATED).body(noms);
    }
}
