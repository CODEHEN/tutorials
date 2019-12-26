package org.example.controllers;

import org.example.models.Customer;
import org.example.models.Student;
import org.example.repositories.StudentRepository;
import org.example.utils.ResponseCode;
import org.example.utils.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    StudentRepository studentRepository;

    @GetMapping("/all")
    public ResponseEntity<Object> findAll(){
        ResponseData responseData = new ResponseData();
        List<Student> students = studentRepository.findAll();
        responseData.setResultCode(ResponseCode.SUCCESS.value());
        responseData.setResultData(students);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
        ResponseData responseData = new ResponseData();
        Student savedStudent = studentRepository.save(student);
        responseData.setResultCode(ResponseCode.SUCCESS.value());
        responseData.setResultData(savedStudent);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }




}
