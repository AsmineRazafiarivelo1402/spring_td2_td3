package org.hei.spring_td2_td3.Controller;

import org.hei.spring_td2_td3.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentController {
    // le memoire vive, on doit créer de liste pour stocker student
    List<Student> studentList =  new ArrayList<>();
    @PostMapping("/students")
    public String createStudent(List<Student> listStudent){
        studentList.addAll(listStudent);

        return studentList.stream().map(Student::getFirstName).collect(Collectors.joining(","));
    }

    @GetMapping("/student")
    public String getStudent(@RequestHeader("accept") String accept){
        //string "accept" par défaut et dans le requette on doit mettre accept, si on met x, de x
        // "accept" considéré dans le consommateur
        // value in Requestheader:mirror values, alias, should be same
        if(!accept.equals("text/plian")){
            return "No accept Header";
        }
        return studentList.stream().map(Student::getFirstName).collect(Collectors.joining(","));
    }
}
