package edu.logos.mapper;

import edu.logos.dto.StudentDTO;
import edu.logos.entity.Student;
import org.modelmapper.ModelMapper;

public interface StudentMapper {

    static Student studentDTOtoStudent(StudentDTO studentDTO) {
        Student student = new Student();


        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAge(studentDTO.getAge());
        student.setPassword(studentDTO.getPassword());
        return student;
    }
}
