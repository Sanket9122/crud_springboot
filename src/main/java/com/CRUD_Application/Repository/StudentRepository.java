package com.CRUD_Application.Repository;

import com.CRUD_Application.Dto.Student;
import com. CRUD_Application.Dto.ResponseStructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer> {

}
