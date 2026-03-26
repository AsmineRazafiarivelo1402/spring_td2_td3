package org.hei.spring_td2_td3.service;

import org.hei.spring_td2_td3.Entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<StudentEntity> studentsInMemory = new ArrayList<>();
    public List<StudentEntity> getStudents() {
        return studentsInMemory;
    }

    public List<StudentEntity> saveInMemory(List<StudentEntity> newStudents) {
        studentsInMemory.addAll(newStudents);
        return studentsInMemory;
    }
}
