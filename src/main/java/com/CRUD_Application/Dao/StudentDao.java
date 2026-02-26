package com.CRUD_Application.Dao;
import com.CRUD_Application.Dto.ResponseStructure;
import com.CRUD_Application.Dto.Student;
import com.CRUD_Application.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class StudentDao {
    @Autowired
    StudentRepository Studentrepo ;
    //save student
    public Student saveStudent(Student student){
        return Studentrepo.save(student);
    }

    //get student by id
    public Student getStudentById(int id){
        Optional<Student> result = Studentrepo.findById(id);
        if(!result.isEmpty()){
            return result.get();
        }
        return null;

    }

    //get all students
    public List<Student> getallStudent(){
        List<Student> result = Studentrepo.findAll();
        return result;
    }

    //update student
    public Student updateStudent(Student student , int id){
        Student exisitingstudent = getStudentById(id);
        try{
            if(exisitingstudent != null){
                exisitingstudent.setName(student.getName());
                exisitingstudent.setPhone(student.getPhone());
                exisitingstudent.setCourse(student.getCourse());
                exisitingstudent.setBatch(student.getBatch());
                return Studentrepo.save(exisitingstudent);
            }
        }
        catch (Exception e){
         System.out.println(e.getMessage());
        }
        return null;
    }



    //deleting student

    public boolean deletestudent(int id){
        Optional<Student> result = Studentrepo.findById(id);
        try{
            if(!result.isEmpty()){
                Studentrepo.delete(result.get());
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
