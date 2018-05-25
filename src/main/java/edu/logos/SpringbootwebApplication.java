package edu.logos;

import edu.logos.entity.Student;
import edu.logos.entity.User;
import edu.logos.entity.UserImages;
import edu.logos.repository.StudentRepository;
import edu.logos.repository.UserRepository;
import edu.logos.service.utils.CustomFileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@EnableTransactionManagement
@SpringBootApplication
public class SpringbootwebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringbootwebApplication.class, args);
        addStudent(ctx);
        addUser(ctx);
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

    private static void addUser(ConfigurableApplicationContext ctx) throws Exception {
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        Long usersCount = userRepository.count();
        System.out.println("Users in DB: " + usersCount);
        if (usersCount == 0) {
            File fileFirstName = new File("first_name.txt");
            File fileLastName = new File("last_name.txt");

            ArrayList fnList = new ArrayList<>();
            ArrayList lnList = new ArrayList<>();

            FileReader fr = new FileReader(fileFirstName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                fnList.add(line);
            }
            fr.close();
            br.close();

            fr = new FileReader(fileLastName);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                lnList.add(line);
            }
            fr.close();
            br.close();

            String firstName;
            String lastName;
            int salary;

            for (int i = 0; i < lnList.size(); i++) {
                UserImages uImages = new UserImages();
                uImages.setImageName("");

                User user = new User();
                firstName = String.valueOf(fnList.listIterator(new Random().nextInt(fnList.size())).next());
                lastName = String.valueOf(lnList.listIterator(new Random().nextInt(lnList.size())).next());
                salary = new Random().nextInt(190000) + 3000;
                user.setUserName("user" + i);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(firstName + "." + lastName + "@gmail.com");
                user.setSalary(salary);
                user.setPassword("Temp1234");
                user.setUserImages(uImages);
                userRepository.save(user);
                CustomFileUtils.createFolder("user_" + user.getId());
            }
        }
        System.out.println();
    }
}
