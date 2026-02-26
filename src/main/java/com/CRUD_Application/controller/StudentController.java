package com.CRUD_Application.controller;

import com.CRUD_Application.Dao.StudentDao;
import com.CRUD_Application.Dto.Student;
import com.CRUD_Application.Dto.ResponseStructure;
import com.CRUD_Application.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud")
public class StudentController {
    @Autowired
//    StudentService studentservice = new StudentService();
    StudentService studentService ;

    // save student
    @PostMapping("/studentcreation")
    public ResponseStructure<Student> saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    // get student by id
    @GetMapping("/student/{id}")
    public ResponseStructure<Student> getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    // get all students
    @GetMapping("/student")
    public ResponseStructure<List<Student>> getallStudent(){
        return studentService.getAllStudent();
    }

    // update student
    @PutMapping("/student/{id}")
    public ResponseStructure<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id){
        return studentService.updateStudent(student, id);
    }

    // delete student
    @DeleteMapping("/student/{id}")
    public ResponseStructure<String> deletestudent(@PathVariable int id){
        return studentService.deletestudent(id);
    }



}
