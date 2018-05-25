package edu.logos.controller;

import edu.logos.dto.StudentDTO;
import edu.logos.dto.UserDTO;
import edu.logos.dto.filter.RockyFilter;
import edu.logos.dto.filter.SimpleFilter;
import edu.logos.entity.Country;
import edu.logos.entity.Student;
import edu.logos.entity.StudentDetails;
import edu.logos.entity.User;

import edu.logos.entity.enums.PageSize;
import edu.logos.mapper.StudentMapper;

import edu.logos.service.CountryService;
import edu.logos.service.StudentService;
import edu.logos.service.UserService;
import edu.logos.service.utils.CustomFileUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"countries", "saveUser","userInfo"})
public class HomeController {

    private CountryService countryService;
    private StudentService studentService;
    private UserService userService;

    public HomeController(CountryService countryService, StudentService studentService, UserService userService) {
        this.countryService = countryService;
        this.studentService = studentService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/add/country")
    public String showAddCountryForm(Model model) {
        model.addAttribute("countryModel", new Country());
        return "c";

    }

    @GetMapping("/add/student")
    public String showAddCStudentForm(Model model) {
        model.addAttribute("studentModel", new Student());
        model.addAttribute("countries", countryService.findAllCountrys());
        return "add-student";
    }

    @PostMapping("/add/country")
    public String saveCountry(@Valid @ModelAttribute("countryModel") Country country,
                              BindingResult br) {
        if (br.hasErrors()) {
            return "add-country";
        }
        countryService.saveCountry(country);
        return "redirect:/";
    }

    @PostMapping("/add/student")
    public String saveStudent(@Valid @ModelAttribute("studentModel") Student student, BindingResult br) {
        if (br.hasErrors()) {
            return "add-student";
        }
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/add/user")
    public String showAddUserForm(Model model) {
        model.addAttribute("saveUser", new User());
        return "add-user";
    }

    @PostMapping("/add/user")
    public String saveUser(@Valid @ModelAttribute("saveUser") User user, BindingResult br) {
        if (br.hasErrors()) {
            return "add-user";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    // DTO
    @GetMapping("/add/student-dto")
    public String showAddStudentDTOFrom(Model model) {
        model.addAttribute("studentDTOModel", new StudentDTO());
        return "add-student-dto";
    }

    @PostMapping("/add/student-dto")
    public String saveStudentDTO(
            @Valid @ModelAttribute("studentDTOModel") StudentDTO studentDTO,
            BindingResult br
    ) {
        if (br.hasErrors()) {
            return "add-student-dto";
        }
        Student student = StudentMapper.studentDTOtoStudent(studentDTO);
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("simpleModel", new SimpleFilter());
        List<Student> s = studentService.findAllStudents();
        model.addAttribute("studentsList", s);
        return "student-list";
    }

    @GetMapping("/students/search")
    public String showStudentsByFilter(
            @ModelAttribute("simpleModel") SimpleFilter filter,
            Model model
    ) {
        model.addAttribute("studentsList", studentService.findAllStudentsByFilter(filter));
        return "student-list";
    }

    @GetMapping("/users")
    public String showUsersPage(Model model) {
        model.addAttribute("usersList", userService.findAllUsers());
        return "users-list";
    }

    @GetMapping("/users/pages")
    public String showUsersByPage(
            Model model,
//            @RequestParam("search") RockyFilter filter,
            //       @ModelAttribute("searchText") RockyFilter filter,
            @PageableDefault Pageable pageable
    ) {
        Page<User> page = userService.findUserByPAge(pageable);
//        Page<User> page = userService.findUsersByPage(pageable, filter);

        int currentPage = page.getNumber();
        int begin = Math.max(1, currentPage - 5);
        int end = Math.min(begin + 5, page.getNumber());
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", currentPage);
        model.addAttribute("usersList", page);
        model.addAttribute("usersPageListByPageSize", page.getContent());
        model.addAttribute("searchText", new RockyFilter());
        return "users-list";
    }

    @GetMapping("/users/pages/search")
    public String showUserFiltered(
            @ModelAttribute("searchText") RockyFilter filter,
            @PageableDefault Pageable pageable,
            Model model
    ) {
        Page<User> page = userService.findUsersByPage(pageable, filter);
        int currentPage = page.getNumber();
        int begin = Math.max(1, currentPage - 5);
        int end = Math.min(begin + 5, page.getNumber());
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", currentPage);
        model.addAttribute("usersList", page);
        model.addAttribute("usersPageListByPageSize", page.getContent());
        model.addAttribute("searchText", filter);
        return "users-list";
    }

    @GetMapping("/students/pages")
    public String showStudentsByPage(
            Model model,
            @PageableDefault Pageable pageable
    ) {
        Page<Student> page = studentService.findAllStudentsByPage(pageable);
        int currentPage = page.getNumber();
        int begin = Math.max(1, currentPage - 5);
        int end = Math.min(begin + 5, page.getNumber());
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", currentPage);
        model.addAttribute("studentsList", page);
        model.addAttribute("studentPageListByPageSize", page.getContent());
        return "students-by-page";
    }

    @GetMapping("/students/{studentID}")
    public String findStudentByID(@PathVariable("studentID") int id) {
        Student student = studentService.findStudentByID(id);
        System.out.println(student);
        return "home";
    }

    @GetMapping("/students/create")
    public String createStudent() {
        StudentDetails studentDetails = new StudentDetails();

        studentDetails.setEmail("jshjshgh@dhfghjshg.com");

        Student student = new Student();
        student.setFirstName("fi");
        student.setLastName("last");
        student.setStudentDetails(studentDetails);
        studentService.saveStudent(student);
        return "home";
    }

    @GetMapping("/users/info/{userID}")
    public String showUserInfo(@PathVariable("userID") int id, Model model) throws Exception {
        User user = userService.findUserByID(id);
        model.addAttribute("userInfo", user);
        String path = user.getUserImages().getImageName();
        if (!path.isEmpty()) {
            model.addAttribute("imageSrc", CustomFileUtils.getImage("user_" + user.getId(),path));
        } else {
            model.addAttribute("imageSrc", CustomFileUtils.getImage("","test/Default.png"));
        }


        return "user-info";
    }

}
