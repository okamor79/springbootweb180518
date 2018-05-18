package edu.logos.service;

import edu.logos.dto.filter.SimpleFilter;
import edu.logos.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    Student findStudentByID(int id);

    List<Student> findAllStudents();

    List<Student> findAllStudentsByFilter(SimpleFilter filter);

    Page<Student> findAllStudentsByPage(Pageable pageable);

}
