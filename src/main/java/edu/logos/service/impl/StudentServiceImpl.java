package edu.logos.service.impl;

import edu.logos.dto.filter.SimpleFilter;
import edu.logos.entity.Student;
import edu.logos.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import edu.logos.service.StudentService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findStudentByID(int id) {
        return studentRepository.getOne(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllStudentsByFilter(SimpleFilter filter) {
        return studentRepository.findAll(getSpecification(filter));
    }

    @Override
    public Page<Student> findAllStudentsByPage(Pageable pageable) {
//        PageRequest pageRequest = new PageRequest(page, size)

        return studentRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
    }

    private Specification<Student> getSpecification(SimpleFilter filter) {
        return new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if(filter.getSearch().isEmpty()) {
                    return null;
                }
                return criteriaBuilder.like(root.get("firstName"),"%" + filter.getSearch() + "%");
            }
        };
    }

}
