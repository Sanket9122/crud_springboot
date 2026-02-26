package com.CRUD_Application.services;

import com.CRUD_Application.Dao.StudentDao;
import com.CRUD_Application.Dto.Student;
import com.CRUD_Application.Dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    //savestudent function to save the student data in the database
    public ResponseStructure<Student> saveStudent(Student student){
        ResponseStructure<Student> response = new ResponseStructure<Student>();
        Student savedStudent = studentDao.saveStudent(student);
        if(savedStudent != null){
            response.setData(savedStudent);
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setStatusmessage("Student saved successfully");
        }
        else {
            response.setData(null);
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setStatusmessage("Internal server error: Student not saved");
        }
        return response;
    }

    //updatestudent function to update the student data in the database
    public ResponseStructure<Student> updateStudent(Student student , int id){
        ResponseStructure<Student> response = new ResponseStructure<Student>();
        Student updatedstudents = studentDao.updateStudent(student , id);
        try{
            if(updatedstudents!=null){
                response.setData(student);
                response.setStatusCode(HttpStatus.OK.value());
                response.setStatusmessage("Student updated successfully");
            }
        }catch(Exception e){System.out.println(e.getMessage());}
        return response;
    }

    //get student by id
    public ResponseStructure<Student> getStudentById(int id){
        ResponseStructure<Student> response = new ResponseStructure<Student>();
        Student student = studentDao.getStudentById(id);
        if(student != null){
            response.setData(student);
            response.setStatusCode(HttpStatus.OK.value());
            response.setStatusmessage("Student found successfully");
        }
        else{
            response.setData(null);
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setStatusmessage("Student not found");
        }
        return response;
    }

    //get all students
    public ResponseStructure<List<Student>> getAllStudent(){
        ResponseStructure<List<Student>> response = new ResponseStructure<>();
        List<Student> student = studentDao.getallStudent();
        if(student!=null){
            response.setData(student);
            response.setStatusCode(HttpStatus.OK.value());
            response.setStatusmessage("All students are fetched");
        }
        else{
            response.setData(null);
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setStatusmessage("All students not found");
        }
        return response;
    }

    //Delete method to delete the student from the database
    //we are returning a string message to the user upon deleting the user
    public ResponseStructure<String> deletestudent (int id){
        ResponseStructure<String> response = new ResponseStructure<String>();
        boolean isTrue = studentDao.deletestudent(id);
        if(isTrue){
            response.setData("student deleted");
            response.setStatusCode(HttpStatus.OK.value());
            response.setStatusmessage("Student deleted successfully");
        }
        else{
            response.setData(null);
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setStatusmessage("Internal server error: Student not deleted");
        }
        return response;
    }
}
