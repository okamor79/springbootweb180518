package edu.logos;

import edu.logos.entity.Student;
import edu.logos.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootwebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringbootwebApplication.class, args);
        addStudent(ctx);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootwebApplication.class);
    }

    private static void addStudent(ConfigurableApplicationContext ctx) {
        StudentRepository studentRepository = ctx.getBean(StudentRepository.class);
        Long studentsCount = studentRepository.count();
        System.out.println("Student in DB: " + studentsCount);
        if (studentsCount == 0) {
            for (int i = 0; i < 500; i++) {
                Student student = new Student();
                student.setFirstName("First Name #" + i);
                student.setLastName("Last Name #" + i);
                student.setAge(i);
                student.setPassword("Pass" + i);
                studentRepository.save(student);
            }
        }
    }
}
